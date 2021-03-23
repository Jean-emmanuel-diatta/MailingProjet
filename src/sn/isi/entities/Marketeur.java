package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Marketeur implements Serializable {
    private int id;
    private String email;
    private String nom;
    private String password;
    //le constricteur sans argument
    public Marketeur() {

    }
    //le constructeur avec arguments
    public Marketeur(int id, String email, String nom, String password) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.password = password;
    }
    //les getteurs et setteurs
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //une fonction de saisie a un Marketeur
    public void saisie()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("ENTRER L'ID DU MARKETEUR: ");
        id =Integer.parseInt(sc.nextLine());
        System.out.println("ENTRE L'EMAIL DU MARKETEUR");
        email = sc.nextLine();
    }
}
