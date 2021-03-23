package sn.isi.dao;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public List<Client> getAll ()throws  Exception;
    public Client saisieClient(Client client) throws Exception;
}
