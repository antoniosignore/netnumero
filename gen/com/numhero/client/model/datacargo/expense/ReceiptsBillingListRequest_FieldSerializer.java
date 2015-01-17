package com.numhero.client.model.datacargo.expense;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ReceiptsBillingListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Long getClientId(com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::clientId;
  }-*/;
  
  private static native void setClientId(com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance, java.lang.Long value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::clientId = value;
  }-*/;
  
  private static native java.util.Date getFromDate(com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::fromDate;
  }-*/;
  
  private static native void setFromDate(com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::fromDate = value;
  }-*/;
  
  private static native java.util.Date getToDate(com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::toDate;
  }-*/;
  
  private static native void setToDate(com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::toDate = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance) throws SerializationException {
    setClientId(instance, (java.lang.Long) streamReader.readObject());
    setFromDate(instance, (java.util.Date) streamReader.readObject());
    setToDate(instance, (java.util.Date) streamReader.readObject());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest instance) throws SerializationException {
    streamWriter.writeObject(getClientId(instance));
    streamWriter.writeObject(getFromDate(instance));
    streamWriter.writeObject(getToDate(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest)object);
  }
  
}
