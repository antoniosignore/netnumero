package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BulkActionRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.BulkActionRequest instance) throws SerializationException {
    instance.entityIdList = (java.util.List) streamReader.readObject();
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.datacargo.BulkActionRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.datacargo.BulkActionRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.BulkActionRequest instance) throws SerializationException {
    streamWriter.writeObject(instance.entityIdList);
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.BulkActionRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.BulkActionRequest)object);
  }
  
}
