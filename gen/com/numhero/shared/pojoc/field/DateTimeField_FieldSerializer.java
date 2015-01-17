package com.numhero.shared.pojoc.field;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DateTimeField_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.field.DateTimeField instance) throws SerializationException {
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.field.DateTimeField instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.field.DateTimeField();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.field.DateTimeField instance) throws SerializationException {
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.field.DateTimeField_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.DateTimeField_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.field.DateTimeField)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.DateTimeField_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.field.DateTimeField)object);
  }
  
}
