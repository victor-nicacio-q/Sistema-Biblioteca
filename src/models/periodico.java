package models;

public class periodico {

	private String tituloPeriodico;
	private String editora;
	private String dataPrimeiroVolume;
	private String dataSegundoVolume;
	private int idLocPub;
	private String tituloPub;
	
	public String getTituloPeriodico() {
		return tituloPeriodico;
	}
	public void setTituloPeriodico(String tituloPeriodico) {
		this.tituloPeriodico = tituloPeriodico;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getDataPrimeiroVolume() {
		return dataPrimeiroVolume;
	}
	public void setDataPrimeiroVolume(String dataPrimeiroVolume) {
		this.dataPrimeiroVolume = dataPrimeiroVolume;
	}
	public String getDataSegundoVolume() {
		return dataSegundoVolume;
	}
	public void setDataSegundoVolume(String dataSegundoVolume) {
		this.dataSegundoVolume = dataSegundoVolume;
	}
	public int getIdLocPub() {
		return idLocPub;
	}
	public void setIdLocPub(int idLocPub) {
		this.idLocPub = idLocPub;
	}
	public String getTituloPub() {
		return tituloPub;
	}
	public void setTituloPub(String tituloPub) {
		this.tituloPub = tituloPub;
	}
}
