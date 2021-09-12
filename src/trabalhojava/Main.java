/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import trabalhojava.controller.MenuLoginController;

/**
 *
 * @author fabio
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuLoginController.class.getResource("/trabalhojava/view/MenuLogin.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        MenuLoginController controller = loader.getController();

        dialogStage.show();

        dialogStage.setOnCloseRequest(event -> controller.clicaButtonSair());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
