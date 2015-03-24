
package controleficha;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

public class TelaPaciente extends javax.swing.JDialog {

    paciente objPaciente;
    MaskFormatter mascaracep;
    JTable tblLista;
    Principal objPrincipal = new Principal();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    configBusca objConfigBusca;
    
    boolean FlagEdit = false;
    
    
    
    public TelaPaciente(paciente objPaciente, JTable tblLista, configBusca objConfigBusca) {
        initComponents();
        
        
        this.objConfigBusca = objConfigBusca;
        this.tblLista = tblLista;
        
        if(objPaciente == null){
        
                this.objPaciente = new paciente();

            }else{

                this.objPaciente = objPaciente;
                carregaTela();
                FlagEdit = true;

            }
        
        }

    private TelaPaciente() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
    public void carregaTela(){
    
        edtNome.setText(objPaciente.getNome());
        edtCpf.setText(objPaciente.getCpf());
        edtCns.setText(objPaciente.getCns());
        edtFicha.setText(objPaciente.getFicha());
        mmoObservacao.setText(objPaciente.getObs());
        edtTel1.setText(objPaciente.getTelefone1());
        edtTel2.setText(objPaciente.getTelefone2());
        edtCelular.setText(objPaciente.getCelular());
        
        try {
            System.out.println(objPaciente.getDtNascimento());
            Date data = sdf.parse(objPaciente.getDtNascimento());
            edtNascimento.setDate(data);
            
        } catch (ParseException ex) {
            Logger.getLogger(TelaPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void carregaObjeto(){
    
        objPaciente.setNome(edtNome.getText());
        objPaciente.setCpf(edtCpf.getText());
        objPaciente.setCns(edtCns.getText());
        objPaciente.setFicha(edtFicha.getText());
        objPaciente.setObs(mmoObservacao.getText());
        objPaciente.setTelefone1(edtTel1.getText());
        objPaciente.setTelefone2(edtTel2.getText());
        objPaciente.setCelular(edtCelular.getText());
        objPaciente.setDtNascimento(sdf.format(edtNascimento.getDate()));
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edtCns = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtFicha = new javax.swing.JTextField();
        try{

            MaskFormatter mascaraCep = new MaskFormatter("###-###-###-##");
            mascaraCep.setPlaceholderCharacter('_');
            edtCpf = new javax.swing.JFormattedTextField(mascaraCep);
            jLabel8 = new javax.swing.JLabel();
            edtNascimento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", ' ');
            jPanel2 = new javax.swing.JPanel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            try{
                MaskFormatter mascaraTel1 = new MaskFormatter("(##)####-####");
                mascaraTel1.setPlaceholderCharacter('_');
                edtTel1 = new javax.swing.JFormattedTextField(mascaraTel1);
                try{
                    MaskFormatter mascaraTel2 = new MaskFormatter("(##)####-####");
                    mascaraTel2.setPlaceholderCharacter('_');
                    edtTel2 = new javax.swing.JFormattedTextField(mascaraTel2);
                    try{

                        MaskFormatter mascaraCel = new MaskFormatter("(##)#####-####");
                        mascaraCel.setPlaceholderCharacter('_');
                        edtCelular = new javax.swing.JFormattedTextField(mascaraCel);
                        jPanel3 = new javax.swing.JPanel();
                        jScrollPane1 = new javax.swing.JScrollPane();
                        mmoObservacao = new javax.swing.JTextArea();
                        jPanel4 = new javax.swing.JPanel();
                        btnSalvar = new javax.swing.JButton();
                        btnCancelar = new javax.swing.JButton();
                        btnExcluir = new javax.swing.JButton();

                        jButton1.setText("jButton1");

                        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

                        jLabel1.setText("Nome:");

                        jLabel2.setText("CPF:");

                        jLabel3.setText("CNS:");

                        jLabel7.setFont(new java.awt.Font("Ubuntu Mono", 1, 19)); // NOI18N
                        jLabel7.setText("Número da ficha:");

                        edtFicha.setFont(new java.awt.Font("Ubuntu Mono", 1, 19)); // NOI18N

                    }catch(Exception e){}

                    jLabel8.setText("Data de Nascimento:");

                    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                    jPanel1.setLayout(jPanel1Layout);
                    jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(edtCns)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(edtFicha, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                                    .addContainerGap())
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7)
                                    .addGap(69, 69, 69))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(edtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                    );
                    jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(edtCns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

                    jLabel4.setText("Telefone 1:");

                    jLabel5.setText("Telefone 2:");

                    jLabel6.setText("Celular:");

                }catch(Exception e){}

            }catch(Exception e){}

        }catch(Exception e){}

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(edtTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(edtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        mmoObservacao.setColumns(20);
        mmoObservacao.setRows(5);
        jScrollPane1.setViewportView(mmoObservacao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(ValidaCampos()){
        
            int resultado = JOptionPane.showConfirmDialog(this, "Confirma a gravação dos dados ?");

                if(FlagEdit){

                    if(resultado == 0){

                        carregaObjeto();
                        objPaciente.atualizar(objPaciente.getId());
                            try {
                                objPrincipal.CarregaTabela(tblLista,objConfigBusca);
                            } catch (SQLException ex) {
                                Logger.getLogger(TelaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        this.dispose();

                    }else if(resultado == 1){

                        dispose();

                    }

                }else{

                    if(resultado == 0){

                        carregaObjeto();
                        objPaciente.salvar();
                        
                            try {
                                objPrincipal.CarregaTabela(tblLista,objConfigBusca);
                            } catch (SQLException ex) {
                                Logger.getLogger(TelaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        this.dispose();

                    }else if(resultado == 1){

                        dispose();

                    }

                }

        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
      
        if(objPaciente.getId() != 0){
        
            int resposta = JOptionPane.showConfirmDialog(this,"Tem certeza que deseja EXCLUÍR este cadastro ?");

            if(resposta == 0){

                objPaciente.excluir(objPaciente.getId());
                
                    try {
                        objPrincipal.CarregaTabela(tblLista, objConfigBusca);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                JOptionPane.showMessageDialog(this, "Cadastro excluído com sucesso.");
                this.dispose();

            }else if(resposta == 1){

                this.dispose();

            }
        
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public boolean ValidaCampos(){
    
        boolean flag = true;
        
        if(edtNome.getText().toString().trim().length() == 0){
        
            flag  = false;
            JOptionPane.showMessageDialog(null, "Infome o nome do Paciente.");
            
        }else if(edtFicha.getText().trim().length() == 0){
        
            flag  = false;
            JOptionPane.showMessageDialog(null, "Infome o número da ficha.");
            
        }else if(edtNascimento.getDate() == null){

                flag  = false;
                JOptionPane.showMessageDialog(null, "Data de nascimento incorreta.");
         
        }else if(!CpfCnpj.isValidCPF(edtCpf.getText())){
        
            flag = false;
            JOptionPane.showMessageDialog(null, "CPF inválido.");
            
        }
        
    return flag;
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
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField edtCelular;
    private javax.swing.JTextField edtCns;
    private javax.swing.JFormattedTextField edtCpf;
    private javax.swing.JTextField edtFicha;
    private com.toedter.calendar.JDateChooser edtNascimento;
    private javax.swing.JTextField edtNome;
    private javax.swing.JFormattedTextField edtTel1;
    private javax.swing.JFormattedTextField edtTel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mmoObservacao;
    // End of variables declaration//GEN-END:variables
}
