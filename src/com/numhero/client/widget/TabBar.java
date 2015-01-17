package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TabBar extends Composite {

    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    interface HeaderUiBinder extends UiBinder<Widget, TabBar> {
    }

    public enum INumheroTab {
        dashboard, moneyin, moneyout, clients, staff, time, reports, accounts, search
    }

    @UiField
    LIElement dashboard;
    @UiField
    LIElement moneyin;
    @UiField
    LIElement moneyout;
    @UiField
    LIElement time;
    @UiField
    LIElement clients;
    @UiField
    LIElement staff;
    @UiField
    LIElement accounts;
    @UiField
    LIElement reports;
    @UiField
    LIElement search;

    private LIElement currentSelection;

    public TabBar() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setActiveTab(INumheroTab tab) {
        switch (tab) {
            case dashboard: {
                activateTab(dashboard);
                break;
            }
            case moneyin: {
                activateTab(moneyin);
                break;
            }
            case moneyout: {
                activateTab(moneyout);
                break;
            }
            case clients: {
                activateTab(clients);
                break;
            }
            case staff: {
                activateTab(staff);
                break;
            }
            case time: {
                activateTab(time);
                break;
            }

            case reports: {
                activateTab(reports);
                break;
            }

            case accounts: {
                activateTab(accounts);
                break;
            }

            case search: {
                activateTab(search);
                break;
            }
        }
    }

    private void activateTab(LIElement anchor) {
        if (currentSelection != null) {
            currentSelection.removeClassName("selected");
        }
        currentSelection = anchor;
        currentSelection.setClassName("selected");
    }
}
