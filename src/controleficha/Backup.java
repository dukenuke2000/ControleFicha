package controleficha;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Backup extends Conexao {
    
    public void GeraBackup(String Caminho){
    
        ConectaBase(true);
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dataAtual = sdf.format(data);
        
        
        String auxCaminho = Caminho + "_" +dataAtual + ".sql'";
        String sql = "SCRIPT TO '" + auxCaminho;
        
        System.out.println("Sql : " + sql);
        
        try {
            
            getStm().execute(sql);
            
            JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.\n" + auxCaminho);
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Falha ao tentar realizar o backup");
            
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void RestauraBackup(String Caminho){
    
        ConectaBase(true);
        
        String sql = "RUNSCRIPT FROM '" + Caminho + "'"; 
       
        try {
            
            getStm().execute(sql);
            
            JOptionPane.showMessageDialog(null, "Backup restaurado com sucesso.");
            
         } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Falha ao tentar restaurar o Backup");
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    
}
