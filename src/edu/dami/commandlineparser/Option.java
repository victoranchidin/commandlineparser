package edu.dami.commandlineparser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by avictor on 4/2/16.
 */
public class Option {
    private final String name;
    private final List<String> values;

    Option(String name) {
        this.name = name;
        values = new LinkedList<>();
    }

    Option addValue(String value) {
        values.add(value);
        return this;
    }

    String getName() {
        return name;
    }

    List<String> getValues() {
        return new ArrayList<>(values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("--")
                .append(name);
        for (String value : values) {
            sb
                    .append(" ")
                    .append(value);

        }
        return sb.toString();
    }
}
