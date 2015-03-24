package controleficha;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Backup extends Conexao {
    
    public void GeraBackup(String Caminho){
    
        ConectaBase(true);
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dataAtual = sdf.format(data);
        
        
        
        String sql = "SCRIPT TO '" + Caminho + "_" +dataAtual + ".sql'";
        
        System.out.println("Sql : " + sql);
        
        try {
            getStm().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void RestauraBackup(String Caminho){
    
        ConectaBase(true);
        
        String sql = "RUNSCRIPT FROM '" + Caminho + "'"; 
       
        try {
            getStm().execute(sql);
         } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    
}