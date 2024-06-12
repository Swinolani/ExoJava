

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.example.simpleTest.DiceScore;
import org.example.simpleTest.Ide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DiceScoreTest {

    @Mock
    private Ide mockDe;

    private DiceScore diceScore;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        diceScore = new DiceScore();
        diceScore.de = mockDe;
    }

    @Test
    public void testIdenticalDiceScores() {
        when(mockDe.getRoll()).thenReturn(4, 4);
        int score = diceScore.getScore();
        assertEquals(18, score); // 4 * 2 + 10 = 18
    }

    @Test
    public void testIdenticalDiceScoresMaxSix() {
        when(mockDe.getRoll()).thenReturn(6, 6);
        int score = diceScore.getScore();
        assertEquals(30, score); // 6 + 6 = 30
    }

    @Test
    public void testDifferentDiceScores() {
        when(mockDe.getRoll()).thenReturn(3, 5);
        int score = diceScore.getScore();
        assertEquals(5, score); // max(3, 5) = 5
    }
}
