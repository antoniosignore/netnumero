package com.numhero.shared.pojoc.field;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class OwnedListField_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getFieldName(com.numhero.shared.pojoc.field.OwnedListField instance) /*-{
    return instance.@com.numhero.shared.pojoc.field.OwnedListField::fieldName;
  }-*/;
  
  private static native void setFieldName(com.numhero.shared.pojoc.field.OwnedListField instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.pojoc.field.OwnedListField::fieldName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.field.OwnedListField instance) throws SerializationException {
    setFieldName(instance, streamReader.readString());
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.field.OwnedListField instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.field.OwnedListField();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.field.OwnedListField instance) throws SerializationException {
    streamWriter.writeString(getFieldName(instance));
    
    com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.field.OwnedListField_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.OwnedListField_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.field.OwnedListField)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.OwnedListField_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.field.OwnedListField)object);
  }
  
}
