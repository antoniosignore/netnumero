package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccountBalanceRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.CountryEnum getCountry(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::country;
  }-*/;
  
  private static native void setCountry(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance, com.numhero.shared.enums.CountryEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::country = value;
  }-*/;
  
  private static native java.util.Date getFrom(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::from;
  }-*/;
  
  private static native void setFrom(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::from = value;
  }-*/;
  
  private static native com.numhero.shared.enums.AccountClassEnum getLedgerAccountClass(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::ledgerAccountClass;
  }-*/;
  
  private static native void setLedgerAccountClass(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance, com.numhero.shared.enums.AccountClassEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::ledgerAccountClass = value;
  }-*/;
  
  private static native java.util.Date getTo(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::to;
  }-*/;
  
  private static native void setTo(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::to = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance) throws SerializationException {
    setCountry(instance, (com.numhero.shared.enums.CountryEnum) streamReader.readObject());
    setFrom(instance, (java.util.Date) streamReader.readObject());
    setLedgerAccountClass(instance, (com.numhero.shared.enums.AccountClassEnum) streamReader.readObject());
    instance.ledgerAccountId = (java.lang.Long) streamReader.readObject();
    setTo(instance, (java.util.Date) streamReader.readObject());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest instance) throws SerializationException {
    streamWriter.writeObject(getCountry(instance));
    streamWriter.writeObject(getFrom(instance));
    streamWriter.writeObject(getLedgerAccountClass(instance));
    streamWriter.writeObject(instance.ledgerAccountId);
    streamWriter.writeObject(getTo(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest)object);
  }
  
}
