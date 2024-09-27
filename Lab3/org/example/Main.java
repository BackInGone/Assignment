package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    // 메인 메서드는 프로그램의 시작점입니다.
    // 여기서 사용자는 서버와 고객의 수를 입력하고 시뮬레이션을 시작합니다.

    Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 스캐너 객체 생성.
    int numOfServers = sc.nextInt(); // 서버의 수를 입력받습니다.
    int numOfCustomers = sc.nextInt(); // 고객의 수를 입력받습니다.
    sc.nextLine(); // 남아있는 줄바꿈 문자를 제거합니다.

    // 고객의 도착 정보와 서비스 시간을 입력받아 Pair 리스트로 저장합니다.
    List<Pair<Integer, Pair<Double, Double>>> arrivals = sc.useDelimiter("\n")
        .tokens()
        .map(line -> {
          // 각 줄을 공백으로 나눈 후, 첫 번째 값은 고객 ID, 두 번째 값은 도착 시간, 세 번째 값은 서비스 시간으로 처리합니다.
          List<String> token = Stream.of(line.split(" ")).toList();
          return new Pair<Integer, Pair<Double, Double>>(
              Integer.parseInt(token.get(0)),
              new Pair<Double, Double>(
                  Double.parseDouble(token.get(1)),
                  Double.parseDouble(token.get(2))
              )
          );
        }).toList();

    // 시뮬레이터 객체를 생성하여 실행하고 결과를 출력합니다.
    State state = new Simulator(numOfServers, numOfCustomers, arrivals).run();
    System.out.println(state);
  }
}