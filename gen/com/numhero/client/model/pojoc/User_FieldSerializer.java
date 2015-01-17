package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class User_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.User instance) throws SerializationException {
    instance.fBusinessAccountRoles = (com.numhero.shared.pojoc.field.OwnedListField) streamReader.readObject();
    instance.fCountryCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fEmail = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fFirstName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fLastLogin = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fLastName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fUserPortalId = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fUserStatus = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fVersion = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.User instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.User();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.User instance) throws SerializationException {
    streamWriter.writeObject(instance.fBusinessAccountRoles);
    streamWriter.writeObject(instance.fCountryCode);
    streamWriter.writeObject(instance.fEmail);
    streamWriter.writeObject(instance.fFirstName);
    streamWriter.writeObject(instance.fLastLogin);
    streamWriter.writeObject(instance.fLastName);
    streamWriter.writeObject(instance.fUserPortalId);
    streamWriter.writeObject(instance.fUserStatus);
    streamWriter.writeObject(instance.fVersion);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.User_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.User_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.User)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.User_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.User)object);
  }
  
}
