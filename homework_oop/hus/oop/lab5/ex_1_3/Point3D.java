package hus.oop.lab5.ex_1_3;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this.z = 0.0f;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] XYZ = {this.getX(), this.getY(), this.getZ()};
        return XYZ;
    }

    public void setXYZ(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    @Override
    public String toString() {
        String str = "(" + this.getX() + "," + this.getY() + "," + this.getZ() + ")";
        return str;
    }
}
