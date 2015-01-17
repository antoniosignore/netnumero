package com.numhero.client.model.datacargo.invoice;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ChangeStatusOfDocumentsRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.InvoiceStatusEnum getStatus(com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest::status;
  }-*/;
  
  private static native void setStatus(com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest instance, com.numhero.shared.enums.InvoiceStatusEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest instance) throws SerializationException {
    setStatus(instance, (com.numhero.shared.enums.InvoiceStatusEnum) streamReader.readObject());
    
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest instance) throws SerializationException {
    streamWriter.writeObject(getStatus(instance));
    
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest)object);
  }
  
}
