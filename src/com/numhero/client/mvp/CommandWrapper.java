package com.numhero.client.mvp;

import com.google.gwt.user.client.Command;

public class CommandWrapper {
    private String name;
    private Command command;

    public CommandWrapper(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
