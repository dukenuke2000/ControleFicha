
package controleficha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class paciente extends Conexao {
    
    int id ;
    private String ficha;
    private String cpf;
    private String cns;
    private String nome;
    private String obs;
    private String telefone1;
    private String telefone2;
    private String celular;
    private String dtNascimento;

    public String getDtNascimento() {
        return dtNascimento;
    }
    
    public int getId() {
        return id;
    }

    public String getFicha() {
        return ficha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCns() {
        return cns;
    }

    public String getNome() {
        return nome.toUpperCase();
    }

    public String getObs() {
        return obs;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public String getCelular() {
        return celular;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public void salvar(){
    
        ConectaBase(true);
        
        String sql = "INSERT INTO pacientes(FICHA,"
                                           + "CPF,"
                                           + "CNS,"
                                           + "NOME,"
                                           + "OBS,"
                                           + "TELEFONE1,"
                                           + "TELEFONE2,"
                                           + "CELULAR, "
                                           + "DTNASCIMENTO) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, this.ficha);
            ps.setString(2, this.cpf);
            ps.setString(3, this.cns);
            ps.setString(4, this.nome);
            ps.setString(5, this.obs);
            ps.setString(6, this.telefone1);
            ps.setString(7, this.telefone2);
            ps.setString(8, this.celular);
            ps.setString(9, codeData(this.dtNascimento));
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void autoCarregar(int id){
    
        String sql = "SELECT * FROM pacientes WHERE id = " + id;
        
        try {
            
            ConectaBase(true);
            ResultSet resultado = getResultSet(sql);
            
            while(resultado.next()){
                
                this.setCelular(resultado.getString("CELULAR"));
                this.setCns(resultado.getString("CNS"));
                this.setCpf(resultado.getString("CPF"));
                this.setFicha(resultado.getString("FICHA"));
                this.setId(resultado.getInt("ID"));
                this.setNome(resultado.getString("NOME"));
                this.setObs(resultado.getString("OBS"));
                this.setTelefone1(resultado.getString("TELEFONE1"));
                this.setTelefone2(resultado.getString("TELEFONE2"));
                this.setDtNascimento(codeData(resultado.getString("DTNASCIMENTO")));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    public void atualizar(int id){
    
        String sql = "UPDATE pacientes SET FICHA = ?,"
                                        + "CNS = ?,"
                                        + "NOME = ?,"
                                        + "OBS = ?,"
                                        + "TELEFONE1 = ?,"
                                        + "TELEFONE2 = ?,"
                                        + "CELULAR = ?,"
                                        + "DTNASCIMENTO = ?,"
                                        + "CPF = ? "
                    + "WHERE id = " + id;
        
      
        try {
            
            PreparedStatement ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, this.getFicha());
            ps.setString(2, this.getCns());
            ps.setString(3, this.getNome());
            ps.setString(4, this.getObs());
            ps.setString(5, this.getTelefone1());
            ps.setString(6, this.getTelefone2());
            ps.setString(7, this.getCelular());
            ps.setString(8, codeData(this.getDtNascimento()));
            ps.setString(9, this.getCpf());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    }
    
    public void excluir(int id){
    
        String sql = "DELETE FROM pacientes WHERE id = ?";
        
        
        try {
            
            PreparedStatement ps = getConnection().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
}
