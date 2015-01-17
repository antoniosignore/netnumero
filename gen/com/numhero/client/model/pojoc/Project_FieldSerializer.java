package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Project_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.Project instance) throws SerializationException {
    instance.fBillableTime = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fBillingMethod = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fBillingRate = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fClientSupplierID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fClientSupplierName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fFlatBillingRate = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fLastBilled = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fProjectStaffDetails = (com.numhero.shared.pojoc.field.OwnedListField) streamReader.readObject();
    instance.fProjectTaskDetails = (com.numhero.shared.pojoc.field.OwnedListField) streamReader.readObject();
    instance.fState = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fTimeUnit = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fTotalBilledTime = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.Project instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.Project();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.Project instance) throws SerializationException {
    streamWriter.writeObject(instance.fBillableTime);
    streamWriter.writeObject(instance.fBillingMethod);
    streamWriter.writeObject(instance.fBillingRate);
    streamWriter.writeObject(instance.fClientSupplierID);
    streamWriter.writeObject(instance.fClientSupplierName);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fFlatBillingRate);
    streamWriter.writeObject(instance.fLastBilled);
    streamWriter.writeObject(instance.fProjectStaffDetails);
    streamWriter.writeObject(instance.fProjectTaskDetails);
    streamWriter.writeObject(instance.fState);
    streamWriter.writeObject(instance.fTimeUnit);
    streamWriter.writeObject(instance.fTotalBilledTime);
    streamWriter.writeObject(instance.fValue);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.Project_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Project_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.Project)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Project_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.Project)object);
  }
  
}
