package modelo;

public enum TipoBagemEnum {
	
    MAO(1, "mão", 5.0),
    NACIONAL(2, "nacional", 23.0),
    INTERNACIONAL(3, "internacional", 32.0);

    private long id;
    private String nome;
    private double pesoMax;

    TipoBagemEnum(long id, String nome, Double pesoMax) {
        this.id = id;
        this.nome = nome;
        this.pesoMax = pesoMax;
	}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPesoMax() {
        return pesoMax;
    }
}
