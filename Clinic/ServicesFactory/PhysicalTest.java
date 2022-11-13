package ServicesFactory;

public class PhysicalTest implements Service {

    @Override
    public String getName() {
        return "Physical Testing";
        
    }

    @Override
    public int getPrice() {
        return 200;
        
    }

    @Override
    public String toString() {
        return getName().toString();
    }
    
}
