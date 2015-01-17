package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BusinessAccount_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.BusinessAccount instance) throws SerializationException {
    instance.fAddress = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCity = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCompanyLogo = (com.numhero.shared.pojoc.field.BlobField) streamReader.readObject();
    instance.fCompanyLogoThumb = (com.numhero.shared.pojoc.field.BlobField) streamReader.readObject();
    instance.fCountry = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDateFormat = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDefaultCurrencies = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fDefaultDaysDue = (com.numhero.shared.pojoc.field.LongField) streamReader.readObject();
    instance.fEmail = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fFax = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fInvoiceColor = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fLastEstimateID = (com.numhero.shared.pojoc.field.LongField) streamReader.readObject();
    instance.fLastInvoiceID = (com.numhero.shared.pojoc.field.LongField) streamReader.readObject();
    instance.fLastUpdateRecaps = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fMonthCost = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fMonthProfit = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fMonthTurnover = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fPaymentMethod = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fPhone = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fPrefix = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fRegion = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fTaxes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fTermsConditions = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fTimeFormat = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fVat = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fWeb = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fYearCost = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fYearProfit = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fYearTurnover = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fZipCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.BusinessAccount instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.BusinessAccount();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.BusinessAccount instance) throws SerializationException {
    streamWriter.writeObject(instance.fAddress);
    streamWriter.writeObject(instance.fCity);
    streamWriter.writeObject(instance.fCompanyLogo);
    streamWriter.writeObject(instance.fCompanyLogoThumb);
    streamWriter.writeObject(instance.fCountry);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDateFormat);
    streamWriter.writeObject(instance.fDefaultCurrencies);
    streamWriter.writeObject(instance.fDefaultDaysDue);
    streamWriter.writeObject(instance.fEmail);
    streamWriter.writeObject(instance.fFax);
    streamWriter.writeObject(instance.fInvoiceColor);
    streamWriter.writeObject(instance.fLastEstimateID);
    streamWriter.writeObject(instance.fLastInvoiceID);
    streamWriter.writeObject(instance.fLastUpdateRecaps);
    streamWriter.writeObject(instance.fMonthCost);
    streamWriter.writeObject(instance.fMonthProfit);
    streamWriter.writeObject(instance.fMonthTurnover);
    streamWriter.writeObject(instance.fPaymentMethod);
    streamWriter.writeObject(instance.fPhone);
    streamWriter.writeObject(instance.fPrefix);
    streamWriter.writeObject(instance.fRegion);
    streamWriter.writeObject(instance.fTaxes);
    streamWriter.writeObject(instance.fTermsConditions);
    streamWriter.writeObject(instance.fTimeFormat);
    streamWriter.writeObject(instance.fVat);
    streamWriter.writeObject(instance.fWeb);
    streamWriter.writeObject(instance.fYearCost);
    streamWriter.writeObject(instance.fYearProfit);
    streamWriter.writeObject(instance.fYearTurnover);
    streamWriter.writeObject(instance.fZipCode);
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.BusinessAccount_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BusinessAccount_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.BusinessAccount)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BusinessAccount_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.BusinessAccount)object);
  }
  
}
