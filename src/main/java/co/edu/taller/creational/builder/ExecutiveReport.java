package co.edu.taller.creational.builder;

import java.util.*;

public class ExecutiveReport {
    private final String title, period;
    private final List<String> sections;

    private ExecutiveReport(Builder b) {
        title = b.title;
        period = b.period;
        sections = List.copyOf(b.sections);
    }

    public String title() {
        return title;
    }

    public String period() {
        return period;
    }

    public List<String> sections() {
        return sections;
    }

    public static class Builder {
        private String title, period;
        private final List<String> sections = new ArrayList<>();

        public Builder title(String v) {
            title = v;
            return this;
        }

        public Builder period(String v) {
            period = v;
            return this;
        }

        public Builder addSection(String v) {
            sections.add(v);
            return this;
        }

        public ExecutiveReport build() {
            // TODO: validate required fields and build report
            if (title == null || title.trim().isEmpty() || period == null || period.trim().isEmpty()) {
                throw new IllegalStateException("Title and period are required");
            }
            return new ExecutiveReport(this);
        }
    }
}