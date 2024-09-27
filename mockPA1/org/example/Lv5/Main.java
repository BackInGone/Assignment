//package org.example.Lv5;
//
//import java.util.List;
//import org.example.Booking;
//
//public class Main {
//  public static List<Booking> findBestBooking(Request request, List<Driver> drivers) {
//    return drivers.stream()
//        .map(driver -> new Booking(driver, request))
//        .sorted()
//        .collect(Collectors.toList());
//  }
//
//  public static void main(String[] args) {
//    Request request = new Request(20, 3, 1000);
//    List<Driver> drivers = List.of(
//        new NormalCab("SHA1234", 5),
//        new PrivateCar("SMA7890", 10)
//    );
//
//    List<Booking> bestBookings = findBestBooking(request, drivers);
//    bestBookings.forEach(System.out::println);
//
//    // Another example
//    Request anotherRequest = new Request(10, 1, 900);
//    List<Booking> anotherBookings = findBestBooking(anotherRequest, drivers);
//    anotherBookings.forEach(System.out::println);
//  }
//}
