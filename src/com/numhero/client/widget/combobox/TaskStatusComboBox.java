package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.TaskStatusEnum;

public class TaskStatusComboBox extends EnumComboBox<TaskStatusEnum> {
    public TaskStatusComboBox() {
        super(TaskStatusEnum.class);
    }
}