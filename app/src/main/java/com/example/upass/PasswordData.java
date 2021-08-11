package com.example.upass;

public class PasswordData {

    private int id;
    private String email_id;
    private String password;
    private String url;

    //constructors

    PasswordData(int id, String email_id, String password, String url){

        this.id = id;
        this.email_id = email_id;
        this.password = password;
        this.url = url;

    }

    //to string

    @Override
    public String toString() {
        return
                " Email id  =  " + email_id +  "\n"+
                " Password  =  " + password + "\n"+
                " Url  =  " + url
                ;
    }

    //getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {return  url;}

    public void setUrl() {this.url = url;}


}
