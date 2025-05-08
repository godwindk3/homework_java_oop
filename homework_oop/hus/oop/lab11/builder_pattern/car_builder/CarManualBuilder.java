package hus.oop.lab11.builder_pattern.car_builder;

public class CarManualBuilder implements Builder {

    private Manual manual;

    public CarManualBuilder() {
        this.reset();
    }

    @Override
    public Builder reset() {
        this.manual = new Manual();
        return this;
    }

    @Override
    public Builder setSeats(int seats) {
        this.manual.addSection("Car has " + seats + " seats");
        return this;
    }

    @Override
    public Builder setEngine(Engine engine) {
        this.manual.addSection("Engine: " + engine.getDescription());
        return this;
    }

    @Override
    public Builder setTripComputer(boolean hasTripComputer) {
        this.manual.addSection("Trip Computer: " + (hasTripComputer ? "Installed" : "Not installed"));
        return this;
    }

    @Override
    public Builder setGPS(boolean hasGPS) {
        this.manual.addSection("GPS: " + (hasGPS ? "Installed" : "Not installed"));
        return this;
    }

    public Manual getProduct() {
        Manual product = this.manual;
        this.reset();
        return product;
    }
}
