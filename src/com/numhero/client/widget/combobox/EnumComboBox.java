package com.numhero.client.widget.combobox;

public class EnumComboBox<E extends Enum<E>> extends ComboBox {
    private Class<E> enumClass;

    public EnumComboBox(Class<E> enumClass) {
        this.enumClass = enumClass;
        addAllItems();
    }

    protected void addAllItems() {
        for (E e : enumClass.getEnumConstants()) {
            addItem(e.name());
        }
    }

    public E getValue() {
        return Enum.valueOf(enumClass, getStringValue());
    }

    public void setValue(E e) {
        if (e != null) {
            super.setValue(e.name());
        }
    }
}
