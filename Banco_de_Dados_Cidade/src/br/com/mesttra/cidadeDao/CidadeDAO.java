package br.com.mesttra.cidadeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mesttra.cidadeBD.CidadeTabela;
import br.com.mesttra.cidadeBD.ConnectionFactory;



public class CidadeDAO {
	
	public Connection conexaoBD;

	public CidadeDAO() {
		
		this.conexaoBD = ConnectionFactory.getconnection();
		
		
	}
	
	public boolean InserirCidade(CidadeTabela cidade) {
		String sql = ("INSERT INTO public.cidades(\r\n"
				+ "	ddd_cidade, nome_cidade, numero_habitantes, renda_per_capita, capital, sigla_estado, nome_prefeito)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?);");
		
		PreparedStatement smt;	
		
		try {
			smt = conexaoBD.prepareStatement(sql);
			
			smt.setInt(1, cidade.getDDD());
			smt.setString(2, cidade.getNomeCidade());
			smt.setDouble(3, cidade.getNumHabitantes());
			smt.setDouble(4, cidade.getRenda_per_capita());
			smt.setBoolean(5, cidade.isCapital());
			smt.setString(6, cidade.getSiglaEstado());
			smt.setString(7, cidade.getNomePrefeito());

			smt.execute();			
			smt.close();
			System.out.println("Cidade adicionada a tabela");
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao adicionar os dados do Banco!");
			return false;
			
			
		}

		
	}
	
	public boolean RemoverCidade(int ddd) {
		String sql = ("DELETE FROM public.cidades\r\n"
				+ "	WHERE ddd_cidade = ?;");
		
		PreparedStatement smt;	
		
		try {
			smt = conexaoBD.prepareStatement(sql);
			
			smt.setInt(1, ddd);

			smt.execute();			
			smt.close();
			System.out.println("-----------------------------------");	
			System.out.println("Cidade removida da tabela");
			System.out.println("-----------------------------------");	

			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao remover os dados do Banco!");
			return false;
		}
		
	}

	public List<CidadeTabela>ConsultaTabela() {
		
		List<CidadeTabela>ConsultaTabela = new ArrayList<>();
		String sql = ("SELECT * FROM cidades;");
		
		PreparedStatement smt;	
		
		try {
			smt = conexaoBD.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();
			
			ConsultaTabela.add(PercorreTabela(smt));
			return ConsultaTabela;
		
		} catch (SQLException e) {
			System.err.println("Erro ao consultar tabela");
			
			return null;
		}
		
		
		
		
	}
	

	public CidadeTabela ConsultaDDD(int ddd) {
		
		
		String sql = ("SELECT * FROM cidades WHERE ddd_cidade = ?;");
		
		PreparedStatement smt;	
		
		try {
			smt = conexaoBD.prepareStatement(sql);
			smt.setInt(1, ddd);			
			return PercorreTabela(smt);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao consultar tabela");
			return null;

			
		}
		
		
		
		
	}

	public List<CidadeTabela>ConsultaCidadePorEstado(String SiglaEstado){
		
		List<CidadeTabela>ConsultaCidadeSigla = new ArrayList<>();
		
		String sql = ("SELECT * FROM cidades WHERE sigla_estado = ?;");
		
		PreparedStatement smt;	
		
		try {
			
			smt = conexaoBD.prepareStatement(sql);
			smt.setString(1,SiglaEstado);	
			
			ConsultaCidadeSigla.add(PercorreTabela(smt));
			smt.close();
			
		} catch (SQLException e) {
			System.err.println("Erro ao consultar cidades do estado de " + SiglaEstado);
			System.err.println(e.getMessage());
			
		}
		
		return ConsultaCidadeSigla;
		
		
	}
	

	public List<CidadeTabela>ConsultaCidadesQueComeCom(String PalavraChave){
		
		List<CidadeTabela>ConsultaCidade = new ArrayList<>();
		
		String sql = ("SELECT * FROM cidades WHERE nome_cidade LIKE  ?;");
		
		PreparedStatement smt;	
		
		try {
			
			smt = conexaoBD.prepareStatement(sql);
			smt.setString(1,PalavraChave + '%');
			ConsultaCidade.add(PercorreTabela(smt));
			smt.close();
			
			
		} catch (SQLException e) {
			System.err.println("Erro ao listar cidades que começam com " +PalavraChave);
			System.err.println(e.getMessage());
			
		}
		
		return ConsultaCidade;
		
		
		
	}
	
	public int ConsultaQtdEstado(String SiglaEstado){
		
		String sql = ("SELECT COUNT(*) as Contagem FROM cidades WHERE sigla_estado = ?");
		
		PreparedStatement smt;	
		
		try {
			
			smt = conexaoBD.prepareStatement(sql);
			smt.setString(1,SiglaEstado);	
			ResultSet rs = smt.executeQuery();
			rs.next();
			return rs.getInt("Contagem");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Erro ao consultar tabela");
			
		}
		
		return 0;
		
		
	}
	
	
	public List<CidadeTabela> ConsultaFiltradaPorCidadeCapital(boolean EhCapital){

		List<CidadeTabela>cidadesCapital = new ArrayList<>();
		
		String sql = ("SELECT * FROM cidades WHERE Capital =  ?;");
		
		PreparedStatement smt;	
		
		try {
			
			smt = this.conexaoBD.prepareStatement(sql);
			smt.setBoolean(1, EhCapital);
			ResultSet rs = smt.executeQuery();
			cidadesCapital.add(PercorreTabela(smt));
			
			smt.close();
			
			return cidadesCapital;
		} catch (SQLException e) {
			System.err.println("Erro ao listar cidades" );
			System.err.println(e.getMessage());
			
			return null;
		}
		
		
	}
	
	
	private CidadeTabela PercorreTabela(PreparedStatement smt ) {
		
		try {
			ResultSet rs = smt.executeQuery();
			
			while(rs.next()) {
				
				CidadeTabela cidade = new CidadeTabela();
				
				cidade.setDDD(rs.getInt("ddd_cidade"));
				cidade.setNomeCidade(rs.getString("nome_cidade"));
				cidade.setNumHabitantes(rs.getDouble("numero_habitantes"));
				cidade.setRenda_per_capita(rs.getDouble("renda_per_capita"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setSiglaEstado(rs.getString("sigla_estado"));
				cidade.setNomePrefeito(rs.getString("nome_prefeito"));
				return cidade;
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
		
	}


}

