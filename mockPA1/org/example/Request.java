package org.example;

public class Request {
  private final int distance;
  private final int numPassengers;
  private final int time;

  public Request(int distance, int numPassengers, int time) {
    this.distance = distance;
    this.numPassengers = numPassengers;
    this.time = time;
  }

  public int getDistance() {
    return distance;
  }

  public int getNumPassengers() {
    return numPassengers;
  }

  public int getTime() {
    return time;
  }

  public int computeFare(Service service) {
    return service.computeFare(this);
  }

  @Override
  public String toString() {
    return distance + "km for " + numPassengers + "pax @ " + String.format("%04d", time) + "hrs";
  }
}
