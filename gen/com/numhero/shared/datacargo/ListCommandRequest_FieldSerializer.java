package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ListCommandRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getMaxResults(com.numhero.shared.datacargo.ListCommandRequest instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandRequest::maxResults;
  }-*/;
  
  private static native void setMaxResults(com.numhero.shared.datacargo.ListCommandRequest instance, int value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandRequest::maxResults = value;
  }-*/;
  
  private static native java.lang.String getStartingKey(com.numhero.shared.datacargo.ListCommandRequest instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandRequest::startingKey;
  }-*/;
  
  private static native void setStartingKey(com.numhero.shared.datacargo.ListCommandRequest instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandRequest::startingKey = value;
  }-*/;
  
  private static native com.numhero.shared.datacargo.ListCommandRequest.TYPE getType(com.numhero.shared.datacargo.ListCommandRequest instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandRequest::type;
  }-*/;
  
  private static native void setType(com.numhero.shared.datacargo.ListCommandRequest instance, com.numhero.shared.datacargo.ListCommandRequest.TYPE value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandRequest::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.ListCommandRequest instance) throws SerializationException {
    setMaxResults(instance, streamReader.readInt());
    setStartingKey(instance, streamReader.readString());
    setType(instance, (com.numhero.shared.datacargo.ListCommandRequest.TYPE) streamReader.readObject());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.datacargo.ListCommandRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.datacargo.ListCommandRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.ListCommandRequest instance) throws SerializationException {
    streamWriter.writeInt(getMaxResults(instance));
    streamWriter.writeString(getStartingKey(instance));
    streamWriter.writeObject(getType(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.ListCommandRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.ListCommandRequest)object);
  }
  
}
