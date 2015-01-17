package com.numhero.client.mvp.report.chartofaccounts;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.pojoc.LedgerAccountIF;
import com.numhero.client.mvp.accounting.LedgerAccountDialog;
import com.numhero.client.mvp.accounting.LedgerAccountPanel;
import com.numhero.client.service.Service;
import com.numhero.client.widget.table.AbstractTableWithHeaderAndFooter;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.List;

public class ChartOfAccountsTable extends AbstractTableWithHeaderAndFooter {

    public void setAccounts(List<SearchablePojo> ledgerAccounts,
                            Service<AccountBalanceRequest, AccountBalanceResponse> getAccountBalance) {
        removeAllRows();
        if (ledgerAccounts != null)
            for (int row = 0; row < ledgerAccounts.size(); row++) {
                final LedgerAccountIF entry = (LedgerAccountIF) ledgerAccounts.get(row);
                Anchor l = entryDialogBox(entry, getAccountBalance);
                setWidget(row, 0, l);
                setText(row, 1, entry.getAccountingGroup().toString());
                setText(row, 2, entry.getDescription());
            }
        addEmptyStatus();
    }

    private Anchor entryDialogBox(final LedgerAccountIF entry, final Service<AccountBalanceRequest, AccountBalanceResponse> getAccountBalance) {
        Anchor l = new Anchor(entry.getName(), false);
        l.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final LedgerAccountPanel panel = new LedgerAccountPanel();
                panel.getLedgerAccountTable().setAccountIF(entry, getAccountBalance);
                final LedgerAccountDialog dialog = new LedgerAccountDialog(panel, entry.getName());
                panel.getBtCancel().addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        dialog.hide();
                    }
                });
                dialog.center();
            }
        });
        return l;
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_LEFT, "240px");
        setHeader(1, Application.getConstants().group(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "%");
    }
}
