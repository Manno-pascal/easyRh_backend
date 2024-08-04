package com.manno.easyrh.entity;

public class Worker {
    private int id;
    private String firstname;
    private String lastname;
    private String position;
    private String position_type;
    private String gender;
    private int age;
    private int warning;
    private String comment;
    private boolean isRqth;
    private int day_off;
    private String phone_number;
    private String email;
    private String address;
    private String city;
    private String country;
    private String zip;
    private boolean isCeo;
    private boolean isRh;

    public Worker(int id, String firstname, String lastname, String position, String position_type, String gender, int age, int warning, String comment, boolean isRqth, int day_off, String phone_number, String email, String address, String city, String country, String zip, boolean isCeo, boolean isRh) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.position_type = position_type;
        this.gender = gender;
        this.age = age;
        this.warning = warning;
        this.comment = comment;
        this.isRqth = isRqth;
        this.day_off = day_off;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.isCeo = isCeo;
        this.isRh = isRh;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionType() {
        return position_type;
    }

    public void setPositionType(String position_type) {
        this.position_type = position_type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isRqth() {
        return isRqth;
    }

    public void setRqth(boolean rqth) {
        isRqth = rqth;
    }

    public int getDayOff() {
        return day_off;
    }

    public void setDayOff(int day_off) {
        this.day_off = day_off;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isCeo() {
        return isCeo;
    }

    public void setCeo(boolean ceo) {
        isCeo = ceo;
    }

    public boolean isRh() {
        return isRh;
    }

    public void setRh(boolean rh) {
        isRh = rh;
    }
}
