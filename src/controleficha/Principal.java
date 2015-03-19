
package controleficha;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Principal extends Conexao {
    
    public void CarregaTabela(JTable tblLista, configBusca objConfigBusca){

        
        ConectaBase(true);
        DefaultTableModel tblModelo = null;
        
        try{
            
            tblModelo = (DefaultTableModel) tblLista.getModel();
            tblModelo.getDataVector().removeAllElements();
            
        }catch(Exception e){
        
        }
        
        ResultSet resultado;
        

        // String sql = "SELECT * FROM pacientes ORDER BY id LIMIT 15";
        
        String sql = "SELECT * FROM pacientes WHERE CPF like '" + objConfigBusca.getCpf() + "' and "
                                                + " CNS like '" + objConfigBusca.getCns() + "' and "
                                                + " NOME like '" + objConfigBusca.getNome() + "%' and "
                                                + " DTNASCIMENTO like '" + objConfigBusca.getDtNascimento() + "' " 
                   + "ORDER BY id LIMIT 15";
        
        try {
            
            resultado = getResultSet(sql);
            
            while(resultado.next()){
            
                tblModelo.addRow(new Object[]{resultado.getString("id"),
                                              resultado.getString("FICHA"),
                                              resultado.getString("NOME"),
                                              codeData(resultado.getString("dtNascimento")),
                                              resultado.getString("CELULAR")
                                             });
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
