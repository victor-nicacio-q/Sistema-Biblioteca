package models;

public class localPublicacao {
	private int idLocPub;
	private String pais;
	private String estado;
	private String cidade;
	private String logradouro;
	private int numero;
	private int cep;
	public int getIdLocPub() {
		return idLocPub;
	}
	public void setIdLocPub(int idLocPub) {
		this.idLocPub = idLocPub;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	
}
