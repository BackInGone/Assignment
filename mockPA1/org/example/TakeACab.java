package org.example;

public class TakeACab implements Service{
  private static final int CENTS_PER_KM = 33;
  private static final int BOOKING_FEE = 200;

  @Override
  public int computeFare(Request request) {
    return request.getDistance() * CENTS_PER_KM + BOOKING_FEE;
  }

  @Override
  public String getServiceName() {
    return "TakeACab";
  }
}
