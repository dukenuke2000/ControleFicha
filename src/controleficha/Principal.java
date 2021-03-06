
package controleficha;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        String sql = "SELECT ID,"
                          + "FICHA,"
                          + "CPF,"
                          + "CNS,"
                          + "upper(NOME) as NOME,"
                          + "OBS,"
                          + "TELEFONE1,"
                          + "TELEFONE2,"
                          + "CELULAR,"
                          + "DTNASCIMENTO FROM pacientes WHERE CPF like '" + objConfigBusca.getCpf() + "%' and "
                                                                           + " CNS like '" + objConfigBusca.getCns() + "%' and "
                                                                           + " upper(NOME) like '" + objConfigBusca.getNome().toUpperCase() + "%' "
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
