package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DaoGenerica {
	private Connection conexao;

	protected DaoGenerica() {
		this.conexao = new ConexaoComBanco().conectar();
	}
	
	protected Connection getConnection() {
		return conexao;
	}
	
	//basicamente ele vai receber a string do sql, e depois uma espécie de lista que vai aceitar vários parametros na hora de fazer a classe de fato ex: passageiro.getNome(), ...

	protected void insercao(String insertSql, Object... parametros) throws SQLException {
        PreparedStatement ps = 
			getConnection().prepareStatement(insertSql);

        for (int i = 0; i < parametros.length; i++) {
        	ps.setObject(i+1, parametros[i]);
        }

        ps.execute();
        ps.close();
    }

    protected void atualizacao(String updateSql, Object id, Object... parametros) throws SQLException {
        PreparedStatement ps = 
		getConnection().prepareStatement(updateSql);
			
        for (int i = 0; i < parametros.length; i++) {
        	ps.setObject(i+1, parametros[i]);
        }
        ps.setObject(parametros.length + 1, id);
        ps.execute();
        ps.close();
    }	
	
    protected void delecao(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement ps = 
		getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
        	ps.setObject(i+1, parametros[i]);
        }

        ps.execute();
        ps.close();
    }

    protected void busca(String sqlSelect, Object... parametros) throws SQLException {
        PreparedStatement ps = 
		getConnection().prepareStatement(sqlSelect);
			
        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i+1, parametros[i]);
        }

        ps.execute();
        ps.close();
        conexao.close();
    }
}
