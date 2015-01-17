package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SaveSingleEntityResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Long getEntityId(com.numhero.shared.datacargo.SaveSingleEntityResponse instance) /*-{
    return instance.@com.numhero.shared.datacargo.SaveSingleEntityResponse::entityId;
  }-*/;
  
  private static native void setEntityId(com.numhero.shared.datacargo.SaveSingleEntityResponse instance, java.lang.Long value) 
  /*-{
    instance.@com.numhero.shared.datacargo.SaveSingleEntityResponse::entityId = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.SaveSingleEntityResponse instance) throws SerializationException {
    setEntityId(instance, (java.lang.Long) streamReader.readObject());
    
  }
  
  public static com.numhero.shared.datacargo.SaveSingleEntityResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.datacargo.SaveSingleEntityResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.SaveSingleEntityResponse instance) throws SerializationException {
    streamWriter.writeObject(getEntityId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.SaveSingleEntityResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.SaveSingleEntityResponse_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.SaveSingleEntityResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.SaveSingleEntityResponse_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.SaveSingleEntityResponse)object);
  }
  
}
