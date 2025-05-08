package hus.oop.lab11.builder_pattern.car_builder;

import java.util.ArrayList;
import java.util.List;

public class Manual {
    private List<String> content = new ArrayList<>();

    public void addSection(String section) {
        content.add(section);
    }

    public String getDescription() {
        return "Manual:\n" + String.join("\n", content);
    }
}
