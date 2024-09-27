package org.example;

import java.util.Optional;

// Event and ArriveEvent classes remain the same as before

class ServeEvent extends Event {
// ServeEvent 클래스는 고객이 서버에서 서비스를 받는 이벤트를 나타냅니다.

  private final Customer customer; // 서비스를 받는 고객 객체를 저장하는 필드입니다.
  private final Server server; // 서비스를 제공하는 서버 객체를 저장하는 필드입니다.

  public ServeEvent(Customer customer, Server server, double time) {
    // 생성자: ServeEvent 객체를 생성할 때 호출됩니다.
    super(time); // 부모 클래스의 생성자를 호출하여 이벤트 발생 시간을 설정합니다.
    this.customer = customer; // 고객 정보를 저장합니다.
    this.server = server; // 서버 정보를 저장합니다.
  }

  @Override
  public String toString() {
    // 이벤트 발생 시간과, 고객 ID, 서버 ID를 문자열로 반환합니다.
    return String.format("%.1f customer %d serve by server %d", time, customer.getId(), server.getId());
  }

  @Override
  public Pair<Optional<Event>, Shop> next(Shop shop) {
    // 고객이 서비스를 받고 난 후, 다음 이벤트로 DoneEvent를 생성합니다.
    Server updatedServer = server.serve(customer); // 서버가 고객을 서비스하고, 서버의 상태를 업데이트합니다.
    Shop updatedShop = shop.update(updatedServer); // 서버 상태가 업데이트된 Shop 객체를 생성합니다.
    Double donetime = time + customer.getServiceTime(); // 서비스가 완료되는 시간을 계산합니다.
    return new Pair<>(Optional.of(new DoneEvent(customer, server, donetime)), updatedShop);
    // 새로운 DoneEvent와 업데이트된 Shop 객체를 반환합니다.
  }
}