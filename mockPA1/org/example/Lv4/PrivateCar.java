/*
package org.example.Lv4;

import org.example.Lv3.Driver;
import org.example.Request;

public class PrivateCar extends Driver {
  private static final Service JUST_RIDE = new JustRide();
  private static final Service SHARE_A_RIDE = new ShareARide();

  public PrivateCar(String plateNumber, int waitingTime) {
    super(plateNumber, waitingTime);
  }

  @Override
  public Service getService() {
    if (JUST_RIDE.computeFare(new Request(1, 1, 0)) <= SHARE_A_RIDE.computeFare(new Request(1, 1, 0))) {
      return JUST_RIDE;
    } else {
      return SHARE_A_RIDE;
    }
  }
}
*/
