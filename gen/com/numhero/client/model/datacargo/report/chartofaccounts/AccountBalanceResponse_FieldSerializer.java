package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccountBalanceResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getAccountBalanceRowList(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse::accountBalanceRowList;
  }-*/;
  
  private static native void setAccountBalanceRowList(com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse instance, java.util.List value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse::accountBalanceRowList = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse instance) throws SerializationException {
    setAccountBalanceRowList(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse instance) throws SerializationException {
    streamWriter.writeObject(getAccountBalanceRowList(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse)object);
  }
  
}
