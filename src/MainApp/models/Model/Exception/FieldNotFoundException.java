package MainApp.models.Model.Exception;

public class FieldNotFoundException extends Exception {
    public FieldNotFoundException() {
        super("Field not found");
    }
}
