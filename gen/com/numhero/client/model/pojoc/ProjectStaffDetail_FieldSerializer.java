package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProjectStaffDetail_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.ProjectStaffDetail instance) throws SerializationException {
    instance.fBillingRate = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fStaffId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fTimeUnit = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.ProjectStaffDetail instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.ProjectStaffDetail();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.ProjectStaffDetail instance) throws SerializationException {
    streamWriter.writeObject(instance.fBillingRate);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fStaffId);
    streamWriter.writeObject(instance.fTimeUnit);
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.ProjectStaffDetail_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ProjectStaffDetail_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.ProjectStaffDetail)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ProjectStaffDetail_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.ProjectStaffDetail)object);
  }
  
}
