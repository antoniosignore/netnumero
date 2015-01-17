package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetSingleEntityRequest_FieldSerializer {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.GetSingleEntityRequest instance) throws SerializationException {
    instance.entityId = (java.lang.Long) streamReader.readObject();
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.GetSingleEntityRequest instance) throws SerializationException {
    streamWriter.writeObject(instance.entityId);
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
