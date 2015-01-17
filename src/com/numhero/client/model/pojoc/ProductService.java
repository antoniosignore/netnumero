package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.ProductTypeEnum;
import com.numhero.shared.enums.ServiceUnitEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.DoubleField;
import com.numhero.shared.pojoc.field.EnumField;

import java.util.Date;

public class ProductService extends SearchablePojo implements Suggestion {
    private static final long serialVersionUID = -6275226319185616159L;

    public EnumField<ProductTypeEnum> fType = enumField("type", ProductTypeEnum.product);
    public EnumField<ServiceUnitEnum> fServiceUnit = enumField("serviceUnit", ServiceUnitEnum.Hour);
    public DoubleField fUnitPrice = doubleField("unitPrice");
//    public BooleanField fTrackingEnabled = booleanField("tracking");
//    public DoubleField fQuantity = doubleField("quantity");

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);
    public DateField fDate = dateField("date", new Date());

    public ProductTypeEnum getProductType() {
        return fType.getValue();
    }

    public void setProductType(ProductTypeEnum productType) {
        fType.setValue(productType);
    }

    public CurrencyEnum getCurrency() {
        return fCurrency.getValue();
    }

    public void setCurrency(CurrencyEnum currency) {
        fCurrency.setValue(currency);
    }

    public ServiceUnitEnum getServiceUnit() {
        return fServiceUnit.getValue();
    }

    public void setServiceUnit(ServiceUnitEnum serviceUnit) {
        fServiceUnit.setValue(serviceUnit);
    }

    public Double getUnitPrice() {
        return fUnitPrice.getValue();
    }

    public void setUnitPrice(Double unitPrice) {
        fUnitPrice.setValue(unitPrice);
    }

    @Override
    public ProductService clone() {
        ProductService ret = new ProductService();
        ret.copyFrom(this);
        return ret;
    }

    @Override
    public String getKind() {
    	return fType.getValue().name();
    }
}
