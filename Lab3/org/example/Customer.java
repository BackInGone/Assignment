package org.example;

public class Customer {

  private final int id; // 고객의 고유 ID를 저장하는 필드입니다.
  private final double arrivalTime; // 고객이 가게에 도착한 시간을 저장하는 필드입니다.
  private final double serviceTime; // 고객이 서비스를 받는 데 걸리는 시간을 저장하는 필드입니다.

  public Customer(int id, double arrivalTime, double serviceTime) {
    // 생성자: Customer 객체를 만들 때 호출되는 메서드입니다.
    this.id = id; // 고객의 고유 ID를 설정합니다.
    this.arrivalTime = arrivalTime; // 고객의 도착 시간을 설정합니다.
    this.serviceTime = serviceTime; // 고객의 서비스 시간을 설정합니다.
  }

  public int getId() {
    // 고객의 ID를 반환하는 메서드입니다.
    return id;
  }

  public double getServiceTime() {
    // 고객이 서비스를 받는 데 걸리는 시간을 반환하는 메서드입니다.
    return serviceTime;
  }

  public boolean canBeServed(double time) {
    // 이 메서드는 특정 시간이 주어졌을 때, 고객이 서비스를 받을 수 있는지를 확인합니다.
    // 고객의 도착 시간이 주어진 시간보다 같거나 빠르면 서비스를 받을 수 있습니다.
    return this.arrivalTime <= time;
  }

  public double getArrivalTime() {
    // 고객의 도착 시간을 반환하는 메서드입니다.
    return this.arrivalTime;
  }

  public double serveTill(double serviceTime) {
    // 이 메서드는 고객이 서비스를 언제까지 받을지를 계산하는 메서드입니다.
    // 도착 시간과 서비스 시간을 더하여 반환합니다.
    return this.arrivalTime + serviceTime;
  }

  @Override
  public String toString() {
    // toString 메서드는 고객 객체를 사람이 읽을 수 있는 문자열로 변환합니다.
    return "customer " + id;
  }
}