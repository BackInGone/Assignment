package org.example;

import java.util.Optional;

abstract class Event implements Comparable<Event> {
  // Event 클래스는 모든 이벤트의 기본이 되는 추상 클래스입니다.
  // 이 클래스는 비교 가능한(Comparable) 객체로, 이벤트 시간을 기준으로 다른 이벤트들과 비교될 수 있습니다.

  protected final double time;
  // 이벤트가 발생한 시간을 저장하는 필드입니다. 이 필드는 상속받은 자식 클래스에서 사용할 수 있도록 protected로 선언됩니다.

  public Event(double time) {
    // 생성자: 이벤트가 생성될 때 발생 시간을 설정합니다.
    this.time = time;
  }

  public double getTime() {
    // 이벤트가 발생한 시간을 반환하는 메서드입니다.
    return time;
  }

  @Override
  public int compareTo(Event other) {
    // 이벤트를 시간 기준으로 비교하는 메서드입니다.
    // 시간이 빠른 순서대로 우선순위를 결정하기 위해 Double.compare를 사용하여 두 이벤트의 시간을 비교합니다.
    return Double.compare(this.time, other.time);
  }

  abstract public Pair<Optional<Event>, Shop> next(Shop shop);
  // 다음 이벤트가 무엇인지 결정하는 추상 메서드입니다.
  // 각 이벤트가 이 메서드를 구현하여 다음 이벤트를 반환합니다.
}