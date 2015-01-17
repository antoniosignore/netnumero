package com.numhero.client.widget.combobox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.NetNumeroSuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.pojoc.SearchablePojo;

public abstract class DropDownBox<REQUEST extends ListCommandRequest, RESPONSE extends ListCommandResponse<?>> extends Composite
        implements Focusable, SelectionHandler<Suggestion> {

    public interface DropDownBoxHandler {
        public void itemSelected(Suggestion pojo);
    }

    @SuppressWarnings("rawtypes")
    interface DropDownBoxUiBinder extends UiBinder<Widget, DropDownBox> {
    }

    private static DropDownBoxUiBinder uiBinder = GWT.create(DropDownBoxUiBinder.class);

    @UiField(provided = true)
    protected NetNumeroSuggestBox suggestBox;

    @UiField
    protected Anchor btDropDown;

    protected Service<REQUEST, RESPONSE> getListService;
    protected DropDownBoxHandler handler;
    protected ServerSuggestOracle<REQUEST, RESPONSE> sso;
    protected REQUEST request;

    public DropDownBox(Service<REQUEST, RESPONSE> getListService, REQUEST request) {
        this.getListService = getListService;
        this.request = request;

        sso = createSuggestOracle(getListService, request);
        addCommandItems(sso);
        suggestBox = new NetNumeroSuggestBox(this, sso);
        suggestBox.setWidth("100%");
        suggestBox.addSelectionHandler(this);
        suggestBox.getTextBox().addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_DOWN) {
                    if (!suggestBox.isSuggestionListShowing()) {
                        suggestBox.showSuggestionList(false);
                        event.stopPropagation();
                    }
                } else if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
                    if (suggestBox.isSuggestionListShowing()) {
                        suggestBox.hideSuggestionList();
                        event.stopPropagation();
                    }
                }
            }
        });
        suggestBox.getTextBox().addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                initPojo();
                suggestBox.setValue(getPojo().getReplacementString());
                itemSelected();
            }
        });

//        suggestBox.getTextBox().addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//                suggestBox.showSuggestionList(false);
//			}
//		});

        initWidget(uiBinder.createAndBindUi(this));
        suggestBox.getSuggestionPopup().addAutoHidePartner(btDropDown.getElement());
        btDropDown.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (suggestBox.isSuggestionListShowing()) {
                    suggestBox.hideSuggestionList();
                } else {
                    suggestBox.showSuggestionList(true);
                }
            }
        });
    }

    protected abstract void initPojo();

    public void setHandler(DropDownBoxHandler handler) {
        this.handler = handler;
    }

    public NetNumeroSuggestBox getSuggestBox() {
        return suggestBox;
    }

    public Anchor getBtDropDown() {
        return btDropDown;
    }

    @Override
    public int getTabIndex() {
        return suggestBox.getTabIndex();
    }

    @Override
    public void setTabIndex(int index) {
        suggestBox.setTabIndex(index);
    }

    @Override
    public void setAccessKey(char key) {
        suggestBox.setAccessKey(key);
    }

    @Override
    public void setFocus(boolean focused) {
        suggestBox.setFocus(focused);
    }

    @Override
    public void onSelection(SelectionEvent<Suggestion> event) {
        if (event.getSelectedItem() instanceof CommandItem) {
            commandSelected((CommandItem) event.getSelectedItem());
        } else {
            Suggestion pojo = event.getSelectedItem();
            if (pojo instanceof SearchablePojo) {
                pojo = ((SearchablePojo) event.getSelectedItem()).clone();
            }
            setPojo(pojo);
            itemSelected();
        }
    }

    public void setPojo(Suggestion pojo) {
        suggestBox.setValue(pojo.getReplacementString());
    }

    public abstract Suggestion getPojo();

    // private methods ---------------------------------------------------
    protected abstract void commandSelected(CommandItem commandItem);

    protected void itemSelected() {
        if (handler != null) {
            handler.itemSelected(getPojo());
        }
    }

    protected ServerSuggestOracle<REQUEST, RESPONSE> createSuggestOracle(Service<REQUEST, RESPONSE> getListService, REQUEST request) {
        ServerSuggestOracle<REQUEST, RESPONSE> ret = new ServerSuggestOracle<REQUEST, RESPONSE>(getListService, request);
        return ret;
    }

    protected void addCommandItems(ServerSuggestOracle<REQUEST, RESPONSE> so) {
    }
}
