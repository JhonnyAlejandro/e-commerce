package application.models;


public class CityModel extends DepartmentModel {
    private  int idCity;
    private String nameCity;
    private int stateCity;
    private  int departmentId;

    public CityModel(int idCity, String nameCity, int stateCity, int departmentId, int idDepartment, String nameDepartment) {
        super( idDepartment, nameDepartment);
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.stateCity = stateCity; 
        this.departmentId = departmentId;
    }

   
    public CityModel() {
        
    }
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getStateCity() {
        return stateCity;
    }

    public void setStateCity(int stateCity) {
        this.stateCity = stateCity;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    
    
}