package com.numhero.client.model.datacargo.expense;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ReceiptsListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Long getClientId(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::clientId;
  }-*/;
  
  private static native void setClientId(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance, java.lang.Long value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::clientId = value;
  }-*/;
  
  private static native com.numhero.shared.enums.InvoiceStatusEnum getClientStatus(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::clientStatus;
  }-*/;
  
  private static native void setClientStatus(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance, com.numhero.shared.enums.InvoiceStatusEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::clientStatus = value;
  }-*/;
  
  private static native java.util.Date getFromDate(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::fromDate;
  }-*/;
  
  private static native void setFromDate(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::fromDate = value;
  }-*/;
  
  private static native com.numhero.shared.enums.ReceiptStatusEnum getReceiptStaffStatus(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::receiptStaffStatus;
  }-*/;
  
  private static native void setReceiptStaffStatus(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance, com.numhero.shared.enums.ReceiptStatusEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::receiptStaffStatus = value;
  }-*/;
  
  private static native java.lang.Long getStaffId(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::staffId;
  }-*/;
  
  private static native void setStaffId(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance, java.lang.Long value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::staffId = value;
  }-*/;
  
  private static native java.util.Date getToDate(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::toDate;
  }-*/;
  
  private static native void setToDate(com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::toDate = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) throws SerializationException {
    setClientId(instance, (java.lang.Long) streamReader.readObject());
    setClientStatus(instance, (com.numhero.shared.enums.InvoiceStatusEnum) streamReader.readObject());
    setFromDate(instance, (java.util.Date) streamReader.readObject());
    setReceiptStaffStatus(instance, (com.numhero.shared.enums.ReceiptStatusEnum) streamReader.readObject());
    setStaffId(instance, (java.lang.Long) streamReader.readObject());
    setToDate(instance, (java.util.Date) streamReader.readObject());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.expense.ReceiptsListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.expense.ReceiptsListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.expense.ReceiptsListRequest instance) throws SerializationException {
    streamWriter.writeObject(getClientId(instance));
    streamWriter.writeObject(getClientStatus(instance));
    streamWriter.writeObject(getFromDate(instance));
    streamWriter.writeObject(getReceiptStaffStatus(instance));
    streamWriter.writeObject(getStaffId(instance));
    streamWriter.writeObject(getToDate(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.expense.ReceiptsListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.expense.ReceiptsListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.expense.ReceiptsListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.expense.ReceiptsListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.expense.ReceiptsListRequest)object);
  }
  
}
