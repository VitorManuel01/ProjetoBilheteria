package controlador;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import dao.PassageiroDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Passageiro;

public class CadastroPassageiroControlador implements Initializable {
	
	@FXML
	private Label labelPassNome;
	@FXML
	private Label labelAltPassID;
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
	private Label labelPassDtNascimento;
	@FXML
	private Label labelPassNumeroCartao;
	@FXML
	private TextField textFieldNome;
	@FXML
	private TextField textFieldCPF;
	@FXML
	private TextField textFieldEmail;
	@FXML
	private TextField textFieldTelefone;
	@FXML
	private TextField textFieldUsuario;
	@FXML
	private TextField textFieldNumeroCartao;
	
	@FXML
	private TextField textFieldAlterarNome;
	@FXML
	private TextField textFieldAlterarCPF;
	@FXML
	private TextField textFieldAlterarEmail;
	@FXML
	private TextField textFieldAlterarTelefone;
	@FXML
	private TextField textFieldAlterarUsuario;
	@FXML
	private TextField textFieldAlterarNumeroCartao;
	
	@FXML
	private PasswordField passwordFieldSenha;
	@FXML
	private DatePicker datePickerDtNacimento;
	@FXML
	private DatePicker datePickerAlterarDtNacimento;
	@FXML
	private Button buttonConfirmar;
	@FXML
	private Button buttonCancelar;
	
	private Stage dialogStage;
	private boolean buttonConfirmarClique = false;
	private Passageiro passageiro;
	private final PassageiroDao passageiroDao = new PassageiroDao();

	
	
	public final Passageiro getPassageiro() {
		return passageiro;
	}

	public final void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;		
	}

	public final void setPassageiroAlterar(Passageiro passageiro) {
		this.passageiro = passageiro;
		this.labelAltPassID.setText(String.valueOf(passageiro.getId()));
		this.textFieldAlterarNome.setText(passageiro.getNome());
		this.textFieldAlterarCPF.setText(passageiro.getCPF());
		this.textFieldAlterarEmail.setText(passageiro.getEmail());
		this.textFieldAlterarTelefone.setText(passageiro.getTelefone());
		this.textFieldAlterarUsuario.setText(passageiro.getUsuario());
		this.textFieldAlterarNumeroCartao.setText(passageiro.getNumeroCartao());		
	}


	public final Stage getDialogStage() {
		return dialogStage;
	}



	public final void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}



	public final boolean isButtonConfirmarClique() {
		return buttonConfirmarClique;
	}



	public final void setButtonConfirmarClique(boolean buttonConfirmarClique) {
		this.buttonConfirmarClique = buttonConfirmarClique;
	}
	private void close() {
	    Stage stage = (Stage) buttonConfirmar.getScene().getWindow();
	    stage.close();
	}
    @FXML
    public void handleButtonConfirmar() throws SQLException {

        if (validarEntradaDeDados()) {
        	passageiro = new Passageiro();
            passageiro.setNome(textFieldNome.getText());
            passageiro.setCPF(textFieldCPF.getText());        
            passageiro.setEmail(textFieldEmail.getText());
            passageiro.setTelefone(textFieldTelefone.getText());
            passageiro.setUsuario(textFieldUsuario.getText());
            passageiro.setSenha(passwordFieldSenha.getText());
            LocalDate dataSelecionada = datePickerDtNacimento.getValue();
            Date data = Date.from(dataSelecionada.atStartOfDay(ZoneId.systemDefault()).toInstant());
            passageiro.setDataNascimento(data);
            passageiro.setNumeroCartao(textFieldNumeroCartao.getText());

            buttonConfirmarClique = true;
            if (buttonConfirmarClique) {
                passageiroDao.inserir(passageiro);
                close();
            }
            
        }
    }
    
    @FXML
    public void handleButtonConfirmarAlterar() {

        if (validarAlterarDeDados()) {
        	passageiro.setId(Long.parseLong(labelAltPassID.getText()));
            passageiro.setNome(textFieldAlterarNome.getText());
            passageiro.setCPF(textFieldAlterarCPF.getText());        
            passageiro.setEmail(textFieldAlterarEmail.getText());
            passageiro.setTelefone(textFieldAlterarTelefone.getText());
            passageiro.setUsuario(textFieldAlterarUsuario.getText());
            LocalDate dataSelecionada = datePickerAlterarDtNacimento.getValue();
            Date data = Date.from(dataSelecionada.atStartOfDay(ZoneId.systemDefault()).toInstant());
            passageiro.setDataNascimento(data);
            passageiro.setNumeroCartao(textFieldAlterarNumeroCartao.getText());

            buttonConfirmarClique = true;
            dialogStage.close();
        }
    }      
    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }
    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldNome.getText() == null || textFieldNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldCPF.getText() == null || textFieldCPF.getText().length() == 0) {
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldEmail.getText() == null || textFieldEmail.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }
        if (textFieldTelefone.getText() == null || textFieldTelefone.getText().length() == 0) {
            errorMessage += "Telefone inválido!\n";
        }
        if (textFieldUsuario.getText() == null || textFieldUsuario.getText().length() == 0) {
            errorMessage += "Usuário inválido!\n";
        }
        if (textFieldNumeroCartao.getText() == null || textFieldNumeroCartao.getText().length() == 0) {
            errorMessage += "Numero de Cartão inválido!\n";
        }
        if (passwordFieldSenha.getText() == null || passwordFieldSenha.getText().length() == 0) {
            errorMessage += "Senha inválida!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    private boolean validarAlterarDeDados() {
        String errorMessage = "";

        if (textFieldAlterarNome.getText() == null || textFieldAlterarNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldAlterarCPF.getText() == null || textFieldAlterarCPF.getText().length() == 0) {
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldAlterarEmail.getText() == null || textFieldAlterarEmail.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }
        if (textFieldAlterarTelefone.getText() == null || textFieldAlterarTelefone.getText().length() == 0) {
            errorMessage += "Telefone inválido!\n";
        }
        if (textFieldAlterarUsuario.getText() == null || textFieldAlterarUsuario.getText().length() == 0) {
            errorMessage += "Usuário inválido!\n";
        }
        if (textFieldAlterarNumeroCartao.getText() == null || textFieldAlterarNumeroCartao.getText().length() == 0) {
            errorMessage += "Numero de Cartão inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
    @FXML
    public void handleButtonInserir() throws IOException, SQLException {
        Passageiro passageiro = new Passageiro();

    }
    
	private boolean showPainelCadastroPassageiro(Passageiro passageiro)throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = Paths.get("./src/view/CadastroPassageiro.fxml").toUri().toURL();
        loader.setLocation(url);
        AnchorPane pagina = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Passageiro");
        Scene cena = new Scene(pagina);
        dialogStage.setScene(cena);

        // Setando o cliente no Controller.
        CadastroPassageiroControlador controlador = loader.getController();
        controlador.setDialogStage(dialogStage);
        controlador.setPassageiro(passageiro);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controlador.isButtonConfirmarClique();
	}

}
