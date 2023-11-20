package modelo;

import java.time.LocalDateTime;

public class Horario {
	private Long id;
	private String codigo;
	private LocalDateTime partida;
	private LocalDateTime chegada;
	private Integer qtdEconomica;
	private Integer qtdPrimeira;
	private Integer qtdExecutiva;
	private Aviao aviao;
	private Rota rota;
	
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
	public final LocalDateTime getPartida() {
		return partida;
	}
	public final void setPartida(LocalDateTime partida) {
		this.partida = partida;
	}
	public final LocalDateTime getChegada() {
		return chegada;
	}
	public final void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
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
	public final Aviao getAviao() {
		return aviao;
	}
	public final void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	public final Rota getRota() {
		return rota;
	}
	public final void setRota(Rota rota) {
		this.rota = rota;
	}
	
	public Horario(Long id, String codigo, LocalDateTime partida, LocalDateTime chegada, Integer qtdEconomica,
			Integer qtdPrimeira, Integer qtdExecutiva, Aviao aviao, Rota rota) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.partida = partida;
		this.chegada = chegada;
		this.qtdEconomica = qtdEconomica;
		this.qtdPrimeira = qtdPrimeira;
		this.qtdExecutiva = qtdExecutiva;
		this.aviao = aviao;
		this.rota = rota;
	}
	public Horario() {
		super();
	}

}
