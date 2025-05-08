package hus.oop.lab11.builder_pattern.car_builder;

public class Director {
    public void constructSportCar(Builder builder) {
        builder.reset()
                .setSeats(2)
                .setEngine(new SportEngine())
                .setTripComputer(true)
                .setGPS(true);
    }

    public void constructSUV(Builder builder) {
        builder.reset()
                .setSeats(5)
                .setEngine(new SUVEngine())
                .setTripComputer(true)
                .setGPS(false);
    }
}
