
package agenda;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


public class telaMedicos extends javax.swing.JDialog {

    DefaultTableModel mdlDias;
    medico objMedico = new medico();
    List listaIdEspecialidade;
    List<Linha_Coluna> listaLinhaColuna;
    boolean edita = false;
    
    Calendar calendarioAgenda = Calendar.getInstance();

    /**
     * Construtor da classe 
     * @param edita True se é uma ediçaõ ou false se for um novo cadastro
     */
    
    public telaMedicos(boolean edita) {
        initComponents();
        
    DesabilitaTela();
    listaIdEspecialidade = objMedico.carregaComboEspecialidades(cmbEspecialidade);
    CarregaObjMedico();
    objMedico.CarregaTabelaMedicos(tblMedicos);
    AddTblMascara();
    
    }

    private telaMedicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void AddTblMascara(){
    
        String mascara = "##:##";
        
    }

    public void CarregaObjMedico(){
        
        int idEspecialidade;
        
        try{
            
            idEspecialidade = Integer.parseInt(listaIdEspecialidade.get(cmbEspecialidade.getSelectedIndex()).toString());
            
        }catch(Exception e){
        
            idEspecialidade = 0;
        
        }
        
        System.out.println("Codigo da especialidade selecionada: " + idEspecialidade);
        
        objMedico.setNome(edtNome.getText());
        objMedico.setEspecialidade(idEspecialidade);
        objMedico.setCelular(edtCelular.getText());
        objMedico.setTelefone(edtTelefone.getText());
        objMedico.setObservacao(mmoObs.getText());
        
        if(chkStatus.isSelected()){
        
            objMedico.setStatus("s");
            
        }else{
        
            objMedico.setStatus("n");
        
        }
        
        
    }
    
    private void CarregaTela(){
    
        edtNome.setText(objMedico.getNome());
        edtTelefone.setText(objMedico.getTelefone());
        edtCelular.setText(objMedico.getCelular());
        mmoObs.setText(objMedico.getObservacao());
        
        if(objMedico.getStatus().equals("s")){
        
            chkStatus.setSelected(true);
            
        }else{
        
            chkStatus.setSelected(false);
        
        }
        
        for(int x=0 ; x<listaIdEspecialidade.size() ; x++){
        
            if(Integer.parseInt(listaIdEspecialidade.get(x).toString()) == objMedico.getEspecialidade()){
                cmbEspecialidade.setSelectedIndex(x);
            }
        
        }
        
    
    }
    
    private void DesabilitaTela(){
    
      //  mdlDias = (DefaultTableModel) tblDias.getModel();
      //  mdlDias.setNumRows(0);
        
        jycAno.setEnabled(false);
        jmcMes.setEnabled(false);
        
        tblDias.setEnabled(false);
        chkStatus.setEnabled(false);
        
        btnAddEspecialidade.setEnabled(false);
        
        btnAlterar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        
        edtNome.setEnabled(false);
        edtNome.setDisabledTextColor(Color.blue);
        
        edtTelefone.setEnabled(false);
        edtTelefone.setDisabledTextColor(Color.blue);
        
        edtCelular.setEnabled(false);
        edtCelular.setDisabledTextColor(Color.blue);
        
        cmbEspecialidade.setEnabled(false);
       
        mmoObs.setEnabled(false);
        mmoObs.setDisabledTextColor(Color.blue);
        
    }
    
    private void HabilitaTela(){
    
        
        jycAno.setEnabled(true);
        jmcMes.setEnabled(true);
        
        tblDias.setEnabled(true);
        chkStatus.setEnabled(true);
        
        btnAddEspecialidade.setEnabled(true);
        
        edtNome.setEnabled(true);
        edtNome.setDisabledTextColor(Color.black);
        
        edtTelefone.setEnabled(true);
        edtTelefone.setDisabledTextColor(Color.black);
        
        edtCelular.setEnabled(true);
        edtCelular.setDisabledTextColor(Color.black);
        
        cmbEspecialidade.setEnabled(true);
       
        mmoObs.setEnabled(true);
        mmoObs.setDisabledTextColor(Color.black);
        
        
    }
    
    public void limpaTela(){
    
        edtCelular.setText("");
        edtNome.setText("");
        edtTelefone.setText("");
        mmoObs.setText("");
        cmbEspecialidade.setSelectedIndex(0);
        
    }
    
    public void limpaTabelasSemanas(jtablemask.JtableMask tblSemana){
    
        DefaultTableModel tblModelSemana = (DefaultTableModel) tblSemana.getModel();
        
        tblModelSemana.setNumRows(0);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableMask1 = new jtablemask.JtableMask();
        mnuDias = new javax.swing.JPopupMenu();
        mnuExcluir = new javax.swing.JMenuItem();
        mnuLimparColuna = new javax.swing.JMenuItem();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel1 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbEspecialidade = new javax.swing.JComboBox();
        btnAddEspecialidade = new javax.swing.JButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        try{
            MaskFormatter mskTelefone = new MaskFormatter("(##)####-####");
            mskTelefone.setPlaceholderCharacter('_');
            edtTelefone = new javax.swing.JFormattedTextField(mskTelefone);
            try{
                MaskFormatter mskCelular = new MaskFormatter("(##)#####-####");
                mskCelular.setPlaceholderCharacter('_');
                edtCelular = new javax.swing.JFormattedTextField(mskCelular);
                jPanel8 = new javax.swing.JPanel();
                jmcMes = new com.toedter.calendar.JMonthChooser();
                jScrollPane2 = new javax.swing.JScrollPane();
                tblDias = new jtablemask.JtableMask();
                jycAno = new com.toedter.calendar.JYearChooser();
                jPanel9 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                mmoObs = new javax.swing.JTextArea();
                jPanel10 = new javax.swing.JPanel();
                chkStatus = new javax.swing.JCheckBox();
                jLabel5 = new javax.swing.JLabel();
                btnSalvar = new javax.swing.JButton();
                btnAlterar = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                btnNovo = new javax.swing.JButton();
                jPanel11 = new javax.swing.JPanel();
                jScrollPane10 = new javax.swing.JScrollPane();
                tblMedicos = new javax.swing.JTable();
                jButton2 = new javax.swing.JButton();

                jtableMask1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                    },
                    new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                    }
                ));
                jScrollPane1.setViewportView(jtableMask1);

                mnuExcluir.setText("Excluir");
                mnuExcluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mnuExcluirActionPerformed(evt);
                    }
                });
                mnuDias.add(mnuExcluir);

                mnuLimparColuna.setText("Limpar Coluna...");
                mnuLimparColuna.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mnuLimparColunaActionPerformed(evt);
                    }
                });
                mnuDias.add(mnuLimparColuna);

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Médico"));

                jLabel1.setText("Nome:");

                jLabel3.setText("Especialidade:");

                cmbEspecialidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                btnAddEspecialidade.setText("+");
                btnAddEspecialidade.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnAddEspecialidadeActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
                jXPanel1.setLayout(jXPanel1Layout);
                jXPanel1Layout.setHorizontalGroup(
                    jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddEspecialidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jXPanel1Layout.setVerticalGroup(
                    jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddEspecialidade))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

                jLabel2.setText("Telefone:");

                jLabel4.setText("Celular:");

            }catch(Exception e){}

        }catch(Exception e){

        }

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Agenda"));

        jmcMes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jmcMesPropertyChange(evt);
            }
        });

        tblDias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selecione uma data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDias.setComponentPopupMenu(mnuDias);
        tblDias.setEnabled(false);
        tblDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDiasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDias);

        jycAno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycAnoPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jmcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jycAno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jmcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jycAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));

        mmoObs.setColumns(20);
        mmoObs.setRows(5);
        jScrollPane3.setViewportView(mmoObs);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        chkStatus.setSelected(true);
        chkStatus.setText("Ativo");

        jLabel5.setText("Status:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkStatus)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Médicos cadastrados"));

        tblMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Celular", "Especialidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicosMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblMedicos);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        jButton2.setText("Finalizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        DesabilitaTela();
        limpaTela();
        
        btnNovo.setEnabled(true);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
               
        
        if (!edita) {

            CarregaObjMedico();
            objMedico.setId(objMedico.PegaUltimoId());  // pega o último id manualmente e adiciona ao obj, para utiliza -lo na inserção da agenda do medico
            
            objMedico.GravaMedico();
            finalizaTabelaDias();
            objMedico.CarregaTabelaMedicos(tblMedicos);
            DesabilitaTela();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(true);
            
            
        } else {

            CarregaObjMedico();
            objMedico.AtualizaMedico();
            objMedico.CarregaTabelaMedicos(tblMedicos);
            finalizaTabelaDias();
            DesabilitaTela();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(true);
            

        }
        
        
      
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void finalizaTabelaDias() {

        int somaId = 0;
        
        // Verifica se a tabela ja foi criada somando todos os ids ca coluna id_paciente
        
        try{                                    
            for(int x=0 ; x<listaLinhaColuna.size() ; x++){

                somaId = somaId + listaLinhaColuna.get(x).getId();

            }
            
        }catch(Exception e){
        
            somaId = 0;
            
        }
        
        System.out.println("Resultado da soma :" + somaId);
        
        //Se o resultado da soma for Zero entao é criado uma nova agenda, se nao ele edita a já existente 
        
        if (somaId == 0) {

            try {
                objMedico.gravaAgendaMedico(tblDias, calendarioAgenda, objMedico.getId());
            } catch (SQLException ex) {
                Logger.getLogger(telaMedicos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                objMedico.AlteraAgenda(listaLinhaColuna, tblDias);
            } catch (SQLException ex) {
                Logger.getLogger(telaMedicos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    private void tblMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicosMouseClicked
        
        if(evt.getClickCount() == 2){
        
            DesabilitaTela();
            limpaTela();
        
            btnNovo.setEnabled(true);
            
            edita = true;
            
            int id = Integer.valueOf(tblMedicos.getValueAt(tblMedicos.getSelectedRow(), 0).toString());
            objMedico.AutoCarregarObj(id);
            CarregaTela();
            btnSalvar.setEnabled(false);
            btnAlterar.setEnabled(true);
            btnCancelar.setEnabled(true);
            
            btnNovo.setEnabled(false);
            
            GeraDiasMes(jmcMes.getMonth(),jycAno.getYear(), tblDias);
            
        }
        
    }//GEN-LAST:event_tblMedicosMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        
        HabilitaTela();
        edita = true;
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        btnNovo.setEnabled(false);
        GeraDiasMes(jmcMes.getMonth(),jycAno.getYear(), tblDias);
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        edita = false;
        limpaTela();
        HabilitaTela();
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        GeraDiasMes(jmcMes.getMonth(),jycAno.getYear(), tblDias);
        
    }//GEN-LAST:event_btnNovoActionPerformed


    public void GeraDiasMes(int Mes,int Ano, jtablemask.JtableMask tblDiasMes){
        
        
        tblDiasMes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableModel tblModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }

        };

        
        int diasMes;
        int diaSemana;
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.MONTH, Mes);
        calendario.set(Calendar.YEAR, Ano);
            
            diasMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            tblModel.setColumnCount(diasMes);
            String[] NomeColuna = new String[diasMes]; 
            
            int cont =1;
            
            for(int x=0 ; x<NomeColuna.length ; x++){
            
                calendario.set(Calendar.DAY_OF_MONTH, cont);
                diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
                
                NomeColuna[x] = String.valueOf(cont) + " (" + ConverteSemana(diaSemana) + ")";
                cont++;
                
            }
            
            tblModel.setColumnIdentifiers(NomeColuna);
            tblDiasMes.setModel(tblModel);
            tblModel.setNumRows(20);
            
            cont = 1;
            
            for(int x=0 ; x<NomeColuna.length ; x++){
            
                tblDiasMes.getColumnModel().getColumn(x).setPreferredWidth(100);
                
                calendario.set(Calendar.DAY_OF_MONTH, cont);
                
               // System.out.println(calendario.get(Calendar.DAY_OF_WEEK));
                
                if(calendario.get(Calendar.DAY_OF_WEEK) == 7){
                
                    tblDiasMes.mudaColuna(NomeColuna[x], Color.YELLOW, Color.YELLOW, jtablemask.JtableMask.ALINHAMENTO_CENTRO);
                    
                }
                
                if(calendario.get(Calendar.DAY_OF_WEEK) == 1){
                
                    tblDiasMes.mudaColuna(NomeColuna[x], Color.red, Color.red, jtablemask.JtableMask.ALINHAMENTO_CENTRO);
                    
                }
                
            cont++;
            }
            
        if(edita){
            
            try {
                listaLinhaColuna = objMedico.carregaTabelaDias(calendario, objMedico.getId(), tblDias);
            } catch (SQLException ex) {
                Logger.getLogger(telaMedicos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            
            for(int coluna=0 ; coluna<tblDias.getColumnCount(); coluna++){
                
                for(int linha=0 ; linha<tblDias.getRowCount() ; linha++){
                
                    tblDias.setValueAt("", linha, coluna);
                    
                }
                
            }
            
        }
        
    }
    
    public String ConverteSemana(int DiaSemana){
        
        String resultado = null;
        
        switch(DiaSemana){
            case 1:
                resultado = "DOM";
                break;
            case 2:
                resultado = "SEG";
                break;
            case 3:
                resultado = "TER";
                break;
            case 4:
                resultado = "QUA";
                break;
            case 5:
                resultado = "QUI";
                break;
            case 6:
                resultado = "SEX";
                break;
            case 7:
                resultado = "SAB";
                break;
        }
    
        return resultado;
    }

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEspecialidadeActionPerformed
        
        TelaEspecialidades telaEsp = new TelaEspecialidades(cmbEspecialidade, listaIdEspecialidade);
        
        telaEsp.setModal(true);
        telaEsp.setLocationRelativeTo(null);
        telaEsp.setVisible(true);
        
    }//GEN-LAST:event_btnAddEspecialidadeActionPerformed

    private void jmcMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmcMesPropertyChange
       
        if("month".equals(evt.getPropertyName())){
        
            System.out.println("Combo mes : " + jmcMes.getMonth());
            GeraDiasMes(jmcMes.getMonth(),jycAno.getYear(), tblDias);
            
            calendarioAgenda.set(Calendar.MONTH, jmcMes.getMonth());
            calendarioAgenda.set(Calendar.YEAR, jycAno.getYear());
            
            
            System.out.println("Data selecionada:" + calendarioAgenda.getTime());
            System.out.println("Mes: " + calendarioAgenda.get(Calendar.MONTH));
            System.out.println("Ano: " + calendarioAgenda.get(Calendar.YEAR));
            
        }
        
    }//GEN-LAST:event_jmcMesPropertyChange

    private void jycAnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycAnoPropertyChange
       
        if("year".equals(evt.getPropertyName())){
        
            System.out.println(jmcMes.getMonth());
            GeraDiasMes(jmcMes.getMonth(),jycAno.getYear(), tblDias);
            
            calendarioAgenda.set(Calendar.MONTH, jmcMes.getMonth());
            calendarioAgenda.set(Calendar.YEAR, jycAno.getYear());
            
            System.out.println(calendarioAgenda.getTime());
        }
        
    }//GEN-LAST:event_jycAnoPropertyChange

    private void tblDiasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiasMousePressed
       
        if(evt.getClickCount() == 2){
        
            TelaHoraAgenda thAgenda = new TelaHoraAgenda(tblDias, tblDias.getSelectedColumn());
            thAgenda.setModal(true);
            thAgenda.setLocationRelativeTo(tblDias);
            thAgenda.setVisible(true);
        
        }
        
    }//GEN-LAST:event_tblDiasMousePressed

    private void mnuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirActionPerformed
 
        try {

            tblDias.setValueAt("", tblDias.getSelectedRow(), tblDias.getSelectedColumn());
            objMedico.AlteraAgenda(listaLinhaColuna, tblDias);
            GeraDiasMes(jmcMes.getMonth(), jycAno.getYear(), tblDias);

        } catch (SQLException ex) {
            Logger.getLogger(telaMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuExcluirActionPerformed

    private void mnuLimparColunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLimparColunaActionPerformed
       
        LimpaColuna(tblDias.getSelectedColumn());
        
    }//GEN-LAST:event_mnuLimparColunaActionPerformed

    
    public void LimpaColuna(int Coluna){
    
        for(int x=0 ; x<tblDias.getRowCount() ; x++){
        
            tblDias.setValueAt("", x, Coluna);
        
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
            java.util.logging.Logger.getLogger(telaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEspecialidade;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JComboBox cmbEspecialidade;
    private javax.swing.JFormattedTextField edtCelular;
    private javax.swing.JTextField edtNome;
    private javax.swing.JFormattedTextField edtTelefone;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private com.toedter.calendar.JMonthChooser jmcMes;
    private jtablemask.JtableMask jtableMask1;
    private com.toedter.calendar.JYearChooser jycAno;
    private javax.swing.JTextArea mmoObs;
    private javax.swing.JPopupMenu mnuDias;
    private javax.swing.JMenuItem mnuExcluir;
    private javax.swing.JMenuItem mnuLimparColuna;
    private jtablemask.JtableMask tblDias;
    private javax.swing.JTable tblMedicos;
    // End of variables declaration//GEN-END:variables
}
