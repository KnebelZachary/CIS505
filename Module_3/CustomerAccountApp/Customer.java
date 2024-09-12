package Module_3.CustomerAccountApp;

public class Customer {
    
    private String name;
    private String address;
    private String city;
    private String zip;

    public  Customer() {
    }

    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Customer Name: " + name + "\n" +
        "Address: " + address + "\n" +
        "City: " + city + "\n" +
        "Zip Code: " + zip;
    }
}
