package org.example;

import java.util.Optional;

class ArriveEvent extends Event {
  // 고객이 가게에 도착했을 때 발생하는 이벤트를 나타내는 클래스입니다.
  // 이 클래스는 Event라는 추상 클래스를 상속받습니다.
  // 추상 클래스를 상속받는다는 것은, 이 클래스가 반드시 Event 클래스에서 정의한 추상 메서드를 구현해야 한다는 것을 의미합니다.

  private final Customer customer;
  // 이 필드는 도착한 고객을 저장합니다. 'final'은 이 값이 한 번 초기화되면 변경될 수 없다는 것을 의미합니다.

  public ArriveEvent(Customer customer, double time) {
    // 생성자: ArriveEvent 객체를 만들 때 호출되는 메서드입니다.
    // customer와 time을 인자로 받아, 부모 클래스인 Event의 생성자(super)를 호출하여 시간을 설정하고, 고객을 저장합니다.
    super(time); // 부모 클래스의 생성자를 호출하여, 이 이벤트가 발생한 시간을 설정합니다.
    this.customer = customer; // 생성자로 전달된 customer 객체를 필드에 저장합니다.
  }

  @Override
  public String toString() {
    // toString 메서드는 객체를 사람이 읽을 수 있는 문자열 형태로 변환하는 메서드입니다.
    // 이벤트가 발생한 시간과 고객의 ID를 출력하는 문자열을 반환합니다.
    return String.format("%.1f customer %d arrives", time, customer.getId());
    // %.1f는 소수점 첫째 자리까지의 시간을 출력하겠다는 의미입니다.
  }

  @Override
  public Pair<Optional<Event>, Shop> next(Shop shop) {
    // next 메서드는 현재 이벤트가 끝난 후에 어떤 이벤트가 발생할지를 결정하는 메서드입니다.
    // 가게(shop)의 상태를 보고, 고객을 받을 수 있는 서버가 있는지 확인합니다.

    Optional<Server> availableServer = shop.getAvailableServer(customer);
    // shop 객체의 getAvailableServer 메서드를 호출하여 고객을 받을 수 있는 서버를 찾습니다.
    // Optional은 값이 존재할 수도 있고, 없을 수도 있는 객체를 나타냅니다.
    // 만약 이용 가능한 서버가 있다면 availableServer는 서버를 담고 있고, 없다면 빈 상태입니다.

    if (availableServer.isPresent()) {
      // 만약 이용 가능한 서버가 존재한다면 (availableServer가 비어있지 않다면)
      // 새로운 ServeEvent(서비스를 제공하는 이벤트)를 생성하여 반환합니다.
      return new Pair<>(Optional.of(new ServeEvent(customer, availableServer.get(), time)), shop);
      // Pair 객체로 감싸서 반환하는데, 첫 번째 값은 새로운 ServeEvent이고, 두 번째 값은 현재 가게(shop)의 상태입니다.
    } else {
      // 이용 가능한 서버가 없을 경우, 고객이 떠나게 됩니다.
      // 따라서 새로운 LeaveEvent(고객이 떠나는 이벤트)를 생성하여 반환합니다.
      return new Pair<>(Optional.of(new LeaveEvent(customer, time)), shop);
    }
  }
}