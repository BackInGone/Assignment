package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static final double SERVICE_TIME = 1.0;
  public static void main(String[] args) {

    //todo level1
  /*  // 고객 생성
    Customer customer1 = new Customer(1, 0.5);
    Customer customer2 = new Customer(2, 1.0);

    // 고객 도착 시간 및 서비스 가능 여부 체크
    System.out.println("Customer 1 Arrival: " + customer1.getArrivalTime());
    System.out.println("Customer 2 Arrival: " + customer2.getArrivalTime());
    System.out.println("Can Customer 1 be served at 0.5? " + customer1.canBeServed(0.5));  // true
    System.out.println("Can Customer 2 be served at 1.5? " + customer2.canBeServed(1.5));  // true
    System.out.println("Can Customer 2 be served at 0.5? " + customer2.canBeServed(0.5));  // false

    // 서비스 종료 시간 계산
    System.out.println("Customer 1 serve till: " + customer1.serveTill(1.0));  // 1.5
    System.out.println("Customer 2 serve till: " + customer2.serveTill(1.0));  // 2.0*/


    //todo Level2
/*
    // 서버와 고객 생성
    Server server1 = new Server(1);
    Customer customer1 = new Customer(1, 0.5);
    Customer customer2 = new Customer(2, 1.0);

    // 서버가 고객을 서비스할 수 있는지 확인
    System.out.println("Can server 1 serve customer 1? " + server1.canServe(customer1));  // true
    server1.serve(customer1, 1.0);  // 서비스 시간 1.0
    System.out.println("Server 1: " + server1);  // 다음 가능 시간 1.5

    System.out.println("Can server 1 serve customer 2? " + server1.canServe(customer2));  // false

*/


    //todo Level3
    // 상점과 고객 생성
/*    Shop shop = new Shop(2);
    Customer customer1 = new Customer(1, 0.5);
    Customer customer2 = new Customer(2, 1.0);
    Customer customer3 = new Customer(3, 1.5);

    // 서버 찾기
    Optional<Server> server1 = shop.findServer(customer1);
    Optional<Server> server2 = shop.findServer(customer2);
    Optional<Server> server3 = shop.findServer(customer3);

    // 첫 번째 고객 서비스
    server1.ifPresent(s -> shop.update(s.serve(customer1, 1.0)));
    server2.ifPresent(s -> shop.update(s.serve(customer2, 1.0)));

    // 상점 상태 출력
    System.out.println("Shop status: " + shop);

    // 세 번째 고객 처리 여부 확인
    System.out.println("Can serve customer 3? " + (server3.isPresent() ? "Yes" : "No"));*/


    //todo LeveL4
    // 고객 도착 리스트 생성 (ID, 도착 시간)
  /*  Scanner sc = new Scanner(System.in);

    // 입력 받기: 서버 수와 고객 수
    int numOfServers = sc.nextInt();
    int numOfCustomers = sc.nextInt();
    sc.nextLine();  // 개행 문자 제거

    // 고객 도착 시간 입력받기
    List<Pair<Integer, Double>> arrivals = new ArrayList<>();
    for (int i = 0; i < numOfCustomers; i++) {
      int id = sc.nextInt();
      double arrivalTime = sc.nextDouble();
      arrivals.add(new Pair<>(id, arrivalTime));
    }

    // 서비스 시간 설정
    double serviceTime = 1.0;

    // 시뮬레이터 실행
    Simulator simulator = new Simulator(numOfServers, numOfCustomers, arrivals, serviceTime);
    State finalState = simulator.run();

    // 결과 출력
    System.out.println(finalState);*/



    //todo 최종 버전
    java.util.Scanner sc = new java.util.Scanner(System.in);

    // 먼저 서버의 수와 고객의 수를 입력받습니다.
    int numOfServers = sc.nextInt();  // 서버의 개수를 입력받습니다.
    int numOfCustomers = sc.nextInt();  // 고객의 수를 입력받습니다.

    sc.nextLine();  // 입력 버퍼에 남아 있는 개행 문자를 제거합니다.

    // 고객의 ID와 도착 시간을 저장하는 리스트입니다.
    List<Pair<Integer, Double>> arrivals = sc.useDelimiter("\n")
        .tokens()  // 각 입력 줄을 스트림으로 가져옵니다.
        .map(line -> {
          // 각 줄을 공백으로 나눈 후, 각각 ID와 도착 시간으로 변환합니다.
          List<String> token = java.util.stream.Stream.of(line.split(" ")).toList();
          return new Pair<>(Integer.parseInt(token.get(0)), Double.parseDouble(token.get(1)));
        }).toList();  // 처리된 모든 쌍을 리스트로 변환합니다.

    // 시뮬레이터를 실행하여 결과 상태를 받아옵니다.
    State state = new Simulator(numOfServers, numOfCustomers, arrivals, SERVICE_TIME).run();

    // 결과를 출력합니다. 시뮬레이션 로그가 출력됩니다.
    System.out.println(state);
  }
}