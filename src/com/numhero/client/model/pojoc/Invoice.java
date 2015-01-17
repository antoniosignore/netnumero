package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoice extends SearchablePojo {
    private static final long serialVersionUID = 3587549668509352849L;

    private static final int _2WEEKS = 1000 * 60 * 60 * 24 * 14;
    public static final String INVOICE_TYPE = "invoiceType";
    public static final String INVOICE_STATUS = "invoiceStatus";
    public static final String INVOICE_ARCHIVED = "invoiceArchived";
    public static final String DATE_RAISED = "dateRaised";
    public static final String DATE_DUE = "dateDue";
    public static final String DATE_PAID = "datePaid";

    public EnumField<InvoiceTypeEnum> fType = enumField(INVOICE_TYPE, InvoiceTypeEnum.Invoice);
    private EnumField<InvoiceStatusEnum> fStatus = enumField(INVOICE_STATUS, InvoiceStatusEnum.Draft);
    private BooleanField fArchived = booleanField(INVOICE_ARCHIVED, false);

    public DateField fDateRaised = dateField(DATE_RAISED, new Date());
    public DateField fDateDue = dateField(DATE_DUE, new Date(getDateRaised().getTime() + _2WEEKS));
    public DateField fDatePaid = dateField(DATE_PAID, new Date());

    public IdField fClientSupplierID = idField("clientSupplierID");

    public IdField fAccountID = idField("accountID");
    public StringField fAccountName = stringField("accountName", 100);

    //@DenormalizedFrom ClientSupplier.name
    public StringField fClientSupplierName = stringField("clientSupplierName", 100);

    public StringField fNotes = stringField("notes", 3000);
    public DoubleField fDiscount = doubleField("discount", 0D);

    public StringField fTermsConditions = stringField("termsConditions", 1000);

    public StringField fPO = stringField("purchaseOrder", 16);

    public BlobField fPDF = blobField("pdf");

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);
    public DateField fDate = dateField("date", new Date());

    protected OwnedListField<InvoiceDetail> details = ownedListField("details");

    public Invoice() {
    }

    public Invoice(Long id) {
        this();
        setId(id);
    }

    public InvoiceTypeEnum getInvoiceType() {
        return fType.getValue();
    }

    public void setInvoiceType(InvoiceTypeEnum invoiceType) {
        fType.setValue(invoiceType);
    }

    public InvoiceStatusEnum getInvoiceStatus() {
        return fStatus.getValue();
    }

    public void setInvoiceStatus(InvoiceStatusEnum invoiceStatus) {
    	if (invoiceStatus == InvoiceStatusEnum.Archived) {
    		fArchived.setValue(true);
    	} else {
    		fArchived.setValue(false);
    		fStatus.setValue(invoiceStatus);
    	}
    }

    public boolean isArchived() {
    	return fArchived.getValue();
    }

    public void setArchived(boolean archived) {
    	fArchived.setValue(archived);
    }

    public Date getDateRaised() {
        return fDateRaised.getValue();
    }

    public void setDateRaised(Date dateRaised) {
        fDateRaised.setValue(dateRaised);
    }

    public Date getDateDue() {
        return fDateDue.getValue();
    }

    public void setDateDue(Date dateDue) {
        fDateDue.setValue(dateDue);
    }

    public Long getClientSupplierID() {
        return fClientSupplierID.getValue();
    }

    public void setClientSupplierID(Long clientSupplierID) {
        fClientSupplierID.setValue(clientSupplierID);
    }

    public String getClientSupplierName() {
        return fClientSupplierName.getValue();
    }

    public void setClientSupplierName(String clientSupplierName) {
        fClientSupplierName.setValue(clientSupplierName);
    }

    public Long getAccountID() {
        return fAccountID.getValue();
    }

    public void setAccountID(Long accountID) {
        fAccountID.setValue(accountID);
    }

    public String getAccountName() {
        return fAccountName.getValue();
    }

    public void setAccountName(String accountName) {
        fAccountName.setValue(accountName);
    }

    public Double getPrice() {
        return fValue.getValue();
    }

    public void setPrice(Double price) {
        fValue.setValue(price);
    }

    public CurrencyEnum getCurrency() {
        return fCurrency.getValue();
    }

    public void setCurrency(CurrencyEnum currency) {
        fCurrency.setValue(currency);
    }

    public String getNotes() {
        return fNotes.getValue();
    }

    public void setNotes(String notes) {
        fNotes.setValue(notes);
    }

    public Double getDiscount() {
        return fDiscount.getValue();
    }

    public void setDiscount(Double discount) {
        fDiscount.setValue(discount);
    }

    public String getTermsConditions() {
        return fTermsConditions.getValue();
    }

    public void setTermsConditions(String termsConditions) {
        fTermsConditions.setValue(termsConditions);
    }

    public List<InvoiceDetail> getDetails() {
        return details;
    }

    public void addInvoiceDetail(InvoiceDetail invoiceDetail) {
        details.add(invoiceDetail);
    }

    @Override
    public DetailBasePojo createNewDetail(String collectionName) {
        return new InvoiceDetail();
    }

    public String getPrefixIDFromName() {
        String ret = "";
        if (fName.getValue() != null && !fName.getValue().isEmpty()) {
            int n = fName.getValue().length();
            int i = n - 1;
            for (; i >= 0; i--) {
                if (!Character.isDigit(fName.getValue().charAt(i))) {
                    break;
                }
            }
            ret = fName.getValue().substring(0, i + 1);
        }
        return ret;
    }

    public long getNumberIDFromName() {
        long ret = 0;
        if (fName.getValue() != null && !fName.getValue().isEmpty()) {
            int n = fName.getValue().length();
            int i = n - 1;
            for (; i >= 0; i--) {
                if (!Character.isDigit(fName.getValue().charAt(i))) {
                    break;
                }
            }
            try {
                ret = Long.parseLong(fName.getValue().substring(i + 1));
            } catch (Exception ignore) {
            }
        }
        return ret;
    }

    public BusinessTransaction clone() {
        BusinessTransaction ret = new BusinessTransaction();
        ret.copyFrom(this);
        return ret;
    }

    @Override
    public String getKind() {
    	return fType.getValue().name();
    }

    public Map<String, Double> calculateTaxes(Map<Long, TaxInfo> taxInfos) {
        Map<String, Double> difTaxes = new HashMap<String, Double>();
        for (InvoiceDetail detail : details) {
            processTaxField(taxInfos, difTaxes, detail, detail.fTax1ID);
            processTaxField(taxInfos, difTaxes, detail, detail.fTax2ID);
        }
        return difTaxes;
    }

    private void processTaxField(Map<Long, TaxInfo> taxInfos, Map<String, Double> difTaxes, InvoiceDetail idc, IdField field) {
        if (field.getValue() != null) {
            TaxInfo tax = taxInfos.get(field.getValue());
            if (tax != null) {
                double taxValue = idc.getTaxValue(tax);
                taxValue = calculateDiscounted(taxValue);

                Double totalTax = difTaxes.get(tax.fName.getValue());
                if (totalTax != null) {
                    totalTax += taxValue;
                } else {
                    totalTax = taxValue;
                }
                difTaxes.put(tax.fName.getValue(), totalTax);
            }
        }
    }

    public double calculateNet() {
        double net = 0.0;
        for (InvoiceDetail idc : getDetails()) {
            net = net + (idc.fQuantity.getValue() * idc.fPrice.getValue());
        }
        net = calculateDiscounted(net);
        return net;
    }

    public double calculateDiscounted(double amount) {
        return amount * (100 - fDiscount.getValue()) / 100;
    }
}
