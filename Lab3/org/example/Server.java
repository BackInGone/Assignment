package org.example;

public class Server {

  private final int id;             // 서버의 고유 ID
  private double availableTime;     // 서버가 다음 고객을 받을 수 있는 시간

  // 생성자: 서버의 ID를 받아 초기화, 초기 availableTime은 0.0
  public Server(int id) {
    this.id = id;
    this.availableTime = 0.0;     // 모든 서버는 처음엔 이용 가능
  }

  // 고객을 처리하고, 서비스 종료 시간(availableTime)을 갱신
  public Server serve(Customer customer) {
    // 서비스 종료 시간을 계산: 고객 도착 시간 + 서비스 시간
//    this.availableTime = customer.serveTill(serviceTime);
    this.availableTime = customer.getArrivalTime() + customer.getServiceTime();

//    System.out.println("server " + this.id + " serves customer " + customer);
    return this;  // 업데이트된 서버 반환
  }

  // 고객을 서비스할 수 있는지 확인
  public boolean canServe(Customer customer) {
    // 현재 서버가 이용 가능한 시간 >= 고객 도착 시간
    return this.availableTime <= customer.getArrivalTime();
  }

  public int getId() {
    return this.id;
  }

  // 서버의 상태를 문자열로 출력하는 toString 메서드
  @Override
  public String toString() {
    return "server " + this.id + " (next available at " + this.availableTime + ")";
  }
}
