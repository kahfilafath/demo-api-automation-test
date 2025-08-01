package com.demo.api.automation.model.response;

import lombok.Data;

import java.util.ArrayList;


@Data
public class GetCompaniesResponse {

    public String status;
    public int code;
    public String locale;
    public Object seed;
    public int total;
    public ArrayList<Datum> data;

    @Data
    public static class Address{
        public int id;
        public String street;
        public String streetName;
        public String buildingNumber;
        public String city;
        public String zipcode;
        public String country;
        public String country_code;
        public double latitude;
        public double longitude;
    }

    @Data
    public static class Address2{
        public int id;
        public String street;
        public String streetName;
        public String buildingNumber;
        public String city;
        public String zipcode;
        public String country;
        public String country_code;
        public double latitude;
        public double longitude;
    }

   @Data
    public static class Contact{
        public int id;
        public String firstname;
        public String lastname;
        public String email;
        public String phone;
        public String birthday;
        public String gender;
        public Address address;
        public String website;
        public String image;
    }

    @Data
    public static class Datum{
        public int id;
        public String name;
        public String email;
        public String vat;
        public String phone;
        public String country;
        public ArrayList<Address> addresses;
        public String website;
        public String image;
        public Contact contact;
    }

}
