/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostranomecomthreadsesockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class Nomes {

    private List<String> grupoList = new ArrayList<>();
    
    private String ip;
    
    private int port;
    
    private int numeroGrupo;

    public Nomes(String ip, int port, int numeroGrupo) throws IOException, ClassNotFoundException {
        this.ip = ip;
        this.port = port;
        this.numeroGrupo = numeroGrupo;
        
        this.grupoList = busca();
    }

    public List<String> busca() throws IOException, ClassNotFoundException {

        List<String> grupoList;
        try (Socket socket = new Socket(this.ip, this.port)) {
            ObjectInputStream entrada;
            try (DataOutputStream saida = new DataOutputStream(socket.getOutputStream())) {
                saida.writeInt(this.numeroGrupo);
                entrada = new ObjectInputStream(socket.getInputStream());
                grupoList = (List<String>) entrada.readObject();
            }
            entrada.close();
        }

        return grupoList;
    }

    public List<String> getGrupoList() {
        return grupoList;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }
}
