
package controleficha;

public class configBusca extends Conexao {
   
    private String nome = "%";
    private String cpf = "%";
    private String cns = "%";
    private String dtNascimento = "%";

    public String getNome() {
        
        if(nome == null || nome == ""){
            nome = "%";
        }
        
        return nome;
    }

    public String getCpf() {
        
        if(cpf == null || cpf == "" || cpf == "___-___-___-__"){
            cpf = "%";
        }
        
        return cpf;
    }

    public String getCns() {
        
        if(cns == null || cns == "" || cns.length() == 0){
            cns = "%";
        }
        
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
        this.cpf = cpf;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = codeData(dtNascimento);
    }
            
    
    
}
