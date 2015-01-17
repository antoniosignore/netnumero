package com.numhero.client.model.datacargo.timeentry;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TimeEntryListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.client.widget.filter.BAPojoFilter getFilter(com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest::filter;
  }-*/;
  
  private static native void setFilter(com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest instance, com.numhero.client.widget.filter.BAPojoFilter value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest::filter = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest instance) throws SerializationException {
    setFilter(instance, (com.numhero.client.widget.filter.BAPojoFilter) streamReader.readObject());
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest instance) throws SerializationException {
    streamWriter.writeObject(getFilter(instance));
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest)object);
  }
  
}
