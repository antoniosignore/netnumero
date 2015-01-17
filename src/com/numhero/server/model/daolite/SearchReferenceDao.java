package com.numhero.server.model.daolite;

import com.google.inject.Inject;
import com.numhero.server.search.TextTokenizer;
import com.numhero.shared.pojoc.SearchReference;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SearchReferenceDao extends BaseDao<SearchReference> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(SearchReferenceDao.class.getName());

    @Inject
    protected TextTokenizer textTokenizer;

    public List<SearchReference> globalSearch(String textToSearch, String businessAccountId) {
        //todo max result
        //todo result in AND not in OR
        List<SearchReference> ret = new ArrayList<SearchReference>();
        List<String> tokens = textTokenizer.getTokens(textToSearch);
        if (!tokens.isEmpty()) {
            if (tokens.size() > 10) {
                throw new RuntimeException("too many tokens (" + tokens.size() + ")");
            }
            //SearchReferenceDao.log.fine("tokens size " + tokens.size());

            internalSelect(createQuerySort(FIELD_WORDS_FOR_SEARCH), ret, 50, where(FIELD_WORDS_FOR_SEARCH).in(tokens), where(SearchablePojo.FIELD_BUSINESS_ACCOUNT_URI).equalsTo(businessAccountId));
        }
        return ret;
    }
}
