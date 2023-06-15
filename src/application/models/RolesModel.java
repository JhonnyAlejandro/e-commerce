
package application.models;

public class RolesModel {

    private int idRoles;
    private String nameRol;

    public RolesModel(int idRoles, String nameRol) {
        this.idRoles = idRoles;
        this.nameRol = nameRol;
    }

    public RolesModel() {

    }

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
}
