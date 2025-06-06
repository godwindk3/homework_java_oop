package hus.oop.lab10.adapter.an_example_of_adapter_pattern;

public class Main {
    public static void main(String[] args) {
        RoundPlug myDevice;

        SquarePlug squarePlug = new SquarePlug(); // don't have connectRound() method

        myDevice = new SquareToRoundAdapter(squarePlug);

        myDevice.connectRound();
    }
}
