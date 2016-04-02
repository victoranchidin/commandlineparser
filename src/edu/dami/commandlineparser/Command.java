package edu.dami.commandlineparser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by avictor on 4/2/16.
 */
public class Command {
    private final String name;
    private final List<Option> options;

    Command(String name) {
        this.name = name;
        options = new LinkedList<>();
    }

    Command addOption(Option option) {
        options.add(option);
        return this;
    }

    String getName() {
        return name;
    }

    List<Option> getOptions() {
        return new LinkedList<>(options);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Command: ")
                .append(name);
        for (Option option : options) {
            sb.append(System.getProperty("line.separator"));
            sb.append(option);
        }
        return sb.toString();
    }
}
