package edu.dami.commandlineparser;

import java.util.*;

/**
 * Created by avictor on 4/2/16.
 */
public class CommandParser {
    private final Set<String> validOptions;

    CommandParser(String... validOptions) {
        this(new LinkedList<String>(Arrays.asList(validOptions)));
    }

    CommandParser(List<String> validOptions) {
        this.validOptions = new HashSet<>(validOptions);
    }

    Command parse(String[] args) throws InvalidOptionException, InvalidCommandException {
        if (args.length == 0) {
            throw new InvalidCommandException();
        }

        if (args[0].startsWith("-")) {
            throw new InvalidCommandException();
        }

        Command command = new Command(args[0]);

        int index = 0;
        Option lastOption = null;
        while (++index < args.length) {
            String arg = args[index];
            if (arg.startsWith("--")) {
                String optionName = arg.substring(2);
                if (!validOptions.contains(optionName)) {
                    throw new InvalidOptionException(optionName);
                }
                lastOption = new Option(optionName);
                command.addOption(lastOption);
            } else {
                if (lastOption == null) {
                    throw new InvalidOptionException("No option");
                }
                lastOption.addValue(arg);
            }
        }
        return command;
    }

    static class InvalidOptionException extends Exception {
        private InvalidOptionException(String unrecognizedOption) {
            super("Unrecognized option " + unrecognizedOption);
        }
    }

    static class InvalidCommandException extends Exception {
        private InvalidCommandException() {
            super("Invalid command");
        }
    }
}
