/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostranomecomthreadsesockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author fabri
 */
public class RunnableNomes implements Runnable {

    private int posi;

    private List<String> pessoas = new ArrayList<String>();

    private Label label;
    
    public boolean infinito = true;

    public RunnableNomes(Label label) {
        this.label = label;
    }

    @Override
    public void run() {

        try {
            Nomes grupoList = new Nomes("34.125.46.96", 12345, 3);
            this.pessoas = grupoList.getGrupoList();

            while (infinito) {

                if (this.posi == grupoList.getGrupoList().size()) {
                    this.posi = 0;
                }

                Platform.runLater(() -> this.label.setText(this.pessoas.get(this.posi)));

                Thread.sleep(3000);
                this.posi++;
            }

        } catch (IOException ex) {
            Logger.getLogger(RunnableNomes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RunnableNomes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunnableNomes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
