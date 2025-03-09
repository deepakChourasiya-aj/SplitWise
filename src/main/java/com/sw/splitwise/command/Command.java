package com.sw.splitwise.command;

public interface Command {
    void execute(String input);

    boolean matches(String input);
}
