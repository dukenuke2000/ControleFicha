
package controleficha;

import javax.swing.JOptionPane;

public class configBusca extends Conexao {
   
    private String nome = "";
    private String cpf = "";
    private String cns = "";
    private String dtNascimento = "";

    public String getNome() {
        return nome.toUpperCase();
    }

    public String getCpf() {
        return cpf;
    }

    public String getCns() {
        return cns;
    }

    public String getDtNascimento() {
        
        if(dtNascimento == null || dtNascimento == ""){
        dtNascimento = "%";
        }
        
        return dtNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        
        if(cpf == null || cpf == "" || cpf.equals("___-___-___-__")){
            cpf = "%";                      
        }else{
            
            if(!CpfCnpj.isValidCPF(cpf)){
                JOptionPane.showMessageDialog(null, "CPF inválido");
            }else{
               // JOptionPane.showMessageDialog(null, "CPF Válido");
            };
            
        }
        
        this.cpf = cpf;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = codeData(dtNascimento);
    }
                
   
}
