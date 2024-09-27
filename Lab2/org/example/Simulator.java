package org.example;

import java.util.List;

public class Simulator {
  private final int numOfServers;  // 서버의 수
  private final int numOfCustomers;  // 고객의 수
  private final List<Pair<Integer, Double>> arrivals;  // 고객의 도착 정보 (ID, 도착 시간 쌍으로 저장)
  private final double serviceTime;  // 서비스 시간 (모든 고객의 서비스 시간이 동일하다고 가정)

  // 생성자: 서버 수, 고객 수, 고객의 도착 시간 목록, 서비스 시간을 받아서 시뮬레이터 객체를 초기화
  Simulator(int numOfServers, int numOfCustomers, List<Pair<Integer, Double>> arrivals, double serviceTime) {
    this.numOfServers = numOfServers;
    this.numOfCustomers = numOfCustomers;
    this.arrivals = arrivals;
    this.serviceTime = serviceTime;
  }

  // 시뮬레이션을 실행하고, 고객들이 어떻게 서비스되었는지를 나타내는 상태를 반환하는 메소드
  State run() {
    Shop shop = new Shop(numOfServers);  // 주어진 서버 수로 상점 생성
    State state = new State(shop);  // 초기 상태 설정 (비어 있는 상점)

    // 고객들의 도착 시간을 순차적으로 처리
    for (Pair<Integer, Double> arrival : arrivals) {
      Customer customer = new Customer(arrival.t(), arrival.u());  // 고객 생성
      state = state.next(new State(shop, customer));  // 새로운 상태로 시뮬레이션 진행
    }
    return state;  // 최종 상태 반환
  }
}
