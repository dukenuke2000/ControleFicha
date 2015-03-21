
package controleficha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.h2.tools.Server;

public class ConexaoBkp {
    
    private Connection connection;
    private Statement stm;
    private ResultSet resultado;
    private Server server;
    
    private String usuario = "sa";

    public Statement getStm() {
        return stm;
    }
    private String senha = "";
    private String servidor = "localhost";
  //  private String pathDb = "~/saude";
  
                                    //windows
//  private String pathDb = "C:\\Users\\a807192\\Documents\\NetBeansProjects\\ControleFicha\\saude";
                                    //Linux
    private String pathDb = "~/saude";
   // private String pathDb = "localhost/~/test";
    
    //       como usar
    //IniciaServidor(true);
    //ConectaBase(true);
    
    public ConexaoBkp() {
        
    } 
    
    public void ConectaBase(Boolean conecta){
    
        try {
        
            if(conecta){

              //  Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection("jdbc:h2:tcp://" + servidor + "/" + pathDb + ";IFEXISTS=TRUE", usuario , senha);
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
    
    public boolean validaData(String data){
    
        boolean flag = true;
        
        SimpleDateFormat df = new SimpleDateFormat("##/##/####");
        df.setLenient(false);
        
        try{
    
            Date Data = df.parse(data);
            flag = true;
            
        }catch(Exception e){
            flag = false;   
        }
        
    return flag;
    }
    
    
}
