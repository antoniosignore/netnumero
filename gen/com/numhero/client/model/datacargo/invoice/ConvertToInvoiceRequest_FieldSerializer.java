package com.numhero.client.model.datacargo.invoice;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ConvertToInvoiceRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest instance) throws SerializationException {
    
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest instance) throws SerializationException {
    
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest)object);
  }
  
}
