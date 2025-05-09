package hus.oop.lab11.visitor_pattern.shape;

public class XMLExportVisitor implements Visitor {

    @Override
    public void visitDot(Dot d) {
        d.draw();
    }

    @Override
    public void visitCircle(Circle c) {
        c.draw();
    }

    @Override
    public void visitRectangle(Rectangle r) {
        r.draw();
    }

    @Override
    public void visitCompoundShape(CompoundShape cs) {
        cs.draw();
    }
}
