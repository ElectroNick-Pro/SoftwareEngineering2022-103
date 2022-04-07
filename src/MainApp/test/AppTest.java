package MainApp.test;

import MainApp.App;
import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.*;

import java.util.*;

import org.junit.*;

public class AppTest {
    @Test
    public void testSave() {
        new App(new String[0]);
        var airline = new Airline();
        airline.name.setValue("AirOne");
        airline.save();
        var plane = new Plane();
        plane.type.rawData = "PlaneOne";
        plane.airline.rawData = airline.id;
        plane.save();
    }
    @Test
    public void testGetAndSet() {
        new App(new String[0]);
        try {
            var airline = (Airline) Airline.getById(Airline.class, 1);
            airline.name.setValue("AirTwo");
            airline.save();
            var plane = Plane.queryByProperty(Plane.class, "type", "PlaneOne").toArray();
            var plane_set = Plane.queryByProperty(Plane.class, "Airline_id", airline.id);
            var planeArr = plane_set.toArray();
            System.out.println(plane);
        } catch (ObjectNotFoundException | FieldNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void testReadNull() {
        GlobalData.init(new String[0]);
        Models.init();
        try {
            var seatStream = Seat.queryByProperty(Seat.class, "Interval_id", 1).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var seats = seatStream.toArray();
            var seat = (Seat)seats[0];
            seat.ticket.setValue(1);
            seat.save();
            var inter = seat.interval.getReferred();
            System.out.println();
        } catch (FieldNotFoundException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFilter() {
        GlobalData.init(new String[0]);
        Models.init();
        try {
            var customers = Customer.queryByProperty(Customer.class, "customerId", "230103200102223218")
                            .filter((x)-> {
                                return x.surname.getValue().equals("Wang");
                            }).toArray();
            var tickets = Ticket.queryByProperty(Ticket.class, "Customer_id", ((Customer)customers[0]).id).toArray();
            var tuples = new HashMap<Integer, Info>();
            for(int i = 0; i < tickets.length; i++) {
                var info = new Info();
                info.ticket = (Ticket)tickets[i];
                info.flight = (Flight)info.ticket.flight.getReferred();
                var arr = Interval.queryByProperty(Interval.class, "Flight_id", info.flight.id).toArray();
                info.interval = new ArrayList<>();
                for(int j = 0; j < arr.length; j++) {
                    info.interval.add((Interval)arr[j]);
                }
                tuples.put(info.ticket.id, info);
            }
            GlobalData.data.put("flightinfo", tuples);
            var fi = (HashMap<Integer, Info>)GlobalData.data.get("flightinfo");
            var airport = (String)fi.get(2).interval.get(0).destAirport.getValue();
            System.out.println(airport);
        } catch (FieldNotFoundException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Info {
    public Ticket ticket;
    public Flight flight;
    public List<Interval> interval;
}