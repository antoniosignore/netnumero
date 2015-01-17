package com.numhero.client.model.datacargo.invoice;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class InvoiceListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.InvoiceTypeEnum getInvoiceType(com.numhero.client.model.datacargo.invoice.InvoiceListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.invoice.InvoiceListRequest::invoiceType;
  }-*/;
  
  private static native void setInvoiceType(com.numhero.client.model.datacargo.invoice.InvoiceListRequest instance, com.numhero.shared.enums.InvoiceTypeEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.invoice.InvoiceListRequest::invoiceType = value;
  }-*/;
  
  private static native com.numhero.shared.enums.InvoiceStatusEnum getStatus(com.numhero.client.model.datacargo.invoice.InvoiceListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.invoice.InvoiceListRequest::status;
  }-*/;
  
  private static native void setStatus(com.numhero.client.model.datacargo.invoice.InvoiceListRequest instance, com.numhero.shared.enums.InvoiceStatusEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.invoice.InvoiceListRequest::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.invoice.InvoiceListRequest instance) throws SerializationException {
    setInvoiceType(instance, (com.numhero.shared.enums.InvoiceTypeEnum) streamReader.readObject());
    setStatus(instance, (com.numhero.shared.enums.InvoiceStatusEnum) streamReader.readObject());
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.invoice.InvoiceListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.invoice.InvoiceListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.invoice.InvoiceListRequest instance) throws SerializationException {
    streamWriter.writeObject(getInvoiceType(instance));
    streamWriter.writeObject(getStatus(instance));
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.invoice.InvoiceListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.invoice.InvoiceListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.invoice.InvoiceListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.invoice.InvoiceListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.invoice.InvoiceListRequest)object);
  }
  
}
