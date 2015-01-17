package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TimeEntry_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.TimeEntry instance) throws SerializationException {
    instance.fBilled = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateTimeField) streamReader.readObject();
    instance.fHours = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fNotes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fProjectId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fProjectName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fStaffId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fStaffName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fTaskId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fTaskName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.TimeEntry instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.TimeEntry();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.TimeEntry instance) throws SerializationException {
    streamWriter.writeObject(instance.fBilled);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fHours);
    streamWriter.writeObject(instance.fNotes);
    streamWriter.writeObject(instance.fProjectId);
    streamWriter.writeObject(instance.fProjectName);
    streamWriter.writeObject(instance.fStaffId);
    streamWriter.writeObject(instance.fStaffName);
    streamWriter.writeObject(instance.fTaskId);
    streamWriter.writeObject(instance.fTaskName);
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.TimeEntry_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.TimeEntry_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.TimeEntry)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.TimeEntry_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.TimeEntry)object);
  }
  
}
