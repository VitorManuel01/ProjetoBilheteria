package Bilhete;

import modelo.Bagagem;
import modelo.Horario;
import modelo.Passageiro;

public abstract class Bilhete {
	private Long id;
	private Integer numero ;
	private String assento;
	private Horario horario;
	private TipoBilheteEnum classe;
	private SituacaoBilheteEnum status;
	
	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final Integer getNumero() {
		return numero;
	}

	public final void setNumero(Integer numero) {
		this.numero = numero;
	}

	public final String getAssento() {
		return assento;
	}

	public final void setAssento(String assento) {
		this.assento = assento;
	}

	public final TipoBilheteEnum getClasse() {
		return classe;
	}

	public final void setClasse(TipoBilheteEnum classe) {
		this.classe = classe;
	}

	public final SituacaoBilheteEnum getStatus() {
		return status;
	}

	public final void setStatus(SituacaoBilheteEnum status) {
		this.status = status;
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public void reservar(Passageiro passageiro) {
        if (this.status == SituacaoBilheteEnum.DISPONIVEL) {
            this.status = SituacaoBilheteEnum.RESERVADO;
            System.out.println("Bilhete reservado para o passageiro: " + passageiro.getNome());
        } else {
            System.out.println("Bilhete não está disponível para reserva");
        }	
	}
	
	public void comprar() {
        if (this.status == SituacaoBilheteEnum.DISPONIVEL) {
            this.status = SituacaoBilheteEnum.VENDIDO;
            System.out.println("Bilhete comprado com sucesso");
        } else if(this.status == SituacaoBilheteEnum.VENDIDO || this.status == SituacaoBilheteEnum.RESERVADO){
            System.out.println("Bilhete não está disponível para compra");
        }		
	}
	
	public void cancelarReservar() {
        if (this.status == SituacaoBilheteEnum.RESERVADO) {
            this.status = SituacaoBilheteEnum.DISPONIVEL;
            System.out.println("Reserva de bilhete cancelada");
        } else {
            System.out.println("Bilhete não está reservado para cancelamento");
        }	
	}
	
	public void checkIn(Bagagem bagagem) {
        if (this.status == SituacaoBilheteEnum.VENDIDO) {
            System.out.println("Check-in realizado com a bagagem de id: " + bagagem.getId());
        } else {
            System.out.println("Bilhete não foi comprado, não é possível fazer check-in");
        }
	}
	
	protected abstract Integer maximoBagagens();
}
