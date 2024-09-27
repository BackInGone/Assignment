/*
package org.example.Lv3;

import org.example.Request;

public class NormalCab extends Driver{
  private static final Service JUST_RIDE = new JustRide();
  private static final Service TAKE_A_CAB = new TakeACab();

  public NormalCab(String plateNumber, int waitingTime) {
    super(plateNumber, waitingTime);
  }

  @Override
  public Service getService() {
    if (JUST_RIDE.computeFare(new Request(1, 1, 0)) <= TAKE_A_CAB.computeFare(new Request(1, 1, 0))) {
      return JUST_RIDE;
    } else {
      return TAKE_A_CAB;
    }
  }
}
*/
