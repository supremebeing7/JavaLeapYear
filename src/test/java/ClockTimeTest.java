import org.junit.*;
import static org.junit.Assert.*;

public class ClockTimeTest {
  @Test
  public void angleDistance_forTwelveOClock_zero() {
    ClockTime app = new ClockTime();
    assertEquals((Double)0.0, app.angleDistance("12:00"));
  }
}