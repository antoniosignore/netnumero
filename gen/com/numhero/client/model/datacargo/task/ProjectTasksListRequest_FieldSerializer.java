package com.numhero.client.model.datacargo.task;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProjectTasksListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.task.ProjectTasksListRequest instance) throws SerializationException {
    instance.projectId = streamReader.readString();
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.task.ProjectTasksListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.task.ProjectTasksListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.task.ProjectTasksListRequest instance) throws SerializationException {
    streamWriter.writeString(instance.projectId);
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.task.ProjectTasksListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.task.ProjectTasksListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.task.ProjectTasksListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.task.ProjectTasksListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.task.ProjectTasksListRequest)object);
  }
  
}
