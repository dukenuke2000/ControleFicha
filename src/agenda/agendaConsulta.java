
package agenda;

import controleficha.paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class agendaConsulta extends medico {

    public List CarregaComboMedico(int idMedico,JComboBox cmbMedico) throws SQLException{
    
        List lstId = new ArrayList();
        String sql = "SELECT ID,NOME FROM MEDICOS WHERE FK_ESPCIALIDADE = " + idMedico;
        
        cmbMedico.removeAllItems();
        
        cmbMedico.addItem("Selecione");
        lstId.add(0);
    
        ResultSet resultado = getResultSet(sql);
        
        while(resultado.next()){
        
            cmbMedico.addItem(resultado.getString("NOME"));
            lstId.add(resultado.getInt("ID"));
            
        }
       
        return lstId;
    }    
    
    public void CarregaTabelaAgenda(JTable tblAgenda,int idMedico, Calendar dataConsulta) throws SQLException{
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        DefaultTableModel mdlAgenda = (DefaultTableModel) tblAgenda.getModel();
        mdlAgenda.setNumRows(0);
        
        String sql = "SELECT * FROM AGENDA "
                   + "LEFT JOIN PACIENTES ON PACIENTES.ID = AGENDA.FK_PACIENTE "
                    + "WHERE FK_MEDICO = " + idMedico + " and "
                         + "DATACONSULTA = '" + sdf.format(dataConsulta.getTime()) + "' "
                         + "and HORA <> '' "
                    + "ORDER BY agenda.id";
        
        
        ConectaBase(true);
        
        ResultSet resultado = getResultSet(sql);
        
        while(resultado.next()){
        
            mdlAgenda.addRow(new Object[]{
                                          resultado.getString("ID"),
                                          resultado.getString("HORA"),
                                          resultado.getString("FK_PACIENTE"),
                                          resultado.getString("NOME"),
                                          resultado.getString("CPF")
                                         });
        
        }
    
    }
    
public void AgendaPaciente(int idHoraAgenda, int idPaciente, String Observacao) throws SQLException{

    ConectaBase(true);
    
    String sql = "update AGENDA "
                     + "set FK_PACIENTE = ?, "
                         + "OBS = ?"
               + "where ID = ?";
    
    PreparedStatement ps = getConnection().prepareStatement(sql);
    
    ps.setInt(1, idPaciente);
    ps.setString(2, Observacao);
    ps.setInt(3, idHoraAgenda);
    
    ps.execute();

}

public void RemoveAgendaPacinete(int idHoraAgenda) throws SQLException{

    String sql = "update AGENDA set FK_PACIENTE = null, OBS = null where ID = " + idHoraAgenda;
    
    getStm().executeUpdate(sql);

}
    
}
