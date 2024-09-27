package org.example;

import java.util.Optional;

public class State {
  private final Shop shop;  // 현재 상점 상태 (서버 목록 포함)
  private final Customer customer;  // 현재 처리 중인 고객 (현재 상태에 포함된 고객)
  private final String log;  // 현재까지의 모든 시뮬레이션 기록을 저장하는 문자열

  // 생성자: 고객이 없는 초기 상태를 생성합니다.
  public State(Shop shop) {
    this.shop = shop;
    this.customer = null;
    this.log = "";  // 초기 상태의 로그는 빈 문자열
  }

  private State(Shop shop, String log) {
    this.shop = shop;
    this.customer = null;  // 현재 고객은 없음
    this.log = log;
  }
  // 고객이 도착한 상태로 초기화하는 생성자
  public State(Shop shop, Customer customer) {
    this.shop = shop;
    this.customer = customer;
    this.log = "customer " + customer.getId() + " arrives\n";  // 고객 도착 로그 추가
  }


  // 다음 상태로 전이하는 메소드
  public State next(State newState) {
    Customer customer = newState.customer;  // 새로 도착한 고객
    Shop updatedShop = newState.shop;  // 업데이트될 상점
    String updatedLog = this.log + "customer " + customer.getId() + " arrives\n";  // 로그 업데이트


    // 고객을 서비스할 수 있는 서버 찾기
    Optional<Server> serverOpt = updatedShop.findServer(customer);


    // 서버가 존재하면 고객을 서비스하고 로그 추가
    if (serverOpt.isPresent()) {
      Server server = serverOpt.get().serve(customer, 1.0);  // 고객 서비스
      updatedShop = updatedShop.update(server);  // 서버 상태 업데이트
      updatedLog += "customer " + customer.getId() + " served by server " + server.getId() + "\n";
    } else {
      updatedLog += "customer " + customer.getId() + " leaves\n";  // 서버가 없으면 고객이 떠남
    }

    return new State(updatedShop, updatedLog);  // 다음 상태 반환
  }


  // 로그를 출력하는 메소드
  @Override
  public String toString() {
    return this.log.trim();  // 로그의 앞뒤 공백을 제거하고 반환
  }
}
