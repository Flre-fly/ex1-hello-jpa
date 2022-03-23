package hellojpa;

import javax.persistence.Embeddable;
import java.io.ObjectStreamClass;
import java.util.Objects;

@Embeddable
public class Address {
    private String zipcode;
    private String street;
    private String city;

    public Address(){

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipcode, address.zipcode);
    }

    public Address(String zipcode, String street, String city){
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
