package modelo;

public class Aviao {
	private Long id;
	private String codigo;
	private double carga;
	private Integer qtdEconomica;
	private Integer qtdPrimeira;
	private Integer qtdExecutiva;
	
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public final double getCarga() {
		return carga;
	}
	public final void setCarga(double carga) {
		this.carga = carga;
	}
	public final Integer getQtdEconomica() {
		return qtdEconomica;
	}
	public final void setQtdEconomica(Integer qtdEconomica) {
		this.qtdEconomica = qtdEconomica;
	}
	public final Integer getQtdPrimeira() {
		return qtdPrimeira;
	}
	public final void setQtdPrimeira(Integer qtdPrimeira) {
		this.qtdPrimeira = qtdPrimeira;
	}
	public final Integer getQtdExecutiva() {
		return qtdExecutiva;
	}
	public final void setQtdExecutiva(Integer qtdExecutiva) {
		this.qtdExecutiva = qtdExecutiva;
	}
	public Aviao(Long id, String codigo, double carga, Integer qtdEconomica, Integer qtdPrimeira,
			Integer qtdExecutiva) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.carga = carga;
		this.qtdEconomica = qtdEconomica;
		this.qtdPrimeira = qtdPrimeira;
		this.qtdExecutiva = qtdExecutiva;
	}
	public Aviao() {
		super();
	}
	
	
	
	
}
