package com.google.gwt.user.client.ui;

/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.PopupPanel.AnimationType;
import com.google.gwt.user.client.ui.SuggestOracle.Callback;
import com.google.gwt.user.client.ui.SuggestOracle.Request;
import com.google.gwt.user.client.ui.SuggestOracle.Response;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;

import java.util.Collection;
import java.util.List;

/**
 * A {@link NetNumeroSuggestBox} is a text box or text area which displays a
 * pre-configured set of selections that match the user's input.
 * <p/>
 * Each {@link NetNumeroSuggestBox} is associated with a single {@link SuggestOracle}.
 * The {@link SuggestOracle} is used to provide a set of selections given a
 * specific query string.
 * <p/>
 * <p>
 * By default, the {@link NetNumeroSuggestBox} uses a {@link MultiWordSuggestOracle} as
 * its oracle. Below we show how a {@link MultiWordSuggestOracle} can be
 * configured:
 * </p>
 * <p/>
 * <pre>
 * MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
 * oracle.add(&quot;Cat&quot;);
 * oracle.add(&quot;Dog&quot;);
 * oracle.add(&quot;Horse&quot;);
 * oracle.add(&quot;Canary&quot;);
 * <p/>
 * SuggestBox box = new SuggestBox(oracle);
 * </pre>
 * <p/>
 * Using the example above, if the user types "C" into the text widget, the
 * oracle will configure the suggestions with the "Cat" and "Canary"
 * suggestions. Specifically, whenever the user types a key into the text
 * widget, the value is submitted to the <code>MultiWordSuggestOracle</code>.
 * <p/>
 * <p>
 * Note that there is no method to retrieve the "currently selected suggestion"
 * in a SuggestBox, because there are points in time where the currently
 * selected suggestion is not defined. For example, if the user types in some
 * text that does not match any of the SuggestBox's suggestions, then the
 * SuggestBox will not have a currently selected suggestion. It is more useful
 * to know when a suggestion has been chosen from the SuggestBox's list of
 * suggestions. A SuggestBox fires {@link SuggestionEvent SuggestionEvents}
 * whenever a suggestion is chosen, and handlers for these events can be added
 * using the {@link #addValueChangeHandler(ValueChangeHandler)} method.
 * </p>
 * <p/>
 * <p>
 * <img class='gallery' src='doc-files/SuggestBox.png'/>
 * </p>
 * <p/>
 * <h3>CSS Style Rules</h3>
 * <dl>
 * <dt>.gwt-SuggestBox</dt>
 * <dd>the suggest box itself</dd>
 * <dt>.gwt-SuggestBoxPopup</dt>
 * <dd>the suggestion popup</dd>
 * <dt>.gwt-SuggestBoxPopup .item</dt>
 * <dd>an unselected suggestion</dd>
 * <dt>.gwt-SuggestBoxPopup .item-selected</dt>
 * <dd>a selected suggestion</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupTopLeft</dt>
 * <dd>the top left cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupTopLeftInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupTopCenter</dt>
 * <dd>the top center cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupTopCenterInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupTopRight</dt>
 * <dd>the top right cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupTopRightInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupMiddleLeft</dt>
 * <dd>the middle left cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupMiddleLeftInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupMiddleCenter</dt>
 * <dd>the middle center cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupMiddleCenterInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupMiddleRight</dt>
 * <dd>the middle right cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupMiddleRightInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupBottomLeft</dt>
 * <dd>the bottom left cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupBottomLeftInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupBottomCenter</dt>
 * <dd>the bottom center cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupBottomCenterInner</dt>
 * <dd>the inner element of the cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupBottomRight</dt>
 * <dd>the bottom right cell</dd>
 * <dt>.gwt-SuggestBoxPopup .suggestPopupBottomRightInner</dt>
 * <dd>the inner element of the cell</dd>
 * </dl>
 *
 * @see SuggestOracle
 * @see MultiWordSuggestOracle
 * @see TextBoxBase
 */
public class NetNumeroSuggestBox extends Composite implements HasText, Focusable, HasAnimation,
        HasAllKeyHandlers, HasValue<String>, HasSelectionHandlers<Suggestion> {

    /**
     * The SuggestionMenu class is used for the display and selection of
     * suggestions in the SuggestBox widget. SuggestionMenu differs from MenuBar
     * in that it always has a vertical orientation, and it has no submenus. It
     * also allows for programmatic selection of items in the menu, and
     * programmatically performing the action associated with the selected item.
     * In the MenuBar class, items cannot be selected programatically - they can
     * only be selected when the user places the mouse over a particlar item.
     * Additional methods in SuggestionMenu provide information about the number
     * of items in the menu, and the index of the currently selected item.
     */
    private static class SuggestionMenu extends MenuBar {

        public SuggestionMenu(boolean vertical) {
            super(vertical);
            // Make sure that CSS styles specified for the default Menu classes
            // do not affect this menu
            setStyleName("");
            setFocusOnHoverEnabled(false);
        }

        public void doSelectedItemAction() {
            // In order to perform the action of the item that is currently
            // selected, the menu must be showing.
            MenuItem selectedItem = getSelectedItem();
            if (selectedItem != null) {
                doItemAction(selectedItem, true, false);
            }
        }

        public int getNumItems() {
            return getItems().size();
        }

        /**
         * Returns the index of the menu item that is currently selected.
         *
         * @return returns the selected item
         */
        public int getSelectedItemIndex() {
            // The index of the currently selected item can only be
            // obtained if the menu is showing.
            MenuItem selectedItem = getSelectedItem();
            if (selectedItem != null) {
                return getItems().indexOf(selectedItem);
            }
            return -1;
        }

        /**
         * Selects the item at the specified index in the menu. Selecting the
         * item does not perform the item's associated action; it only changes
         * the style of the item and updates the value of
         * SuggestionMenu.selectedItem.
         *
         * @param index index
         */
        public void selectItem(int index) {
            List<MenuItem> items = getItems();
            if (index > -1 && index < items.size()) {
                itemOver(items.get(index), false);
            }
        }
    }

    /**
     * Class for menu items in a SuggestionMenu. A SuggestionMenuItem differs
     * from a MenuItem in that each item is backed by a Suggestion object. The
     * text of each menu item is derived from the display string of a Suggestion
     * object, and each item stores a reference to its Suggestion object.
     */
    private static class SuggestionMenuItem extends MenuItem {

        private static final String STYLENAME_DEFAULT = "item";

        private Suggestion suggestion;

        public SuggestionMenuItem(Suggestion suggestion, boolean asHTML) {
            super(suggestion.getDisplayString(), asHTML);
            // Each suggestion should be placed in a single row in the
            // suggestion
            // menu. If the window is resized and the suggestion cannot fit on a
            // single row, it should be clipped (instead of wrapping around and
            // taking up a second row).
            DOM.setStyleAttribute(getElement(), "whiteSpace", "nowrap");
            setStyleName(STYLENAME_DEFAULT);
            setSuggestion(suggestion);
        }

        public Suggestion getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(Suggestion suggestion) {
            this.suggestion = suggestion;
        }
    }

    public static final int DEFAULT_LIMIT = 10;
    private static final String STYLENAME_DEFAULT = "gwt-SuggestBox";

    private int limit = DEFAULT_LIMIT;
    private int scrollLimit = 0;
    private boolean selectsFirstItem = true;
    private SuggestOracle oracle;
    private String currentText;
    private final SuggestionMenu suggestionMenu;
    private final DecoratedPopupPanel suggestionPopup;
    private final TextBoxBase box;
    private final Callback callback = new Callback() {
        public void onSuggestionsReady(Request request, Response response) {
            showSuggestions(response.getSuggestions());
        }
    };
    private Widget parent;

    /**
     * Constructor for {@link NetNumeroSuggestBox}. Creates a {@link TextBox} to use with
     * this {@link NetNumeroSuggestBox}.
     *
     * @param oracle the oracle for this <code>SuggestBox</code>
     */
    public NetNumeroSuggestBox(Widget parent, SuggestOracle oracle) {
        this(parent, oracle, new TextBox());
    }

    /**
     * Constructor for {@link NetNumeroSuggestBox}. The text box will be removed from
     * it's current location and wrapped by the {@link NetNumeroSuggestBox}.
     *
     * @param oracle supplies suggestions based upon the current contents of the
     *               text widget
     * @param box    the text widget
     */
    public NetNumeroSuggestBox(Widget parent, SuggestOracle oracle, TextBoxBase box) {
        this.parent = parent;
        this.box = box;
        initWidget(box);

        // suggestionMenu must be created before suggestionPopup, because
        // suggestionMenu is suggestionPopup's widget
        suggestionMenu = new SuggestionMenu(true);
        suggestionPopup = createPopup();
        suggestionPopup.setAnimationType(AnimationType.ROLL_DOWN);

        addEventsToTextBox();

        setOracle(oracle);
        setStyleName(STYLENAME_DEFAULT);
    }

    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return addDomHandler(handler, KeyDownEvent.getType());
    }

    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return addDomHandler(handler, KeyPressEvent.getType());
    }

    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        return addDomHandler(handler, KeyUpEvent.getType());
    }

    public HandlerRegistration addSelectionHandler(SelectionHandler<Suggestion> handler) {
        return addHandler(handler, SelectionEvent.getType());
    }

    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    /**
     * Gets the limit for the number of suggestions that should be displayed for
     * this box. It is up to the current {@link SuggestOracle} to enforce this
     * limit.
     *
     * @return the limit for the number of suggestions
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Gets the suggest box's
     * {@link com.google.gwt.user.client.ui.SuggestOracle}.
     *
     * @return the {@link SuggestOracle}
     */
    public SuggestOracle getSuggestOracle() {
        return oracle;
    }

    public int getTabIndex() {
        return box.getTabIndex();
    }

    public String getText() {
        return box.getText();
    }

    /**
     * Get the text box associated with this suggest box.
     *
     * @return this suggest box's text box
     */
    public TextBoxBase getTextBox() {
        return box;
    }

    public String getValue() {
        return box.getValue();
    }

    public DecoratedPopupPanel getSuggestionPopup() {
        return suggestionPopup;
    }

    /**
     * Hide current suggestions.
     */
    public void hideSuggestionList() {
        this.suggestionPopup.hide();
    }

    public boolean isAnimationEnabled() {
        return suggestionPopup.isAnimationEnabled();
    }

    /**
     * Returns whether or not the first suggestion will be automatically
     * selected. This behavior is on by default.
     *
     * @return true if the first suggestion will be automatically selected
     */
    public boolean isAutoSelectEnabled() {
        return selectsFirstItem;
    }

    /**
     * @return true if the list of suggestions is currently showing, false if
     *         not
     */
    public boolean isSuggestionListShowing() {
        return suggestionPopup.isShowing();
    }

    public void setAccessKey(char key) {
        box.setAccessKey(key);
    }

    public void setAnimationEnabled(boolean enable) {
        suggestionPopup.setAnimationEnabled(enable);
    }

    /**
     * Turns on or off the behavior that automatically selects the first
     * suggested item. This behavior is on by default.
     *
     * @param selectsFirstItem Whether or not to automatically select the first suggestion
     */
    public void setAutoSelectEnabled(boolean selectsFirstItem) {
        this.selectsFirstItem = selectsFirstItem;
    }

    public void setFocus(boolean focused) {
        box.setFocus(focused);
    }

    /**
     * Sets the limit to the number of suggestions the oracle should provide. It
     * is up to the oracle to enforce this limit.
     *
     * @param limit the limit to the number of suggestions provided
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setScrollLimit(int scrollLimit) {
        this.scrollLimit = scrollLimit;
    }

    /**
     * Sets the style name of the suggestion popup.
     *
     * @param style the new primary style name
     * @see UIObject#setStyleName(String)
     */
    public void setPopupStyleName(String style) {
        suggestionPopup.setStyleName(style);
    }

    public void setTabIndex(int index) {
        box.setTabIndex(index);
    }

    public void setText(String text) {
        box.setText(text);
    }

    public void setValue(String newValue) {
        box.setValue(newValue);
    }

    public void setValue(String value, boolean fireEvents) {
        box.setValue(value, fireEvents);
    }

    /**
     * Show the current list of suggestions.
     */
    public void showSuggestionList(boolean showAll) {
        if (isAttached()) {
            currentText = null;
            refreshSuggestions(showAll);
        }
    }

    /**
     * <b>Affected Elements:</b>
     * <ul>
     * <li>-popup = The popup that appears with suggestions.</li>
     * <li>-items-item# = The suggested item at the specified index.</li>
     * </ul>
     *
     * @see UIObject#onEnsureDebugId(String)
     */
    @Override
    protected void onEnsureDebugId(String baseID) {
        super.onEnsureDebugId(baseID);
        suggestionPopup.ensureDebugId(baseID + "-popup");
        suggestionMenu.setMenuItemDebugIds(baseID);
    }

    /**
     * Gets the specified suggestion from the suggestions currently showing.
     *
     * @param index the index at which the suggestion lives
     * @return the given suggestion
     * @throws IndexOutOfBoundsException if the index is greater then the number of suggestions
     *                                   currently showing
     */
    Suggestion getSuggestion(int index) {
        if (!isSuggestionListShowing()) {
            throw new IndexOutOfBoundsException("No suggestions showing, so cannot show " + index);
        }
        return ((SuggestionMenuItem) suggestionMenu.getItems().get(index)).suggestion;
    }

    /**
     * Get the number of suggestions that are currently showing.
     *
     * @return the number of suggestions currently showing, 0 if there are none
     */
    int getSuggestionCount() {
        return isSuggestionListShowing() ? suggestionMenu.getNumItems() : 0;
    }

    void showSuggestions(String query) {
        if (query == null || query.length() == 0) {
            oracle.requestDefaultSuggestions(new Request(null, limit), callback);
        } else {
            oracle.requestSuggestions(new Request(query, limit), callback);
        }
    }

    private void addEventsToTextBox() {
        class TextBoxEvents extends HandlesAllKeyEvents implements ValueChangeHandler<String> {

            public void onKeyDown(KeyDownEvent event) {
                // Make sure that the menu is actually showing. These keystrokes
                // are only relevant when choosing a suggestion.
                if (suggestionPopup.isAttached()) {
                    switch (event.getNativeKeyCode()) {
                        case KeyCodes.KEY_DOWN:
                            suggestionMenu.selectItem(suggestionMenu.getSelectedItemIndex() + 1);
                            break;
                        case KeyCodes.KEY_UP:
                            suggestionMenu.selectItem(suggestionMenu.getSelectedItemIndex() - 1);
                            break;
                        case KeyCodes.KEY_ENTER:
                        case KeyCodes.KEY_TAB:
                            if (suggestionMenu.getSelectedItemIndex() < 0) {
                                suggestionPopup.hide();
                            } else {
                                suggestionMenu.doSelectedItemAction();
                            }
                            break;
                    }
                }
                delegateEvent(NetNumeroSuggestBox.this, event);
            }

            public void onKeyPress(KeyPressEvent event) {
                delegateEvent(NetNumeroSuggestBox.this, event);
            }

            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() != KeyCodes.KEY_ESCAPE) {
                    // After every user key input, refresh the popup's suggestions.
                    refreshSuggestions(false);
                    delegateEvent(NetNumeroSuggestBox.this, event);
                }
            }

            public void onValueChange(ValueChangeEvent<String> event) {
                delegateEvent(NetNumeroSuggestBox.this, event);
            }
        }

        TextBoxEvents events = new TextBoxEvents();
        events.addKeyHandlersTo(box);
        box.addValueChangeHandler(events);
    }

    private DecoratedPopupPanel createPopup() {
        DecoratedPopupPanel p = new DecoratedPopupPanel(true, false, "suggestPopup") {
            @Override
            public void show() {
                super.show();
                if (scrollLimit > 0 && suggestionMenu.getNumItems() > scrollLimit) {
                    if (DOM.getStyleAttribute(getElement(), "width") == null || DOM.getStyleAttribute(getElement(), "width").length() == 0) {
                        int width = getOffsetWidth();
                        if (parent.getOffsetWidth() > width) {
                            width = parent.getOffsetWidth();
                        }
                        DOM.setStyleAttribute(getElement(), "width", Integer.toString(width + 15));
                    }
                    DOM.setStyleAttribute(getElement(), "height", Integer.toString(scrollLimit * 17 + (scrollLimit - 1) * 2 + 17));
                    DOM.setStyleAttribute(getElement(), "overflow", "auto");
                } else {
                    DOM.setStyleAttribute(getElement(), "width", "");
                    DOM.setStyleAttribute(getElement(), "height", "");
                }
            }
        };
        p.setWidget(suggestionMenu);
        p.setStyleName("gwt-SuggestBoxPopup");
        p.setPreviewingAllNativeEvents(true);
        p.addAutoHidePartner(getTextBox().getElement());
        return p;
    }

    private void fireSuggestionEvent(Suggestion selectedSuggestion) {
        SelectionEvent.fire(this, selectedSuggestion);
    }

    private void refreshSuggestions(boolean showAll) {
        String text = null;
        if (!showAll) {
            text = box.getText();
            if (text.equals(currentText)) {
                return;
            } else {
                currentText = text;
            }
        }
        showSuggestions(text);
    }

    private void setNewSelection(SuggestionMenuItem menuItem) {
        Suggestion curSuggestion = menuItem.getSuggestion();
        if (!(curSuggestion instanceof CommandItem)) {
            currentText = curSuggestion.getReplacementString();
            setValue(currentText);
            suggestionPopup.hide();
        }
        fireSuggestionEvent(curSuggestion);
    }

    /**
     * Sets the suggestion oracle used to create suggestions.
     *
     * @param oracle the oracle
     */
    private void setOracle(SuggestOracle oracle) {
        this.oracle = oracle;
    }

    /**
     * Show the given collection of suggestions.
     *
     * @param suggestions suggestions to show
     */
    private void showSuggestions(Collection<? extends Suggestion> suggestions) {
        if (suggestions.size() > 0) {

            // Hide the popup before we manipulate the menu within it. If we do
            // not
            // do this, some browsers will redraw the popup as items are removed
            // and added to the menu.
            boolean isAnimationEnabled = suggestionPopup.isAnimationEnabled();
            if (suggestionPopup.isAttached()) {
                suggestionPopup.hide();
            }

            suggestionMenu.clearItems();

            for (Suggestion curSuggestion : suggestions) {
                final SuggestionMenuItem menuItem = new SuggestionMenuItem(curSuggestion, oracle.isDisplayStringHTML());
                menuItem.setCommand(new Command() {
                    public void execute() {
                        NetNumeroSuggestBox.this.setNewSelection(menuItem);
                    }
                });

                suggestionMenu.addItem(menuItem);
            }

            if (selectsFirstItem) {
                // Select the first item in the suggestion menu.
                suggestionMenu.selectItem(0);
            }

            suggestionPopup.showRelativeTo(parent);
            suggestionPopup.setWidth(Integer.toString(parent.getOffsetWidth() - 3));
            suggestionPopup.setAnimationEnabled(isAnimationEnabled);
        } else {
            suggestionPopup.hide();
        }
    }
}
