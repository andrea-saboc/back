package com.example.isa.model;

import jdk.jfr.Name;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @SequenceGenerator(name = "address_sequence_generator", sequenceName = "address_sequence", initialValue = 100)
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence_generator")
    private Integer id;

    public String address;
    public String city;
    public  String country;
    public String latitude;
    public String longitude;

   // @OneToOne(mappedBy = "Address")
   // @JoinColumn(nullable = true)
    //public Boat boat;

    public Address(){}

    public Address(String address, String city, String country, String latitude, String longitude) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Address(String s, String novi_sad, String srbija) {
        address = s;
        country = srbija;
        city = novi_sad;
        latitude = "2.33";
        longitude = "44.77";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  /*  public Boat getBoat() {
        return boat;
    }*/

  /*  public void setBoat(Boat boat) {
        this.boat = boat;
    }*/
}
