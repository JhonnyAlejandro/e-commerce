/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.models;

public class ProviderModel {
   
    private int id;
    private String FirstName;
    private String lastName;
    private String address;
    private int city;
    private String department;
    private String phone;
    private String email;
    private CityModel cityModel;
    private int state;

    public ProviderModel(int id, String FirstName, String lastName, String address, int city, String department, String phone, String email, CityModel cityModel, int state) {
        this.id = id;
        this.FirstName = FirstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.department = department;
        this.phone = phone;
        this.email = email;
        this.cityModel = cityModel;
        this.state = state;
    }
   

   
    
    public ProviderModel() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public CityModel getCityModel() {
        return cityModel;
    }

    public void setCityModel(CityModel cityModel) {
        this.cityModel = cityModel;
    }
    
    
   
}


