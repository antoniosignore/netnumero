package com.numhero.client.mvp.timeentry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.timeentry.*;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericTimeTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.Date;

@Singleton
public class TimeEntryPresenter extends EditPresenter {

    Service<GetTimeEntryRequest, GetTimeEntryResponse> timeentryGetService;
    Service<SaveTimeEntryRequest, SaveTimeEntryResponse> timeentrySaveService;
    private Service<TimeEntryListRequest, TimeEntryListResponse> timeEntriesListService;
    private Service<DeleteTimeEntriesRequest, BulkActionResponse> deleteTimeEntriesService;
    private TimeEntryConstants constants;


    @Inject
    public TimeEntryPresenter(PlaceManager eventManager,
                              Service<GetTimeEntryRequest, GetTimeEntryResponse> timeentryGetService,
                              Service<SaveTimeEntryRequest, SaveTimeEntryResponse> timeentrySaveService,
                              TimeEntryPanel timeEntryPanel,
                              Service<TimeEntryListRequest, TimeEntryListResponse> timeEntriesListService,
                              Service<DeleteTimeEntriesRequest, BulkActionResponse> deleteTimeEntriesService,
                              TimeEntryConstants constants) {
        super(eventManager, new GenericTimeTabEditPage(timeEntryPanel));
        this.timeentryGetService = timeentryGetService;
        this.timeentrySaveService = timeentrySaveService;
        this.timeEntriesListService = timeEntriesListService;
        this.deleteTimeEntriesService = deleteTimeEntriesService;
//        final TimeEntriesTable table = getTimeEntryPanel().getTimeEntriesTable();
//        Command deleteCommand = new Command() {
//            public void execute() {
//                deleteTimeEntries(table.getSelectedIds());
//            }
//        };

//        table.getFooter().getTableFooterActionsCombo().setAnimationEnabled(true);
//        table.getFooter().getTableFooterActionsCombo().setAutoOpen(true);
//        MenuBar bulkActions = new MenuBar(true);
//        bulkActions.addItem(new MenuItem(Application.getConstants().deleteTimeEntries(), deleteCommand));
//        table.getFooter().getTableFooterActionsCombo().addItem(new MenuItem(Application.getConstants().bulkAction(), bulkActions));
        this.constants = constants;
    }

    private TimeEntryPanel getTimeEntryPanel() {
        return ((TimeEntryPanel) getView().getContentPanel().getContentWidget());
    }

//    private void deleteTimeEntries(List<Long> selectedIds) {
//        if (ClientUtils.warnNotEmptyIds(selectedIds)) return;
//
//        DeleteTimeEntriesRequest request = new DeleteTimeEntriesRequest();
//        request.setEntityIdList(selectedIds);
//        deleteTimeEntriesService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
//            @Override
//            public void onSuccess(BulkActionResponse response) {
//                if (!response.getFailureIdList().isEmpty()) Window.alert("Errors deleting time entries");
//                refreshFromServer();
//            }
//        });
//    }


    @Override
    public GenericTimeTabEditPage getView() {
        return (GenericTimeTabEditPage) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            getTimeEntryPanel().setPojo(new TimeEntry());
            getView().setDetailTitlePanel(constants.newTimeLog());
        } else {
            getView().setDetailTitlePanel(constants.editTimeLog());
            GetTimeEntryRequest request = new GetTimeEntryRequest();
            request.setEntityId(getUrl().getId());
            timeentryGetService.execute(request, new ServiceCallbackImpl<GetTimeEntryResponse>() {
                @Override
                public void onSuccess(GetTimeEntryResponse response) {
                    getTimeEntryPanel().setPojo(response.getEntity());
                }
            });
        }
//        refreshFromServer();
    }

    private ClickHandler saveTimeEntryHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TimeEntry timeEntry = getTimeEntryPanel().getTimeEntry();
                if (getTimeEntryPanel().saveValuesFromUi()) {
                    if (timeEntry.fBilled.getValue())
                        Window.alert(Application.getConstants().timeEntryAlreadyBilled());
                    else {
                        SaveTimeEntryRequest request = new SaveTimeEntryRequest();
                        timeEntry.fDate.setValue(getTimeEntryPanel().getSelectedDate().getValue());
                        request.setEntity(timeEntry);
                        timeentrySaveService.execute(request, new ServiceCallbackImpl<SaveTimeEntryResponse>() {
                            @Override
                            public void onSuccess(SaveTimeEntryResponse response) {
                                Application.toasterMessage(Application.getConstants().timeEntrySaved());
                                redirect();
                            }
                        });
                    }
                }
            }
        };
        return ret;
    }

    @Override
    protected void onBind() {
        super.onBind();
        final TimeEntryPanel panel = getTimeEntryPanel();
        panel.getSelectedDate().setValue(new Date());
        panel.getBtSave().addClickHandler(saveTimeEntryHandler());
        panel.getBtCancel().addClickHandler(cancelTimeEntryHandler());
    }

    private ClickHandler cancelTimeEntryHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                redirect();
            }
        };
        return ret;
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

//    private void refreshFromServer() {
//        TimeEntryListRequest request = new TimeEntryListRequest();
//        timeEntriesListService.execute(request, new ServiceCallbackImpl<TimeEntryListResponse>() {
//            @Override
//            public void onSuccess(TimeEntryListResponse response) {

    //                getTimeEntryPanel().getTimeEntriesTable().setTimeEntries(response.getTimeEntryList());
//            }
//        });
//    }
//
    @Override
    protected String getReturnUrl() {
        return "timeentries";
    }
}
