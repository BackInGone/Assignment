package org.example;

import java.util.Optional;

class DoneEvent extends Event {
  // DoneEvent 클래스는 고객의 서비스가 완료되었을 때 발생하는 이벤트입니다.
  // Event 클래스에서 상속받아 구현됩니다.

  private final Customer customer; // 서비스를 완료한 고객을 저장하는 필드입니다.
  private final Server server; // 서비스를 제공한 서버를 저장하는 필드입니다.

  public DoneEvent(Customer customer, Server server, double time) {
    // 생성자: DoneEvent 객체를 만들 때 호출됩니다.
    // 고객, 서버, 이벤트 발생 시간을 인자로 받아 초기화합니다.
    super(time); // 부모 클래스의 생성자를 호출하여 이벤트 시간을 설정합니다.
    this.customer = customer; // 서비스가 완료된 고객 정보를 저장합니다.
    this.server = server; // 서비스를 제공한 서버 정보를 저장합니다.
  }

  @Override
  public String toString() {
    // toString 메서드는 이벤트 발생 시간과 완료된 고객의 정보를 출력하는 문자열을 반환합니다.
    return String.format("%.1f customer %d done", time, customer.getId());
  }

  @Override
  public Pair<Optional<Event>, Shop> next(Shop shop) {
    // 서비스가 완료된 후, 추가로 발생할 이벤트가 없기 때문에 빈 Optional 객체를 반환합니다.
    return new Pair<>(Optional.empty(), shop);
  }
}