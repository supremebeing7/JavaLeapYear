public class ClockTime {
  public static void main(String[] args) {}

  public Double angleDistance(String time) {
    String[] timeParts = time.split(":");
    Double hour = Double.parseDouble(timeParts[0]);
    Double minute = Double.parseDouble(timeParts[1]);
    if ( minute.equals(0.0) ) {
      return distanceForTimesOnTheHour(hour);
    } else {
      return 100000.0;
    }
  }

  public Double distanceForTimesOnTheHour(Double hour) {
    if ( hour > 6 ) {
      return 180.0 - (hour - 6) * 30;
    } else {
      return (hour % 12) * 30;
    }
  }
}