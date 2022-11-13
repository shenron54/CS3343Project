package ServicesFactory;

public abstract class Application {
    abstract Service createService(String type);

    public Service newService(String type){
        Service service = createService(type);
        return service;
    }
}