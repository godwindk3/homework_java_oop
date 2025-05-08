package hus.oop.lab11.builder_pattern.builder_pattern_example;


public class Sandwich {
    private String bread;
    private String meat;
    private String cheese;

    private Sandwich(Builder builder) {
        this.bread = builder.bread;
        this.meat = builder.meat;
        this.cheese = builder.cheese;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                '}';
    }

    public static class Builder {
        private String bread;
        private String meat;
        private String cheese;

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }

        public Builder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(this);
        }
    }

}
