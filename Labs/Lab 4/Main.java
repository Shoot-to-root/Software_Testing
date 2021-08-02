import java.util.Scanner;

public class Main {
    public void main(String[] args) {
        String p1, p2;
        Scanner in = new Scanner(System.in);

        System.out.println("=== Welcome to Rock-Paper-Scissor Game ===");

        System.out.println("Enter Player 1 choice (rock, paper, or scissors): ");
        p1 = in.nextLine();
        Game.input_validation(p1);

        System.out.println("Enter Player 2 choice (rock, paper, or scissors): ");
        p2 = in.nextLine();
        Game.input_validation(p2);

        Game.result(p1, p2);
    }
}
