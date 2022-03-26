package MainApp.models.Models.Exception;

public class FieldNotFoundException extends Exception {
    public FieldNotFoundException() {
        super("Field not found");
    }
}
