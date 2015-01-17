package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SaveSingleEntityRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.pojoc.BAPojo getEntity(com.numhero.shared.datacargo.SaveSingleEntityRequest instance) /*-{
    return instance.@com.numhero.shared.datacargo.SaveSingleEntityRequest::entity;
  }-*/;
  
  private static native void setEntity(com.numhero.shared.datacargo.SaveSingleEntityRequest instance, com.numhero.shared.pojoc.BAPojo value) 
  /*-{
    instance.@com.numhero.shared.datacargo.SaveSingleEntityRequest::entity = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.SaveSingleEntityRequest instance) throws SerializationException {
    setEntity(instance, (com.numhero.shared.pojoc.BAPojo) streamReader.readObject());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.datacargo.SaveSingleEntityRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.datacargo.SaveSingleEntityRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.SaveSingleEntityRequest instance) throws SerializationException {
    streamWriter.writeObject(getEntity(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.SaveSingleEntityRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.SaveSingleEntityRequest_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.SaveSingleEntityRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.SaveSingleEntityRequest_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.SaveSingleEntityRequest)object);
  }
  
}
