package com.sw.splitwise;

import com.sw.splitwise.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitWiseApplication {

    @Autowired
    private static CommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();

            commandExecutor.execute(input);
        }
    }

}
/**
 * SETTLE UP THE REQUIREMENMT
 *
 * CONTROLLERS --> SERVICE --> REPOSITORY
 */