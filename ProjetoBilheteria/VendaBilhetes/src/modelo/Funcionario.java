package modelo;

import java.util.Date;

public class Funcionario extends Pessoa{
	
	private String codigo;
	private String contaCorrente;
	private Papel funcao;
	
	public final String getCodigo() {		
		return codigo;
	}
	public final void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public final String getContaCorrente() {
		return contaCorrente;
	}
	public final void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public Papel getFuncao() {
		return funcao;
	}
	public void setFuncao(Papel funcao) {
		this.funcao = funcao;
	}
	
	public Funcionario(Long id, String nome, String email, String telefone,String usuario, String senha, Date dataNascimento,
			String codigo, String contaCorrente, Endereco endereco, Papel papel) {
		super(id, nome, email, usuario, senha, telefone, dataNascimento, endereco);
		this.codigo = codigo;
		this.contaCorrente = contaCorrente;
		this.funcao = papel;
	}
	public Funcionario() {
		super();
	}

	
	

}
