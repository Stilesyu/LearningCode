//package designPattern.build;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.experimental.Accessors;
//
//import java.util.Calendar;
//
///**
// * @author Stiles yu
// * @since 1.0
// */
//@Data
//@Accessors(chain = true)
//@Builder
//public class Car {
//    private Integer seats;
//    private String engine;
//    private String trip;
//    private String GPS;
//    private String brake;
//    private String seatBelt;
//    private String HVAC;
//    private String wheel;
//    private String fender;
//    private String sparkPlug;
//    private String cacheMode;
//
//    public Car(Integer seats, String engine, String GPS, String wheel,String fender ) {
//
//    }
//
//
//
//
//    //    public Car(Integer seats, String engine, String trip, String GPS, String brake, String seatBelt, String HVAC, String wheel, String fender, String sparkPlug) {
////        this.seats = seats;
////        this.engine = engine;
////        this.trip = trip;
////        this.GPS = GPS;
////        this.brake = brake;
////        this.seatBelt = seatBelt;
////        this.HVAC = HVAC;
////        this.wheel = wheel;
////        this.fender = fender;
////        this.sparkPlug = sparkPlug;
////    }
//
//    public static void main(String[] args) {
//        Car car = Car.builder()
//                .seats(4)
//                .engine("XX engine")
//                .trip("XX trip")
//                .GPS("XXX GPS")
//                .brake("XXX brake")
//                .seatBelt("xxx seatBelt")
//                .HVAC("XXX HVAC")
//                .wheel("XXX wheel")
//                .fender("xxx fender")
//                .sparkPlug("xxx sparkPlug")
//                .build();
//        car.setCacheMode("remote");
//    }
//
//
//}
