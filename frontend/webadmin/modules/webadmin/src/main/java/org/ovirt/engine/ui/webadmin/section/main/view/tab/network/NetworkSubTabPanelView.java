package org.ovirt.engine.ui.webadmin.section.main.view.tab.network;

import org.ovirt.engine.core.common.businessentities.network.NetworkView;
import org.ovirt.engine.ui.common.idhandler.ElementIdHandler;
import org.ovirt.engine.ui.common.presenter.OvirtBreadCrumbsPresenterWidget;
import org.ovirt.engine.ui.common.widget.tab.AbstractTabPanel;
import org.ovirt.engine.ui.common.widget.tab.DetailTabLayout;
import org.ovirt.engine.ui.uicommonweb.models.networks.NetworkListModel;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.NetworkActionPanelPresenterWidget;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.network.NetworkSubTabPanelPresenter;
import org.ovirt.engine.ui.webadmin.section.main.view.AbstractSubTabPanelView;
import org.ovirt.engine.ui.webadmin.widget.tab.SimpleTabPanel;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;

public class NetworkSubTabPanelView extends AbstractSubTabPanelView implements NetworkSubTabPanelPresenter.ViewDef {

    interface ViewIdHandler extends ElementIdHandler<NetworkSubTabPanelView> {
        ViewIdHandler idHandler = GWT.create(ViewIdHandler.class);
    }

    private final SimpleTabPanel tabPanel;

    @Inject
    public NetworkSubTabPanelView(OvirtBreadCrumbsPresenterWidget<NetworkView, NetworkListModel> breadCrumbs,
            NetworkActionPanelPresenterWidget actionPanel, DetailTabLayout detailTabLayout) {
        tabPanel = new SimpleTabPanel(breadCrumbs, actionPanel, detailTabLayout);
        initWidget(getTabPanel());
        actionPanel.removeButton(actionPanel.getNewButtonDefinition());
        actionPanel.removeButton(actionPanel.getImportButtonDefinition());
    }

    @Override
    protected void generateIds() {
        ViewIdHandler.idHandler.generateAndSetIds(this);
    }

    @Override
    protected Object getContentSlot() {
        return NetworkSubTabPanelPresenter.TYPE_SetTabContent;
    }

    @Override
    protected AbstractTabPanel getTabPanel() {
        return tabPanel;
    }

}

