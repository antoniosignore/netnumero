package com.numhero.shared.pojoc.field;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class StringField_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getMaxLength(com.numhero.shared.pojoc.field.StringField instance) /*-{
    return instance.@com.numhero.shared.pojoc.field.StringField::maxLength;
  }-*/;
  
  private static native void setMaxLength(com.numhero.shared.pojoc.field.StringField instance, int value) 
  /*-{
    instance.@com.numhero.shared.pojoc.field.StringField::maxLength = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.field.StringField instance) throws SerializationException {
    setMaxLength(instance, streamReader.readInt());
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.field.StringField instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.field.StringField();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.field.StringField instance) throws SerializationException {
    streamWriter.writeInt(getMaxLength(instance));
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.field.StringField_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.StringField_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.field.StringField)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.StringField_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.field.StringField)object);
  }
  
}
