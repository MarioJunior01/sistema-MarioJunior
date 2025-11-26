/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.compra;

import bean.MpjTbCompra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControllerCompra extends AbstractTableModel {

    private List listaCompras;

    public void setList(List listaCompras) {
        this.listaCompras = listaCompras;
    }

    public MpjTbCompra getBean(int rowIndex) {
        return (MpjTbCompra) listaCompras.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return listaCompras.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbCompra compra = (MpjTbCompra) listaCompras.get(rowIndex);
        if (columnIndex == 0) {
            return compra.getMpjIdCompra();
        } else if (columnIndex == 1) {
            return compra.getMpjDataCompra();
        } else if (columnIndex == 2) {
            return compra.getMpjTbFornecedor();
        } else if (columnIndex == 3) {
            return compra.getMpjTbFuncionario();

        } else if (columnIndex == 4) {
            return compra.getMpjValorCompra();

        }
        return "";
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        } else if (columnIndex == 1) {
            return "Data ";
        } else if (columnIndex == 2) {
            return "Fornecedor";
        } else if (columnIndex == 3) {
            return "Funcionario";
        } else if (columnIndex == 4) {
            return "Valor ";
        }
        return "";
    }
}
