package sn.isi.dao;


import sn.isi.entities.Client;
import sn.isi.entities.Marketeur;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketeurImp implements IMarketeur {
    private Db db = new Db();
    Scanner sc = new Scanner(System.in);
    ResultSet rs = null;
    Marketeur marketeur = null;
    String rep;
    int ok;
    @Override
    public List<Marketeur> VerifierConnexion(Marketeur m) throws Exception {
        db.open();
        List<Marketeur> ListMark = new ArrayList<>();
        String sql = "SELECT * FROM marketeur";
        db.init(sql);
        rs = db.executeSelect();
        while (rs.next()) {
            Marketeur Lmark = new Marketeur();
            marketeur.setId(rs.getInt(1));
            marketeur.setEmail(rs.getString(2));
            marketeur.setPassword(rs.getString(3));
        }
        return ListMark;
    }

    @Override
    public Marketeur connect(Marketeur marketeur) throws Exception {
        int cpt =0;
        String mdp ="";
        System.out.println("------------------------------------------------------------------");
        System.out.println("                            AUTHENTIFICATION                      ");
        System.out.println("------------------------------------------------------------------");
        System.out.println("VEUILLER ENTRER VOTRE EMAIL !!!!");
        marketeur.setEmail(sc.nextLine());
        System.out.println("VEUILLER ENTRER VOTRE MOT DE PASSE !!!");
        marketeur.setPassword(sc.nextLine());
        return marketeur;
    }

    @Override
    public int add(Client client) throws Exception {
        do {
            client.saisieClient(client);
            String sql = "INSERT INTO client VALUES(NULL,?,?,?,?,?)";
            db.init(sql);
            db.getPstm().setString(1, client.getNom());
            db.getPstm().setString(2, client.getPrenom());
            db.getPstm().setString(3, client.getEmail());
            db.getPstm().setString(4, client.getTelephone());
            db.getPstm().setInt(5, client.getMarketeur().getId());
            ok = db.executeUdate();
            db.close();
            System.out.println("Voulez vous continuer ? Oui/Non");
            rep = sc.nextLine();
        }while (rep.equalsIgnoreCase("Oui"));
        return ok;
    }

    @Override
    public int Edition(Client client, Integer idN) throws Exception {
        String sql = "UPDATE client SET nom =?, prenom =?, email =? , tel = ? WHERE id = ?";
        db.init(sql);
        db.getPstm().setString(1,client.getNom());
        db.getPstm().setString(2,client.getPrenom());
        db.getPstm().setString(3,client.getEmail());
        db.getPstm().setString(4,client.getTelephone());
        db.getPstm().setInt(5,idN);
        ok = db.executeUdate();
        return ok;
    }

    @Override
    public List<Client> Visualiser() throws Exception {
            List<Client> listClient = new ArrayList<>();
            String sql = "SELECT * FROM client ";
            db.init(sql);
            rs = db.executeSelect();
            while (rs.next()){
                Client cli = new Client();
                cli.setId(rs.getInt(1));
                cli.setNom(rs.getString(2));
                cli.setPrenom(rs.getNString(3));
                cli.setEmail(rs.getString(4));
                cli.setTelephone(rs.getString(5));
                listClient.add(cli);
            }
            return listClient;
    }

    @Override
    public Client RechercherClient() throws Exception {
        Client client = new Client();
        //Client client = null;
        db.open();
        System.out.println("VEUILLER ENTRER L'EMAIL DU CLIENT A RECHERCHER: ");
        String email = sc.nextLine();
        String sql = "SELECT * FROM client c LEFT JOIN marketeur m ON (c.idM = m.idMark) WHERE c.email = ?";
        db.init(sql);
        db.getPstm().setString(1, email);
        ResultSet rs = db.executeSelect();
        if(rs.next()){
            client.setId(rs.getInt(1));
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTelephone(rs.getString(5));
            Marketeur marketeur = new Marketeur();
            marketeur.setId(rs.getInt(6));
            marketeur.setEmail(rs.getString(7));
            marketeur.setPassword(rs.getString(8));
        }
        return client;
    }

    @Override
    public int Menu() throws Exception {
        int choix;
        System.out.println("------------------------------------------------");
        System.out.println("            Veuillez faire votre choix          ");
        System.out.println("              1-Creer client                    ");
        System.out.println("               2-EDITION                        ");
        System.out.println("               3-VISUALISER                     ");
        System.out.println("               4-RECHERCHER                     ");
        System.out.println("               5-QUITTER                        ");
        System.out.println("------------------------------------------------");
        choix= sc.nextInt();
        return choix;
    }
}
