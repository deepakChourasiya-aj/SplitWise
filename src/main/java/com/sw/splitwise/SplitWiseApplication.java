package com.sw.splitwise;

import com.sw.splitwise.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SplitWiseApplication {

//    @Autowired
//    private static CommandExecutor commandExecutor;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SplitWiseApplication.class, args);

        // Manually get the bean
        CommandExecutor commandExecutor = context.getBean(CommandExecutor.class);

        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();
            System.out.println(input+" <<<<<INPUT>>>>>");
            commandExecutor.execute(input);
        }
    }

}
/**
 * SETTLE UP THE REQUIREMENMT
 * CONTROLLERS --> SERVICE --> REPOSITORY
 */