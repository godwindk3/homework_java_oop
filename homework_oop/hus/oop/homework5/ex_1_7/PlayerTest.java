package hus.oop.homework5.ex_1_7;

public class PlayerTest {
    public static void main(String[] args) {
        // Create a player and a ball
        Player player = new Player(10, 20.0f, 30.0f);
        Ball ball = new Ball(25.0f, 35.0f, 0.0f);

        // Test constructor and toString
        System.out.println("Initial player: " + player); // Expected: Player 10 at (20.0, 30.0, 0.0)
        System.out.println("Initial ball: " + ball);     // Expected: (25.0, 35.0, 0.0)

        // Test getters
        System.out.println("Number: " + player.getNumber()); // Expected: 10
        System.out.println("X: " + player.getX());           // Expected: 20.0
        System.out.println("Y: " + player.getY());           // Expected: 30.0
        System.out.println("Z: " + player.getZ());           // Expected: 0.0

        // Test move
        player.move(5.0f, -5.0f);
        System.out.println("After move: " + player);         // Expected: Player 10 at (25.0, 25.0, 0.0)

        // Test jump
        player.jump(10.0f);
        System.out.println("After jump: " + player);         // Expected: Player 10 at (25.0, 25.0, 10.0)

        // Test near (should be true since distance is sqrt((25-25)^2 + (25-35)^2) = 10 < 8)
        player.move(0.0f, 10.0f); // Move to (25.0, 35.0)
        System.out.println("After move to ball: " + player); // Expected: Player 10 at (25.0, 35.0, 10.0)
        System.out.println("Is near ball? " + player.near(ball)); // Expected: true

        // Test kick
        player.kick(ball);
        System.out.println("After kick: " + ball);           // Ball moves a random distance

        // Test jump with negative zDisp
        player.jump(-15.0f);
        System.out.println("After jump down: " + player);
    }
}
