package controlador;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import dao.PassageiroDao;
import modelo.Passageiro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListaPassageiroControlador implements Initializable {
	
	@FXML
	private TableView<Passageiro> tableViewPassageiros;
	@FXML
	private TableColumn<Passageiro, String> tableColumnPassageiroNome;
	@FXML
	private TableColumn<Passageiro, String> tableColumnPassageiroCPF;
	@FXML
	private Button buttonInserir;
	@FXML
	private Button buttonAlterar;
	@FXML
	private Button buttonRemover;
	@FXML
	private Label labelPassID;
	@FXML
	private Label labelPassNome;
	@FXML
	private Label labelPassCPF;
	@FXML
	private Label labelPassEmail;
	@FXML
	private Label labelPassTelefone;
	@FXML
	private Label labelPassUsuario;
	@FXML
	private Label labelPassSenha;
	@FXML
	private Label labelPassDataNascimento;
	@FXML
	private Label labelPassNumeroCartao;
	
	
	private List<Passageiro> listaPassageiros;
	
	private ObservableList<Passageiro> listaObservavelPassageiros;	
	
	private final PassageiroDao passageiroDao = new PassageiroDao();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		carregarTableViewPassageiro();
		
		tableViewPassageiros.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
		
	}
	
	public void carregarTableViewPassageiro() {
		tableColumnPassageiroNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnPassageiroCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));

		listaPassageiros = passageiroDao.listarPassageiros();

		listaObservavelPassageiros = FXCollections.observableArrayList(listaPassageiros);
		tableViewPassageiros.setItems(listaObservavelPassageiros);
	}
	
	public void selecionarItemTableViewClientes(Passageiro passageiro) {
        if (passageiro != null) {
        	labelPassID.setText(String.valueOf(passageiro.getId()));
        	labelPassNome.setText(passageiro.getNome());
        	labelPassCPF.setText(passageiro.getCPF());
        	labelPassEmail.setText(passageiro.getEmail());
        	labelPassTelefone.setText(passageiro.getTelefone());
        	labelPassUsuario.setText(passageiro.getUsuario());
        	labelPassSenha.setText(passageiro.getSenha());
        	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        	String dataFormatada = formato.format(passageiro.getDataNascimento());
        	labelPassDataNascimento.setText(dataFormatada);
        	labelPassNumeroCartao.setText(passageiro.getNumeroCartao());
        } else {
        	labelPassID.setText("");
        	labelPassNome.setText("");
        	labelPassCPF.setText("");
        	labelPassTelefone.setText("");
        	labelPassUsuario.setText("");
        	labelPassSenha.setText("");
        	labelPassDataNascimento.setText("");
        	labelPassNumeroCartao.setText("");
        }	
	}
	

    
    @FXML
    public void handleButtonAlterar() throws IOException, SQLException {
    	Passageiro passageiro = tableViewPassageiros.getSelectionModel().getSelectedItem();

    	if (passageiro != null) {
    		
    	    boolean buttonConfirmarClique = showPainelAlterarPassageiro(passageiro);
    	    if (buttonConfirmarClique) {
    	    	passageiroDao.alterar(passageiro);
    	        carregarTableViewPassageiro();
    	    }
    	} else {
    	    Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setContentText("Por favor, escolha um cliente na Tabela!");
    	    alert.show();
    	}
    }
    @FXML
    public void handleButtonRemover() throws IOException, SQLException {
    	Passageiro passageiro = tableViewPassageiros.getSelectionModel().getSelectedItem();
        if (passageiro != null) {
        	passageiroDao.remover(passageiro);
            carregarTableViewPassageiro();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }


	private boolean showPainelAlterarPassageiro(Passageiro passageiro)throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = Paths.get("./src/view/AlterarPassageiro.fxml").toUri().toURL();
        loader.setLocation(url);
        AnchorPane pagina = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Alterar Informações de Passageiro");
        Scene cena = new Scene(pagina);
        dialogStage.setScene(cena);

        // Setando o cliente no Controller.
        CadastroPassageiroControlador controlador = loader.getController();
        controlador.setDialogStage(dialogStage);
        controlador.setPassageiroAlterar(passageiro);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controlador.isButtonConfirmarClique();
	}
	
}
