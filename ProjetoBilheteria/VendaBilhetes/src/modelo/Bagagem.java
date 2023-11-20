package modelo;

public class Bagagem {
	private Long id;
	private Double peso;
	private TipoBagemEnum tipoBagagem;
	
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final Double getPeso() {
		return peso;
	}
	public final void setPeso(Double peso) {
		this.peso = peso;
	}
	public final TipoBagemEnum getTipoBagagem() {
		return tipoBagagem;
	}
	public final void setTipoBagagem(TipoBagemEnum tipoBagagem) {
		this.tipoBagagem = tipoBagagem;
	}
	
	public Bagagem(Long id, Double peso, TipoBagemEnum tipoBagagem) {
		super();
		this.id = id;
		this.peso = peso;
		this.tipoBagagem = tipoBagagem;
	}
	public Bagagem() {
		super();
	}	
}
