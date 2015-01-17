package com.google.gwt.user.client.rpc.core;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class byte_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, byte[] instance) throws SerializationException {
    for (int i = 0, n = instance.length; i < n; ++i) {
      instance[i] = streamReader.readByte();
    }
  }
  
  public static byte[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new byte[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, byte[] instance) throws SerializationException {
    streamWriter.writeInt(instance.length);
    
    for (int i = 0, n = instance.length; i < n; ++i) {
      streamWriter.writeByte(instance[i]);
    }
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.rpc.core.byte_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.byte_Array_Rank_1_FieldSerializer.deserialize(reader, (byte[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.byte_Array_Rank_1_FieldSerializer.serialize(writer, (byte[])object);
  }
  
}
