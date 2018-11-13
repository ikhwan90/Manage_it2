package com.manage_it.Events;

import com.manage_it.ToDo;

public class FocusTaskChanged {

    public static ToDo currentFocusTask;
    public static ToDo previousFocusTask;

    public FocusTaskChanged(ToDo item) {
        long id = item.getToDoId();
        if (currentFocusTask != null && id != currentFocusTask.getToDoId()) {
            previousFocusTask = currentFocusTask;
        }
        currentFocusTask = item;
    }
}


