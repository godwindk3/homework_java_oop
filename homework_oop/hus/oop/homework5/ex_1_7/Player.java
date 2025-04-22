package hus.oop.homework5.ex_1_7;

public class Player {
    private int number;
    private float x;
    private float y;
    private float z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
        if (this.z < 0) {
            this.z = 0.0f;
        }
    }

    public boolean near(Ball ball) {
        float distance = (float) Math.sqrt(
                Math.pow(this.x - ball.getX(), 2) +
                        Math.pow(this.y - ball.getY(), 2)

        );
        return distance < 8.0f;
    }

    public void kick(Ball ball) {
        float kickDistance = 10.0f + (float) (Math.random() * 10.0);
        float angle = (float) (Math.random() * 360);
        float deltaX = (float) (kickDistance * Math.cos(Math.toRadians(angle)));
        float deltaY = (float) (kickDistance * Math.sin(Math.toRadians(angle)));

        float newZ = ball.getZ();
        if (this.z > 0) {
            newZ += this.z * 0.5f;
        }

        ball.setXYZ(ball.getX() + deltaX, ball.getY() + deltaY, newZ);
    }


    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
