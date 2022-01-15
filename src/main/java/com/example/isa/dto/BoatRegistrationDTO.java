package com.example.isa.dto;

import com.example.isa.model.Address;
import com.example.isa.model.Boat;
import com.example.isa.model.reservations.AdditionalService;

import java.util.List;
import java.util.Set;

public class BoatRegistrationDTO {
    public String name;
    public String type;
    public String cancellationPolicy;
    public double length;
    public int numberOfEngines;
    public double enginePower;
    public double maxSpeed;
    public boolean GPS;
    public boolean radar;
    public boolean VHFradio;
    public boolean fishfinder;
    public double pricePerHour;
    public double pricePerDay;
    public double priceForSevenDays;
    public String address;
    public String city;
    public String country;
    public String longitude;
    public String latitude;
    public String promoDescription;
    public Set<String> InteriorImages;
    public Set<String> ExteriorImages;
    public int capacity;
    public Set<String> rules;
    public Set<AdditionalService> additionalServices;

    public BoatRegistrationDTO(){}

    public BoatRegistrationDTO(String name, String type, String cancellationPolicy, double length, int numberOfEngines, double enginePower, double maxSpeed, boolean GPS, boolean radar, boolean VHFradio, boolean fishfinder, double pricePerHour, double pricePerDay, double priceForSevenDays, String address, String city, String country, String longitude, String latitude, String promoDescription, Set<String> interiorImages, Set<String> exteriorImages, int capacity, Set<String> rules) {
        this.name = name;
        this.type = type;
        this.cancellationPolicy = cancellationPolicy;
        this.length = length;
        this.numberOfEngines = numberOfEngines;
        this.enginePower = enginePower;
        this.maxSpeed = maxSpeed;
        this.GPS = GPS;
        this.radar = radar;
        this.VHFradio = VHFradio;
        this.fishfinder = fishfinder;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.priceForSevenDays = priceForSevenDays;
        this.address = address;
        this.city = city;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.promoDescription = promoDescription;
        InteriorImages = interiorImages;
        ExteriorImages = exteriorImages;
        this.capacity = capacity;
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "BoatRegistrationDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cancellationPolicy='" + cancellationPolicy + '\'' +
                ", length=" + length +
                ", numberOfEngines=" + numberOfEngines +
                ", enginePower=" + enginePower +
                ", maxSpeed=" + maxSpeed +
                ", GPS=" + GPS +
                ", radar=" + radar +
                ", VHFradio=" + VHFradio +
                ", fishfinder=" + fishfinder +
                ", pricePerHour=" + pricePerHour +
                ", pricePerDay=" + pricePerDay +
                ", priceForSevenDays=" + priceForSevenDays +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", promoDescription='" + promoDescription + '\'' +
                ", InteriorImages=" + InteriorImages +
                ", ExteriorImages=" + ExteriorImages +
                ", capacity=" + capacity +
                ", rules=" + rules +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isGPS() {
        return GPS;
    }

    public void setGPS(boolean GPS) {
        this.GPS = GPS;
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }

    public boolean isVHFradio() {
        return VHFradio;
    }

    public void setVHFradio(boolean VHFradio) {
        this.VHFradio = VHFradio;
    }

    public boolean isFishfinder() {
        return fishfinder;
    }

    public void setFishfinder(boolean fishfinder) {
        this.fishfinder = fishfinder;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public Set<String> getInteriorImages() {
        return InteriorImages;
    }

    public void setInteriorImages(Set<String> interiorImages) {
        InteriorImages = interiorImages;
    }

    public Set<String> getExteriorImages() {
        return ExteriorImages;
    }

    public void setExteriorImages(Set<String> exteriorImages) {
        ExteriorImages = exteriorImages;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<String> getRules() {
        return rules;
    }

    public void setRules(Set<String> rules) {
        this.rules = rules;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPriceForSevenDays() {
        return priceForSevenDays;
    }

    public void setPriceForSevenDays(double priceForSevenDays) {
        this.priceForSevenDays = priceForSevenDays;
    }
}
