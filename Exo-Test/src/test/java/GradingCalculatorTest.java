import org.example.simpleTest.GradingCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradingCalculatorTest {

    @Test
    public void testGradeA() {
        GradingCalculator calculator = new GradingCalculator(95, 90);
        assertEquals('A', calculator.getGrade(), "Score: 95%, Présence: 90%");
    }

    @Test
    public void testGradeB() {
        GradingCalculator calculator = new GradingCalculator(85, 90);
        assertEquals('B', calculator.getGrade(), "Score: 85%, Présence: 90%");
    }

    @Test
    public void testGradeC() {
        GradingCalculator calculator = new GradingCalculator(65, 90);
        assertEquals('C', calculator.getGrade(), "Score: 65%, Présence: 90%");
    }

    @Test
    public void testGradeBWithLowerAttendance() {
        GradingCalculator calculator = new GradingCalculator(95, 65);
        assertEquals('B', calculator.getGrade(), "Score: 95%, Présence: 65%");
    }

    @Test
    public void testGradeFWithLowAttendance() {
        GradingCalculator calculator = new GradingCalculator(95, 55);
        assertEquals('F', calculator.getGrade(), "Score: 95%, Présence: 55%");
    }

    @Test
    public void testGradeFLowScoreAndAttendance() {
        GradingCalculator calculator = new GradingCalculator(65, 55);
        assertEquals('F', calculator.getGrade(), "Score: 65%, Présence: 55%");
    }

    @Test
    public void testGradeFLowScore() {
        GradingCalculator calculator = new GradingCalculator(50, 90);
        assertEquals('F', calculator.getGrade(), "Score: 50%, Présence: 90%");
    }
}
