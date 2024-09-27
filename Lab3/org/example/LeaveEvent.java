package org.example;


import java.util.Optional;

class LeaveEvent extends Event {
  // LeaveEvent 클래스는 고객이 떠나는 이벤트를 나타냅니다.

  private final Customer customer; // 떠나는 고객을 저장하는 필드입니다.

  public LeaveEvent(Customer customer, double time) {
    // 생성자: LeaveEvent 객체를 생성할 때 호출됩니다.
    super(time); // 부모 클래스의 생성자를 호출하여 이벤트 발생 시간을 설정합니다.
    this.customer = customer; // 떠나는 고객의 정보를 저장합니다.
  }

  @Override
  public String toString() {
    // toString 메서드는 이벤트가 발생한 시간과 떠나는 고객의 ID를 문자열로 반환합니다.
    return String.format("%.1f customer %d leaves", time, customer.getId());
  }

  @Override
  public Pair<Optional<Event>, Shop> next(Shop shop) {
    // 고객이 떠난 후에는 더 이상 발생할 이벤트가 없기 때문에 빈 Optional 객체를 반환합니다.
    return new Pair<>(Optional.empty(), shop);
  }
}