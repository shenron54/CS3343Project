package ServicesFactory;

public class Vaccination implements Service {

    @Override
    public String getName() {
        return "Vaccination";
    }

    @Override
    public int getPrice() {
        return 100;
    }
    
    @Override
    public String toString() {
        return getName().toString();
    }
}
