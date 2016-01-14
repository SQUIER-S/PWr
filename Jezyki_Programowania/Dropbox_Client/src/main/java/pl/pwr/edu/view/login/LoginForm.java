package pl.pwr.edu.view.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by SQUIER on 2016-01-14.
 */
public class LoginForm {

    private Stage stage;
    private Scene scene;

    private VBox main;
    private TextField authLink;

    public LoginForm() throws MalformedURLException {
        stage = new Stage();
        main = new VBox();
        scene = new Scene(main, 300, 150);

        setStyle(new File("src/main/resources/style.css"));

        main.getChildren().add(initComponents());

        stage.setScene(scene);
    }

    public void setStyle(File cssFile) throws MalformedURLException {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(cssFile.toURI().toURL().toExternalForm());
    }

    public VBox initComponents() {
        VBox vBox = new VBox(5);
        VBox labels = new VBox(5);
        HBox link = new HBox(5);

        Label clickHere = new Label("1. Go to:");
        authLink = new TextField();
        authLink.setEditable(false);

        link.getChildren().addAll(clickHere, authLink);
        link.setAlignment(Pos.CENTER_LEFT);

        Label allow = new Label("2. Click \"Allow\" (you might have to log in first)");
        Label copy = new Label("3. Copy the auth code, and paste it below.");

        TextField code = new TextField();

        Button accept = new Button("OK");

        labels.getChildren().addAll(link, allow, copy, code);

        vBox.getChildren().addAll(labels, accept);

        VBox.setMargin(labels, new Insets(10));
        VBox.setMargin(accept, new Insets(0, 0, 10, 130));

        return vBox;
    }

    public void showForm() {
        stage.show();
    }

    public void setClickHereText(String text) {
        authLink.setEditable(true);
        authLink.setText(text);
        authLink.setEditable(false);
    }
}
