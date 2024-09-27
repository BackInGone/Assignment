package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static List<Booking> findBestBooking(Request request, List<Driver> drivers) {
    List<Booking> bookings = new ArrayList<>();
    for (Driver driver : drivers) {
      Service[] availableServices = driver.getAvailableServices();  // 모든 서비스에 대한 예약 생성
      for (Service service : availableServices) {
        bookings.add(new Booking(driver, request, service));  // 각 서비스에 대한 예약 추가
      }
    }
    Collections.sort(bookings);  // 요금 및 대기시간 기준으로 정렬
    return bookings;
  }
  public static void main(String[] args) {
    Request request = new Request(20, 3, 1000);
    List<Driver> drivers = new ArrayList<>();
    drivers.add(new NormalCab("SHA1234", 5));
    drivers.add(new PrivateCar("SMA7890", 10));

    List<Booking> bestBookings = findBestBooking(request, drivers);
    for (Booking booking : bestBookings) {
      System.out.println(booking);
    }

    Request anotherRequest = new Request(10, 1, 900);
//    drivers.add(new NormalCab("SHA1234", 5));
//    drivers.add(new PrivateCar("SMA7890", 10));

    List<Booking> anotherBookings = findBestBooking(anotherRequest, drivers);
    for (Booking booking : anotherBookings) {
      System.out.println(booking);
    }
    }
  }


