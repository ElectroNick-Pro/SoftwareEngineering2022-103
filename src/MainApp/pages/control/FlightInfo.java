package MainApp.pages.control;

import MainApp.GlobalData;
import MainApp.models.Model.Exception.*;
import MainApp.models.Model.UserModel.*;
import java.util.*;

public class FlightInfo {
    public Ticket ticket;
    public Flight flight;
    public Airline airline;
    public List<Interval> interval;
    public static Map<Integer, FlightInfo> getInfoMap(int id) {
        try {
            var customer = Customer.getById(Customer.class, id);
            var tickets = Ticket.queryByProperty(Ticket.class, "Customer_id", customer.id).toArray();
            var tuples = new HashMap<Integer, FlightInfo>();
            for(int i = 0; i < tickets.length; i++) {
                var info = new FlightInfo();
                info.ticket = (Ticket)tickets[i];
                info.flight = (Flight)info.ticket.flight.getReferred();
                info.airline = (Airline)((Plane)info.flight.plane.getReferred()).airline.getReferred();
                var arr = Interval.queryByProperty(Interval.class, "Flight_id", info.flight.id).toArray();
                info.interval = new ArrayList<>();
                for(int j = 0; j < arr.length; j++) {
                    var interval = (Interval)arr[j];
                    info.interval.add(interval);
                }
                tuples.put(info.ticket.id, info);
            }
            GlobalData.data.put("flightInfoMap", tuples);
            return tuples;
        } catch (FieldNotFoundException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Map<Integer, FlightInfo> getTicketInfoMap(int id){
        try {
            var ticket = Ticket.getById(Ticket.class,id);
            var tuples = new HashMap<Integer, FlightInfo>();
            var info = new FlightInfo();
            info.ticket = (Ticket)ticket;
            info.flight = (Flight)info.ticket.flight.getReferred();
            info.airline = (Airline)((Plane)info.flight.plane.getReferred()).airline.getReferred();
            var arr = Interval.queryByProperty(Interval.class, "Flight_id", info.flight.id).toArray();
            info.interval = new ArrayList<>();
            for(int j = 0; j < arr.length; j++) {
                var interval = (Interval)arr[j];
                info.interval.add(interval);
            }
            tuples.put(info.ticket.id, info);
            GlobalData.data.put("flightInfoMap", tuples);
            return tuples;
        } catch (FieldNotFoundException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
