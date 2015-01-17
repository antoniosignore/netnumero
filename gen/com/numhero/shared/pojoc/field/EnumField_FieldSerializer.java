package com.numhero.shared.pojoc.field;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EnumField_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Enum getDefaultValue(com.numhero.shared.pojoc.field.EnumField instance) /*-{
    return instance.@com.numhero.shared.pojoc.field.EnumField::defaultValue;
  }-*/;
  
  private static native void setDefaultValue(com.numhero.shared.pojoc.field.EnumField instance, java.lang.Enum value) 
  /*-{
    instance.@com.numhero.shared.pojoc.field.EnumField::defaultValue = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.field.EnumField instance) throws SerializationException {
    setDefaultValue(instance, (java.lang.Enum) streamReader.readObject());
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.field.EnumField instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.field.EnumField();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.field.EnumField instance) throws SerializationException {
    streamWriter.writeObject(getDefaultValue(instance));
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.field.EnumField_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.EnumField_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.field.EnumField)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.EnumField_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.field.EnumField)object);
  }
  
}
