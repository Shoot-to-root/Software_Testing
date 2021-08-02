import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void p1_win() {
        Game.result("rock", "scissors");
        assertEquals("Player 1 win!\r\n", "Player 1 win!\r\n");
        Game.result("scissors", "paper");
        assertEquals("Player 1 win!\r\n", "Player 1 win!\r\n");
        Game.result("paper", "rock");
        assertEquals("Player 1 win!\r\n", "Player 1 win!\r\n");
    }

    @Test
    public void p2_win() {
        Game.result("scissors", "rock");
        assertEquals("Player 2 win!\r\n", "Player 2 win!\r\n");
        Game.result("paper", "scissors");
        assertEquals("Player 2 win!\r\n", "Player 2 win!\r\n");
        Game.result("rock", "paper");
        assertEquals("Player 2 win!\r\n", "Player 2 win!\r\n");
    }

    @Test
    public void tie() {
        Game.result("rock", "rock");
        assertEquals("Draw!\r\n", "Draw!\r\n");
        Game.result("paper", "paper");
        assertEquals("Draw!\r\n", "Draw!\r\n");
        Game.result("scissors", "scissors");
        assertEquals("Draw!\r\n", "Draw!\r\n");
    }

    @Test
    public void check_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            Game.input_validation("rubbish"); });
    }
}