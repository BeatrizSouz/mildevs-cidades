package br.com.mesttra.cidadeBD;

public class CidadeTabela {
	/*cidade(ddd*, nome, nro_habitantes, 
	 * renda_per_capita, capital**, estado, nome_prefeito) 
	 * */
	private int DDD;
	private String NomeCidade;
	private double  NumHabitantes;
	private double Renda_per_capita;
	private boolean Capital;
	private String SiglaEstado;
	private String NomePrefeito;
	
	public CidadeTabela(int ddd, String nomeCidade, double numHabitantes, double renda_per_capita, boolean capital,
			String siglaEstado, String nomePrefeito) {
		super();
		DDD = ddd;
		NomeCidade = nomeCidade;
		NumHabitantes = numHabitantes;
		Renda_per_capita = renda_per_capita;
		Capital = capital;
		SiglaEstado = siglaEstado;
		NomePrefeito = nomePrefeito;
	}
	
	public CidadeTabela() {
		super();
		
	}
	
	public int getDDD() {
		return DDD;
	}
	public void setDDD(int ddd) {
		DDD = ddd;
	}
	public String getNomeCidade() {
		return NomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		NomeCidade = nomeCidade;
	}
	public double getNumHabitantes() {
		return NumHabitantes;
	}
	public void setNumHabitantes(double numHabitantes) {
		NumHabitantes = numHabitantes;
	}
	public double getRenda_per_capita() {
		return Renda_per_capita;
	}
	public void setRenda_per_capita(double renda_per_capita) {
		Renda_per_capita = renda_per_capita;
	}
	public boolean isCapital() {
		return Capital;
	}
	public void setCapital(boolean capital) {
		Capital = capital;
	}
	public String getSiglaEstado() {
		return SiglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		SiglaEstado = siglaEstado;
	}
	public String getNomePrefeito() {
		return NomePrefeito;
	}
	public void setNomePrefeito(String nomePrefeito) {
		NomePrefeito = nomePrefeito;
	}

	@Override
	public String toString() {
		return "\n"+ "CidadeTabela\n[DDD = " + DDD + "|Nome da Cidade = " + NomeCidade + "|Número de Habitantes = " + NumHabitantes +
				 "|Renda Per Capita = " + Renda_per_capita +  "|É Capital = " + Capital + "|Sigla do Estado = " + SiglaEstado + 
				 "|Nome do Prefeito = " + NomePrefeito + "]" ;
	}
	
	/*return "CidadeTabela]\n[DDD = " + DDD + "\n" + "Nome da Cidade = " + NomeCidade + "\n" + "Número de Habitantes = " + NumHabitantes + "\n" +
				 "Renda Per Capita = " + Renda_per_capita + "\n" + "Capital = " + Capital + "\n" +"Sigla do Estado = " + SiglaEstado + "\n" +
				 "Nome do Prefeito = " + NomePrefeito + "\n";*/
	
	
	
}
