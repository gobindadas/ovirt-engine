package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import java.util.List;

import org.ovirt.engine.core.common.businessentities.StorageDomain;
import org.ovirt.engine.ui.common.place.PlaceRequestFactory;
import org.ovirt.engine.ui.common.presenter.OvirtBreadCrumbsPresenterWidget;
import org.ovirt.engine.ui.common.uicommon.model.GroupedTabData;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.uicommonweb.models.storage.StorageListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.section.main.presenter.AbstractMainTabWithDetailsPresenter;
import org.ovirt.engine.ui.webadmin.section.main.presenter.MainTabPanelPresenter;
import org.ovirt.engine.ui.webadmin.section.main.presenter.SearchPanelPresenterWidget;
import org.ovirt.engine.ui.webadmin.widget.tab.MenuLayoutMenuDetails;
import org.ovirt.engine.ui.webadmin.widget.tab.WebadminMenuLayout;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.annotation.GenEvent;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class MainTabStoragePresenter extends AbstractMainTabWithDetailsPresenter<StorageDomain, StorageListModel, MainTabStoragePresenter.ViewDef, MainTabStoragePresenter.ProxyDef> {

    @GenEvent
    public class StorageSelectionChange {

        List<StorageDomain> selectedItems;

    }

    @ProxyCodeSplit
    @NameToken(WebAdminApplicationPlaces.storageMainTabPlace)
    public interface ProxyDef extends TabContentProxyPlace<MainTabStoragePresenter> {
    }

    public interface ViewDef extends AbstractMainTabWithDetailsPresenter.ViewDef<StorageDomain> {
    }

    @TabInfo(container = MainTabPanelPresenter.class)
    static TabData getTabData(WebadminMenuLayout menuLayout) {
        MenuLayoutMenuDetails menuDetails = menuLayout.getDetails(
                WebAdminApplicationPlaces.storageMainTabPlace);
        return new GroupedTabData(menuDetails);
    }

    @Inject
    public MainTabStoragePresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, MainModelProvider<StorageDomain, StorageListModel> dataProvider,
            SearchPanelPresenterWidget<StorageDomain, StorageListModel> searchPanelPresenterWidget,
            OvirtBreadCrumbsPresenterWidget<StorageDomain, StorageListModel> breadCrumbs,
            StorageActionPanelPresenterWidget actionPanel) {
        super(eventBus, view, proxy, placeManager, dataProvider, searchPanelPresenterWidget, breadCrumbs, actionPanel);
    }

    @Override
    protected void fireTableSelectionChangeEvent() {
        StorageSelectionChangeEvent.fire(this, getSelectedItems());
    }

    @Override
    protected PlaceRequest getMainTabRequest() {
        return PlaceRequestFactory.get(WebAdminApplicationPlaces.storageMainTabPlace);
    }

}
