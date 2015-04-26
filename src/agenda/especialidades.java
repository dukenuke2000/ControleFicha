 
package agenda;

import controleficha.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public class especialidades extends Conexao {
    
    private int id;
    private String especialidade;

    public int getId() {
        return id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void GravaEspecialidade() throws SQLException{
    
        ConectaBase(true);
        
        String sql = "INSERT INTO ESPECIALIDADES(ESPECIALIDADE) VALUES(?)";
        
        PreparedStatement ps = getConnection().prepareStatement(sql);
        
        ps.setString(1, this.especialidade);
        
        ps.execute();
        
    }
    
    public List CarregaListaEspecialidade(JList lstEspecialidade) throws SQLException{
    
        List lstId = new ArrayList();
        DefaultListModel<String> mdlEspecialidade = new DefaultListModel<>();
        
        ConectaBase(true);
        
        String sql = "SELECT * FROM ESPECIALIDADES";
        
        ResultSet resultado = getResultSet(sql);
        
        while(resultado.next()){
        
           mdlEspecialidade.addElement(resultado.getString("ESPECIALIDADE"));
           lstId.add(resultado.getString("ID"));
           
        }
        
        lstEspecialidade.setModel(mdlEspecialidade);
        
    return lstId;
    }
    
    public void removeEspecialidade(int idEspecialidade) throws SQLException{
    
        String sql = "DELETE FROM ESPECIALIDADES WHERE ID = " + idEspecialidade;
        
        getStm().executeUpdate(sql);
    
    }
    
}
