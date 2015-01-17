package com.numhero.client.widget.combobox;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.numhero.client.Application;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;

import java.util.ArrayList;
import java.util.List;

public class ServerSuggestOracle<REQUEST extends ListCommandRequest, RESPONSE extends ListCommandResponse<?>> extends SuggestOracle {
    private static final int DELAY = 500;
    private Service<REQUEST, RESPONSE> service;
    private REQUEST request;
    private List<CommandItem> commandItems;

    private Timer requestTimer;
    private SuggestOracle.Request suggestRequest;
    private String lastSuggestRequest = "";
    private SuggestOracle.Callback callback;
    private boolean useCache = true;

    public ServerSuggestOracle(Service<REQUEST, RESPONSE> service, REQUEST request) {
        this.service = service;
        this.request = request;
        commandItems = new ArrayList<CommandItem>();
        requestTimer = new Timer() {
            @Override
            public void run() {
                internalRequestSuggestions();
            }
        };
    }

    public String getLastSuggestRequest() {
        return lastSuggestRequest;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    public boolean isUseCache() {
        return useCache;
    }

    public void addCommandItem(CommandItem commandItem) {
        commandItems.add(commandItem);
    }

    public void clearCommandItems() {
        commandItems.clear();
    }

    public void addAddNewItem() {
        commandItems.add(CommandItem.ADD_NEW);
    }

    public void addMoreItem() {
        commandItems.add(CommandItem.MORE);
    }

    @Override
    public boolean isDisplayStringHTML() {
        return true;
    }

    @Override
    public void requestDefaultSuggestions(Request request, Callback callback) {
        request.setQuery("*");
        requestSuggestions(request, callback);
    }

    @Override
    public void requestSuggestions(SuggestOracle.Request suggestRequest, SuggestOracle.Callback callback) {
        this.suggestRequest = suggestRequest;
        this.callback = callback;
        requestTimer.cancel();
        requestTimer.schedule(DELAY);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void internalRequestSuggestions() {
        request.setType(ListCommandRequest.TYPE.SUGGEST);
        request.setMaxResults(suggestRequest.getLimit());
        request.setStartingKey(suggestRequest.getQuery());
        ServiceCallback serviceCallback = new ServiceCallbackImpl<RESPONSE>() {
            @Override
            public void onSuccess(RESPONSE response) {
                List<CommandItem> showCommandItems = new ArrayList<CommandItem>(commandItems);
                if (!showMore(response)) {
                    showCommandItems.remove(CommandItem.MORE);
                }
                response.setCommandItems(showCommandItems);
                callback.onSuggestionsReady(suggestRequest, response);
            }
        };
        boolean useCacheForThisCall;
        if (suggestRequest.getQuery().equals("*")) {
            lastSuggestRequest = "";
            useCacheForThisCall = true;
        } else {
            lastSuggestRequest = suggestRequest.getQuery();
            useCacheForThisCall = false;
        }
        if (useCache && useCacheForThisCall) {
            //todo Mikado !!!
//            Application.injector.getClientCache().useCache(request, serviceCallback);
                  service.execute(request, serviceCallback);
        } else {
            service.execute(request, serviceCallback);
        }
    }

    // private methods --------------------------------------------------
    protected boolean showMore(RESPONSE response) {
        return response.getEntityList().size() >= suggestRequest.getLimit();
    }

    // inner class ------------------------------------------------------
    public static class CommandItem implements Suggestion, IsSerializable {
        private final static CommandItem ADD_NEW = new CommandItem(
                CommandItem.addKey, Application.getConstants().addNew() + "...");
        private final static CommandItem MORE = new CommandItem(
                CommandItem.moreKey, Application.getConstants().more() + "...");

        public static final String addKey = "+";
        public static final String moreKey = "*";

        private String key;
        private String value;

		public CommandItem(String key, String value) {
			this.key = key;
			this.value = "<b>" + value + "</b>";
		}

		@Override
		public String getDisplayString() {
			return value;
		}

		@Override
		public String getReplacementString() {
			return key;
		}
	}
}
