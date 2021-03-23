package sn.isi.entities;

import java.io.Serializable;
import java.util.Scanner;

public class Client implements Serializable {
    private int id;
    private  String nom;
    private  String prenom;
    private  String email;
    private  String telephone;
    private Marketeur marketeur = new Marketeur();
    //le constructeur par defaut
    public Client() {
    }
    // le constructeur avec argument
    public Client(int id, String nom, String prenom, String email, String telephone, Marketeur marketeur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.marketeur = marketeur;
    }
    //les getteurs et setteurs
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Marketeur getMarketeur() {
        return marketeur;
    }
    public void setMarketeur(Marketeur marketeur) {
        this.marketeur = marketeur;
    }
    //une fonction pour saisir le client
    public Client saisieClient(Client client) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTRER L'ID DU CLIENT: ");
        client.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("ENTRER LE NOM DU CLIENT: ");
        client.setNom(sc.nextLine());
        System.out.println("ENTRER LE PRENOM DU CLIENT: ");
        client.setPrenom(sc.nextLine());
        System.out.println("ENTRE L'EMAL DU CLIENT");
        client.setEmail(sc.nextLine());
        System.out.println("ENTRE LE TELEPHONE DU CLIENT");
        client.setTelephone(sc.nextLine());
        return client;
    }

}
