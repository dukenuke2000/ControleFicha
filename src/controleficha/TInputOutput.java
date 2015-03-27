package controleficha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;



public class TInputOutput {
    
    private String localarquivo = "/" + this.getApplicationPath() + "/Config.ini";

    
        public TInputOutput(){ // Construtor

            System.out.println("Arquivo de Configuração : " + getLocalarquivo());

        }
     
        
        
    public void setLocalarquivo(String localarquivo) {
        this.localarquivo = localarquivo;
    }

    public String getLocalarquivo() {
        return localarquivo;
    }
    
  //  public TInputOutput(String LocalArquivo){  //LocalArquivo Ex: /home/ricardo/teste.ini
    
   // localarquivo = LocalArquivo;
    
   // }

    public void gravaTexto(String[] texto){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(localarquivo));
            
            for(int x=0 ; x<texto.length ;x++){
            bw.write(texto[x],0, texto[x].length());
            bw.newLine();
            }
            
            bw.flush();
            bw.close();
            
            } catch (IOException ex) {
                                     Logger.getLogger(TInputOutput.class.getName()).log(Level.SEVERE, null, ex);
                                       }
        
        
    }
    
    public String LeTexto(){
       
        String texto = "";
        
        try {
          //  /home/ricardo/teste.ini
            FileReader fr = new FileReader(localarquivo);
            BufferedReader br = new BufferedReader(fr);
            try {
              
                do{
                    
                 texto = texto + br.readLine() + "\n";                
        
                  }while(br.ready());
                
                    } catch (IOException ex) {
                        Logger.getLogger(TInputOutput.class.getName()).log(Level.SEVERE, null, ex);     
                        }
                    
           
            
            } catch (FileNotFoundException ex) {
                                                Logger.getLogger(TInputOutput.class.getName()).log(Level.SEVERE, null, ex);
                                                }
        return texto;
        
    }
    
    public List LeTextoArray(){
       
        
        List lista = new ArrayList();
        
        try {
            
            FileReader fr = new FileReader(localarquivo);
            BufferedReader br = new BufferedReader(fr);
            try {
              
                  do{
                    
                  lista.add(br.readLine());                
                
                  }while(br.ready());
                
                    } catch (IOException ex) {
                        Logger.getLogger(TInputOutput.class.getName()).log(Level.SEVERE, null, ex);     
                        }
                    
           
            
            } catch (FileNotFoundException ex) {
                                                Logger.getLogger(TInputOutput.class.getName()).log(Level.SEVERE, null, ex);
                                                }
        return lista;
        
    }
    
    public String PegaValor(String Campo){  // pega o valor da linha no arquivo de texto e separa 
                                             // antes do sinal "=" campo
                                             // depois do sinal "=" valor
        String resultado = null;
        List ArrayL = this.LeTextoArray();
        String[] Lcampo = new String[ArrayL.size()];
        String[] Lvalor = new String[ArrayL.size()];
        
        for(int x=0 ; x<ArrayL.size() ; x++){
        
            Lcampo[x] =  ArrayL.get(x).toString().substring(0, ArrayL.get(x).toString().indexOf('='));
            Lvalor[x] =  ArrayL.get(x).toString().substring( ArrayL.get(x).toString().indexOf('=') +1 ,  ArrayL.get(x).toString().length());
         
        }
    
        for(int x=0 ; x<ArrayL.size() ; x++){
        
            if(Campo.equals(Lcampo[x])){
            
                resultado = Lvalor[x];
                
            
            }
        
        }
        
        return resultado;
    }
    
//    public String Codifica(String Senha){
//        String Codigo = null;
//
//        BASE64Encoder encoder = new BASE64Encoder();
//        String encodedBytes = encoder.encodeBuffer(Senha.getBytes());
//     // System.out.println("encodedBytes " + encodedBytes);
//      Codigo = encodedBytes;
//         
//        return Codigo;
//    
//    }
    
//    public String Decodifica(String Senha){
//    String codigo = null;
//    
//    BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            byte[] decodedBytes = decoder.decodeBuffer(Senha);
//            codigo = new String(decodedBytes);
//            
//            } catch (IOException ex) {
//                    Logger.getLogger(TInputOutput.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//    
//    return codigo;
//    }
    
    public String CaminhoExe(){
    
    return System.getProperty("user.dir");
    
    }
    
     public String getApplicationPath() {  
      String url = getClass().getResource(getClass().getSimpleName() + ".class").getPath();  
        File dir = new File(url).getParentFile();  
        String path = null;  
          
        if (dir.getPath().contains(".jar"))  
            path = findJarParentPath(dir);  
        else  
            path = dir.getPath();  
  
        try {  
            return URLDecoder.decode(path, "UTF-8");  
        }  
        catch (UnsupportedEncodingException e) {                  
            return path.replace("%20", " ");  
        }  
   }  
     
    private String findJarParentPath(File jarFile) {  
        while (jarFile.getPath().contains(".jar"))  
            jarFile = jarFile.getParentFile();  
          
        return jarFile.getPath().substring(6);  
    }  
    
}
