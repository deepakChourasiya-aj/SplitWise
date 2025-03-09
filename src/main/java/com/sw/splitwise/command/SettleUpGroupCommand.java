package com.sw.splitwise.command;

import java.util.List;

public class SettleUpGroupCommand implements Command {
    private CommandKeywords commandKeywords;

    @Override
    public void execute(String input){

    }
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==3 && words.get(0).equals("SettleUp");
    }
}
