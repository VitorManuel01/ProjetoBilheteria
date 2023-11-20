package modelo;

import java.util.Date;

public class Passageiro extends Pessoa{
	private String CPF;
	private String numeroCartao;
	
	public final String getCPF() {
		return CPF;
	}
	public final void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public final String getNumeroCartao() {
		return numeroCartao;
	}
	public final void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public Passageiro(Long id, String nome, String email,String telefone, String usuario, String senha, Date dataNascimento, String CPF,
			String numeroCartao, Endereco endereco) {
		super(id, nome, email, usuario, senha, telefone, dataNascimento, endereco);
		this.CPF = CPF;
		this.numeroCartao = numeroCartao;
	}
	public Passageiro() {
		super();
	}
	
}
