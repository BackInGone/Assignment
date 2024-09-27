package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Shop {
  private final List<Server> servers;

  public Shop(int numOfServers) {
    this.servers = IntStream.rangeClosed(1, numOfServers)
        .mapToObj(Server::new)
        .collect(Collectors.toList());
  }

  public Optional<Server> getAvailableServer(Customer customer) {
    return servers.stream()
        .filter(server -> server.canServe(customer))
        .findFirst();
  }

  public Shop update(Server updatedServer) {
    List<Server> newServers = servers.stream()
        .map(server -> server.getId() == updatedServer.getId() ? updatedServer : server)
        .collect(Collectors.toList());
    Shop newShop = new Shop(servers.size());
    newShop.servers.clear();
    newShop.servers.addAll(newServers);
    return newShop;
  }

  @Override
  public String toString() {
    return servers.stream()
        .map(Server::toString)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}