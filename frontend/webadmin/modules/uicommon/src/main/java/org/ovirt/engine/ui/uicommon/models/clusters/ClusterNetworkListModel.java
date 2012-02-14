package org.ovirt.engine.ui.uicommon.models.clusters;
import java.util.Collections;
import org.ovirt.engine.core.compat.*;
import org.ovirt.engine.ui.uicompat.*;
import org.ovirt.engine.core.common.businessentities.*;
import org.ovirt.engine.core.common.vdscommands.*;
import org.ovirt.engine.core.common.queries.*;
import org.ovirt.engine.core.common.action.*;
import org.ovirt.engine.ui.frontend.*;
import org.ovirt.engine.ui.uicommon.*;
import org.ovirt.engine.ui.uicommon.models.*;
import org.ovirt.engine.core.common.*;

import org.ovirt.engine.core.common.interfaces.*;
import org.ovirt.engine.core.common.businessentities.*;

import org.ovirt.engine.core.common.queries.*;
import org.ovirt.engine.ui.uicommon.*;
import org.ovirt.engine.ui.uicommon.models.*;

@SuppressWarnings("unused")
public class ClusterNetworkListModel extends SearchableListModel
{

	private UICommand privateNewNetworkCommand;
	public UICommand getNewNetworkCommand()
	{
		return privateNewNetworkCommand;
	}
	private void setNewNetworkCommand(UICommand value)
	{
		privateNewNetworkCommand = value;
	}
	private UICommand privateManageCommand;
	public UICommand getManageCommand()
	{
		return privateManageCommand;
	}
	private void setManageCommand(UICommand value)
	{
		privateManageCommand = value;
	}
	private UICommand privateSetAsDisplayCommand;
	public UICommand getSetAsDisplayCommand()
	{
		return privateSetAsDisplayCommand;
	}
	private void setSetAsDisplayCommand(UICommand value)
	{
		privateSetAsDisplayCommand = value;
	}



	public VDSGroup getEntity()
	{
		return (VDSGroup)((super.getEntity() instanceof VDSGroup) ? super.getEntity() : null);
	}
	public void setEntity(VDSGroup value)
	{
		super.setEntity(value);
	}

	private Model window;
	public Model getWindow()
	{
		return window;
	}
	public void setWindow(Model value)
	{
		if (window != value)
		{
			window = value;
			OnPropertyChanged(new PropertyChangedEventArgs("Window"));
		}
	}


	public ClusterNetworkListModel()
	{
		setTitle("Logical Networks");

		setManageCommand(new UICommand("Manage", this));
		setSetAsDisplayCommand(new UICommand("SetAsDisplay", this));
		setNewNetworkCommand(new UICommand("New", this));

		UpdateActionAvailability();
	}

	@Override
	protected void OnEntityChanged()
	{
		super.OnEntityChanged();
		getSearchCommand().Execute();
	}

	@Override
	public void Search()
	{
		if (getEntity() != null)
		{
			super.Search();
		}
	}

	@Override
	protected void SyncSearch()
	{
		super.SyncSearch();

		AsyncQuery _asyncQuery = new AsyncQuery();
		_asyncQuery.setModel(this);
		_asyncQuery.asyncCallback = new INewAsyncCallback() { public void OnSuccess(Object model, Object ReturnValue)
		{
			SearchableListModel searchableListModel = (SearchableListModel)model;
			searchableListModel.setItems((java.util.ArrayList<network>)((VdcQueryReturnValue)ReturnValue).getReturnValue());
		}};

		Frontend.RunQuery(VdcQueryType.GetAllNetworksByClusterId, new VdsGroupQueryParamenters(getEntity().getId()), _asyncQuery);
	}

	@Override
	protected void AsyncSearch()
	{
		super.AsyncSearch();

		setAsyncResult(Frontend.RegisterQuery(VdcQueryType.GetAllNetworksByClusterId, new VdsGroupQueryParamenters(getEntity().getId())));
		setItems(getAsyncResult().getData());
	}

	public void SetAsDisplay()
	{
		network network = (network)getSelectedItem();

		Frontend.RunAction(VdcActionType.UpdateDisplayToVdsGroup, new DisplayNetworkToVdsGroupParameters(getEntity(), network, true));
	}

	public void Manage()
	{
		if (getWindow() != null)
		{
			return;
		}

		ListModel model = new ListModel();
		setWindow(model);
		model.setTitle("Assign/Detach Networks");
		model.setHashName("assign_networks");

		//var items = DataProvider.GetNetworkList(Entity.storage_pool_id.GetValueOrDefault())
		//	.Where(a => !a.name.Equals("engine", StringComparison.CurrentCulture))
		//	.Select(a => new EntityModel() { Entity = a })
		//	.ToList();
		Guid storagePoolId = (getEntity().getstorage_pool_id() != null) ? getEntity().getstorage_pool_id().getValue() : Guid.Empty;

		java.util.ArrayList<network> networkList = DataProvider.GetNetworkList(storagePoolId);
		Collections.sort(networkList, new Linq.NetworkByNameComparer());

		java.util.ArrayList<EntityModel> items = new java.util.ArrayList<EntityModel>();
		for (network a : networkList)
		{
			if (!a.getname().equals("engine"))
			{
				EntityModel tempVar = new EntityModel();
				tempVar.setEntity(a);
				items.add(tempVar);
			}
		}
		model.setItems(items);

		boolean noItems = items.isEmpty();

		java.util.ArrayList<network> networks = Linq.<network>Cast(getItems());
		for (EntityModel item : items)
		{
			network net = (network)item.getEntity();
			//				Selector.SetIsSelected(item, networks.Any(a => a.id == network.id));
			boolean value = false;
			for (network a : networks)
			{
				if (a.getId().equals(net.getId()))
				{
					value = true;
					break;
				}
			}
			item.setIsSelected(value);
		}


		UICommand tempVar2 = new UICommand("Cancel", this);
		tempVar2.setTitle("Cancel");
		tempVar2.setIsDefault(noItems);
		tempVar2.setIsCancel(true);
		model.getCommands().add(tempVar2);

		if (!noItems)
		{
			UICommand tempVar3 = new UICommand("OnManage", this);
			tempVar3.setTitle("OK");
			tempVar3.setIsDefault(true);
			model.getCommands().add(0, tempVar3);
		}
	}

	public void OnManage()
	{
		ListModel model = (ListModel)getWindow();

		java.util.ArrayList<EntityModel> items = Linq.<EntityModel>Cast(model.getItems());
		java.util.ArrayList<network> networks = Linq.<network>Cast(getItems());

		if (getEntity() == null)
		{
			Cancel();
			return;
		}

		java.util.ArrayList<VdcActionParametersBase> prms1 = new java.util.ArrayList<VdcActionParametersBase>();
		for (EntityModel a : items)
		{
			boolean value = false;
			for (network b : networks)
			{
				if (b.getId().equals(((network)a.getEntity()).getId()))
				{
					value = true;
					break;
				}
			}
			if (a.getIsSelected() && !value)
			{
				prms1.add(new AttachNetworkToVdsGroupParameter(getEntity(), (network)a.getEntity()));
			}
		}

		// Call the command only if necessary (i.e. only if there are paramters):
		if (prms1.size() > 0)
		{
			Frontend.RunMultipleAction(VdcActionType.AttachNetworkToVdsGroup, prms1);
		}


		java.util.ArrayList<VdcActionParametersBase> prms2 = new java.util.ArrayList<VdcActionParametersBase>();
		for (EntityModel a : items)
		{
			if (!a.getIsSelected())
			{
				prms2.add(new AttachNetworkToVdsGroupParameter(getEntity(), (network)a.getEntity()));
			}
		}

		// Call the command only if necessary (i.e. only if there are paramters):
		if (prms2.size() > 0)
		{
			Frontend.RunMultipleAction(VdcActionType.DetachNetworkToVdsGroup, prms2);
		}

		Cancel();
	}

	public void Cancel()
	{
		setWindow(null);
	}

	@Override
	protected void EntityChanging(Object newValue, Object oldValue)
	{
		VDSGroup vdsGroup = (VDSGroup)newValue;
		getNewNetworkCommand().setIsExecutionAllowed(vdsGroup != null && vdsGroup.getstorage_pool_id() != null);
	}

	@Override
	protected void OnSelectedItemChanged()
	{
		super.OnSelectedItemChanged();
		UpdateActionAvailability();
	}

	@Override
	protected void SelectedItemsChanged()
	{
		super.SelectedItemsChanged();
		UpdateActionAvailability();
	}

	private void UpdateActionAvailability()
	{
		network network = (network)getSelectedItem();

		//CanRemove = SelectedItems != null && SelectedItems.Count > 0;
		getSetAsDisplayCommand().setIsExecutionAllowed(getSelectedItems() != null && getSelectedItems().size() == 1 && network != null && !(network.getis_display() == null ? false : network.getis_display()) && network.getStatus() != NetworkStatus.NonOperational);
	}

	public void New()
	{
		if (getWindow() != null)
		{
			return;
		}

		ClusterNetworkModel model = new ClusterNetworkModel();
		setWindow(model);
		model.setTitle("New Logical Network");
		model.setHashName("new_logical_network");
		model.setIsNew(true);
		if (getEntity().getstorage_pool_id() != null)
		{
			storage_pool dataCenter = DataProvider.GetDataCenterById(getEntity().getstorage_pool_id().getValue());
			if (dataCenter != null)
			{
				model.setDataCenterName(dataCenter.getname());
			}
		}
		UICommand tempVar = new UICommand("OnSave", this);
		tempVar.setTitle("OK");
		tempVar.setIsDefault(true);
		model.getCommands().add(tempVar);

		UICommand tempVar2 = new UICommand("Cancel", this);
		tempVar2.setTitle("Cancel");
		tempVar2.setIsCancel(true);
		model.getCommands().add(tempVar2);
	}

	public void OnSave()
	{
		ClusterNetworkModel model = (ClusterNetworkModel)getWindow();
		network network = new network();

		if (getEntity() == null)
		{
			Cancel();
			return;
		}

		if (!model.Validate() || getEntity().getstorage_pool_id() == null)
		{
			return;
		}

		network.setstorage_pool_id(getEntity().getstorage_pool_id());
		network.setname((String)model.getName().getEntity());
		network.setstp(model.getIsStpEnabled());
		network.setdescription((String)model.getDescription().getEntity());
		network.setvlan_id(null);
		if (model.getHasVLanTag())
		{
			network.setvlan_id(Integer.parseInt(model.getVLanTag().getEntity().toString()));
		}
		VdcReturnValueBase returnValue = Frontend.RunAction(VdcActionType.AddNetwork, new AddNetworkStoragePoolParameters(network.getstorage_pool_id().getValue(), network));

		if (returnValue != null && returnValue.getSucceeded())
		{
			network tempVar = new network();
			tempVar.setId((Guid)returnValue.getActionReturnValue());
			tempVar.setname(network.getname());
			Frontend.RunAction(VdcActionType.AttachNetworkToVdsGroup, new AttachNetworkToVdsGroupParameter(getEntity(), tempVar));
			Cancel();
		}
	}



	@Override
	public void ExecuteCommand(UICommand command)
	{
		super.ExecuteCommand(command);

		if (command == getManageCommand())
		{
			Manage();
		}
		else if (command == getSetAsDisplayCommand())
		{
			SetAsDisplay();
		}

		else if (StringHelper.stringsEqual(command.getName(), "OnManage"))
		{
			OnManage();
		}
		else if (StringHelper.stringsEqual(command.getName(), "New"))
		{
			New();
		}
		else if (StringHelper.stringsEqual(command.getName(), "OnSave"))
		{
			OnSave();
		}
		else if (StringHelper.stringsEqual(command.getName(), "Cancel"))
		{
			Cancel();
		}
	}

}