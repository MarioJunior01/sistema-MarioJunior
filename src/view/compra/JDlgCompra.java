/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.compra;

import bean.MpjTbCompra;
import bean.MpjTbCompraProduto;
import bean.MpjTbFornecedor;
import bean.MpjTbFuncionario;
import dao.CompraDAO;
import dao.CompraProdutoDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
import funcionalidade.HistoricoTransacoes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import tools.Util;

/**
 *
 * @author mario
 */
public class JDlgCompra extends javax.swing.JDialog {

    /**
     * Creates new form Compra
     */
    private boolean incluirCompra = true;
    private boolean incluirProduto = true;
    private List listaFuncionarios;
    private List listaCompras;
    private List listaProdutos;
    ControllerCompra controllerCompra;
    ControllerComprasProdutos controllerComprasProdutos;

    public JDlgCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        mpj_jTbCompras.getSelectionModel().addListSelectionListener(event -> {
            // Ignora eventos duplicados
            if (!event.getValueIsAdjusting()) {
                int linhaSelecionada = mpj_jTbCompras.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    MpjTbCompra compraSelecionada = controllerCompra.getBean(linhaSelecionada);
                    beanView(compraSelecionada);
                }

            }
        });
        Util.habilitar(false, mpj_jBtrConfirmarCompra, mpj_jBtCancelarCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jTxtTotalCompra, mpj_jCboVedendor, mpj_jCboFornecedor);
        Util.habilitar(true, mpj_jBtIncluirCompra, mpj_jBtAlterarCompra, mpj_jBtExcluirCompra);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CompraDAO compraDAO = new CompraDAO();
        this.listaFuncionarios = (List) funcionarioDAO.listAll();
        this.listaCompras = (List) compraDAO.listAll();
        this.controllerCompra = new ControllerCompra();
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            mpj_jCboVedendor.addItem((MpjTbFuncionario) listaFuncionarios.get(i));
        }

        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List listaFornecedores = (List) fornecedorDAO.listAll();
        for (int i = 0; i < listaFornecedores.size(); i++) {
            mpj_jCboFornecedor.addItem((MpjTbFornecedor) listaFornecedores.get(i));
        }

        controllerComprasProdutos = new ControllerComprasProdutos();
        controllerComprasProdutos.setList(new ArrayList());
        mpj_jTbCompras.setModel(controllerComprasProdutos);

    }

    public JTable getMpjTbCompras() {
        return mpj_jTbCompras;
    }

    public MpjTbCompra viewBean() {
        MpjTbCompra compra = new MpjTbCompra();
        compra.setMpjDataCompra(Util.strToDate(mpj_jFtmDataCompra.getText()));
        compra.setMpjValorCompra(Util.strToDouble(mpj_jTxtTotalCompra.getText()));
        compra.setMpjTbFuncionario((MpjTbFuncionario) mpj_jCboVedendor.getSelectedItem());
        compra.setMpjTbFornecedor((MpjTbFornecedor) mpj_jCboFornecedor.getSelectedItem());
        atualizarTotal();
        return compra;
    }

    public void beanView(MpjTbCompra compra) {
        mpj_jTxtCodigoCompra.setText(Util.intToStr(compra.getMpjIdCompra()));
        mpj_jFtmDataCompra.setText(Util.dateToStr(compra.getMpjDataCompra()));

        mpj_jTxtTotalCompra.setText(Util.doubleToStr(compra.getMpjValorCompra()));

        mpj_jCboVedendor.setSelectedItem(compra.getMpjTbFuncionario());

        mpj_jCboFornecedor.setSelectedItem(compra.getMpjTbFornecedor());

        CompraProdutoDAO compraProdutosDAO = new CompraProdutoDAO();
        List lista = (List) compraProdutosDAO.listProdutos(compra);
        controllerComprasProdutos.setList(lista);

    }

    public boolean validacaoCompra() {
        LineBorder bordaErro = new LineBorder(Color.RED, 2);
        LineBorder bordaNormal = new LineBorder(Color.GRAY, 1);

        if (mpj_jFtmDataCompra.getText().trim().isEmpty() || Util.strToDate(mpj_jFtmDataCompra.getText()) == null) {
            Util.mensagem("Por favor, informe uma data de compra válida.");
            mpj_jFtmDataCompra.setBorder(bordaErro);
            return true;
        } else {
            mpj_jFtmDataCompra.setBorder(bordaNormal);
        }

        // Validação do Vendedor
        if (mpj_jCboVedendor.getSelectedIndex() == -1) {
            Util.mensagem("Por favor, selecione um vendedor.");
            mpj_jCboVedendor.setBorder(bordaErro);
            return true;
        } else {
            mpj_jCboVedendor.setBorder(bordaNormal);
        }

        // Validação do Fornecedor
        if (mpj_jCboFornecedor.getSelectedIndex() == -1) {
            Util.mensagem("Por favor, selecione um fornecedor.");
            mpj_jCboFornecedor.setBorder(bordaErro);
            return true;
        } else {
            mpj_jCboFornecedor.setBorder(bordaNormal);
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mpj_jTxtCodigoCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mpj_jFtmDataCompra = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        mpj_jCboFornecedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        mpj_jCboVedendor = new javax.swing.JComboBox<MpjTbFuncionario>();
        jLabel5 = new javax.swing.JLabel();
        mpj_jTxtTotalCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mpj_jTbCompras = new javax.swing.JTable();
        mpj_jBtAdicionarProduto = new javax.swing.JButton();
        mpj_jBtEditarProduto = new javax.swing.JButton();
        mpj_jBtExcluirProduto = new javax.swing.JButton();
        mpj_jBtIncluirCompra = new javax.swing.JButton();
        mpj_jBtExcluirCompra = new javax.swing.JButton();
        mpj_jBtAlterarCompra = new javax.swing.JButton();
        mpj_jBtrConfirmarCompra = new javax.swing.JButton();
        mpj_jBtCancelarCompra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo");

        mpj_jTxtCodigoCompra.setEnabled(false);
        mpj_jTxtCodigoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jTxtCodigoCompraActionPerformed(evt);
            }
        });

        jLabel2.setText("Data");

        try {
            mpj_jFtmDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mpj_jFtmDataCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jFtmDataCompraActionPerformed(evt);
            }
        });

        jLabel3.setText("Fornecedor");

        jLabel4.setText("Vedendor");

        jLabel5.setText("Total");

        mpj_jTbCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(mpj_jTbCompras);

        mpj_jBtAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_add.png"))); // NOI18N
        mpj_jBtAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtAdicionarProdutoActionPerformed(evt);
            }
        });

        mpj_jBtEditarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        mpj_jBtEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtEditarProdutoActionPerformed(evt);
            }
        });

        mpj_jBtExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_remove.png"))); // NOI18N
        mpj_jBtExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtExcluirProdutoActionPerformed(evt);
            }
        });

        mpj_jBtIncluirCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_add.png"))); // NOI18N
        mpj_jBtIncluirCompra.setText("Incluir");
        mpj_jBtIncluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtIncluirCompraActionPerformed(evt);
            }
        });

        mpj_jBtExcluirCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_remove.png"))); // NOI18N
        mpj_jBtExcluirCompra.setText("Excluir");
        mpj_jBtExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtExcluirCompraActionPerformed(evt);
            }
        });

        mpj_jBtAlterarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        mpj_jBtAlterarCompra.setText("Alterar");
        mpj_jBtAlterarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtAlterarCompraActionPerformed(evt);
            }
        });

        mpj_jBtrConfirmarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        mpj_jBtrConfirmarCompra.setText("Confirmar");
        mpj_jBtrConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtrConfirmarCompraActionPerformed(evt);
            }
        });

        mpj_jBtCancelarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        mpj_jBtCancelarCompra.setText("Cancelar");
        mpj_jBtCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtCancelarCompraActionPerformed(evt);
            }
        });

        jLabel6.setText("Codigo gerado Automaticamente");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mpj_jBtAdicionarProduto)
                            .addComponent(mpj_jBtEditarProduto)
                            .addComponent(mpj_jBtExcluirProduto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1))
                            .addComponent(mpj_jTxtCodigoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mpj_jFtmDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(mpj_jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mpj_jCboVedendor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mpj_jTxtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(mpj_jBtIncluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(mpj_jBtAlterarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(mpj_jBtExcluirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(mpj_jBtrConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mpj_jBtCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mpj_jTxtCodigoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(mpj_jBtAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mpj_jBtEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mpj_jBtExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mpj_jFtmDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mpj_jCboVedendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mpj_jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mpj_jTxtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mpj_jBtIncluirCompra)
                            .addComponent(mpj_jBtExcluirCompra)
                            .addComponent(mpj_jBtAlterarCompra)
                            .addComponent(mpj_jBtrConfirmarCompra)
                            .addComponent(mpj_jBtCancelarCompra)
                            .addComponent(jButton1))))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mpj_jTxtCodigoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jTxtCodigoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpj_jTxtCodigoCompraActionPerformed

    private void mpj_jFtmDataCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jFtmDataCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpj_jFtmDataCompraActionPerformed

    private void mpj_jBtAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtAdicionarProdutoActionPerformed
        // TODO add your handling code here:
        JDlgComprasProdutos jDlgComprasProdutos = new JDlgComprasProdutos(null, true);
        jDlgComprasProdutos.setTelaAnterior(this, null);
        jDlgComprasProdutos.setVisible(true);
        atualizarTotal();

    }//GEN-LAST:event_mpj_jBtAdicionarProdutoActionPerformed

    private void mpj_jBtEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtEditarProdutoActionPerformed
        // TODO add your handling code here:
        JDlgComprasProdutos jDlgComprasProdutos = new JDlgComprasProdutos(null, true);

        MpjTbCompraProduto compraProduto = controllerComprasProdutos.getBean(mpj_jTbCompras.getSelectedRow());
        jDlgComprasProdutos.setTelaAnterior(this, compraProduto);
        jDlgComprasProdutos.setVisible(true);
        atualizarTotal();

    }//GEN-LAST:event_mpj_jBtEditarProdutoActionPerformed

    private void mpj_jBtExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtExcluirProdutoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (Util.perguntar("Deseja excluir o produto ?") == true) {
            int ind = mpj_jTbCompras.getSelectedRow();
            controllerComprasProdutos.removeBean(ind);
        }

    }//GEN-LAST:event_mpj_jBtExcluirProdutoActionPerformed

    private void mpj_jBtIncluirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtIncluirCompraActionPerformed
        // TODO add your handling code here:
        incluirCompra = true;
        Util.limpar(mpj_jTxtTotalCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboVedendor, mpj_jCboFornecedor);
        Util.habilitar(true, mpj_jBtrConfirmarCompra, mpj_jBtCancelarCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboVedendor, mpj_jCboFornecedor);
        Util.habilitar(false, mpj_jTxtCodigoCompra, mpj_jBtAlterarCompra, mpj_jBtIncluirCompra, mpj_jBtExcluirCompra, mpj_jBtAlterarCompra, mpj_jTxtTotalCompra);

    }//GEN-LAST:event_mpj_jBtIncluirCompraActionPerformed

    private void mpj_jBtrConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtrConfirmarCompraActionPerformed
        // TODO add your handling code here:
        CompraDAO compraDAO = new CompraDAO();
        CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();
        MpjTbCompra compra = viewBean();

        if (validacaoCompra() == false) {
            if (incluirCompra == true) {

                compraDAO.insert(compra);
                for (int ind = 0; ind < mpj_jTbCompras.getRowCount(); ind++) {
                    MpjTbCompraProduto compraProdutos = controllerComprasProdutos.getBean(ind);
                    compraProdutos.setMpjTbCompra(compra);
                    compraProdutoDAO.insert(compraProdutos);
                }

                Util.mensagem("Compra Cadastrada com sucesso");
                HistoricoTransacoes.salvar(
                        "CREATE compra",
                        "Fornecedor: " + viewBean().getMpjTbFornecedor().getMpjNomeFantasiaFornecedor()
                        + ", Valor: " + viewBean().getMpjValorCompra()
                );
                Util.limpar(mpj_jTxtTotalCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboVedendor, mpj_jCboFornecedor);

            } else {
                compraDAO.update(compra);
                compraProdutoDAO.deleteProdutos(compra);
                for (int ind = 0; ind < mpj_jTbCompras.getRowCount(); ind++) {
                    MpjTbCompraProduto compraProdutos = controllerComprasProdutos.getBean(ind);
                    compraProdutos.setMpjTbCompra(compra);
                    compraProdutoDAO.insert(compraProdutos);
                }
                //remove todos os pedidosprodutos 

                Util.mensagem("Compra Atualizada com sucesso ");
                HistoricoTransacoes.salvar(
                        "UPDATE compra",
                        "Fornecedor: " + viewBean().getMpjTbFornecedor().getMpjNomeFantasiaFornecedor()
                        + ", Valor: " + viewBean().getMpjValorCompra()
                );
                Util.limpar(mpj_jTxtTotalCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboVedendor, mpj_jCboFornecedor);

            }

            Util.habilitar(true, mpj_jBtAdicionarProduto, mpj_jBtAlterarCompra, mpj_jBtExcluirProduto, mpj_jBtIncluirCompra, mpj_jBtExcluirCompra, mpj_jBtAlterarCompra);
            Util.habilitar(false, mpj_jBtCancelarCompra, mpj_jBtrConfirmarCompra);

        }

    }//GEN-LAST:event_mpj_jBtrConfirmarCompraActionPerformed

    private void mpj_jBtAlterarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtAlterarCompraActionPerformed
        // TODO add your handling code here:
        incluirCompra = false;

        Util.habilitar(true, mpj_jBtrConfirmarCompra, mpj_jBtCancelarCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboVedendor, mpj_jCboFornecedor);
        Util.habilitar(false, mpj_jTxtCodigoCompra, mpj_jBtAlterarCompra, mpj_jBtIncluirCompra, mpj_jBtExcluirCompra, mpj_jBtAlterarCompra, mpj_jTxtTotalCompra);

    }//GEN-LAST:event_mpj_jBtAlterarCompraActionPerformed

    private void mpj_jBtExcluirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtExcluirCompraActionPerformed
        // TODO add your handling code here:

        if (Util.perguntar(
                "Deseja deletar essa compra?") == true) {
            CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();
            CompraDAO compraDAO = new CompraDAO();
            for (int ind = 0; ind < mpj_jTbCompras.getRowCount(); ind++) {
                MpjTbCompraProduto compraProdutos = controllerComprasProdutos.getBean(ind);
                compraProdutoDAO.delete(compraProdutos);
            }
            compraDAO.delete(viewBean());
            Util.mensagem("Compra Deletada com sucesso");
            //HistoricoTransacoes.salvar(
            //        "Delete da compra",
            //     "Fornecedor: " + compraDelete.getMpjTbFornecedor().getMpjNomeFantasiaFornecedor()
            //     + ", Valor: " + compraDelete.getMpjValorCompra()
            ///
            //Util.limpar(mpj_jTxtTotalCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboFornecedor, mpj_jCboVedendor);

            // Util.limpar(mpj_jTxtTotalCompra, mpj_jTxtCodigoCompra, mpj_jFtmDataCompra, mpj_jCboFornecedor, mpj_jCboVedendor);
        } else {
            Util.mensagem("Operacao Cancelada");
        }


    }//GEN-LAST:event_mpj_jBtExcluirCompraActionPerformed

    private void mpj_jBtCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtCancelarCompraActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, mpj_jBtAdicionarProduto, mpj_jBtAlterarCompra, mpj_jBtExcluirProduto, mpj_jBtIncluirCompra, mpj_jBtExcluirCompra, mpj_jBtAlterarCompra);
        Util.mensagem("Operacao Cancelada");
        Util.habilitar(false, mpj_jBtCancelarCompra, mpj_jBtrConfirmarCompra);

    }//GEN-LAST:event_mpj_jBtCancelarCompraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JDlgCompraPesquisar jDlgCompraPesquisar = new JDlgCompraPesquisar(null, true);
        jDlgCompraPesquisar.setTelaPai(this);
        jDlgCompraPesquisar.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void atualizarTotal() {
        double total = 0.0;

        for (int i = 0; i < mpj_jTbCompras.getRowCount(); i++) {
            // Supondo que a coluna 2 seja quantidade e a coluna 3 seja valor unitário
            int quantidade = Integer.parseInt(mpj_jTbCompras.getValueAt(i, 2).toString());
            double valorUnitario = Double.parseDouble(mpj_jTbCompras.getValueAt(i, 3).toString());

            total += quantidade * valorUnitario;
        }

        mpj_jTxtTotalCompra.setText(String.format("%.2f", total));
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
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCompra dialog = new JDlgCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mpj_jBtAdicionarProduto;
    private javax.swing.JButton mpj_jBtAlterarCompra;
    private javax.swing.JButton mpj_jBtCancelarCompra;
    private javax.swing.JButton mpj_jBtEditarProduto;
    private javax.swing.JButton mpj_jBtExcluirCompra;
    private javax.swing.JButton mpj_jBtExcluirProduto;
    private javax.swing.JButton mpj_jBtIncluirCompra;
    private javax.swing.JButton mpj_jBtrConfirmarCompra;
    private javax.swing.JComboBox<MpjTbFornecedor> mpj_jCboFornecedor;
    private javax.swing.JComboBox<MpjTbFuncionario> mpj_jCboVedendor;
    private javax.swing.JFormattedTextField mpj_jFtmDataCompra;
    private javax.swing.JTable mpj_jTbCompras;
    private javax.swing.JTextField mpj_jTxtCodigoCompra;
    private javax.swing.JTextField mpj_jTxtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
