package controleficha;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CsvRead extends Conexao{
    
    public int LeArquivo(JTable tblVizualiza, String arquivo, DefaultListModel<String> listaImportada){
    
        int nLinhas = 0;
        FileInputStream stream = null;
        String linha = null;
        
        
        
//        JFileChooser jc = new JFileChooser();
//        jc.showOpenDialog(jc);
//        File file = jc.getSelectedFile();
        
     //   String arquivo = file.getPath();
        
        DefaultTableModel tblModelo = (DefaultTableModel) tblVizualiza.getModel();
        
        tblModelo.getDataVector().removeAllElements();
        
        
        
        try {
            
            stream = new FileInputStream(arquivo);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            linha = br.readLine();
        
            
            
            while( linha != null){
                
                nLinhas++;
                String campo[] = linha.split(";");
                tblModelo.setColumnCount(campo.length);
                
                
                
                if(nLinhas == 1){
                    tblModelo.setColumnIdentifiers(campo);
                    
                    for(int x=0 ; x<campo.length ; x++){
                
                        listaImportada.addElement(campo[x]);
                        
                    
                    }
                    
                }else{
                    tblModelo.addRow(campo);
                }
                
                linha = br.readLine();
            
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CsvRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nLinhas;
    }
    
    public void gravaLinha(){
   
    }
    
    public DefaultListModel<String> carregaNomeCampos(JList listaBaseLocal){
    
        DefaultListModel<String> lista = new DefaultListModel<String>();
        
        String sql = "Show columns from pacientes";
        
        ConectaBase(true);
        
        try {
            
            ResultSet resultado = getResultSet(sql);
            
            while(resultado.next()){
                
                lista.addElement(resultado.getString("FIELD"));
                
            }
            
            listaBaseLocal.setModel(lista);
            
        } catch (SQLException ex) {
            Logger.getLogger(CsvRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       return lista; 
    }
    
    public void InsereDadosImportados(JTable tblImporta,final  DefaultListModel<String> ListaLocal, DefaultListModel<String> ListaImportada, List listaIndices){

        String sqlCampos = "";
        String sqlValores = "";
        String sql;
        
        for(int y=0 ; y<tblImporta.getRowCount() ; y++){
        
            for(int x=0 ; x<ListaLocal.size() ;  x++){

                String virgula = ", ";

                if(x == ListaLocal.getSize() -1){
                    virgula = "";
                }

                sqlCampos = sqlCampos + ListaLocal.getElementAt(x) + virgula;

            }

            for(int x=0 ; x<listaIndices.size(); x++){

                String virgula = ", ";

                if(x == listaIndices.size() -1){
                    virgula = "";
                }

            sqlValores = sqlValores +"'"+ tblImporta.getValueAt(y, Integer.parseInt(listaIndices.get(x).toString())) +"'"+ virgula;

           }
           
           sql = "INSERT INTO pacientes(" + sqlCampos +  ") VALUES(" + sqlValores + ")";
           
           GravaLinha(sql);
           
           System.out.println(sql);
           
           sqlCampos = "";
           sqlValores = "";
           
        }   
           
    }

    public void GravaLinha(String sql){
    
        try {
            getStm().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CsvRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
