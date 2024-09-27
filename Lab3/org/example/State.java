package org.example;

import java.util.Optional;
import java.util.*;

public class State {
  private final PQ<Event> events;
  private final Shop shop;
  private final List<String> eventLog;



  public State(PQ<Event> events, Shop shop) {
    this.events = events;
    this.shop = shop;
    this.eventLog = new ArrayList<>();

  }

  public State next() {
    Pair<Optional<Event>, PQ<Event>> eventAndRest = events.poll();
    Optional<Event> event = eventAndRest.t();
    PQ<Event> rest = eventAndRest.u();

    if (event.isEmpty()) {

      return this;
    }

    Event currentEvent = event.get();

    eventLog.add(currentEvent.toString());

    Pair<Optional<Event>, Shop> nextAndShop = currentEvent.next(shop);
    Optional<Event> nextEvent = nextAndShop.t();
    Shop nextShop = nextAndShop.u();

    PQ<Event> nextEvents = rest;
    if (nextEvent.isPresent()) {
      nextEvents = nextEvents.add(nextEvent.get());
    }

    State newState = new State(nextEvents, nextShop);
    newState.eventLog.addAll(this.eventLog);
    return newState;
  }

  public boolean isEmpty() {
    return events.isEmpty();
  }

  @Override
  public String toString() {
    return String.join("\n", eventLog);
  }
}
