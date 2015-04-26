
package agenda;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

public class TelaHoraAgenda extends javax.swing.JDialog {
    
    boolean Editando = false;
    List listaColuna;
    jtablemask.JtableMask tblAgenda;
    int coluna;

    public TelaHoraAgenda(jtablemask.JtableMask tblAgenda, int coluna) {
        initComponents();
        
        String valorSelecionado = "";
        
        this.tblAgenda = tblAgenda;
        this.coluna = coluna;
        
        listaColuna = CarregaListColuna(tblAgenda, coluna);
        
        try{
            valorSelecionado = tblAgenda.getValueAt(tblAgenda.getSelectedRow(), tblAgenda.getSelectedColumn()).toString();
        }catch(Exception e){
        }
        
        if(!valorSelecionado.equals("")){
        
            edtHora.setText(valorSelecionado);
            Editando = true;
            
        }else{
        
            Editando = false;
        
        }
        
        spnMinutos.setValue(15);
        
    }

    private TelaHoraAgenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List CarregaListColuna(jtablemask.JtableMask tblAgenda, int coluna) {

        List<String> lstColuna = new ArrayList<String>();

        for (int x = 0; x < tblAgenda.getRowCount(); x++) {

           // System.out.println(tblAgenda.getValueAt(x, coluna));
            
            if ((tblAgenda.getValueAt(x, coluna) != null) && (!tblAgenda.getValueAt(x, coluna).equals("")) && (!tblAgenda.getValueAt(x, coluna).equals("livre"))) {

                lstColuna.add(tblAgenda.getValueAt(x, coluna).toString());
              //  System.out.println("Valores : " + lstColuna.get(x));
                 
            }

           
        }

        return lstColuna;
    }
    
    private void InsereListTabela(jtablemask.JtableMask tblAgenda, int coluna, List listaColuna, String Hora, int qtde, int minutos){
        
        Calendar calendario = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        try {
            calendario.setTime(sdf.parse(Hora));
        } catch (ParseException ex) {
            Logger.getLogger(TelaHoraAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaColuna.add(sdf.format(calendario.getTime()));
        
        System.out.println("Calendario inicial: " + sdf.format(calendario.getTime()));
        
        for(int x=0 ; x<qtde ; x++){
            
            calendario = SomaHora(minutos, calendario);
            listaColuna.add(sdf.format(calendario.getTime()));
            
        }
        
        for(int x=0 ; x<listaColuna.size() ; x++){
        
            tblAgenda.setValueAt(listaColuna.get(x), x, coluna);
            
        }
    
    }

    private Calendar SomaHora(int SomaMinutos, Calendar calendario){
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        System.out.println("Antes : " + sdf.format(calendario.getTime()));
        calendario.add(Calendar.MINUTE, SomaMinutos);
        System.out.println("Depois: " + sdf.format(calendario.getTime()));
        
        return calendario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        try{
            MaskFormatter mfHora = new MaskFormatter("##:##");
            mfHora.setPlaceholderCharacter('_');
            edtHora = new javax.swing.JFormattedTextField(mfHora);
            jLabel1 = new javax.swing.JLabel();
            spnQuantidade = new javax.swing.JSpinner();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            spnMinutos = new javax.swing.JSpinner();
            btnAdicionar = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        }catch(Exception e){}

        jLabel1.setText("Hora inicial:");

        jLabel2.setText("Qtd Consultas:");

        jLabel3.setText("Duração(Minutos):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnMinutos, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(spnQuantidade))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(edtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spnMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       
        if(Editando){
            tblAgenda.setValueAt(edtHora.getText(), tblAgenda.getSelectedRow(), tblAgenda.getSelectedColumn());
            this.dispose();
        }else{
            InsereListTabela(tblAgenda, coluna, listaColuna, edtHora.getText(),(Integer) spnQuantidade.getValue(),(Integer) spnMinutos.getValue());
            this.dispose();
        }
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaHoraAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHoraAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHoraAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHoraAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHoraAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JFormattedTextField edtHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spnMinutos;
    private javax.swing.JSpinner spnQuantidade;
    // End of variables declaration//GEN-END:variables
}
