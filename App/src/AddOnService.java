/**
 * =============================================================
 * CLASS - AddOnService
 * =============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * @version 7.0
 */
public class AddOnService {

    /** Name of the service */
    private String serviceName;

    /** Cost of the service */
    private double cost;

    /** Constructor */
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}