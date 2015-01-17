package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ChartOfAccountsResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getNominalLedgerAccounts(com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse::nominalLedgerAccounts;
  }-*/;
  
  private static native void setNominalLedgerAccounts(com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse instance, java.util.List value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse::nominalLedgerAccounts = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse instance) throws SerializationException {
    setNominalLedgerAccounts(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse instance) throws SerializationException {
    streamWriter.writeObject(getNominalLedgerAccounts(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse)object);
  }
  
}
