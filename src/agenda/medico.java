
package agenda;

import controleficha.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class medico extends Conexao {
    
    private int id;
    private String nome;
    private int especialidade;
    private String NomeEspecialidade;
    private String telefone;
    private String celular;
    private String status;
    private String observacao;
    private JTable tblSegunda;
    private JTable tblTerca;
    private JTable tblQuarta;
    private JTable tblQuinta;
    private JTable tblSexta;
    private JTable tblSabado;
    private JTable tblDomingo;

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public JTable getTblSegunda() {
        return tblSegunda;
    }

    public JTable getTblTerca() {
        return tblTerca;
    }

    public JTable getTblQuarta() {
        return tblQuarta;
    }

    public JTable getTblQuinta() {
        return tblQuinta;
    }

    public JTable getTblSexta() {
        return tblSexta;
    }

    public JTable getTblSabado() {
        return tblSabado;
    }

    public JTable getTblDomingo() {
        return tblDomingo;
    }

    public String getNomeEspecialidade() {
        return NomeEspecialidade;
    }

    public void setNomeEspecialidade(String NomeEspecialidade) {
        this.NomeEspecialidade = NomeEspecialidade;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setTblSegunda(JTable tblSegunda) {
        this.tblSegunda = tblSegunda;
    }

    public void setTblTerca(JTable tblTerca) {
        this.tblTerca = tblTerca;
    }

    public void setTblQuarta(JTable tblQuarta) {
        this.tblQuarta = tblQuarta;
    }

    public void setTblQuinta(JTable tblQuinta) {
        this.tblQuinta = tblQuinta;
    }

    public void setTblSexta(JTable tblSexta) {
        this.tblSexta = tblSexta;
    }

    public void setTblSabado(JTable tblSabado) {
        this.tblSabado = tblSabado;
    }

    public void setTblDomingo(JTable tblDomingo) {
        this.tblDomingo = tblDomingo;
    }
    
public void GravaMedico(){

    ConectaBase(true);
    
    String sql = "INSERT INTO medicos(NOME, "
                                   + "FK_ESPCIALIDADE, "
                                   + "TELEFONE, "
                                   + "CELULAR, "
                                   + "OBS) "
               + "VALUES(?,?,?,?,?)";
    
        try {
            
            PreparedStatement ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, this.getNome());
            ps.setInt(2, this.getEspecialidade());
            ps.setString(3, this.getTelefone());
            ps.setString(4, this.getCelular());
            ps.setString(5, this.getObservacao());
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    

}   

public List carregaComboEspecialidades(JComboBox cmbEspecialidades){
    
        
    List listaEsp = new ArrayList();
    cmbEspecialidades.removeAllItems();
    

    ConectaBase(true);
    String sql = "SELECT * FROM ESPECIALIDADES";
    
        try {
            
            ResultSet resultado = getStm().executeQuery(sql);
            
            while(resultado.next()){
            
                cmbEspecialidades.addItem(resultado.getString("ESPECIALIDADE"));
                listaEsp.add(resultado.getString("id"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    
return listaEsp;
}

public void CarregaTabelaMedicos(JTable tblMedicos){

    DefaultTableModel tblModelo = (DefaultTableModel) tblMedicos.getModel();
    tblModelo.setNumRows(0);
    
    String sql = "SELECT medicos.id, medicos.nome, medicos.celular, especialidades.especialidade FROM medicos " +
                 "INNER JOIN especialidades ON medicos.FK_ESPCIALIDADE = ESPECIALIDADES.id";
    
    ConectaBase(true);
    
    ResultSet resultado;
        try {
            
            resultado = getResultSet(sql);
            
            while(resultado.next()){
    
                tblModelo.addRow(new Object[]{resultado.getString("id"),
                                              resultado.getString("nome"),
                                              resultado.getString("celular"),
                                              resultado.getString("especialidade")
                                              });
        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    

}

/**
 * Carrega o objeto medico (this) a partir da base de dados
 * @param id código do médico a ser carregado
 */

public void AutoCarregarObj(int id){

    String sql = "SELECT medicos.ID as medicosId,"
                      + "medicos.NOME,"
                      + "medicos.TELEFONE,"
                      + "medicos.CELULAR,"
                      + "medicos.OBS,"
                      + "ESPECIALIDADES.ID as espId,"
                      + "ESPECIALIDADES.ESPECIALIDADE "
               + "FROM medicos "
               + "INNER JOIN especialidades on medicos.FK_ESPCIALIDADE = ESPECIALIDADES.id "
               + "where medicos.id = " + id;
    
        try {
            
            ResultSet resultado = getResultSet(sql);
            
            while(resultado.next()){
            
                this.setId(resultado.getInt("medicosId"));
                this.setNome(resultado.getString("nome"));
                this.setTelefone(resultado.getString("telefone"));
                this.setCelular(resultado.getString("celular"));
                this.setObservacao(resultado.getString("obs"));
                this.setEspecialidade(resultado.getInt("espId"));
                this.setNomeEspecialidade(resultado.getString("ESPECIALIDADE"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    

}
    
}
