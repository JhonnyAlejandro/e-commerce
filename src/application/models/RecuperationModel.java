/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.models;

/**
 *
 * @author leidy
 */
public class RecuperationModel {
    
     static String emailFrom = "recuperacion.arcoiris@gmail.com";
    static String passwordFrom = "ypygwvkcbepwqbqb";
    private String emailTo;
    private String subject;
    private String content;
    
    public static String getEmailFrom() {
        return emailFrom;
    }

    public static String getPasswordFrom() {
        return passwordFrom;
    }
    
    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
