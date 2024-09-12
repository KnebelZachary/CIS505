package Module_3.CustomerAccountApp;

public class CustomerDB {
    
    public static Customer getCustomer(int id) {
        if (id == 1007) {
            return new Customer("Tony Stark", "10880 Malibu Point", "Malibu", "90265");
        } else if (id == 1008) {
            return new Customer("Steve Rogers", "569 Leaman Place", "Brooklyn", "11201");
        } else if (id == 1009) {
            return new Customer("Peter Parker", "20 Ingram Street", "Queens", "11375");
        } else {
            return new Customer();
        }
    }
}
