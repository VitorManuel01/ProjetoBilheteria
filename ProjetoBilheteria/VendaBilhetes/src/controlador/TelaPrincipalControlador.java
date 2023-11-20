package controlador;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalControlador implements Initializable {
	
	@FXML
	private ImageView imageMain;

	@FXML
	private Label usuarioLabelMain;

	@FXML
	private Label senhaLabelMain;

	@FXML
	private TextField usuarioTextFieldMain;

	@FXML
	private PasswordField senhaPassWordTextFiledMain;

	@FXML
	private Button buttonEntrarMain;

	@FXML
	private Button buttonCadastrarMain;
	@FXML
	private AnchorPane ancora1;

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	public void handleButtonEntrar() throws IOException{
		
	}
	public void handleButtonCadastrar() throws IOException{
		URL url = Paths.get("./src/view/CadastroPassageiro.fxml").toUri().toURL();
		FXMLLoader loader = new FXMLLoader(url);
	    AnchorPane root = loader.load();
	    
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
	}
	public void handlerMenuItemCadastrosPassageiro() throws IOException{
		URL url = Paths.get("./src/view/ListaPassageiro.fxml").toUri().toURL();
		AnchorPane a = (AnchorPane) FXMLLoader.load(url);
		ancora1.getChildren().setAll(a);
	}

}
