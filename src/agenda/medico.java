
package agenda;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import controleficha.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class medico extends Conexao {
    
    public static final int DOMINGO = 1; 
    public static final int SEGUNDA = 2; 
    public static final int TERCA = 3; 
    public static final int QUARTA = 4; 
    public static final int QUINTA = 5; 
    public static final int SEXTA = 6; 
    public static final int SABADO = 7; 
    
    private int id;
    private String nome;
    private int especialidade;
    private String NomeEspecialidade;
    private String telefone;
    private String celular;
    private String status;
    private String observacao;

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

    
public void GravaMedico(){

    ConectaBase(true);
    
    String sql = "INSERT INTO medicos(NOME, "
                                   + "FK_ESPCIALIDADE, "
                                   + "TELEFONE, "
                                   + "CELULAR, "
                                   + "OBS, "
                                   + "ID, "
                                   + "ATIVO) "
               + "VALUES(?,?,?,?,?,?,?)";
    
        try {
            
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setString(1, this.getNome());
            ps.setInt(2, this.getEspecialidade());
            ps.setString(3, this.getTelefone());
            ps.setString(4, this.getCelular());
            ps.setString(5, this.getObservacao());
            ps.setInt(6, this.getId());
            ps.setString(7, this.getStatus());
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    

}   

public List carregaComboEspecialidades(JComboBox cmbEspecialidades){
    
        
    List listaEsp = new ArrayList();
    cmbEspecialidades.removeAllItems();
    
    cmbEspecialidades.addItem("Selecione");
    listaEsp.add("0");

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
    
    String sql = "SELECT medicos.id, "
                      + "medicos.nome, "
                      + "medicos.celular, "
                      + "especialidades.especialidade "
               + "FROM medicos " +
                 "INNER JOIN especialidades ON medicos.FK_ESPCIALIDADE = ESPECIALIDADES.id ORDER BY medicos.id";
    
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
                      + "medicos.ATIVO,"
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
                this.setStatus(resultado.getString("ATIVO"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    

}

public void AtualizaMedico(){

    String sql = "UPDATE medicos SET NOME = ?, "
                                   + "TELEFONE = ?, "
                                   + "CELULAR = ?, "
                                   + "OBS = ?, "
                                   + "FK_ESPCIALIDADE = ?, "
                                   + "ATIVO = ? "
               + "WHERE ID = ?";
    
        try {
            
            PreparedStatement ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, this.getNome());
            ps.setString(2, this.getTelefone());
            ps.setString(3, this.getCelular());
            ps.setString(4, this.getObservacao());
            ps.setInt(5, this.getEspecialidade());
            ps.setString(6, this.getStatus());
            ps.setInt(7, this.getId());
            
            ps.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }

}

public void gravaAgendaMedico(JTable tblDiaMes, Calendar dataConsulta, int fk_medico) throws SQLException{

    dataConsulta.set(Calendar.DAY_OF_MONTH, 1);
    
    String mes = String.valueOf(dataConsulta.get(Calendar.MONTH) + 1);
    String ano = String.valueOf(dataConsulta.get(Calendar.YEAR));
    
    
    for (int coluna = 0; coluna < tblDiaMes.getColumnCount(); coluna++) {
        
        for (int linha = 0; linha < tblDiaMes.getRowCount(); linha++) {

            try {
                
                if (tblDiaMes.getValueAt(linha, coluna) != null) {
                    
                    String hora = tblDiaMes.getValueAt(linha, coluna).toString();
                    String dia = String.valueOf(dataConsulta.get(Calendar.DAY_OF_MONTH));

                    String dataConsultaF = ano + "-" + mes + "-" + dia;
                    System.out.println("Data formatada para o banco: " + dataConsultaF);
                    System.out.println("Hora: " + hora);

                    gravaLinhaAgendaMedico(hora, dataConsultaF, fk_medico);

                }else{
                    
                    String dia = String.valueOf(dataConsulta.get(Calendar.DAY_OF_MONTH));

                    String dataConsultaF = ano + "-" + mes + "-" + dia;
                    gravaLinhaAgendaMedico("", dataConsultaF, fk_medico); 
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            

        
        }
        
    dataConsulta.add(Calendar.DAY_OF_MONTH, 1);
    
    }

}

private void gravaLinhaAgendaMedico(String HoraInicio, String DataConsulta, int fk_medico) throws SQLException{

    ConectaBase(true);
    
    String sql = "INSERT INTO AGENDA (HORA, "
                                   + "FK_MEDICO, "
                                   + "DATACONSULTA) "
               + "VALUES (?,?,?)";
    
    PreparedStatement ps = getConnection().prepareStatement(sql);
    
    ps.setString(1, HoraInicio); 
    ps.setInt(2, fk_medico);
    ps.setString(3, DataConsulta);
    
    ps.execute();

    System.out.println("Agenda gravada com sucesso.");
    
}

public void CarregaTabelaSemana(int idMedico, int Semana, JTable tblDiaMes) throws SQLException{

    DefaultTableModel tblModel = (DefaultTableModel) tblDiaMes.getModel();
    tblModel.setNumRows(0);
    
    String Sql = "SELECT * FROM AGENDAMEDICO "
               + "WHERE DIASEMANA = " + String.valueOf(Semana) 
               + " and FK_MEDICO = " + idMedico;
    
    ResultSet resultado = getResultSet(Sql);
    
    while(resultado.next()){
    
        tblModel.addRow(new Object[]{resultado.getString("HORAINICIO"),
                                     resultado.getString("HORAFIM")});
        
    }

}

public int PegaUltimoId(){

    String sql = "select max(id) + 1 as newId from medicos";
    int retorno = 0;
        try {
            
            ResultSet resultado = getResultSet(sql);
            while(resultado.next()){
                
                retorno = resultado.getInt("newId");
                
            }   } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
        }

    return retorno;
}

public List carregaTabelaDias(Calendar calendario, int idMedico, jtablemask.JtableMask tblDia) throws SQLException{
    
    int linha;
    DefaultTableModel dtmDia = new DefaultTableModel();
    
    List<Linha_Coluna> listCampoId = new ArrayList<Linha_Coluna>();
    Linha_Coluna objCampoid;
    
    dtmDia.setNumRows(20);
    
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    calendario.set(Calendar.DAY_OF_MONTH, 1);
    
    
    for(int coluna=0 ; coluna<calendario.getActualMaximum(Calendar.DAY_OF_MONTH) ; coluna++){
        
        linha = 0;
        String dataConsulta = sdf.format(calendario.getTime());
        
        String sql = "select ID,HORA from AGENDA "
                   + "WHERE DATACONSULTA = '" + dataConsulta + "' "
                   + "and fk_medico = " + String.valueOf(idMedico)
                   + " order by id";

        ResultSet resultado = getResultSet(sql);
        
        
       // if (resultado.getRow() != 0) {

            while (resultado.next()) {

//                System.out.println("cont = " + cont + " diaCont = " + diaCont);
//                System.out.println("hora = " + resultado.getString("HORA"));
                
                try {
                    
                    objCampoid = new Linha_Coluna();
                    
                    objCampoid.setLinha(linha);
                    objCampoid.setColuna(coluna);
                    objCampoid.setId(resultado.getInt("ID"));
                    
                    tblDia.setValueAt(resultado.getString("HORA"), linha, coluna);
                    
                    listCampoId.add(objCampoid);
                    
                } catch (Exception e) {
                }
                
                linha++;
                
            }

      //  }
        calendario.add(Calendar.DAY_OF_MONTH, 1);
    }

    return listCampoId;
}
    
public void AlteraAgenda(List<Linha_Coluna> linhaColuna, JTable tblDias) throws SQLException{
    
    String valorCampo;
    
    for(int x=0 ; x<linhaColuna.size() ; x++){
        
        try{
            valorCampo = tblDias.getValueAt(linhaColuna.get(x).getLinha(), linhaColuna.get(x).getColuna()).toString();
        }catch(Exception e){
            valorCampo = "";
        }
        
        String sql = "UPDATE AGENDA SET HORA = '" + valorCampo + "' WHERE ID = " + linhaColuna.get(x).getId();
    
        this.getStm().executeUpdate(sql);
    
        System.out.println("Tabela linha: " + tblDias.getSelectedRow() + " coluna : " + tblDias.getSelectedColumn());
        System.out.println("Objeto linha: " + linhaColuna.get(x).getLinha() + " coluna : " + linhaColuna.get(x).getColuna());
        System.out.println("Valor do campo: " + valorCampo);
        
    }
    
    
    
    

}


}
