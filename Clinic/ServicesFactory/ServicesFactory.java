package ServicesFactory;

public class ServicesFactory extends Application{

    @Override
    public
    Service createService(String type) {
        if (type.equals("Checkup"))
            return new CheckUp();
        else if (type.equals("Vaccination"))
            return new Vaccination();
        else if (type.equals("Physical Test"))
            return new PhysicalTest();
        else
            return null;
    }
}
