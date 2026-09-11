package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PritheeGameTest {

    private PritheeGame game;

    @BeforeEach
    void setUp() {
        game = new PritheeGame();
    }

    @Test
    void testSonnetWordParsing() {
        assertNotNull(game.getWords(), "Word list should not be null");
        assertFalse(game.getWords().isEmpty(), "Word list should contain the sonnet words");
        assertEquals("Shall", game.sanitizeWord(game.getWords().get(0)));
    }

    @Test
    void testSanitizeWord() {
        assertEquals("summer’s", game.sanitizeWord("summer’s?"));
        assertEquals("temperate", game.sanitizeWord("temperate:"));
        assertEquals("May", game.sanitizeWord("May,"));
    }

    @Test
    void testInitialScores() {
        assertEquals(0, game.getCorrectCount());
        assertEquals(0, game.getIncorrectCount());
    }
}