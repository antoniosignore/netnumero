package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.shared.datacargo.PaginatedList;

public class CommandGetInvoices extends AbstractGetPaginatedCommand<InvoiceListRequest, InvoiceListResponse> {

	@Inject
	InvoiceDao invoiceDao;

	@Override
	public InvoiceListResponse execute(InvoiceListRequest request) {

		return getPaginatedResults(request);
	}


	protected PaginatedList<Invoice> getPaginated(InvoiceListRequest request) {

		PaginatedList<Invoice> invoices = invoiceDao.findAllPaginated(request.getBusinessAccountId(),
				request.getMaxResults(), request.getRefObjectId(), request.getInvoiceType(), request.getStatus());

		return invoices;
	}


	@Override
	protected InvoiceListResponse getPaginatedResults(InvoiceListRequest request) {
        		InvoiceListResponse response = new InvoiceListResponse();
		response.setPaginatedList(getPaginated(request));

        return response;
	}
}
