
package agenda;

import controleficha.paciente;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class TelaAgendaConsulta extends javax.swing.JDialog {

    agendaConsulta objAgendaConsulta;
    paciente objpaciente;
    Calendar calendario = Calendar.getInstance();

    List idEspecialidade;
    List idMedico;
    
    public TelaAgendaConsulta(paciente objPaciente) {
        initComponents();
        
        this.objpaciente = objPaciente;
        
        lblNome.setText(objPaciente.getNome());
        lblNascimento.setText(objPaciente.getDtNascimento());
        
        objAgendaConsulta = new agendaConsulta();
        
        idEspecialidade = objAgendaConsulta.carregaComboEspecialidades(cmbEspecialidades);
        
    }

    private TelaAgendaConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmTblAgenda = new javax.swing.JPopupMenu();
        mnuDesmarcar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbEspecialidades = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbMedicos = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jdcDataAgenda = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblSemana = new javax.swing.JLabel();

        mnuDesmarcar.setText("Desmarcar agenda");
        mnuDesmarcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuDesmarcarMousePressed(evt);
            }
        });
        mnuDesmarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDesmarcarActionPerformed(evt);
            }
        });
        ppmTblAgenda.add(mnuDesmarcar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));

        lblNome.setText("jLabel1");

        lblNascimento.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNascimento)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNome)
                .addComponent(lblNascimento))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Médico"));

        jLabel1.setText("Especialidade:");

        cmbEspecialidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEspecialidades.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbEspecialidadesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel2.setText("Nome:");

        cmbMedicos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEspecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbMedicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jdcDataAgenda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcDataAgendaPropertyChange(evt);
            }
        });

        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idAgenda", "hora", "fkPaciente", "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAgendaMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAgenda);
        if (tblAgenda.getColumnModel().getColumnCount() > 0) {
            tblAgenda.getColumnModel().getColumn(0).setMinWidth(0);
            tblAgenda.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblAgenda.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAgenda.getColumnModel().getColumn(2).setMinWidth(0);
            tblAgenda.getColumnModel().getColumn(2).setPreferredWidth(0);
            tblAgenda.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblSemana.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        lblSemana.setForeground(new java.awt.Color(10, 204, 209));
        lblSemana.setText("Dia da Semana");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSemana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdcDataAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcDataAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSemana))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEspecialidadesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbEspecialidadesPopupMenuWillBecomeInvisible
        
        int idEsp = Integer.parseInt(idEspecialidade.get(cmbEspecialidades.getSelectedIndex()).toString());
        
        try {
            idMedico = objAgendaConsulta.CarregaComboMedico(idEsp , cmbMedicos);
        } catch (SQLException ex) {
            Logger.getLogger(TelaAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cmbEspecialidadesPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jdcDataAgendaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcDataAgendaPropertyChange
          
        int idMed;
        int DiaSemana;
        
        if ("date".equals(evt.getPropertyName())) {

            try {
                
                idMed = Integer.parseInt(idMedico.get(cmbMedicos.getSelectedIndex()).toString());
                DiaSemana = jdcDataAgenda.getCalendar().get(Calendar.DAY_OF_WEEK);

                lblSemana.setText(ConverteSemana(DiaSemana));
                
                objAgendaConsulta.CarregaTabelaAgenda(tblAgenda, idMed, jdcDataAgenda.getCalendar());
            } catch (SQLException ex) {
                Logger.getLogger(TelaAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(jdcDataAgenda.getCalendar().get(Calendar.DAY_OF_WEEK));
        }
        
    }//GEN-LAST:event_jdcDataAgendaPropertyChange

    private void tblAgendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMousePressed

        ListSelectionModel tblModel = (ListSelectionModel) tblAgenda.getSelectionModel();
        
        if (evt.getButton() == MouseEvent.BUTTON3) {  
            
            int row = tblAgenda.rowAtPoint( evt.getPoint() );  
            
            tblModel.setSelectionInterval(row, row);
            
            ppmTblAgenda.show(tblAgenda, evt.getX(), evt.getY());
            
            
        }  
        
        
        
        if(evt.getClickCount() == 2){
            
            if(ValidaPaciente()){
            
                TelaConfirmaConsulta tcc = new TelaConfirmaConsulta(tblAgenda, 
                                                                    jdcDataAgenda.getCalendar(), 
                                                                    idMedico.get(cmbMedicos.getSelectedIndex()).toString(), 
                                                                    objpaciente.getId());
                tcc.setModal(true);
                tcc.setLocationRelativeTo(null);
                tcc.setVisible(true);
            
            }
        
        }
        
        
    }//GEN-LAST:event_tblAgendaMousePressed

    public boolean ValidaPaciente(){
        
            boolean resultado = true;
            
            for(int x=0 ; x<tblAgenda.getRowCount() ; x++){
            
                try{
                    
                int idPacienteTab = Integer.parseInt(tblAgenda.getValueAt(x, 2).toString());
                
                    if(objpaciente.getId() == idPacienteTab){

                        resultado = false;
                        JOptionPane.showMessageDialog(null, "Paciente já agendado neste dia.");

                    }
                
                }catch(Exception e){
                }
                
            }
            
            
            return resultado;
        }
    
    private void mnuDesmarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDesmarcarActionPerformed
        
        
        
    }//GEN-LAST:event_mnuDesmarcarActionPerformed

    private void tblAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMouseClicked
        
        
        
    }//GEN-LAST:event_tblAgendaMouseClicked

    private void mnuDesmarcarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuDesmarcarMousePressed
        
        try {
            
            String NomeSelecionado = tblAgenda.getValueAt(tblAgenda.getSelectedRow(), 3).toString();
            
            int resposta = JOptionPane.showConfirmDialog(null, "Confirma cancelamento de agenda de " + NomeSelecionado +" ?","Atenção", JOptionPane.OK_CANCEL_OPTION);
            
            if(resposta == 0){
                
                objAgendaConsulta.RemoveAgendaPacinete(Integer.parseInt(tblAgenda.getValueAt(tblAgenda.getSelectedRow(), 0).toString()));
                objAgendaConsulta.CarregaTabelaAgenda(tblAgenda, 
                                                      Integer.parseInt(idMedico.get(cmbMedicos.getSelectedIndex()).toString()), 
                                                      jdcDataAgenda.getCalendar());
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaAgendaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mnuDesmarcarMousePressed

 
    public String ConverteSemana(int DiaSemana){
        
        String resultado = null;
        
        switch(DiaSemana){
            case 1:
                resultado = "Domingo";
                break;
            case 2:
                resultado = "Segunda-feira";
                break;
            case 3:
                resultado = "Terça-feira";
                break;
            case 4:
                resultado = "Quarta-feira";
                break;
            case 5:
                resultado = "Quinta-feira";
                break;
            case 6:
                resultado = "Sexta-feira";
                break;
            case 7:
                resultado = "Sábado";
                break;
        }
    
        return resultado;
    }
    
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
            java.util.logging.Logger.getLogger(TelaAgendaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgendaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEspecialidades;
    private javax.swing.JComboBox cmbMedicos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcDataAgenda;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSemana;
    private javax.swing.JMenuItem mnuDesmarcar;
    private javax.swing.JPopupMenu ppmTblAgenda;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables
}
