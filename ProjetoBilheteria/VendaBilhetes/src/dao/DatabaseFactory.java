package dao;

public class DatabaseFactory {
    public static Database getDatabase(String nome){
        if(nome.equals("mysql")){
            return new ConexaoComBanco();
        }
        return null;
    }
}
