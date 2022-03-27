package MainApp.test;

import MainApp.App;
import MainApp.models.Models.Exception.FieldNotFoundException;
import MainApp.models.Models.Exception.ObjectNotFoundException;
import MainApp.models.Models.UserModels.Airline;
import MainApp.models.Models.UserModels.Plane;

import org.junit.*;

public class AppTest {
    @Test
    public void testSave() {
        new App();
        var airline = new Airline();
        airline.name.rawData = "AirOne";
        airline.save();
        var plane = new Plane();
        plane.type.rawData = "PlaneOne";
        plane.airline.rawData = airline.id;
        plane.save();
    }
    @Test
    public void testGetAndSet() {
        new App();
        try {
            var airline = (Airline) Airline.getById(Airline.class, 1);
            airline.name.rawData = "AirTwo";
            airline.save();
            var plane = Plane.queryByProperty(Plane.class, "type", "PlaneOne").toArray();
            System.out.println(plane);
        } catch (ObjectNotFoundException | FieldNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}