package org.ovirt.engine.ui.webadmin.section.main.presenter.tab.profile;

import org.ovirt.engine.core.common.businessentities.network.VnicProfileView;
import org.ovirt.engine.ui.common.place.PlaceRequestFactory;
import org.ovirt.engine.ui.common.presenter.AbstractSubTabPresenter;
import org.ovirt.engine.ui.common.presenter.DetailActionPanelPresenterWidget;
import org.ovirt.engine.ui.common.uicommon.model.DetailModelProvider;
import org.ovirt.engine.ui.uicommonweb.models.HasEntity;
import org.ovirt.engine.ui.uicommonweb.models.profiles.VnicProfileListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public abstract class AbstractSubTabVnicProfilePresenter<D extends HasEntity<?>,
    V extends AbstractSubTabPresenter.ViewDef<VnicProfileView>, P extends TabContentProxyPlace<?>>
        extends AbstractSubTabPresenter <VnicProfileView, VnicProfileListModel, D, V, P> {

    public AbstractSubTabVnicProfilePresenter(EventBus eventBus, V view, P proxy, PlaceManager placeManager,
            DetailModelProvider<VnicProfileListModel, D> modelProvider, VnicProfileMainTabSelectedItems selectedItems,
            DetailActionPanelPresenterWidget<?, VnicProfileListModel, D> actionPanel,
            Type<RevealContentHandler<?>> slot) {
        super(eventBus, view, proxy, placeManager, modelProvider, selectedItems, actionPanel, slot);
    }

    @Override
    protected PlaceRequest getMainTabRequest() {
        return PlaceRequestFactory.get(WebAdminApplicationPlaces.vnicProfileMainTabPlace);
    }
}
