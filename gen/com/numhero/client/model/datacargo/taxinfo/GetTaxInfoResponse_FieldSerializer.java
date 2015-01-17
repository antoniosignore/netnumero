package com.numhero.client.model.datacargo.taxinfo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetTaxInfoResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse instance) throws SerializationException {
    
    com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse instance) throws SerializationException {
    
    com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse)object);
  }
  
}
