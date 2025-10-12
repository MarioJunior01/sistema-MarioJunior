/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fornecedor;

import bean.MpjTbFornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControlleFornecedor extends AbstractTableModel {

    private List listaFornecedores;

    public void setList(List listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }

    public MpjTbFornecedor getBean(int rowIndex) {
        return (MpjTbFornecedor) listaFornecedores.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return listaFornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 15; // Ajuste conforme o número de colunas que deseja mostrar
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbFornecedor fornecedor = (MpjTbFornecedor) listaFornecedores.get(rowIndex);

        if (columnIndex == 0) {
            return fornecedor.getMpjNomeFantasiaFornecedor();
        } else if (columnIndex == 1) {
            return fornecedor.getMpjRazaoSocialFornecedor();
        } else if (columnIndex == 2) {
            return fornecedor.getMpjCnpjFornecedor();
        } else if (columnIndex == 3) {
            return fornecedor.getMpjEmailFornecedor();
        } else if (columnIndex == 4) {
            return fornecedor.getMpjTelefoneFornecedor();
        } else if (columnIndex == 5) {
            return fornecedor.getMpjCepFornecedor();
        } else if (columnIndex == 6) {
            return fornecedor.getMpjEstadoFornecedor();
        } else if (columnIndex == 7) {
            return fornecedor.getMpjRuaFornecedor();
        } else if (columnIndex == 8) {
            return fornecedor.getMpjNumeroFornecedor();       // Número
        } else if (columnIndex == 9) {
            return fornecedor.getMpjComplementoFornecedor();   // Complemento
        } else if (columnIndex == 10) {
            return fornecedor.getMpjSegmentoFornecedor();
        } else if (columnIndex == 11) {
            return fornecedor.getMpjServicoPrestadoFornecedor();
        } else if (columnIndex == 12) {
            return fornecedor.getMpjPorteFornecedor();
        } else if (columnIndex == 13) {
            return fornecedor.getMpjQuantidadeFuncionariosFornecedor();
        } else if (columnIndex == 14) {
            return fornecedor.getMpjNomeResponsavelFornecedor(); // Nome Representante
        } else {
            return "";
        }

    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome Fantasia";
        } else if (columnIndex == 1) {
            return "Razão Social";
        } else if (columnIndex == 2) {
            return "CNPJ";
        } else if (columnIndex == 3) {
            return "Email";
        } else if (columnIndex == 4) {
            return "Telefone";
        } else if (columnIndex == 5) {
            return "CEP";
        } else if (columnIndex == 6) {
            return "Estado";
        } else if (columnIndex == 7) {
            return "Rua";
        } else if (columnIndex == 8) {
            return "Numero";
        } else if (columnIndex == 9) {
            return "Complemento";
        } else if (columnIndex == 10) {
            return "Segmento";
        } else if (columnIndex == 11) {
            return "Serviço Prestado";
        } else if (columnIndex == 12) {
            return "Porte";
        } else if (columnIndex == 13) {
            return "Qtd Funcionários";
        } else if (columnIndex == 14) {
            return "Nome Representante";
        } else {
            return "";
        }

    }

}
