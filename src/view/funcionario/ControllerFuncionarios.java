/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionario;

import bean.MpjTbFuncionario;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControllerFuncionarios extends AbstractTableModel {

    private List listaFuncionario;

    public void setList(List listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public MpjTbFuncionario getBean(int rowIndex) {

        return (MpjTbFuncionario) listaFuncionario.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return listaFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbFuncionario mpjTbfuncionario = (MpjTbFuncionario) listaFuncionario.get(rowIndex);

        if (columnIndex == 0) {
           return mpjTbfuncionario.getMpjNomeCompletoFuncionario();
        } else if (columnIndex == 1) {
            return mpjTbfuncionario.getMpjCpfFuncionario();
        } else if (columnIndex == 2) {
           return  mpjTbfuncionario.getMpjTelefoneFuncionario();
        } else if (columnIndex == 3) {
           return  mpjTbfuncionario.getMpjEmailFuncionario();
        } else if (columnIndex == 4) {
            return mpjTbfuncionario.getMpjDataNascimento();
        } else if (columnIndex == 5) {
            return mpjTbfuncionario.getMpjCargoFuncionario();
        } else if (columnIndex == 6) {
            return mpjTbfuncionario.getMpjSetorFuncionario();
        } else if (columnIndex == 7) {
            return mpjTbfuncionario.getMpjSexoFuncionario();
        }
        return "";
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome";
        } else if (columnIndex == 1) {
            return "CPF";
        } else if (columnIndex == 2) {
            return "Telefone";
        } else if (columnIndex == 3) {
            return "Email";
        } else if (columnIndex == 4) {
            return "Data Nascimento ";
        } else if (columnIndex == 5) {
            return "Cargo";
        } else if (columnIndex == 6) {
            return "Setor";
        } else if (columnIndex == 7) {
            return "Sexo ";
        }
        return "";
    }

}
