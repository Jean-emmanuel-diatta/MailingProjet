package sn.isi.dao;



import sn.isi.entities.Client;
import sn.isi.entities.Marketeur;

import java.util.List;

public interface IMarketeur {
    public List<Marketeur> VerifierConnexion(Marketeur m ) throws  Exception;
    public Marketeur connect(Marketeur marketeur) throws  Exception;
    public int add(Client client) throws Exception;
    public int Edition(Client client, Integer idE) throws  Exception;
    public List<Client> Visualiser() throws Exception;
    public Client RechercherClient() throws Exception;
    public int Menu() throws Exception;

}
