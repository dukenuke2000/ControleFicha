
package controleficha;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal extends Conexao {
    
    public void CarregaTabela(JTable tblLista, configBusca objConfigBusca) throws SQLException{

        String auxSqlData = "";
        ConectaBase(true);
        DefaultTableModel tblModelo = null;
        ResultSet resultado;
        

        // String sql = "SELECT * FROM pacientes ORDER BY id LIMIT 15";
        
        if(objConfigBusca.getDtNascimento() != "%"){
            auxSqlData = "and DTNASCIMENTO like '" + objConfigBusca.getDtNascimento() + "' ";
        }
        
        String sql = "SELECT * FROM pacientes WHERE CPF like '" + objConfigBusca.getCpf() + "%' and "
                                                + " CNS like '" + objConfigBusca.getCns() + "%' and "
                                                + " NOME like '" + objConfigBusca.getNome() + "%' "
                                                +  auxSqlData 
                   + "ORDER BY id DESC LIMIT 15";
        
        System.out.println(sql);
        

            
            tblModelo = (DefaultTableModel) tblLista.getModel();
            tblModelo.setNumRows(0);
            
            resultado = getResultSet(sql);
            
            while(resultado.next()){
            
                tblModelo.addRow(new Object[]{resultado.getString("id"),
                                              resultado.getString("FICHA"),
                                              resultado.getString("NOME"),
                                              codeData(resultado.getString("dtNascimento")),
                                              resultado.getString("CELULAR")
                                             });
                
            }
            
        
    }
    
}
