package Bilhete;

public enum SituacaoBilheteEnum {
	DISPONIVEL(1, "Disponível"),
	RESERVADO(2, "Reservado"),
	VENDIDO(3,"Vendido");
	
	private long id;
    private String nome;

    SituacaoBilheteEnum(long id, String nome) {
        this.id = id;
        this.nome = nome;
	}

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}
 
}
