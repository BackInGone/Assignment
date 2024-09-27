package org.example;

public class Server {
  private final int id;  // 서버의 고유 ID (서버를 구분하기 위해 사용)
  private double availableTime;  // 서버가 언제 다음 고객을 받을 수 있는지 기록하는 변수

  // 생성자: 서버의 ID를 설정하고, 서버의 초기 가용 시간을 0으로 설정합니다.
  public Server(int id) {
    this.id = id;
    this.availableTime = 0.0;  // 처음에는 서버가 항상 가용 상태이므로, 0.0으로 초기화
  }

  // 고객을 서비스하고, 서버의 다음 가용 시간을 업데이트하는 메소드
  public Server serve(Customer customer, double serviceTime) {
    this.availableTime = customer.serveTill(serviceTime);
    System.out.println("server " + this.id + " serves customer " + customer);
    return this;
  }

  // 주어진 고객의 도착 시간이 서버의 가용 시간보다 같거나 크다면, 서버는 해당 고객을 받을 수 있음
  public boolean canServe(Customer customer) {
    return this.availableTime <= customer.getArrivalTime();
  }

  // 서버의 ID를 반환
  public int getId() {
    return this.id;
  }

  // 서버의 상태(다음 가용 시간 포함)를 문자열로 반환
  @Override
  public String toString() {
    return "server " + this.id + " (next available at " + this.availableTime + ")";
  }
}
