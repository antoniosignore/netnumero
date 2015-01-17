package com.numhero.client.model.datacargo.report.trialbalance;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TrialBalanceResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getSheetRows(com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse::sheetRows;
  }-*/;
  
  private static native void setSheetRows(com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse instance, java.util.List value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse::sheetRows = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse instance) throws SerializationException {
    setSheetRows(instance, (java.util.List) streamReader.readObject());
    
  }
  
  public static com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse instance) throws SerializationException {
    streamWriter.writeObject(getSheetRows(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse)object);
  }
  
}
