package com.example.appfx;

public class Contact {
    private int id;
    private String raison;
    private String mail;

    public Contact(int id, String raison, String mail) {
        this.id = id;
        this.raison = raison;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getRaison() {
        return raison;
    }

    public String getMail() {
        return mail;
    }

}