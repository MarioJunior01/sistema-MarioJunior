/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.funcionario;

import bean.MpjTbFuncionario;
import dao.FuncionarioDAO;
import java.awt.Color;
import javax.swing.border.LineBorder;
import tools.Util;

/**
 *
 * @author mario
 */
public class JDlgFuncionarios extends javax.swing.JDialog {

    private boolean incluir = true;

    public JDlgFuncionarios(java.awt.Frame parent, boolean modal) {
        initComponents();
        Util.habilitar(false, mpj_jCboSexoFuncionario1, mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario, mpj_jBtnCancelar, mpj_jBtnConfirmar);
    }

    public MpjTbFuncionario viewBean() {
        MpjTbFuncionario funcionario = new MpjTbFuncionario();

        funcionario.setMpjNomeCompletoFuncionario(mpj_jTxtNomeFuncionario.getText());
        funcionario.setMpjCpfFuncionario(mpj_jFmtCpfFuncionario.getText());
        funcionario.setMpjTelefoneFuncionario(mpj_jFmtTelefoneFuncionario.getText());
        funcionario.setMpjEmailFuncionario(mpj_jTxtEmailFuncionario.getText());
        funcionario.setMpjCargoFuncionario(mpj_jCboCargoFuncionario.getSelectedItem().toString());
        funcionario.setMpjSetorFuncionario(mpj_jCboSetorFuncionario.getSelectedItem().toString());
        funcionario.setMpjSexoFuncionario(mpj_jCboSexoFuncionario1.getSelectedItem().toString());
        funcionario.setMpjDataNascimento(Util.strToDate(mpj_jFmtDataNascimentoFuncionario.getText().trim()));

        return funcionario;
    }

    //criar a chave estrageira no banco
    public void beanView(MpjTbFuncionario funcionario) {
        mpj_jTxtNomeFuncionario.setText(funcionario.getMpjNomeCompletoFuncionario());
        mpj_jTxtEmailFuncionario.setText(funcionario.getMpjEmailFuncionario());
        mpj_jFmtDataNascimentoFuncionario.setText(Util.dateToStr(funcionario.getMpjDataNascimento()));
        mpj_jFmtCpfFuncionario.setText(funcionario.getMpjCpfFuncionario());
        mpj_jFmtTelefoneFuncionario.setText(funcionario.getMpjTelefoneFuncionario());
        mpj_jCboSetorFuncionario.setSelectedItem(funcionario.getMpjSetorFuncionario());
        mpj_jCboCargoFuncionario.setSelectedItem(funcionario.getMpjCargoFuncionario());
        mpj_jCboSexoFuncionario1.setSelectedItem(funcionario.getMpjSexoFuncionario());
    }

    public boolean validacao() {
        LineBorder bordaErro = new LineBorder(Color.RED, 2);
        LineBorder bordaNormal = new LineBorder(Color.GRAY, 1);
        if (mpj_jTxtNomeFuncionario.getText().length() <= 5) {
            Util.mensagem("Por favor preencha seu nome corretamente");
            mpj_jTxtNomeFuncionario.setBorder(bordaErro);
            return true;
        } else {
            mpj_jTxtNomeFuncionario.setBorder(bordaNormal);
        }
        if (mpj_jTxtEmailFuncionario.getText().length() <= 8) {
            Util.mensagem("Por favor preencha seu e-mail corretamente");
            mpj_jTxtEmailFuncionario.setBorder(bordaErro);
            return true;
        } else {
            mpj_jTxtEmailFuncionario.setBorder(bordaNormal);
        }

        if (mpj_jFmtCpfFuncionario.getText().isEmpty() || mpj_jFmtCpfFuncionario.getText().length() != 14) {
            Util.mensagem("Digite um CPF válido!");
            mpj_jFmtCpfFuncionario.setBorder(new LineBorder(Color.RED, 2));
            return true;
        } else {
            mpj_jFmtCpfFuncionario.setBorder(new LineBorder(Color.GRAY, 1));
        }

        if (mpj_jCboCargoFuncionario.getSelectedIndex() == -1) {
            Util.mensagem("Por favor selecione uma opcao");
            mpj_jCboSexoFuncionario1.setBorder(bordaErro);
            return true;
        } else {
            mpj_jCboCargoFuncionario.setBorder(bordaNormal);
        }
        if (mpj_jCboSetorFuncionario.getSelectedIndex() == -1) {
            Util.mensagem("Por favor selecione uma opcao");
            mpj_jCboSetorFuncionario.setBorder(bordaErro);
            return true;
        } else {
            mpj_jCboSetorFuncionario.setBorder(bordaNormal);
        }
        if (mpj_jCboSexoFuncionario1.getSelectedIndex() == -1) {
            Util.mensagem("Por favor selecione uma opcao");
            mpj_jCboSexoFuncionario1.setBorder(bordaErro);
            return true;
        } else {
            mpj_jCboSexoFuncionario1.setBorder(bordaNormal);
        }

        if (Util.strToDate(mpj_jFmtDataNascimentoFuncionario.getText()) == null) {
            Util.mensagem("Data invalida");
            mpj_jFmtDataNascimentoFuncionario.setBorder(bordaErro);
            return true;
        } else {
            mpj_jFmtDataNascimentoFuncionario.setBorder(bordaNormal);
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
        mpj_jTxtNomeFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mpj_jFmtCpfFuncionario = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        mpj_jFmtTelefoneFuncionario = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        mpj_jFmtDataNascimentoFuncionario = new javax.swing.JFormattedTextField();
        mpj_jCboSetorFuncionario = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mpj_jTxtEmailFuncionario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mpj_jCboCargoFuncionario = new javax.swing.JComboBox<String>();
        mpj_jBtnIncluir = new javax.swing.JButton();
        mpj_jBtnAlterar = new javax.swing.JButton();
        mpj_jBtnExcluir = new javax.swing.JButton();
        mpj_jBtnConfirmar = new javax.swing.JButton();
        mpj_jBtnCancelar = new javax.swing.JButton();
        mpj_jBtnPesquisar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mpj_jCboSexoFuncionario1 = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome Completo:");

        mpj_jTxtNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jTxtNomeFuncionarioActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF:");

        try {
            mpj_jFmtCpfFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Telefone:");

        try {
            mpj_jFmtTelefoneFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Data de Nascimento:");

        try {
            mpj_jFmtDataNascimentoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        mpj_jCboSetorFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limpeza", "Administrativo", "Atendimento", "Caixa", "Vendas" }));

        jLabel5.setText("Setor Funcionário:");

        jLabel6.setText("Email:");

        jLabel7.setText("Sexo:");

        mpj_jCboCargoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Caixa", "Empacotador", "Gerente", "Limpeza", "Empregado" }));
        mpj_jCboCargoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jCboCargoFuncionarioActionPerformed(evt);
            }
        });

        mpj_jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_add.png"))); // NOI18N
        mpj_jBtnIncluir.setText("Incluir");
        mpj_jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtnIncluirActionPerformed(evt);
            }
        });

        mpj_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        mpj_jBtnAlterar.setText("Alterar");
        mpj_jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtnAlterarActionPerformed(evt);
            }
        });

        mpj_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_remove.png"))); // NOI18N
        mpj_jBtnExcluir.setText("Excluir");
        mpj_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtnExcluirActionPerformed(evt);
            }
        });

        mpj_jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apply.png"))); // NOI18N
        mpj_jBtnConfirmar.setText("Confirmar");
        mpj_jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtnConfirmarActionPerformed(evt);
            }
        });

        mpj_jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        mpj_jBtnCancelar.setText("Cancelar");
        mpj_jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtnCancelarActionPerformed(evt);
            }
        });

        mpj_jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        mpj_jBtnPesquisar.setText("Pesquisar");
        mpj_jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpj_jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carteira-de-identidade (1).png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Cadastro Funcionários");

        jLabel10.setText("Cargo  Funcionário");

        mpj_jCboSexoFuncionario1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mpj_jBtnIncluir)
                .addGap(15, 15, 15)
                .addComponent(mpj_jBtnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mpj_jBtnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpj_jBtnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(mpj_jBtnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mpj_jBtnPesquisar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mpj_jTxtNomeFuncionario)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mpj_jFmtCpfFuncionario)
                            .addComponent(mpj_jFmtTelefoneFuncionario)
                            .addComponent(mpj_jTxtEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mpj_jCboSexoFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(mpj_jFmtDataNascimentoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mpj_jCboSetorFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(136, 136, 136))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(mpj_jCboCargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mpj_jTxtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mpj_jFmtCpfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mpj_jFmtTelefoneFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mpj_jCboCargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mpj_jFmtDataNascimentoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mpj_jTxtEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mpj_jCboSetorFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpj_jCboSexoFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mpj_jBtnAlterar)
                    .addComponent(mpj_jBtnExcluir)
                    .addComponent(mpj_jBtnPesquisar)
                    .addComponent(mpj_jBtnIncluir)
                    .addComponent(mpj_jBtnConfirmar)
                    .addComponent(mpj_jBtnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mpj_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, mpj_jCboSexoFuncionario1, mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario, mpj_jBtnConfirmar, mpj_jBtnCancelar);
        Util.habilitar(false, mpj_jBtnIncluir, mpj_jBtnAlterar, mpj_jBtnExcluir, mpj_jBtnPesquisar);
    }//GEN-LAST:event_mpj_jBtnIncluirActionPerformed

    private void mpj_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, mpj_jCboSexoFuncionario1, mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario, mpj_jBtnConfirmar, mpj_jBtnCancelar);
        Util.habilitar(false, mpj_jBtnIncluir, mpj_jBtnAlterar, mpj_jBtnExcluir, mpj_jBtnPesquisar);
    }//GEN-LAST:event_mpj_jBtnAlterarActionPerformed

    private void mpj_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtnExcluirActionPerformed
        // TODO add your handling code here:

        boolean resposta = Util.perguntar("Deseja excluir o registro?");
        if (resposta != true) {
            Util.mensagem("Operacao Cancelada");
            Util.limpar(mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario);

        } else {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.delete(viewBean());
            Util.mensagem("Funcionario Removido");
            Util.limpar(mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario);

        }
    }//GEN-LAST:event_mpj_jBtnExcluirActionPerformed

    private void mpj_jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (validacao() == false) {
            if (incluir == true) {
                funcionarioDAO.insert(viewBean());
                Util.mensagem("Funcionario Cadastrado com Sucesso");
            } else {

                funcionarioDAO.update(viewBean());
                Util.mensagem("Funcionario  Atualizado com sucesso");
            }

            Util.habilitar(false, mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario, mpj_jBtnConfirmar, mpj_jBtnCancelar);
            Util.limpar(mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario);

            Util.habilitar(true, mpj_jBtnIncluir, mpj_jBtnAlterar, mpj_jBtnExcluir, mpj_jBtnPesquisar);
        }
    }//GEN-LAST:event_mpj_jBtnConfirmarActionPerformed

    private void mpj_jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtnCancelarActionPerformed
        // TODO add your handling code here:

        Util.habilitar(false, mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario, mpj_jBtnCancelar, mpj_jBtnConfirmar);
        Util.habilitar(true, mpj_jBtnIncluir, mpj_jBtnAlterar, mpj_jBtnExcluir, mpj_jBtnPesquisar);
        Util.limpar(mpj_jTxtNomeFuncionario, mpj_jFmtTelefoneFuncionario, mpj_jFmtDataNascimentoFuncionario, mpj_jFmtCpfFuncionario, mpj_jTxtEmailFuncionario, mpj_jCboCargoFuncionario, mpj_jCboSetorFuncionario);

    }//GEN-LAST:event_mpj_jBtnCancelarActionPerformed

    private void mpj_jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        JDlgFuncionariosPesquisar jdlgFuncionariosPesquisar = new JDlgFuncionariosPesquisar(null, true);
        jdlgFuncionariosPesquisar.setTelaPai(this);
        jdlgFuncionariosPesquisar.setVisible(true);
    }//GEN-LAST:event_mpj_jBtnPesquisarActionPerformed

    private void mpj_jTxtNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jTxtNomeFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpj_jTxtNomeFuncionarioActionPerformed

    private void mpj_jCboCargoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpj_jCboCargoFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpj_jCboCargoFuncionarioActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgFuncionarios dialog = new JDlgFuncionarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton mpj_jBtnAlterar;
    private javax.swing.JButton mpj_jBtnCancelar;
    private javax.swing.JButton mpj_jBtnConfirmar;
    private javax.swing.JButton mpj_jBtnExcluir;
    private javax.swing.JButton mpj_jBtnIncluir;
    private javax.swing.JButton mpj_jBtnPesquisar;
    private javax.swing.JComboBox<String> mpj_jCboCargoFuncionario;
    private javax.swing.JComboBox<String> mpj_jCboSetorFuncionario;
    private javax.swing.JComboBox<String> mpj_jCboSexoFuncionario1;
    private javax.swing.JFormattedTextField mpj_jFmtCpfFuncionario;
    private javax.swing.JFormattedTextField mpj_jFmtDataNascimentoFuncionario;
    private javax.swing.JFormattedTextField mpj_jFmtTelefoneFuncionario;
    private javax.swing.JTextField mpj_jTxtEmailFuncionario;
    private javax.swing.JTextField mpj_jTxtNomeFuncionario;
    // End of variables declaration//GEN-END:variables
}
