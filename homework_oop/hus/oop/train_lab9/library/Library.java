package hus.oop.train_lab9.library;

public class Library {
    Rent[] rents;

    public Library(Rent[] rents) {
        this.rents = rents;
    }

    public Rent getLongestRent() {
        long longestRent = rents[0].getBegin().getTime() - rents[0].getEnd().getTime();

        for (Rent time : rents) {
            if (time.getBegin().getTime() - time.getEnd().getTime() > longestRent) {
                longestRent = time.getBegin().getTime() - time.getEnd().getTime();
            }
        }

        for (Rent longestRentList : rents) {
            if (longestRentList.getBegin().getTime() - longestRentList.getEnd().getTime() == longestRent) {
                return longestRentList;
            }
        }
        return null;
    }
}
