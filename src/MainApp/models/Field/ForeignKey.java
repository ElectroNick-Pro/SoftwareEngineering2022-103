package MainApp.models.Field;

import MainApp.models.Model.*;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.Exception.ValidationException;

public class ForeignKey extends BaseField {

    public Class<? extends BaseModel> foreignClz;

    public ForeignKey(Class<? extends BaseModel> foreignClz) {
        super(foreignClz.getSimpleName()+"_id");
        this.foreignClz = foreignClz;
    }

    public ForeignKey(Class<? extends BaseModel> foreignClz, String verbose) {
        super(verbose);
        this.foreignClz = foreignClz;
    }
    
    @Override
    public void save_field() {
        if(rawData == null) {
            csvForm = "";
            return;
        }
        csvForm = ((Integer)rawData).toString();
    }

    @Override
    public void validate_data() throws ValidationException {
        int id = (Integer)rawData;
        try {
            BaseModel.getById(foreignClz, id);
        } catch (ObjectNotFoundException e) {
            throw new ValidationException();
        }
    }

    @Override
    public void read_field() {
        rawData = csvForm.equals("") ? null : Integer.parseInt(csvForm);
    }

    public BaseModel getReferred() throws ObjectNotFoundException {
        return BaseModel.getById(foreignClz, (Integer)rawData);
    }

}
