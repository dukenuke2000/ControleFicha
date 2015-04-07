
package controleficha;

import agenda.telaMedicos;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

public class TelaPrincipal extends javax.swing.JFrame {

    Principal objpriPrincipal = new Principal();
    configBusca objConfigBusca = new configBusca();
    
    public TelaPrincipal() {
        initComponents();

        this.setLocationRelativeTo(null);
        
        edtCpf.setFocusLostBehavior(JFormattedTextField.PERSIST);
       // edtNascimento.setFocusLostBehavior(JFormattedTextField.PERSIST);
        
        Conexao con = new Conexao();
        
        con.IniciaServidor(true);
        try {
            objpriPrincipal.CarregaTabela(tblLista, objConfigBusca);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            
            RestauraBackup();
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edtCns = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        try{
            MaskFormatter mascaraCpf = new MaskFormatter("###-###-###-##");
            mascaraCpf.setPlaceholderCharacter('_');
            edtCpf = new javax.swing.JFormattedTextField(mascaraCpf);
            jLabel4 = new javax.swing.JLabel();
            edtNascimento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", ' ');
            btnLimpar = new javax.swing.JButton();
            jPanel2 = new javax.swing.JPanel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tblLista = new javax.swing.JTable();
            jMenuBar1 = new javax.swing.JMenuBar();
            jMenu1 = new javax.swing.JMenu();
            jMenu3 = new javax.swing.JMenu();
            mnuNovo = new javax.swing.JMenuItem();
            jMenuItem1 = new javax.swing.JMenuItem();
            jMenuItem2 = new javax.swing.JMenuItem();
            mnuImportar = new javax.swing.JMenuItem();
            mnuSair = new javax.swing.JMenuItem();
            jMenu2 = new javax.swing.JMenu();
            mnuGeraBkp = new javax.swing.JMenuItem();
            mnuRestauraBkp = new javax.swing.JMenuItem();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));

            jLabel2.setText("CPF:");

            jLabel3.setText("CNS:");

            edtCns.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    edtCnsKeyPressed(evt);
                }
            });

            edtNome.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    edtNomeKeyPressed(evt);
                }
            });

            jLabel1.setText("Nome:");

            btnBuscar.setText("Buscar");
            btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBuscarActionPerformed(evt);
                }
            });

        }catch(Exception e){}
        edtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCpfKeyPressed(evt);
            }
        });

        jLabel4.setText("Data de Nascimento:");

        edtNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtNascimentoKeyPressed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtCns, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addComponent(edtCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(edtCns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(jLabel4)
                        .addComponent(btnLimpar))
                    .addComponent(edtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacientes"));

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Ficha", "Nome", "Nascimento", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLista);
        if (tblLista.getColumnModel().getColumnCount() > 0) {
            tblLista.getColumnModel().getColumn(0).setMinWidth(0);
            tblLista.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblLista.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");

        jMenu3.setText("Novo...");

        mnuNovo.setText("Paciente");
        mnuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNovoActionPerformed(evt);
            }
        });
        jMenu3.add(mnuNovo);

        jMenuItem1.setText("Médico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Especialidade");
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        mnuImportar.setText("Importar CSV...");
        mnuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuImportarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuImportar);

        mnuSair.setText("Sair");
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Backup");

        mnuGeraBkp.setText("Gerar Backup ...");
        mnuGeraBkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGeraBkpActionPerformed(evt);
            }
        });
        jMenu2.add(mnuGeraBkp);

        mnuRestauraBkp.setText("Restaurar Backup ...");
        mnuRestauraBkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRestauraBkpActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRestauraBkp);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNovoActionPerformed
        
        TelaPaciente Tpac = new TelaPaciente(null,tblLista, objConfigBusca);
        Tpac.setModal(true);
        Tpac.setLocationRelativeTo(null);
        Tpac.setVisible(true);
        
    }//GEN-LAST:event_mnuNovoActionPerformed

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        
        int id = Integer.parseInt(tblLista.getValueAt(tblLista.getSelectedRow(),0).toString());
        
        if(evt.getClickCount() == 2){
        
            paciente objPaciente = new paciente();
            objPaciente.autoCarregar(id);

            TelaPaciente Tpac = new TelaPaciente(objPaciente, tblLista, objConfigBusca);
            Tpac.setModal(true);
            Tpac.setLocationRelativeTo(null);
            Tpac.setVisible(true);
            
        }
        
    }//GEN-LAST:event_tblListaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    
      pesquisa();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mnuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuImportarActionPerformed
        
        String arquivo = null;
        
        JFileChooser jc = new JFileChooser();
        jc.setFileFilter(new FileNameExtensionFilter("Arquivo CSV", "csv"));
        jc.setAcceptAllFileFilterUsed(false);
        jc.showOpenDialog(jc);
        File file = jc.getSelectedFile();
        
        try{
        arquivo = file.getPath();
        }catch(Exception e){}
        
        if(arquivo != null){
            TelavizualizaExp tvz = new TelavizualizaExp(arquivo, tblLista);
            tvz.setLocationRelativeTo(null);
            tvz.setVisible(true);
        }
    }//GEN-LAST:event_mnuImportarActionPerformed

    private void mnuGeraBkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGeraBkpActionPerformed
        
        GeraBackup();
       
    }//GEN-LAST:event_mnuGeraBkpActionPerformed

    private void mnuRestauraBkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRestauraBkpActionPerformed
        
        RestauraBackup();
        
    }//GEN-LAST:event_mnuRestauraBkpActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       
        LimpaPesquisa();
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
       
        this.dispose();
        
    }//GEN-LAST:event_mnuSairActionPerformed

    private void edtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCpfKeyPressed

        if(evt.getKeyCode() == 10){
            
            pesquisa();
            
        }
        
    }//GEN-LAST:event_edtCpfKeyPressed

    private void edtCnsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCnsKeyPressed
       
        if(evt.getKeyCode() == 10){
            
            pesquisa();
            
        }
        
    }//GEN-LAST:event_edtCnsKeyPressed

    private void edtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeKeyPressed
       
        if(evt.getKeyCode() == 10){
            
            pesquisa();
            
        }
        
    }//GEN-LAST:event_edtNomeKeyPressed

    private void edtNascimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNascimentoKeyPressed
        
        if(evt.getKeyCode() == 10){
            
            pesquisa();
            
        }
        
    }//GEN-LAST:event_edtNascimentoKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        telaMedicos Tmed = new telaMedicos(false);
        Tmed.setLocationRelativeTo(null);
        Tmed.setModal(true);
        Tmed.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void pesquisa(){
    
         String auxData = null;
        
        if(edtNascimento.getDate() != null){
            
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
            auxData = df.format(edtNascimento.getDate());
            
        }
        
      //  System.out.println(auxData);
        
        objConfigBusca.setCns(edtCns.getText());
        objConfigBusca.setCpf(edtCpf.getText());
        objConfigBusca.setDtNascimento(auxData);
        objConfigBusca.setNome(edtNome.getText());
        
        try {
            objpriPrincipal.CarregaTabela(tblLista, objConfigBusca);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            
            RestauraBackup();
            
                try {
                    objpriPrincipal.CarregaTabela(tblLista, objConfigBusca);
                } catch (SQLException ex1) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex1);
                }
        } 
    
    }
    
    public void LimpaPesquisa(){
    
        edtCns.setText(null);
        edtCpf.setText(null);
        edtNascimento.setDate(null);
        edtNome.setText(null);
    
    }
    
    public void GeraBackup(){
    
       Backup objBackup = new Backup();
        
        String caminho = System.getProperty("user.dir") + "\\Backup";
        
       JFileChooser jc = new JFileChooser();
       jc.setCurrentDirectory(new File(caminho));
       jc.setDialogTitle("GERA BACKUP");
       jc.setFileFilter(new FileNameExtensionFilter("Arquivo SQL", "sql"));
       jc.setAcceptAllFileFilterUsed(false);
       jc.showSaveDialog(jc);
       File file = jc.getSelectedFile();
       
       System.out.println("Gerar backup em: " + file.getAbsolutePath());
    
       objBackup.GeraBackup(file.getAbsolutePath());
       
       
       
    }
    
    public void RestauraBackup(){
    
      Backup objBackup = new Backup();
      
      String caminho = System.getProperty("user.dir") + "\\Backup";
        
      JFileChooser jc = new JFileChooser();
      jc.setCurrentDirectory(new File(caminho));
      jc.setDialogTitle("RESTAURA BACKUP");
      jc.setFileFilter(new FileNameExtensionFilter("Arquivo SQL", "sql"));
      jc.setAcceptAllFileFilterUsed(false);
      jc.showOpenDialog(jc);
      File file = jc.getSelectedFile();
       
      System.out.println("Restaurar de: " + file.getAbsolutePath());  
    
      objBackup.RestauraBackup(file.getAbsolutePath());
      
      try {
                    objpriPrincipal.CarregaTabela(tblLista, objConfigBusca);
                } catch (SQLException ex1) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex1);
                }
      
    }
    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextField edtCns;
    private javax.swing.JFormattedTextField edtCpf;
    private com.toedter.calendar.JDateChooser edtNascimento;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuGeraBkp;
    private javax.swing.JMenuItem mnuImportar;
    private javax.swing.JMenuItem mnuNovo;
    private javax.swing.JMenuItem mnuRestauraBkp;
    private javax.swing.JMenuItem mnuSair;
    private javax.swing.JTable tblLista;
    // End of variables declaration//GEN-END:variables
}
