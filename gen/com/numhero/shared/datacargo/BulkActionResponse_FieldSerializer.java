package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BulkActionResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.BulkActionResponse instance) throws SerializationException {
    instance.failureIdList = (java.util.List) streamReader.readObject();
    instance.message = streamReader.readString();
    instance.successIdList = (java.util.List) streamReader.readObject();
    
  }
  
  public static com.numhero.shared.datacargo.BulkActionResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.datacargo.BulkActionResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.BulkActionResponse instance) throws SerializationException {
    streamWriter.writeObject(instance.failureIdList);
    streamWriter.writeString(instance.message);
    streamWriter.writeObject(instance.successIdList);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.BulkActionResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.BulkActionResponse_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.BulkActionResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.BulkActionResponse_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.BulkActionResponse)object);
  }
  
}
