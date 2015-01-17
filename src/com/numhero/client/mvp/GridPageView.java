package com.numhero.client.mvp;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.shared.datacargo.ListCommandResponse;

import java.util.List;

public interface GridPageView extends PageView {
    void showLoading();

    void putEntitiesInGrid(ListCommandResponse<?> response);

    List<Long> getSelectedIds();

    void prepareTable(ClickHandler lastPageClickHandler, ClickHandler firstPageClickHandler, ClickHandler prevPageClickHandler, ClickHandler nextPageClickHandler);

    String getLastRowKey(); //todo Mikado should be Long

    String getFirstRowKey(); //todo Mikado should be Long

	void showErrorDeleting();

	void showDeletedEntitiesToaster();


    void addActionsCommands(CommandWrapper... commands);

    void ShowNoneSelectedError();

    void showOneRowError();
}
