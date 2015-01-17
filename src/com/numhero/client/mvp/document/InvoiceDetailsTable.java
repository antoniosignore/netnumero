package com.numhero.client.mvp.document;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.model.datacargo.product.SaveProductRequest;
import com.numhero.client.model.datacargo.product.SaveProductResponse;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.currency.CurrencyConvertBean;
import com.numhero.client.mvp.currency.CurrencyConvertDialog;
import com.numhero.client.service.Service;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.shared.enums.CurrencyEnum;
import eu.maydu.gwt.validation.client.ValidationProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InvoiceDetailsTable extends FlexTableWithHeader {
    public interface InvoiceDetailsHandler {

        public void totalChanged();
    }
    private Service<ProductServicesListRequest, ProductListResponse> productListService;

    private Service<SaveProductRequest, SaveProductResponse> productSaveService;
    private Service<TaxInfoListRequest, TaxInfoListResponse> taxListService;
    private Service<SaveTaxInfoRequest, SaveTaxInfoResponse> taxSaveService;
    private Service<GetCurrencyConversionRequest,GetCurrencyConversionResponse> conversionService;

    private List<InvoiceDetailLine> lines;
    private Invoice invoice;
    private Map<Long, TaxInfo> taxes;
    private InvoiceDetailsHandler handler;
    private ValidationProcessor validator;

    @Inject
    public InvoiceDetailsTable(
            Service<ProductServicesListRequest, ProductListResponse> productListService,
            Service<SaveProductRequest, SaveProductResponse> productSaveService,
            Service<TaxInfoListRequest, TaxInfoListResponse> taxListService,
            Service<SaveTaxInfoRequest, SaveTaxInfoResponse> taxSaveService, Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService) {
        this.productListService = productListService;
        this.productSaveService = productSaveService;
        this.taxListService = taxListService;
        this.taxSaveService = taxSaveService;
        this.conversionService = conversionService;
        this.lines = new ArrayList<InvoiceDetailLine>();
        setHeader();
        setValues();
        setStyleName("entity-details-table");
    }

    public Service<ProductServicesListRequest, ProductListResponse> getProductListService() {
		return productListService;
	}
    
    public Service<SaveProductRequest, SaveProductResponse> getProductSaveService() {
		return productSaveService;
	}
    
    public Service<TaxInfoListRequest, TaxInfoListResponse> getTaxListService() {
		return taxListService;
	}
    
    public Service<SaveTaxInfoRequest, SaveTaxInfoResponse> getTaxSaveService() {
		return taxSaveService;
	}

    public void setTaxes(Map<Long, TaxInfo> taxes) {
    	this.taxes = taxes;
    }
    
    public Map<Long, TaxInfo> getTaxes() {
    	return taxes;
    }
    
    public void setHandler(InvoiceDetailsHandler handler) {
        this.handler = handler;
    }

    public void callHandler() {
        if (handler != null) {
            handler.totalChanged();
        }
    }
    
    public void setValidator(ValidationProcessor validator) {
    	this.validator = validator;
    }

    public ValidationProcessor getValidator() {
		return validator;
	}

    public Invoice getInvoice() {
    	return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
        if (invoice.getDetails().isEmpty()) {
            InvoiceDetail idc1 = new InvoiceDetail();
            invoice.getDetails().add(idc1);

            InvoiceDetail idc2 = new InvoiceDetail();
            invoice.getDetails().add(idc2);

            InvoiceDetail idc3 = new InvoiceDetail();
            invoice.getDetails().add(idc3);
        }

        lines.clear();
        for (InvoiceDetail idc : invoice.getDetails()) {
            addLine(idc);
        }
        setValues();
    }

    public void setCurrency(final CurrencyEnum currency) {
    	removeEmptyLines();

    	final List<CurrencyConvertBean> toConvert = new ArrayList<CurrencyConvertBean>(lines.size());
    	for (InvoiceDetailLine idline : lines) {
        	CurrencyConvertBean ccb = new CurrencyConvertBean();
        	ccb.setFromAmount(idline.txUnitPrice.getAmount());
        	ccb.setFromCurrency(invoice.getCurrency());
        	ccb.setToAmount(0);
        	ccb.setToCurrency(currency);
        	toConvert.add(ccb);
        }

    	CurrencyConvertDialog dlg = new CurrencyConvertDialog(toConvert, conversionService);
        dlg.center();
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				for (int row = 0; row < lines.size(); row++) {
					InvoiceDetailLine idline = lines.get(row);
					CurrencyConvertBean ccb = toConvert.get(row);
		            idline.txUnitPrice.setCurrency(currency);
		            idline.txTotalPrice.setCurrency(currency);
					idline.invoiceDetail.setPrice(ccb.getToAmount());
					idline.setLineValues();
				}
				callHandler();
			}
		});
    }

    public void addLine(InvoiceDetail idc) {
        lines.add(new InvoiceDetailLine(this, idc, conversionService));
    }

    public int getLineIndex(InvoiceDetailLine idline) {
        return lines.indexOf(idline);
    }

    public void moveUp(InvoiceDetailLine idline) {
        int row = getLineIndex(idline);
        if (row > 0) {
            lines.set(row, lines.get(row - 1));
            lines.set(row - 1, idline);
            setValues();
        }
    }

    public void moveDown(InvoiceDetailLine idline) {
        int row = getLineIndex(idline);
        if (row < lines.size() - 1) {
            lines.set(row, lines.get(row + 1));
            lines.set(row + 1, idline);
            setValues();
        }
    }

    public void removeLine(InvoiceDetailLine idline) {
    	idline.removeValidators();
        removeRow(getLineIndex(idline));
        lines.remove(idline);
    }

    public void removeEmptyLines() {
        for (int row = 0; row < lines.size();) {
            InvoiceDetailLine idline = lines.get(row);
            boolean canBeRemoved = lines.size() > 1 && idline.isEmpty();
            if (canBeRemoved) {
            	removeLine(idline);
            } else {
            	row++;
            }
        }
    }

    public void setValues() {
        removeAllRows();
        for (int row = 0; row < lines.size(); row++) {
            InvoiceDetailLine idline = lines.get(row);
            setWidget(row, 0, idline.sbProductService);
            setWidget(row, 1, idline.txDescription);
            setWidget(row, 2, idline.txUnitPrice);
            setWidget(row, 3, idline.txQuantity);
            setWidget(row, 4, idline.sbTax1);
            setWidget(row, 5, idline.sbTax2);
            setWidget(row, 6, idline.txTotalPrice);
            setWidget(row, 7, idline.toolbar);
            for (int i = 0; i < 8; i++) {
                getCellFormatter().setStyleName(row, i, NETNUMERO_ROW);
            }
        }
    }

    public void saveValuesFromUi() {
        invoice.getDetails().clear();
        for (int row = 0; row < lines.size(); row++) {
            InvoiceDetailLine idline = lines.get(row);
            idline.saveValuesFromUi();
            invoice.getDetails().add(idline.invoiceDetail);
        }
    }

    public double getTotal() {
        double ret = 0;
        for (InvoiceDetailLine idline : lines) {
            ret += idline.txTotalPrice.getAmount();
        }
        return ret;
    }

    // private methods --------------------
    private void setHeader() {
        setHeader(0, Application.getConstants().item(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(1, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "395px");
        setHeader(2, Application.getConstants().unitPrice(), HasHorizontalAlignment.ALIGN_RIGHT, "70px");
        setHeader(3, Application.getConstants().quantity(), HasHorizontalAlignment.ALIGN_RIGHT, "70px");
        setHeader(4, Application.getConstants().tax1(), HasHorizontalAlignment.ALIGN_RIGHT, "70px");
        setHeader(5, Application.getConstants().tax2(), HasHorizontalAlignment.ALIGN_RIGHT, "70px");
        setHeader(6, Application.getConstants().price(), HasHorizontalAlignment.ALIGN_RIGHT, "70px");
        setHeader(7, "", HasHorizontalAlignment.ALIGN_RIGHT, "32px", "invoiceDetailsToolbar");
    }
}
