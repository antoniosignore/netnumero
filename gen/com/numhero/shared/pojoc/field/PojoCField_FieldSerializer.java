package com.numhero.shared.pojoc.field;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PojoCField_FieldSerializer {
  private static native java.lang.String getFieldName(com.numhero.shared.pojoc.field.PojoCField instance) /*-{
    return instance.@com.numhero.shared.pojoc.field.PojoCField::fieldName;
  }-*/;
  
  private static native void setFieldName(com.numhero.shared.pojoc.field.PojoCField instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.pojoc.field.PojoCField::fieldName = value;
  }-*/;
  
  private static native boolean getIsSearchableField(com.numhero.shared.pojoc.field.PojoCField instance) /*-{
    return instance.@com.numhero.shared.pojoc.field.PojoCField::isSearchableField;
  }-*/;
  
  private static native void setIsSearchableField(com.numhero.shared.pojoc.field.PojoCField instance, boolean value) 
  /*-{
    instance.@com.numhero.shared.pojoc.field.PojoCField::isSearchableField = value;
  }-*/;
  
  private static native java.lang.Object getValue(com.numhero.shared.pojoc.field.PojoCField instance) /*-{
    return instance.@com.numhero.shared.pojoc.field.PojoCField::value;
  }-*/;
  
  private static native void setValue(com.numhero.shared.pojoc.field.PojoCField instance, java.lang.Object value) 
  /*-{
    instance.@com.numhero.shared.pojoc.field.PojoCField::value = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.field.PojoCField instance) throws SerializationException {
    setFieldName(instance, streamReader.readString());
    setIsSearchableField(instance, streamReader.readBoolean());
    setValue(instance, streamReader.readObject());
    
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.field.PojoCField instance) throws SerializationException {
    streamWriter.writeString(getFieldName(instance));
    streamWriter.writeBoolean(getIsSearchableField(instance));
    streamWriter.writeObject(getValue(instance));
    
  }
  
}
