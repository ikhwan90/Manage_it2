package com.manage_it.Events;

import com.manage_it.ToDo;

public class CurrentTaskEdited {

    public static ToDo editedItem;
    public CurrentTaskEdited(ToDo editedItem) {
        CurrentTaskEdited.editedItem = editedItem;
    }
}

