package factorymethod;

public abstract class Logistics {
    //factory method
    public abstract Transport createTransport();

    //shared workflow
    public void planDelivery(String cargo, String destination) {
        Transport transport = createTransport();
        transport.deliver(cargo, destination);
    }
}