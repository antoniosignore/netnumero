package com.numhero.client.model.datacargo.client_supplier;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SaveClientSupplierRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest instance) throws SerializationException {
    
    com.numhero.shared.datacargo.SaveSingleEntityRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest instance) throws SerializationException {
    
    com.numhero.shared.datacargo.SaveSingleEntityRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest)object);
  }
  
}
