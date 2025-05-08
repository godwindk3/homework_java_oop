package hus.oop.lab11.builder_pattern.car_builder;

public class Application {
    public static void main(String[] args) {
        new Application().makeCar();
    }

    public void makeCar() {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportCar(carBuilder);
        Car car = carBuilder.getProduct();
        System.out.println(car.toString());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportCar(manualBuilder);
        Manual manual = manualBuilder.getProduct();
        System.out.println(manual.getDescription());

        CarBuilder suvBuilder = new CarBuilder();
        director.constructSUV(suvBuilder);
        Car suv = suvBuilder.getProduct();
        System.out.println(suv.toString());
    }
}
