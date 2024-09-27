package org.example;

public class PrivateCar extends Driver{
  private static final Service JUST_RIDE = new JustRide();
  private static final Service SHARE_A_RIDE = new ShareARide();

  public PrivateCar(String plateNumber, int waitingTime) {
    super(plateNumber, waitingTime);
  }

  /*@Override
  public Service getService() {
    if (JUST_RIDE.computeFare(new Request(1, 1, 0)) <= SHARE_A_RIDE.computeFare(new Request(1, 1, 0))) {
      return JUST_RIDE;
    } else {
      return SHARE_A_RIDE;
    }
  }*/

  @Override
  public Service getService(Request request) {
    int justRideFare = JUST_RIDE.computeFare(request);
    int shareARideFare = SHARE_A_RIDE.computeFare(request);

    if (justRideFare <= shareARideFare) {
      return JUST_RIDE;
    } else {
      return SHARE_A_RIDE;
    }
  }
  @Override
  public Service[] getAvailableServices() {
    return new Service[]{JUST_RIDE, SHARE_A_RIDE};
  }

  }

