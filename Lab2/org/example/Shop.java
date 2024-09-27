package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop {
  private final List<Server> servers;  // 상점에 있는 서버들을 저장하는 리스트

  // 생성자: 주어진 서버의 수만큼 서버 객체를 생성하고 리스트에 추가합니다.
  public Shop(int numOfServers) {
    this.servers = new ArrayList<>();
    for (int i = 1; i <= numOfServers; i++) {
      this.servers.add(new Server(i));  // 각 서버는 ID 1부터 시작하여 순차적으로 추가
    }
  }

  // 주어진 고객을 처리할 수 있는 첫 번째 서버를 찾는 메소드
  public Optional<Server> findServer(Customer customer) {
    for (Server server : servers) {
      if (server.canServe(customer)) {
        return Optional.of(server);  // 서비스 가능한 서버를 찾으면 반환
      }
    }
    return Optional.empty();  // 서비스 가능한 서버가 없으면 비어 있는 Optional 반환
  }

  // 서버 상태를 업데이트하는 메소드
  public Shop update(Server updatedServer) {
    for (int i = 0; i < servers.size(); i++) {
      if (servers.get(i).getId() == updatedServer.getId()) {
        servers.set(i, updatedServer);  // 해당 서버의 상태를 업데이트
        break;
      }
    }
    return this;  // 현재 상점 객체를 반환 (상태가 업데이트된 상점)
  }

  // 상점의 서버 상태를 문자열로 반환 (서버들의 리스트 출력)
  @Override
  public String toString() {
    return servers.toString();
  }
}
