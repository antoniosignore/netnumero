package com.numhero.client.widget.filter;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BAPojoFilter_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Boolean getBilled(com.numhero.client.widget.filter.BAPojoFilter instance) /*-{
    return instance.@com.numhero.client.widget.filter.BAPojoFilter::billed;
  }-*/;
  
  private static native void setBilled(com.numhero.client.widget.filter.BAPojoFilter instance, java.lang.Boolean value) 
  /*-{
    instance.@com.numhero.client.widget.filter.BAPojoFilter::billed = value;
  }-*/;
  
  private static native java.util.Date getFrom(com.numhero.client.widget.filter.BAPojoFilter instance) /*-{
    return instance.@com.numhero.client.widget.filter.BAPojoFilter::from;
  }-*/;
  
  private static native void setFrom(com.numhero.client.widget.filter.BAPojoFilter instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.widget.filter.BAPojoFilter::from = value;
  }-*/;
  
  private static native java.util.Date getTo(com.numhero.client.widget.filter.BAPojoFilter instance) /*-{
    return instance.@com.numhero.client.widget.filter.BAPojoFilter::to;
  }-*/;
  
  private static native void setTo(com.numhero.client.widget.filter.BAPojoFilter instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.widget.filter.BAPojoFilter::to = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.widget.filter.BAPojoFilter instance) throws SerializationException {
    setBilled(instance, (java.lang.Boolean) streamReader.readObject());
    setFrom(instance, (java.util.Date) streamReader.readObject());
    setTo(instance, (java.util.Date) streamReader.readObject());
    
    com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.widget.filter.BAPojoFilter instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.widget.filter.BAPojoFilter();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.widget.filter.BAPojoFilter instance) throws SerializationException {
    streamWriter.writeObject(getBilled(instance));
    streamWriter.writeObject(getFrom(instance));
    streamWriter.writeObject(getTo(instance));
    
    com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.widget.filter.BAPojoFilter_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.widget.filter.BAPojoFilter_FieldSerializer.deserialize(reader, (com.numhero.client.widget.filter.BAPojoFilter)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.widget.filter.BAPojoFilter_FieldSerializer.serialize(writer, (com.numhero.client.widget.filter.BAPojoFilter)object);
  }
  
}
