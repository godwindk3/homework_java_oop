package hus.oop.test_exam_training_2022.decorator;

public class ThickcrustBread extends Bread {

    public ThickcrustBread() {
        description = "Thick crust bread, with tomato sauce";
    }

    public double cost() {
        return 30.0;
    }
}