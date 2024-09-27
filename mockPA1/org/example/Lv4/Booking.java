/*
package org.example.Lv4;

public class Booking implements Comparable<Booking>{
  private final Driver driver;
  private final Request request;
  private final Service service;
  private final int fare;

  public Booking(Driver driver, Request request) {
    this.driver = driver;
    this.request = request;
    this.service = driver.getService();
    this.fare = request.computeFare(this.service);
  }

  @Override
  public int compareTo(Booking other) {
    if (this.fare != other.fare) {
      return Integer.compare(this.fare, other.fare);
    }
    return Integer.compare(this.driver.getWaitingTime(), other.driver.getWaitingTime());
  }
  @Override
  public String toString() {
    return String.format("$%.2f using %s (%s)",
        fare / 100.0, driver, service.getClass().getSimpleName());
  }
}
*/
