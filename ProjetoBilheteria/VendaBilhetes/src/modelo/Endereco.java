package modelo;

public class Endereco {
	private Long id;
	private String rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	public final Long getId() {
		return id;
	}
	public final void setId(Long id) {
		this.id = id;
	}
	public final String getRua() {
		return rua;
	}
	public final void setRua(String rua) {
		this.rua = rua;
	}
	public final Integer getNumero() {
		return numero;
	}
	public final void setNumero(Integer numero) {
		this.numero = numero;
	}
	public final String getComplemento() {
		return complemento;
	}
	public final void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public final String getBairro() {
		return bairro;
	}
	public final void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public final String getCidade() {
		return cidade;
	}
	public final void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public final String getEstado() {
		return estado;
	}
	public final void setEstado(String estado) {
		this.estado = estado;
	}
	public final String getPais() {
		return pais;
	}
	public final void setPais(String pais) {
		this.pais = pais;
	}
	public Endereco(Long id, String rua, Integer numero, String complemento, String bairro, String cidade,
			String estado, String pais) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	public Endereco() {
		super();
	}
	
	
}
