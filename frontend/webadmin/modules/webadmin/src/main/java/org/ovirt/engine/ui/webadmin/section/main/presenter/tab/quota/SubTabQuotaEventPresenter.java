package org.ovirt.engine.ui.webadmin.section.main.presenter.tab.quota;

import org.ovirt.engine.core.common.businessentities.AuditLog;
import org.ovirt.engine.core.common.businessentities.Quota;
import org.ovirt.engine.ui.common.presenter.AbstractSubTabPresenter;
import org.ovirt.engine.ui.common.uicommon.model.SearchableDetailModelProvider;
import org.ovirt.engine.ui.uicommonweb.models.quota.QuotaEventListModel;
import org.ovirt.engine.ui.uicommonweb.models.quota.QuotaListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.DetailTabDataIndex;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

public class SubTabQuotaEventPresenter
    extends AbstractSubTabQuotaPresenter<QuotaEventListModel, SubTabQuotaEventPresenter.ViewDef,
        SubTabQuotaEventPresenter.ProxyDef> {

    @ProxyCodeSplit
    @NameToken(WebAdminApplicationPlaces.quotaEventSubTabPlace)
    public interface ProxyDef extends TabContentProxyPlace<SubTabQuotaEventPresenter> {
    }

    public interface ViewDef extends AbstractSubTabPresenter.ViewDef<Quota> {
    }

    @TabInfo(container = QuotaSubTabPanelPresenter.class)
    static TabData getTabData() {
        return DetailTabDataIndex.QUOTA_EVENT;
    }

    @Inject
    public SubTabQuotaEventPresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, QuotaMainTabSelectedItems selectedItems,
            SearchableDetailModelProvider<AuditLog, QuotaListModel, QuotaEventListModel> modelProvider) {
        // View doesn't have an actionPanel, passing null.
        super(eventBus, view, proxy, placeManager, modelProvider, selectedItems, null,
                QuotaSubTabPanelPresenter.TYPE_SetTabContent);
    }

}
