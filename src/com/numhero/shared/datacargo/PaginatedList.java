package com.numhero.shared.datacargo;

import java.util.List;

public interface PaginatedList<T> {

	List<T> getList();

	boolean isLastPage();

	boolean isFirstPage();

}
