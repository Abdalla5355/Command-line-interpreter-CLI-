package mainPack;
import java.util.List;
import java.lang.String;
import java.util.ArrayList;

public class Parser {

    String commandName;
    String[] args;
    boolean isArgProblem = false;

//This method will divide the input into commandName and args
//where "input" is the string command entered by the user 
    public boolean parse(String input) {
        String[] commandParts = input.split(" ");
        //filtering command name
        this.commandName = commandParts[0];
        // validating then filter the arguments for every command
        switch (this.commandName) {
            case "echo":
                if (commandParts.length != 2) {
                    this.isArgProblem = true;
                    return false;
                }
                args = new String[1];
                args[0] = commandParts[1];
                return true;
            case "pwd":
                if (commandParts.length != 1) {
                    this.isArgProblem = true;
                    return false;
                }
                return true;
            case "ls":
                if (commandParts.length > 2) {
                    this.isArgProblem = true;
                    return false;
                }
                if(commandParts.length == 2){
                    args = new String[1];
                    args[0] = commandParts[1];
                }
                return true;
            case "exit":
                return true;
            default:
                System.out.println("no such command");
            return false;
        }
    }

    public String getCommandName() {
        return this.commandName;
    }

    public String[] getArgs() {
        return this.args;
    }
    
    public boolean getIsArgProblem() {
        return this.isArgProblem;
    }

}
