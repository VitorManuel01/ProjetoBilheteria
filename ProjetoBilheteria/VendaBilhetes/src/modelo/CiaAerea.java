package modelo;

public class CiaAerea {
	private Long id;
	private String nome;
	private Papel papeis;
	private Aviao avioes;
	private Rota rotas;
	
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
	public final Papel getPapeis() {
		return papeis;
	}
	public final void setPapeis(Papel papeis) {
		this.papeis = papeis;
	}
	public final Aviao getAvioes() {
		return avioes;
	}
	public final void setAvioes(Aviao avioes) {
		this.avioes = avioes;
	}
	public final Rota getRotas() {
		return rotas;
	}
	public final void setRotas(Rota rotas) {
		this.rotas = rotas;
	}
	
	public CiaAerea(Long id, String nome, Papel papeis, Aviao avioes, Rota rotas) {
		super();
		this.id = id;
		this.nome = nome;
		this.papeis = papeis;
		this.avioes = avioes;
		this.rotas = rotas;
	}
	public CiaAerea() {
		super();
	}
	
	
	
}
