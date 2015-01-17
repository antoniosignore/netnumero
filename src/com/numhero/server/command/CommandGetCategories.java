package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.pojoc.Category;
import com.numhero.server.model.daolite.CategoryDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.logging.Logger;

public class CommandGetCategories extends AbstractGetPaginatedCommand<CategoryListRequest, CategoryListResponse> {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(CommandGetCategories.class.getName());

	@Inject
	CategoryDao categoryDao;

	@Override
	public CategoryListResponse execute(CategoryListRequest request) {
		CategoryListResponse response = new CategoryListResponse();


		if (request.getType() == TYPE.SUGGEST) {
			if (request.getStartingKey().equals("*")) {
				response.setEntityList(categoryDao.findAll(
						request.getBusinessAccountId(),
						request.getMaxResults()));
                        return response;
			} else {
				response.setEntityList(categoryDao.searchForStartsWith(
						request.getStartingKey(),
						request.getMaxResults(),
						request.getBusinessAccountId()));
                        return response;
			}
		} else if (request.getType() == TYPE.SEARCH) {
			response.setEntityList(categoryDao.search(
					request.getStartingKey(),
					request.getBusinessAccountId()));
                    return response;
		} else {
			return getPaginatedResults(request);
		}


	}

	@Override
	protected CategoryListResponse getPaginatedResults(CategoryListRequest request) {

        CategoryListResponse response = new CategoryListResponse();
        response.setPaginatedList(getPaginated(request));
                return response;

	}


	protected PaginatedList<Category> getPaginated(CategoryListRequest request) {
		return categoryDao.findAllPaginated(
				request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
	}

}
