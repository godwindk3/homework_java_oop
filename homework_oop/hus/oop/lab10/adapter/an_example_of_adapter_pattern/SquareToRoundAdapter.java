package hus.oop.lab10.adapter.an_example_of_adapter_pattern;

public class SquareToRoundAdapter implements RoundPlug {

    private SquarePlug squarePlug;

    public SquareToRoundAdapter(SquarePlug squarePlug) {
        this.squarePlug = squarePlug;
    }

    @Override
    public void connectRound() {
        squarePlug.connectSquare();
    }
}
