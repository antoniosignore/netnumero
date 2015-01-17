package com.numhero.shared.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SearchReference_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.pojoc.field.IdField getFPojoId(com.numhero.shared.pojoc.SearchReference instance) /*-{
    return instance.@com.numhero.shared.pojoc.SearchReference::fPojoId;
  }-*/;
  
  private static native void setFPojoId(com.numhero.shared.pojoc.SearchReference instance, com.numhero.shared.pojoc.field.IdField value) 
  /*-{
    instance.@com.numhero.shared.pojoc.SearchReference::fPojoId = value;
  }-*/;
  
  private static native com.numhero.shared.pojoc.field.StringField getFPojoKind(com.numhero.shared.pojoc.SearchReference instance) /*-{
    return instance.@com.numhero.shared.pojoc.SearchReference::fPojoKind;
  }-*/;
  
  private static native void setFPojoKind(com.numhero.shared.pojoc.SearchReference instance, com.numhero.shared.pojoc.field.StringField value) 
  /*-{
    instance.@com.numhero.shared.pojoc.SearchReference::fPojoKind = value;
  }-*/;
  
  private static native com.numhero.shared.pojoc.field.StringField getFPojoName(com.numhero.shared.pojoc.SearchReference instance) /*-{
    return instance.@com.numhero.shared.pojoc.SearchReference::fPojoName;
  }-*/;
  
  private static native void setFPojoName(com.numhero.shared.pojoc.SearchReference instance, com.numhero.shared.pojoc.field.StringField value) 
  /*-{
    instance.@com.numhero.shared.pojoc.SearchReference::fPojoName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.SearchReference instance) throws SerializationException {
    setFPojoId(instance, (com.numhero.shared.pojoc.field.IdField) streamReader.readObject());
    setFPojoKind(instance, (com.numhero.shared.pojoc.field.StringField) streamReader.readObject());
    setFPojoName(instance, (com.numhero.shared.pojoc.field.StringField) streamReader.readObject());
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.SearchReference instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.SearchReference();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.SearchReference instance) throws SerializationException {
    streamWriter.writeObject(getFPojoId(instance));
    streamWriter.writeObject(getFPojoKind(instance));
    streamWriter.writeObject(getFPojoName(instance));
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.SearchReference_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.SearchReference_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.SearchReference)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.SearchReference_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.SearchReference)object);
  }
  
}
