package hus.oop.lab11.builder_pattern.car_builder;

public class CarBuilder implements Builder {
    private Car car;

    public CarBuilder() {
        this.reset();
    }

    @Override
    public Builder reset() {
        this.car = new Car();
        return this;
    }

    @Override
    public Builder setSeats(int seats) {
        this.car.setSeats(seats);
        return this;
    }

    @Override
    public Builder setEngine(Engine engine) {
        this.car.setEngine(engine);
        return this;
    }

    @Override
    public Builder setTripComputer(boolean hasTripComputer) {
        this.car.setTripComputer(hasTripComputer);
        return this;
    }

    @Override
    public Builder setGPS(boolean hasGPS) {
        this.car.setGps(hasGPS);
        return this;
    }

    public Car getProduct() {
        Car product = this.car;
        this.reset();
        return product;
    }


}
