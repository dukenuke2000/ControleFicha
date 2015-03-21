
package controleficha;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.h2.tools.Server;

public class Conexao extends TInputOutput {
    
    private Connection connection;
    private Statement stm;
    private ResultSet resultado;
    private Server server;
    
    private String usuario = "sa";
    private String senha = "";
    private String servidor; //= "localhost";
    private String pathDb; // = "~/saude";
 
    
    //       como usar
    //IniciaServidor(true);
    //ConectaBase(true);
    
    public Conexao(){
            
        
        File file = new File(getLocalarquivo());
        
        if(file.exists()){  //Verifica se o arquivo já existe, se nao existir ele ira criar um como modelo
            
            System.out.println("Arquivo Config.ini já existe.");
            
            //pega valor do arquivo Config.ini utilizando o metodo PegaValor() da super classe
            pathDb = PegaValor("database");
            servidor = PegaValor("servidor");
            
        }else{
            
            System.out.println("Arquivo Config.ini não existe !!!");
            
            
            try{
                
                String[] linhaConfig = {"database=~/NetBeansProjects/ControleFicha/build/classes/controleficha/saude",
                                        "servidor=localhost"
                                        };

                gravaTexto(linhaConfig);
            
                System.out.println("Arquivo Config.ini criado com sucesso...");
                
                pathDb = PegaValor("database");
                servidor = PegaValor("servidor");
                
            }catch(Exception e){
                
                System.out.println("Erro ao tentar criar Config.ini");
                
            }
            
            
            
        }
        
            
            
 
    } 
    
    public void ConectaBase(Boolean conecta){
    
        try {
        
            if(conecta){
                String ConfigCon = "jdbc:h2:tcp://" + servidor + "/" + pathDb + ";IFEXISTS=TRUE";
                System.out.println("Base de dados: " + ConfigCon);
                
              //  Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection(ConfigCon, usuario , senha);
                stm = connection.createStatement();

            }else{

                stm.close();
                connection.close();

            }
    
        } catch (SQLException ex) {
                 Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Não foi possível conectar a base de dados (" + servidor + "/" + pathDb + ")");
            }
    
    }
    
    public ResultSet getResultSet(String sql) throws SQLException{
        
       // ConectaBase(true);
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    };
    
    public void setInsertPs(String sql, List parametros) throws SQLException{
        
        ConectaBase(true);
        
        PreparedStatement ps = connection.prepareStatement(sql);
        
        for(int x=0 ; x<parametros.size() ; x++){
            ps.setString(x + 1 , parametros.get(x).toString());
        }
        
        ps.execute();
       
        
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void IniciaServidor(Boolean start){
    
        if(start){
            
            try {
                server = Server.createTcpServer().start();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
        
            server.stop(); 
            
        }
        
    }
    
    public String codeData(String data){
    
        String dataCorrigido = "";
        
        if(data != null){
        
            String dataInternacianal[] = data.split("-");
            String dataNacional[] = data.split("/");

            

            try{

                dataCorrigido = dataInternacianal[2] + "/" + dataInternacianal[1] + "/" + dataInternacianal[0];

            }catch(Exception e){

                dataCorrigido = dataNacional[2] + "-" + dataNacional[1] + "-" + dataNacional[0];

            }

        }
            return dataCorrigido;
    }
    
    
    
}
