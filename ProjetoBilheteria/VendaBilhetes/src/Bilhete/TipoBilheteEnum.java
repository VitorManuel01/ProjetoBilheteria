package Bilhete;

public enum TipoBilheteEnum {
	ECONOMICA(1, "Economica"),
	EXECUTIVA(2, "Executiva"),
	PRIMEIRA(3, "Primeira");

	private long id;
    private String nome;

	TipoBilheteEnum(long id, String nome) {
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
