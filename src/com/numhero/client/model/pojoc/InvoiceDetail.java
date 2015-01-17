package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.InvoiceDetailTypeEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.IdField;

public class InvoiceDetail extends DetailBasePojo {
	private static final long serialVersionUID = 8283426385092631622L;

	public IdField fProductID = idField("productId");
    public IdField fServiceID = idField("serviceId");
    public DoubleField fQuantity = doubleField("quantity", 1D);
    public DoubleField fPrice = doubleField("price", 0D);
    public IdField fTax1ID = idField("tax1Id");
    public IdField fTax2ID = idField("tax2Id");
    public EnumField<InvoiceDetailTypeEnum> fOriginatingType = enumField("originatingType", InvoiceDetailTypeEnum.undefined);
    public IdField fOriginalID = idField("originalId");

    public InvoiceDetail() {
    }

    public Double getQuantity() {
        return fQuantity.getValue();
    }

    public void setQuantity(Double quantity) {
        fQuantity.setValue(quantity);
    }

    public Double getPrice() {
        return fPrice.getValue();
    }

    public void setPrice(Double price) {
        fPrice.setValue(price);
    }

    public double getTaxValue(TaxInfo tax) {
        double taxValue = 0;
        if (tax.getPercent() != null) {
            taxValue = getPrice().doubleValue() * getQuantity().doubleValue() * tax.getPercent() / 100;
        }
        return taxValue;
    }
}
