package com.numhero.shared.pojoc.field;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DateField_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.field.DateField instance) throws SerializationException {
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.field.DateField instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.field.DateField();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.field.DateField instance) throws SerializationException {
    
    com.numhero.shared.pojoc.field.PojoCField_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.field.DateField_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.DateField_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.field.DateField)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.field.DateField_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.field.DateField)object);
  }
  
}
