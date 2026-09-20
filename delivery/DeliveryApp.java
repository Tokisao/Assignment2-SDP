package delivery;

import abstractfactory.*;
import factorymethod.*;

public class DeliveryApp {
    private final Button button;
    private final Checkbox checkbox;
    private final Logistics logistics;

    //constructor injection
    public DeliveryApp(GUIFactory guiFactory, Logistics logistics) {
        this.button = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
        this.logistics = logistics;
    }

    public void run(String cargo, String destination) {
        button.paint();
        checkbox.paint();
        logistics.planDelivery(cargo, destination);
    }
}
