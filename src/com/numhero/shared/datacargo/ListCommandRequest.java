package com.numhero.shared.datacargo;

import com.numhero.shared.service.ApplicationCommandEnum;

public class ListCommandRequest extends CommandRequest {
	public static final int DEFAULT_MAX_RESULT = 10;


	//ideally we should use a better system here
	public enum TYPE {
		DATA, SEARCH, SUGGEST
	}

//	private String	orderBy;
	// --- maybe enum but it could be on specific commands... dunno

//	private int		skipFirst;
//	// -- maybe in the future (for example 20 means get the next maxResult after
//	// first 20)


    private String startingKey;
	// - for type = DATA
	// this is the refObjectId  --> should be a Long
	// could be null (for first page in ascOder, last in descOrder)
	// or the last result of current page (for next page in ascOrder)
	// or the first result of current page (for prev page in descOrder)
	// - for type = SEARCH
	// this is the searchString
	// - for type = SUGGEST
	// this is the suggestString

	private TYPE type = TYPE.DATA;

	private int maxResults = DEFAULT_MAX_RESULT;


    public ListCommandRequest() {
        super();
    }

    public ListCommandRequest(int maxResults, String startingKey, TYPE type, ApplicationCommandEnum commandEnum) {
        super();
        this.maxResults = maxResults;
        this.startingKey = startingKey;
        this.type = type;
        setCommand(commandEnum);
    }

	public String getStartingKey() {
		return startingKey;
	}

	public void setStartingKey(String startingKey) {
		this.startingKey = startingKey;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public Long getRefObjectId() {
		Long refObjectId = null;
		if (getStartingKey() != null)
			refObjectId = new Long(getStartingKey());
		return refObjectId;
	}


}
