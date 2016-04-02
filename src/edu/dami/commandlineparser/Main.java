package edu.dami.commandlineparser;

public class Main {

    public static void main(String[] args) {
        CommandParser commandParser = new CommandParser("l", "a", "b");
        try {
            Command command = commandParser.parse(args);
            System.out.println(command);
        } catch (CommandParser.InvalidOptionException|CommandParser.InvalidCommandException e) {
            System.err.println(e);
        }
    }
}
