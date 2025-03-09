package com.sw.splitwise.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    // NEED NOT THIS BELOW CONSTRUCTOR SPRING WILL AUTOMATICALLY INJECT THE
    // THESE COMMANDS AS THE LIST..
    //    public CommandExecutor() {
    //        commands.add(settleUpUserCommand);
    //        commands.add(registerUserCommand);
    //        commands.add(addGroupCommand);
    //    }

    @Autowired
    public CommandExecutor(List<Command> commands) {  // Inject commands list automatically
        this.commands = commands;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        System.out.println("CommandExecutor: executing the " + input+" ..");
        for(Command command : commands) {
            if(command.matches(input.toString())) {
                command.execute(input);
                break;
            }
        }
    }

}
