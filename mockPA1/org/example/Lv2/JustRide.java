/*
package org.example.Lv2;

public class JustRide implements Service{
  private static final int CENTS_PER_KM = 22;
  private static final int PEAK_HOUR_SURCHARGE = 500;
  private static final int PEAK_HOUR_START = 600;
  private static final int PEAK_HOUR_END = 900;

  @Override
  public int computeFare(Request request) {
    int baseFare = request.getDistance() * CENTS_PER_KM;
    if (isPeakHour(request.getTime())) {
      baseFare += PEAK_HOUR_SURCHARGE;
    }
    return baseFare;  }

  private boolean isPeakHour(int time) {
    return time >= PEAK_HOUR_START && time <= PEAK_HOUR_END;
  }
}
*/
