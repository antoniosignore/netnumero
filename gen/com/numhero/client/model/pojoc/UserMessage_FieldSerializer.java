package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class UserMessage_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.UserMessage instance) throws SerializationException {
    instance.fMessage = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fMessageType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.UserMessage instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.UserMessage();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.UserMessage instance) throws SerializationException {
    streamWriter.writeObject(instance.fMessage);
    streamWriter.writeObject(instance.fMessageType);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.UserMessage_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.UserMessage_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.UserMessage)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.UserMessage_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.UserMessage)object);
  }
  
}
