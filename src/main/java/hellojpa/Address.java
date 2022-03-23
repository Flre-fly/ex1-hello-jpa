package hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipcode;
    private String street;
    private String city;
}
