package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.user.client.Command;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

public abstract class AbstractClientsSuppliersPresenter extends GridPresenter {
    protected Service<DeleteClientsSuppliersRequest, BulkActionResponse> deleteClientsSuppliersService;
    protected ClientsConstants consts;

    public AbstractClientsSuppliersPresenter(PlaceManager eventManager, GridPageView view, ClientsConstants clientsConstants, Service<DeleteClientsSuppliersRequest, BulkActionResponse> deleteClientsSuppliersService) {
        super(eventManager, view);
        this.consts = clientsConstants;
        this.deleteClientsSuppliersService = deleteClientsSuppliersService;
    }

    protected void setupBulkActionMenu() {
        CommandWrapper raiseInvoicesCommand = new CommandWrapper(consts.raiseInvoices(), new Command() {
            @Override
            public void execute() {
               raiseInvoices(getView().getSelectedIds());

            }
        });

        CommandWrapper raiseEstimatesCommand = new CommandWrapper(consts.raiseEstimates(), new Command() {

            public void execute() {
                raiseEstimates(getView().getSelectedIds());
            }
        });

        CommandWrapper raiseExpensesCommand = new CommandWrapper(consts.raiseExpenses(), new Command() {


            public void execute() {
                raiseExpenses(getView().getSelectedIds());
            }
        });
        CommandWrapper deleteClientsCommand = new CommandWrapper(consts.deleteClients(), new Command() {

            public void execute() {
                deleteEntities(new DeleteClientsSuppliersRequest(), deleteClientsSuppliersService);
            }
        });

        getView().addActionsCommands(raiseInvoicesCommand, raiseEstimatesCommand, raiseExpensesCommand, deleteClientsCommand);
    }

    private void raiseInvoices(List<Long> ids) {
        if (warnNotEmptyIds(ids)) return;
        redirectToEntity(ids.get(0), "invoice");
    }

    private void raiseEstimates(List<Long> ids) {
        if (warnNotEmptyIds(ids)) return;
        redirectToEntity(ids.get(0), "estimate");
    }

    private void raiseExpenses(List<Long> ids) {
        if (warnNotEmptyIds(ids)) return;
        redirectToEntity(ids.get(0), "expense");
    }




}
