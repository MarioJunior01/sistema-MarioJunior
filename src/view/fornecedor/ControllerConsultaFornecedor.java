/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fornecedor;

/**
 *
 * @author mario
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


;
import bean.MpjTbFornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;



public class ControllerConsultaFornecedor extends AbstractTableModel {

     private List lstFornecedores;

    public void setList(List lstFornecedores) {
        this.lstFornecedores = lstFornecedores;
        this.fireTableDataChanged();
    }

    public MpjTbFornecedor getBean(int rowIndex) {
        return (MpjTbFornecedor) lstFornecedores.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstFornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbFornecedor usuario = (MpjTbFornecedor) lstFornecedores.get(rowIndex);

        if (columnIndex == 0) {
            return usuario.getMpjNomeFantasiaFornecedor();
        } else if (columnIndex == 1) {
            return usuario.getMpjCnpjFornecedor();
        } else if (columnIndex == 2) {
            return usuario.getMpjSegmentoFornecedor();
        }
        else if (columnIndex == 3) {
            return usuario.getMpjDataCriacaoFornecedor();
        }

        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome Fantasia";
        } else if (columnIndex == 1) {
            return "CNPJ";
        } else if (columnIndex == 2) {
            return "SEGMENTO";
        }
        else if (columnIndex == 3) {
            return "Data de Criacao";
        }

        return "";
    }
}
