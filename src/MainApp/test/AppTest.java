package MainApp.test;

import MainApp.App;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.Airline;
import MainApp.models.Model.UserModel.Plane;

import org.junit.*;

public class AppTest {
    @Test
    public void testSave() {
        new App();
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
        new App();
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
}