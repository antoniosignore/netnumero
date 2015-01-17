package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.Application;

import java.util.Date;

public class HeaderLine extends Composite {

    private static HeaderLineUiBinder uiBinder = GWT.create(HeaderLineUiBinder.class);

    interface HeaderLineUiBinder extends UiBinder<Widget, HeaderLine> {
    }


    @UiField
    HeaderLineStyle style;  //FIXME not bound to uibinder

    @UiField
    AnchorElement myAccount;

    @UiField
    AnchorElement settings;

//    @UiField
//    AnchorElement users; //TODO 1.1 version stuff

    @UiField
    AnchorElement help;

    @UiField
    SpanElement currentDate;

    @UiField
    AnchorElement logout;

    private AnchorElement currentSelection;

    interface HeaderLineStyle extends CssResource {
        String current();
    }

    public HeaderLine() {
        initWidget(uiBinder.createAndBindUi(this));
        currentDate.setInnerText(Application.getMessages().currentDate(new Date()));

        //TODO  logout should remove the cookie too

    }

    public enum Tab {
        MY_ACCOUNT, SETTINGS, USERS, HELP, LOGOUT
    }

    public void setActiveTab(HeaderLine.Tab tab) {
        switch (tab) {
            case MY_ACCOUNT: {
                activateAnchor(myAccount);
                break;
            }
            case SETTINGS: {
                activateAnchor(settings);
                break;
            }
//            case USERS: {                  //TODO 1.1 stuff
//                activateAnchor(users);
//                break;
//            }
            case HELP: {
                activateAnchor(help);
                break;
            }
            case LOGOUT: {
                activateAnchor(logout);
                break;
            }
        }
    }

    private void activateAnchor(AnchorElement anchor) {
        if (currentSelection != null) {
            currentSelection.removeClassName(style.current());
        }
        currentSelection = anchor;
        currentSelection.setClassName(style.current());
    }


}


