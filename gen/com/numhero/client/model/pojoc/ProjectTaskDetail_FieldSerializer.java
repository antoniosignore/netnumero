package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProjectTaskDetail_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.ProjectTaskDetail instance) throws SerializationException {
    instance.fBillable = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fBillingRate = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fLastBilled = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fStatus = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fTaskId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fTimeUnit = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fTotalTime = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.ProjectTaskDetail instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.ProjectTaskDetail();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.ProjectTaskDetail instance) throws SerializationException {
    streamWriter.writeObject(instance.fBillable);
    streamWriter.writeObject(instance.fBillingRate);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fLastBilled);
    streamWriter.writeObject(instance.fStatus);
    streamWriter.writeObject(instance.fTaskId);
    streamWriter.writeObject(instance.fTimeUnit);
    streamWriter.writeObject(instance.fTotalTime);
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.ProjectTaskDetail_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ProjectTaskDetail_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.ProjectTaskDetail)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ProjectTaskDetail_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.ProjectTaskDetail)object);
  }
  
}
