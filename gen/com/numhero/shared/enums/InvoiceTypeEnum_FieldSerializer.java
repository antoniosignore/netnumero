package com.numhero.shared.enums;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class InvoiceTypeEnum_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.enums.InvoiceTypeEnum instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.numhero.shared.enums.InvoiceTypeEnum instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.numhero.shared.enums.InvoiceTypeEnum[] values = com.numhero.shared.enums.InvoiceTypeEnum.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.enums.InvoiceTypeEnum instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.enums.InvoiceTypeEnum_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.enums.InvoiceTypeEnum_FieldSerializer.deserialize(reader, (com.numhero.shared.enums.InvoiceTypeEnum)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.enums.InvoiceTypeEnum_FieldSerializer.serialize(writer, (com.numhero.shared.enums.InvoiceTypeEnum)object);
  }
  
}
