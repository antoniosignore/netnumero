package com.numhero.client.model.datacargo.product;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetItemResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.product.GetItemResponse instance) throws SerializationException {
    
    com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.product.GetItemResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.product.GetItemResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.product.GetItemResponse instance) throws SerializationException {
    
    com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.product.GetItemResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.product.GetItemResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.product.GetItemResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.product.GetItemResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.product.GetItemResponse)object);
  }
  
}
