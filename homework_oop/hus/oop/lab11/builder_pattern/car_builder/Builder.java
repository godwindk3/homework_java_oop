package hus.oop.lab11.builder_pattern.car_builder;

public interface Builder {
    Builder reset();

    Builder setSeats(int seats);

    Builder setEngine(Engine engine);

    Builder setTripComputer(boolean hasTripComputer);

    Builder setGPS(boolean hasGPS);
}
