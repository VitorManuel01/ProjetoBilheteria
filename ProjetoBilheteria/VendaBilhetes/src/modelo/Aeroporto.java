package modelo;

public class Aeroporto {
	private Long id;
	private String nome;
	private String codigo;
	private Endereco endereco;
	private Rota rota;
	
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
	public final String getCodigo() {
		return codigo;
	}
	public final void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public final Endereco getEndereco() {
		return endereco;
	}
	public final void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public final Rota getRota() {
		return rota;
	}
	public final void setRota(Rota rota) {
		this.rota = rota;
	}
	
	public Aeroporto(Long id, String nome, String codigo, Endereco endereco, Rota rota) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.endereco = endereco;
		this.rota = rota;
	}
	public Aeroporto() {
		super();
	}

}
