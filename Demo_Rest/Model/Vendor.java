package Demo_Rest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Namo_data")
public class Vendor {
    @Id
    private  int id;
    private  String name;
    private  String lname;
    private  String Address;

    public Vendor(){

    }


    public Vendor(int id, String name, String lname, String address) {
        this.id = id;
        this.name = name;
        this.lname = lname;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


}
