package application.models;

public class UsersModel extends RolesModel{

    private int idUsers;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int city;
    private String department;
    private String phone;
    private int state;
    private char[] password;
    private int rol;
    private CityModel cityModel; //composicion 


    //private String dateCreate;
    //private String dateUpdate;
    public UsersModel(int idUsers, String firstName, String lastName, String email, String adress, int city,
            String department, String phone, int state, char[] password, int rol, int idRoles, String nameRol,
            CityModel cityModel) {
        super(idRoles, nameRol);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = adress;
        this.city = city;
        this.department = department;
        this.phone = phone;
        this.state = state;
        this.password = password;
        this.rol = rol;
        this.cityModel = cityModel;
    }

    public UsersModel() {

    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

     public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    public CityModel getCityModel() {
        return cityModel;
    }

    public void setCityModel(CityModel cityModel) {
        this.cityModel = cityModel;
    }
}

