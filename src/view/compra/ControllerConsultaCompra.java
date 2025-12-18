/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.compra;

import bean.MpjTbCompra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultaCompra extends AbstractTableModel {

    private List<MpjTbCompra> lstCompras;


    public void setList(List<MpjTbCompra> lstCompras) {
        this.lstCompras = lstCompras;
        this.fireTableDataChanged();
    }


    public MpjTbCompra getBean(int rowIndex) {
        if (lstCompras == null || rowIndex < 0 || rowIndex >= lstCompras.size()) {
            return null;
        }
        return lstCompras.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstCompras == null ? 0 : lstCompras.size();
    }

    @Override
    public int getColumnCount() {
        return 4; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbCompra compra = getBean(rowIndex);
        if (compra == null) return "";

     
        if (columnIndex == 0) {
            return compra.getMpjIdCompra();
        } else if (columnIndex == 1) {
            return compra.getMpjTbFornecedor();
        } else if (columnIndex == 2) {
            return compra.getMpjDataCompra();
        } else if (columnIndex == 3) {
            return compra.getMpjValorCompra();
        } else {
            return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Número da Compra";
        } else if (columnIndex == 1) {
            return "Fornecedor";
        } else if (columnIndex == 2) {
            return "Data da Compra";
        } else if (columnIndex == 3) {
            return "Valor Total";
        } else {
            return "";
        }
    }
}

