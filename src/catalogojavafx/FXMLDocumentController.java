/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogojavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Paredes
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anPane;
    @FXML
    private AnchorPane pane;
    @FXML
    private Slider red;
    @FXML
    private Slider green;
    @FXML
    private Slider blue;
    @FXML
    private RadioButton accion;
    @FXML
    private RadioButton ciencia;
    @FXML
    private RadioButton fantasia;
    @FXML
    private RadioButton comedia;
    @FXML
    private RadioButton drama;
    @FXML
    private RadioButton terror;
    @FXML
    private RadioButton casa;
    @FXML
    private RadioButton niño;
    @FXML
    private RadioButton montaña;
    @FXML
    private RadioButton paisaje;
    @FXML
    private TextArea txtArea;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtNames;
    @FXML
    private TextField txtNewUser;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField passNew;
    @FXML
    private PasswordField conf;
    
    private ToggleGroup group;
    @FXML
    private ImageView viewImage;

    @FXML
    private void ingresar(ActionEvent e) {
        String cad = "Usuario: " + txtUser.getText()
                + "\nContraseña: " + pass.getText();
        JOptionPane.showMessageDialog(null, cad, "Datos de Usuario", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void nuevo(ActionEvent e) {
        pane.setVisible(true);
    }

    @FXML
    private void registrar(ActionEvent e) {
        String cad = "Nombres: " + txtNames.getText()
                + "\nUsuario: " + txtNewUser.getText();
        if (passNew.getText().equals(conf.getText())) {
            cad += "\n Contraseña: " + conf.getText();
            JOptionPane.showMessageDialog(null, cad, "Datos de Registro", JOptionPane.INFORMATION_MESSAGE);
            cancelar(e);
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña no coincide\n INtentelo de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
            cancelar(e);
        }
    }
    
    @FXML
    private void cancelar(ActionEvent e) {
        txtNames.setText("");
        txtNewUser.setText("");
        passNew.setText("");
        conf.setText("");
        pane.setVisible(false);
    }

    @FXML
    private void eventoSalir(ActionEvent event) {
        int opc = JOptionPane.showConfirmDialog(null, "Desea salair?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (opc == 0) System.exit(0);
    }

    @FXML
    private void clicked(ActionEvent event) {
        int r = (int) red.getValue();
        int g = (int) green.getValue();
        int b = (int) blue.getValue();
        System.out.println("clicked");
        Color color = Color.rgb(r, g, b);
        anPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    private void aceptar(ActionEvent even) {
        String cad = "";
        if (accion.isSelected()) cad += "Acción\n";
        if (ciencia.isSelected()) cad += "Ciencia Ficción\n";
        if (fantasia.isSelected()) cad += "Fantasia\n";
        if (comedia.isSelected()) cad += "Comedia\n";
        if (drama.isSelected()) cad += "Drama\n";
        if (terror.isSelected()) cad += "Terror\n";
        txtArea.setText(cad);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new ToggleGroup();
        casa.setToggleGroup(group);
        niño.setToggleGroup(group);
        montaña.setToggleGroup(group);
        paisaje.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (casa.isSelected()) {
                    viewImage.setImage(new Image("casa.jpg"));
                }
                if (niño.isSelected()) {
                    viewImage.setImage(new Image("niño.jpg"));
                }
                if (montaña.isSelected()) {
                    viewImage.setImage(new Image("montaña.jpg"));
                }
                if (paisaje.isSelected()) {
                    viewImage.setImage(new Image("paisaje.jpg"));
                }
            }
        });
    }

}
