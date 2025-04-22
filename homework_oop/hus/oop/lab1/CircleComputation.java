package hus.oop.lab1;

import java.util.Scanner;

public class CircleComputation {
    public static void main(String[] args) {
        double radius;
        double diameter;
        double circumference;
        double area;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        radius = in.nextDouble();

        in.close();

        diameter = radius * 2.0;
        circumference = 2.0 * Math.PI * radius;
        area = Math.PI * radius * radius;
        System.out.printf("Diameter is: %.2f%n", diameter);
        System.out.printf("Circumference is: %.2f%n", circumference);
        System.out.printf("Area is: %.2f%n", area);

    }
}
