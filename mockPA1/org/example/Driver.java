package org.example;

public abstract class Driver {
  private final String plateNumber;
  private final int waitingTime;

  public Driver(String plateNumber, int waitingTime) {
    this.plateNumber = plateNumber;
    this.waitingTime = waitingTime;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public int getWaitingTime() {
    return waitingTime;
  }

  public abstract Service getService(Request request);
  public abstract Service[] getAvailableServices();

  @Override
  public String toString() {
    return plateNumber + " (" + waitingTime + " mins away) " + this.getClass().getSimpleName();
  }
}
