package main;

import sn.isi.dao.*;
import sn.isi.entities.Client;
import sn.isi.entities.Marketeur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Db db = new Db();
        Scanner sc = new Scanner(System.in);
        List<Marketeur> LMark = new ArrayList<>();
        Client client = new Client();
        IClient cl = new ClientImp();
        IMarketeur im = new MarketeurImp();
        Marketeur m = im.connect();
        client.setMarketeur(m);
        client.getEmail();
        Client cli = new Client();
        List<Client> list = new ArrayList<>();
        LMark = im.VerifierConnexion(m);
        //im.CreerClient(client);
        int choix = im.Menu();
        IMarketeur iMarketeur = new MarketeurImp();
        switch (choix){
            case 1:
                iMarketeur.add(client);
                break;

            case 2:
                System.out.println("Donner l'id: ");
                int idE = sc.nextInt();
                client = cl.saisieClient(client);
                int ok = im.Edition(client,idE);
                break;
            case 3:
                List<Client> clientList =new ArrayList<>();
                clientList = iMarketeur.Visualiser();
                for (Client c: clientList) {
                    System.out.println("Nom : "+c.getNom());
                    System.out.println("prenoom : "+c.getPrenom());
                    System.out.println("Email : "+c.getEmail());
                    System.out.println("Tel : "+c.getTelephone());
                }
                break;

            case 4:
                Client c = iMarketeur.RechercherClient();
                System.out.println(c.getId());
                System.out.println(c.getNom());
                System.out.println(c.getPrenom());
                System.out.println(c.getEmail());
                System.out.println(c.getTelephone());

                break;
        }
    }
}
