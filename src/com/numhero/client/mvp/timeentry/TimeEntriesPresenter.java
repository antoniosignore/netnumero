package com.numhero.client.mvp.timeentry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest;
import com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericTimeTabViewPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

@Singleton
public class TimeEntriesPresenter extends GridPresenter {

	private Service<TimeEntryListRequest, TimeEntryListResponse> timeEntriesListService;
	private Service<DeleteTimeEntriesRequest, BulkActionResponse> deleteTimeEntriesService;

	BAPojoFilter filter = null;
	private TimeEntriesTable table = null;

	@Inject
	public TimeEntriesPresenter(PlaceManager eventManager,
								Service<TimeEntryListRequest, TimeEntryListResponse> timeEntriesListService,
								Service<DeleteTimeEntriesRequest, BulkActionResponse> deleteTimeEntriesService,
								TimeEntriesTable timeEntriesTable, final TimeEntryConstants constants) {

		super(eventManager, new GenericTimeTabViewPage(timeEntriesTable));

		this.timeEntriesListService = timeEntriesListService;
		this.deleteTimeEntriesService = deleteTimeEntriesService;

		timeEntriesTable.getFilter().getSbStaff().setVisible(true);
		timeEntriesTable.getFilter().getSbProject().setVisible(true);
		timeEntriesTable.getFilter().getSbTask().setVisible(true);

		timeEntriesTable.getFilter().getStaffLabel().setVisible(true);
		timeEntriesTable.getFilter().getProjectLabel().setVisible(true);
		timeEntriesTable.getFilter().getTaskLabel().setVisible(true);

		getView().setDetailTitlePanel(constants.viewTimeEntries());
		table = (TimeEntriesTable) getView().getContentPanel().getContentWidget();

		CommandWrapper deleteTimeEntriesCommand = new CommandWrapper(constants.deleteTimeEntries(),new Command() {
			public void execute() {
				deleteTimeEntries(table.getSelectedIds());
			}
		});

		table.getFilter().getBtFilter().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				refreshFromServer();
			}
        });

		getView().addActionsCommands(deleteTimeEntriesCommand);

	}

	private void deleteTimeEntries(List<Long> ids) {
		if (ClientUtils.warnNotEmptyIds(ids, getView())) return;
		DeleteTimeEntriesRequest request = new DeleteTimeEntriesRequest();
		request.setEntityIdList(ids);
		deleteTimeEntriesService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
			@Override
			public void onSuccess(BulkActionResponse response) {
				if (!response.getFailureIdList().isEmpty()) {
					Window.alert(Application.getConstants().errorDeleting());
				} else {
					Application.toasterMessage(Application.getConstants().itemsDeleted());
				}
				refreshFromServer();
			}

		});
	}


	protected void refreshFromServer() {
		super.refreshFromServer();
		TimeEntryListRequest request = new TimeEntryListRequest();
		filter = table.getFilter().getFilter();
		request.setFilter(filter);

		setPagination(request);
		super.refreshFromServer();

		timeEntriesListService.execute(request, new ServiceCallbackImpl<TimeEntryListResponse>() {
			@Override
			public void onSuccess(TimeEntryListResponse response) {
//                ((TimeEntriesTable) getView().getContentPanel().getContentWidget()).setTimeEntries(response.getEntityList());
//                getTable().manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
				getView().putEntitiesInGrid(response);
			}
		});
	}

}
