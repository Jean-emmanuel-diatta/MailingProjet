package sn.isi.dao;

import sn.isi.entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientImp implements IClient {
    @Override
    public List<Client> getAll() throws Exception {
        Db db = new Db();
        List<Client> clients = new ArrayList<Client>();
        db.open();
        String sql = "SELECT * from client";
        db.init(sql);
        ResultSet res = db.executeSelect();
        while (res.next()) {
            Client cli = new Client();
            cli.setId(res.getInt(1));
            cli.setNom(res.getString(2));
            cli.setPrenom(res.getString(3));
            cli.setEmail(res.getString(4));
            cli.setTelephone(res.getString(5));
            clients.add(cli);
        }
        return clients;
    }
    @Override
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



