package br.com.mesttra.principal;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.mesttra.cidadeBD.CidadeTabela;
import br.com.mesttra.cidadeDao.CidadeDAO;

public class PrincipalJDBC {
	
	private static int  EscolhaMenu() {
		Scanner tecla = new Scanner(System.in);
		
		System.out.println("-----------------------------------------------");
		System.out.println("\tBanco de Dados Cidades brasileiras\t");	
		System.out.println("-----------------------------------------------");
		
		System.out.println("0- Sair do processo\n"
				+ "1- Inserir Cidade\n"
				+ "2- Remover Cidade\n"
				+ "3- Consultar tabela cidade\n"
				+ "4- Consultar cidade pelo DDD\n"
				+ "5- Consultar cidade por palavra-chave\n");
		
	   System.out.print("Escolha o procedimento:");
	   int  menu = tecla.nextInt();
	   
	   System.out.print("\n");

		return menu ;
	
	}
	
	public static void InserirCidade(CidadeDAO cidadeDAO) {
	   Scanner tecla = new Scanner(System.in);
	  
		System.out.println("-----------------------------------");	
		System.out.println("\tInserir  cidade\t");	
		System.out.println("-----------------------------------");	
		

		System.out.print("Informe o DDD da cidade:");
		int DDD = tecla.nextInt();
		
		
		tecla.nextLine();
		System.out.print("Informe o nome da cidade:");
		String NomeCidade = tecla.nextLine();
		
		System.out.print("Informe o número de habitantes:");
		double NumHabitantes = tecla.nextDouble();
		
		System.out.print("Informe a renda per capita:");
		double RendaPerCap = tecla.nextDouble();
		
		
		System.out.print("Digite (0) caso seja uma capital ou  (1) caso não seja:");
		boolean capital = tecla.nextInt() == 0;
		
		tecla.nextLine();
		System.out.print("Informe a sigla do estado:");
		String SiglaEstado = tecla.nextLine();
		
		System.out.print("Informe o nome do prefeito:");
		String NomePrefeito =  tecla.nextLine();
		
		System.out.println("-----------------------------------------------");
		System.out.println();

		
		CidadeTabela cidade = new CidadeTabela(DDD,NomeCidade,NumHabitantes,RendaPerCap,capital,SiglaEstado,NomePrefeito);
		cidadeDAO.InserirCidade(cidade);
		
	}
	
	private static void RemoverCidade(CidadeDAO cidadeDAO, CidadeTabela cidade) {
		 Scanner tecla = new Scanner(System.in);
		  
			System.out.println("-----------------------------------");	
			System.out.println("\tRemover  cidade\t");	
			System.out.println("-----------------------------------");	
			

			System.out.print("Digite o DDD da cidade:");
			int DDD = tecla.nextInt();
			System.out.println();
			
			cidadeDAO.RemoverCidade(DDD);
	}
	
	private static int ConsultaTabelaDDD() {
		Scanner tecla = new Scanner(System.in);
		System.out.println("-----------------------------------");	
		System.out.println("\tConsultar  cidade\t");	
		System.out.println("-----------------------------------");	
			
		System.out.print("Digite o DDD da cidade:");
		int DDD = tecla.nextInt();
		System.out.println("-----------------------------------");	
		System.out.println();
		return DDD;
			
		
	}
	
	public static void main(String[] args) throws SQLException {
		 Scanner tecla = new Scanner(System.in);
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		int menu ;
		

		do {
			
			
			menu = EscolhaMenu();
			switch (menu) {
			case 1:
				
				
				InserirCidade(cidadeDAO);
				tecla.nextLine();
			
				
				
				break;

			case 2:
				
				CidadeTabela cidade = new CidadeTabela();
				RemoverCidade(cidadeDAO,cidade);
				tecla.nextLine();
			
				
				break;
				
			case 3:
				
				System.out.println(cidadeDAO.ConsultaTabela()); 
				tecla.nextLine();
				
				break;
			case 4 :
				
				System.out.println(cidadeDAO.ConsultaDDD(ConsultaTabelaDDD())); 
				tecla.nextLine();
				
				break;
			case 5 :
				
				System.out.println(cidadeDAO.ConsultaCidades(tecla.nextLine())); 
				
				break;
			case 6 :
				
				//String S = tecla.nextLine();
				//System.out.println(cidadeDAO.ConsultaCidadesFiltradasPorCapital()); 
				
				break;
				
			}
			
			
			
		}while(menu != 0);
		
	}



	
}
