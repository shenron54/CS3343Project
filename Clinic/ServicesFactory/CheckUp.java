package ServicesFactory;

public class CheckUp implements Service{

    @Override
    public String getName() {
        return "CheckUp";       
    }

    @Override
    public int getPrice() {
        return 300;        
    }
    
    @Override
    public String toString() {
        return getName().toString();
    }
}
