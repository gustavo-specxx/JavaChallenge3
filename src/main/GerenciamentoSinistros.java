package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import conn.ConnectionFactory;

public class GerenciamentoSinistros {

	public static void main(String[] args) throws SQLException{

		System.out.println("digite x");
		String x = scan.nextLine();
		
		
		Connection conn = new ConnectionFactory().criaConexao();
		System.out.println("Conectou" + x);
		conn.close();
		
	}

}
