package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserDetail_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.UserDetail instance) throws SerializationException {
    instance.fLastUsed = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fRelatedBAUri = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fRole = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.UserDetail instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.UserDetail();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.UserDetail instance) throws SerializationException {
    streamWriter.writeObject(instance.fLastUsed);
    streamWriter.writeObject(instance.fRelatedBAUri);
    streamWriter.writeObject(instance.fRole);
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.UserDetail_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.UserDetail_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.UserDetail)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.UserDetail_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.UserDetail)object);
  }
  
}
