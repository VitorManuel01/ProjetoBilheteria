package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Passageiro;


public class PassageiroDao extends DaoGenerica {
	
    
	public void inserir(Passageiro passageiro) throws SQLException {
            PreparedStatement ps1 = getConnection().prepareStatement("CREATE DATABASE IF NOT EXISTS Bilheteria;");
            PreparedStatement ps2 = getConnection().prepareStatement("USE Bilheteria;");
            PreparedStatement ps3 = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS passageiro (id BIGINT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255),CPF VARCHAR(14), EMAIL VARCHAR(255), TELEFONE VARCHAR(255) , USUARIO VARCHAR(30), SENHA VARCHAR(15), dtNascimento Date, numeroCartao VARCHAR(16));"); 
			ps1.execute();
			ps2.execute();
			ps3.execute();
			String insert = "INSERT INTO Bilheteria.passageiro (nome, CPF, EMAIL, TELEFONE, USUARIO, SENHA, dtNascimento, numeroCartao) VALUES(?,?,?,?,?,?,?,?)";
            insercao(insert, passageiro.getNome(), passageiro.getCPF(), passageiro.getEmail(), passageiro.getTelefone(), passageiro.getUsuario(), passageiro.getSenha(), passageiro.getDataNascimento(), passageiro.getNumeroCartao());
            
	}
	
	public void alterar(Passageiro passageiro) throws SQLException {
	    PreparedStatement ps1 = getConnection().prepareStatement("CREATE DATABASE IF NOT EXISTS Bilheteria;");
	    PreparedStatement ps2 = getConnection().prepareStatement("USE Bilheteria;");
	    PreparedStatement ps3 = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS passageiro (id BIGINT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255),CPF VARCHAR(14), EMAIL VARCHAR(255), TELEFONE VARCHAR(255) , USUARIO VARCHAR(30), SENHA VARCHAR(15), dtNascimento Date, numeroCartao VARCHAR(16));"); 
	    ps1.execute();
	    ps2.execute();
	    ps3.execute();
	    
	    String update = "UPDATE Bilheteria.passageiro " + 
	    	    "SET nome = ?, CPF = ?, EMAIL = ?, TELEFONE = ?, USUARIO = ?, dtNascimento = ?, numeroCartao = ? " + 
	    	    "WHERE id = ?;";
	    
	    atualizacao(update,passageiro.getId(), 
	            passageiro.getNome(), 
	            passageiro.getCPF(), 
	            passageiro.getEmail(), 
	            passageiro.getTelefone(), 
	            passageiro.getUsuario(), 
	            passageiro.getDataNascimento(), 
	            passageiro.getNumeroCartao());
	}

    public void remover(Passageiro passageiro) throws SQLException {
        String deleteSql = "DELETE FROM Bilheteria.passageiro WHERE id = ?";
        
        delecao(deleteSql, passageiro.getId());

    }
	
	public List<Passageiro> listarPassageiros() {
		List<Passageiro> passageiros = new ArrayList<Passageiro>();
		String sqlSelect = "select * from Bilheteria.passageiro;";
		
		
		try (PreparedStatement ps = getConnection().prepareStatement(sqlSelect)){
					
			ResultSet retorno = ps.executeQuery();			
			while(retorno.next()) {		
				Passageiro passageiro= new Passageiro();
				passageiro.setId(retorno.getLong("id"));
				passageiro.setNome(retorno.getString("nome"));
				passageiro.setCPF(retorno.getString("CPF"));
				passageiro.setEmail(retorno.getString("EMAIL"));
				passageiro.setTelefone(retorno.getString("TELEFONE"));
				passageiro.setUsuario(retorno.getString("USUARIO"));
				passageiro.setSenha(retorno.getString("SENHA"));
				passageiro.setDataNascimento(retorno.getDate("dtNascimento"));
				passageiro.setNumeroCartao(retorno.getString("numeroCartao"));
				
				passageiros.add(passageiro);
			}
        } catch (SQLException e) {
        	throw new RuntimeException("Erro ao executar SQL: " + e.getMessage(), e);
        }
		return passageiros;
	}
}
