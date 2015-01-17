package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ListCommandResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Collection getCommandItems(com.numhero.shared.datacargo.ListCommandResponse instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandResponse::commandItems;
  }-*/;
  
  private static native void setCommandItems(com.numhero.shared.datacargo.ListCommandResponse instance, java.util.Collection value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandResponse::commandItems = value;
  }-*/;
  
  private static native java.util.List getEntityList(com.numhero.shared.datacargo.ListCommandResponse instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandResponse::entityList;
  }-*/;
  
  private static native void setEntityList(com.numhero.shared.datacargo.ListCommandResponse instance, java.util.List value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandResponse::entityList = value;
  }-*/;
  
  private static native boolean getIsFirstPage(com.numhero.shared.datacargo.ListCommandResponse instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandResponse::isFirstPage;
  }-*/;
  
  private static native void setIsFirstPage(com.numhero.shared.datacargo.ListCommandResponse instance, boolean value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandResponse::isFirstPage = value;
  }-*/;
  
  private static native boolean getIsLastPage(com.numhero.shared.datacargo.ListCommandResponse instance) /*-{
    return instance.@com.numhero.shared.datacargo.ListCommandResponse::isLastPage;
  }-*/;
  
  private static native void setIsLastPage(com.numhero.shared.datacargo.ListCommandResponse instance, boolean value) 
  /*-{
    instance.@com.numhero.shared.datacargo.ListCommandResponse::isLastPage = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.ListCommandResponse instance) throws SerializationException {
    setCommandItems(instance, (java.util.Collection) streamReader.readObject());
    setEntityList(instance, (java.util.List) streamReader.readObject());
    setIsFirstPage(instance, streamReader.readBoolean());
    setIsLastPage(instance, streamReader.readBoolean());
    
    com.google.gwt.user.client.ui.SuggestOracle_Response_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.datacargo.ListCommandResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.datacargo.ListCommandResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.ListCommandResponse instance) throws SerializationException {
    streamWriter.writeObject(getCommandItems(instance));
    streamWriter.writeObject(getEntityList(instance));
    streamWriter.writeBoolean(getIsFirstPage(instance));
    streamWriter.writeBoolean(getIsLastPage(instance));
    
    com.google.gwt.user.client.ui.SuggestOracle_Response_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.ListCommandResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.ListCommandResponse)object);
  }
  
}
