package org.example;

public class Customer {
  private final int id;  // 이 변수는 각 고객의 고유 ID를 저장합니다. 고객을 구분할 수 있게 해줍니다.
  private final double arrivalTime;  // 고객이 언제 도착했는지 저장하는 변수입니다. 시간 단위로 기록됩니다.

  // 생성자: 이 생성자는 고객의 ID와 도착 시간을 인자로 받아서 고객 객체를 초기화합니다.
  public Customer(int id, double arrivalTime) {
    this.id = id;  // id를 인스턴스 변수에 저장
    this.arrivalTime = arrivalTime;  // arrivalTime을 인스턴스 변수에 저장
  }

  // 이 메소드는 주어진 시간이 현재 고객의 도착 시간 이후인지를 확인하여, 고객이 서비스를 받을 수 있는지 여부를 반환합니다.
  public boolean canBeServed(double time) {
    return this.arrivalTime <= time;
    // 도착 시간이 현재 시간보다 작거나 같으면 고객이 서비스를 받을 수 있습니다.
    // 도착 시간이 현재 시간보다 뒤라면 아직 도착하지 않았기 때문에 서비스를 받을 수 없습니다.
  }

  // 고객의 도착 시간을 반환하는 메소드입니다.
  public double getArrivalTime() {
    return this.arrivalTime;  // 고객이 언제 도착했는지 반환해줍니다.
  }

  // 이 메소드는 서비스 시간을 받아, 고객이 언제까지 서비스를 받을지를 계산하여 반환합니다.
  public double serveTill(double serviceTime) {
    return this.arrivalTime + serviceTime;
    // 도착 시간에 서비스 시간이 더해진 값이 서비스가 종료되는 시간입니다.
    // 예를 들어, 고객이 1.0에 도착했고 서비스 시간이 1.0이라면, 2.0에 서비스가 끝납니다.
  }

  // 고객을 문자열로 표현하는 메소드입니다.
  @Override
  public String toString() {
    return "customer " + id;  // 고객 ID를 "customer {id}" 형식으로 출력해줍니다.
  }

  // 고객의 ID를 반환하는 메소드입니다.
  public int getId() {
    return this.id;  // 고객의 ID를 반환합니다.
  }
}
