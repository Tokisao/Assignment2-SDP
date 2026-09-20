package delivery;
import abstractfactory.*;
import factorymethod.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Delivery mode (ROAD / SEA): ");
        String deliveryInput = scanner.nextLine().trim().toUpperCase();

        System.out.print("UI platform (WINDOWS / MACOS): ");
        String platformInput = scanner.nextLine().trim().toUpperCase();

        Logistics logistics = null;
        switch (deliveryInput) {
            case "ROAD":
                logistics = new RoadLogistics();
                break;
            case "SEA":
                logistics = new SeaLogistics();
                break;
            default:
                System.err.println("Error: Unsupported delivery mode! Clean stop.");
                return; //safe termination without using default values
        }

        GUIFactory factory = null;
        switch (platformInput) {
            case "WINDOWS":
                factory = new WindowsFactory();
                break;
            case "MACOS":
                factory = new MacOSFactory();
                break;
            default:
                System.err.println("Error: Unsupported UI platform! Clean stop.");
                return; //safe shutdown
        }

        DeliveryApp app = new DeliveryApp(factory, logistics);
        app.run("laboratory equipment", "Aktau");
    }
}
