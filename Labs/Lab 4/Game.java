public class Game {
    public static void input_validation(String p) {
        if (!(p.equalsIgnoreCase("rock") || p.equalsIgnoreCase("paper") || p.equalsIgnoreCase("scissors")))
            throw new IllegalArgumentException("Illegal Argument!");
    }

    public static void result(String p1, String p2) {
        if(p1.equals(p2)) {
            System.out.println("Draw!");
        } else if((p1.equalsIgnoreCase("rock") && p2.equalsIgnoreCase("scissors")) ||
                (p1.equalsIgnoreCase("scissors") && p2.equalsIgnoreCase("paper")) ||
                (p1.equalsIgnoreCase("paper") && p2.equalsIgnoreCase("rock"))) {
            System.out.println("Player 1 won!");
        } else {
            System.out.println("Player 2 won!");
        }
    }
}
