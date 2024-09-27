package org.example;

import java.util.List;
import java.util.stream.Stream;

public class Simulator {
  private final int numOfServers;
  private final int numOfCustomers;
  private final List<Pair<Integer, Pair<Double, Double>>> arrivals;

  public Simulator(int numOfServers, int numOfCustomers, List<Pair<Integer, Pair<Double, Double>>> arrivals) {
    this.numOfServers = numOfServers;
    this.numOfCustomers = numOfCustomers;
    this.arrivals = arrivals;
  }

  public State run() {
    PQ<Event> initialEvents = new PQ<Event>();
    for (Pair<Integer, Pair<Double, Double>> arrival : arrivals) {
      int id = arrival.t();
      double arrivalTime = arrival.u().t();
      double serviceTime = arrival.u().u();
      Customer customer = new Customer(id, arrivalTime, serviceTime);
      initialEvents = initialEvents.add(new ArriveEvent(customer, arrivalTime));
    }

    Shop shop = new Shop(numOfServers);
    State initialState = new State(initialEvents, shop);


    return Stream.iterate(initialState, state -> !state.isEmpty(), State::next)
        .reduce((first, second) -> second)
        .orElse(initialState);
  }
}