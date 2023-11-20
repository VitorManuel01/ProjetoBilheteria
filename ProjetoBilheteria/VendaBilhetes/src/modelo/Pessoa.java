package modelo;

import java.util.Date;

public abstract class Pessoa {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String usuario;
	private String senha;
	private Date dataNascimento;
	private Endereco endereco;
	
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final String getNome() {
		return nome;
	}
	public final void setNome(String nome) {
		this.nome = nome;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public final String getUsuario() {
		return usuario;
	}
	public final void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public final String getSenha() {
		return senha;
	}
	public final void setSenha(String senha) {
		this.senha = senha;
	}
	public final Date getDataNascimento() {
		return dataNascimento;
	}
	public final void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public final Endereco getEndereco() {
		return endereco;
	}
	public final void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
    
	public Pessoa(Long id, String nome, String email, String telefone, String usuario, String senha, Date dataNascimento,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.usuario = usuario;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	public Pessoa() {
		super();
	}
	
	
	
}
