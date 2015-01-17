package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class InvoiceDetail_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.InvoiceDetail instance) throws SerializationException {
    instance.fOriginalID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fOriginatingType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fPrice = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fProductID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fQuantity = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fServiceID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fTax1ID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fTax2ID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.InvoiceDetail instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.InvoiceDetail();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.InvoiceDetail instance) throws SerializationException {
    streamWriter.writeObject(instance.fOriginalID);
    streamWriter.writeObject(instance.fOriginatingType);
    streamWriter.writeObject(instance.fPrice);
    streamWriter.writeObject(instance.fProductID);
    streamWriter.writeObject(instance.fQuantity);
    streamWriter.writeObject(instance.fServiceID);
    streamWriter.writeObject(instance.fTax1ID);
    streamWriter.writeObject(instance.fTax2ID);
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.InvoiceDetail_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.InvoiceDetail_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.InvoiceDetail)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.InvoiceDetail_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.InvoiceDetail)object);
  }
  
}
