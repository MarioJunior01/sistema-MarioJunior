/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.usuarios;

/**
 *
 * @author mario
 */;

import bean.MpjTbUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */


public class ControllerConsultaUsuario extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
        this.fireTableDataChanged();
    }

    public MpjTbUsuario getBean(int rowIndex) {
        return (MpjTbUsuario) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios == null ? 0 : lstUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbUsuario usuario = (MpjTbUsuario) lstUsuarios.get(rowIndex);

        if (columnIndex == 0) {
            return usuario.getMpjCpfUsuario();
        } else if (columnIndex == 1) {
            return usuario.getMpjNomeUsuario();
        } else if (columnIndex == 2) {
            return usuario.getMpjDataNascimentoUsuario();
        }

        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "CPF";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return "Data de Nascimento";
        }

        return "";
    }
}
