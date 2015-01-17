package com.numhero.client.model.datacargo.home;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetHomeRecapRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Integer getYear(com.numhero.client.model.datacargo.home.GetHomeRecapRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.home.GetHomeRecapRequest::year;
  }-*/;
  
  private static native void setYear(com.numhero.client.model.datacargo.home.GetHomeRecapRequest instance, java.lang.Integer value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.home.GetHomeRecapRequest::year = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.home.GetHomeRecapRequest instance) throws SerializationException {
    setYear(instance, (java.lang.Integer) streamReader.readObject());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.home.GetHomeRecapRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.home.GetHomeRecapRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.home.GetHomeRecapRequest instance) throws SerializationException {
    streamWriter.writeObject(getYear(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.home.GetHomeRecapRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.home.GetHomeRecapRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.home.GetHomeRecapRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.home.GetHomeRecapRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.home.GetHomeRecapRequest)object);
  }
  
}
