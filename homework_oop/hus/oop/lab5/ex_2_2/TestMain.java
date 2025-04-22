package hus.oop.lab5.ex_2_2;

public class TestMain {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);
        System.out.println(cylinder1.getVolume());

        Cylinder cylinder2 = new Cylinder(2.0);
        System.out.println(cylinder2);
        System.out.println(cylinder2.getVolume());

        Cylinder cylinder3 = new Cylinder(2.0, 5);
        System.out.println(cylinder3);
        System.out.println(cylinder3.getVolume());



        cylinder3.setHeight(4);
        System.out.println("Set height: " + cylinder3 );
        System.out.println(cylinder3.getVolume());


        Cylinder cylinder4 = new Cylinder(2.0, "green", 6);
        System.out.println(cylinder4);
        System.out.println(cylinder4.getVolume());


    }
}
