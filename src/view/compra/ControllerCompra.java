/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.compra;

import bean.MpjTbCompra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControllerCompra extends AbstractTableModel {

    private List<MpjTbCompra> listaCompras;

    public ControllerCompra() {
        this.listaCompras = new ArrayList<>(); // inicializa para evitar NullPointerException
    }

    public void setList(List<MpjTbCompra> listaCompras) {
        if (listaCompras != null) {
            this.listaCompras = listaCompras;
        } else {
            this.listaCompras = new ArrayList<>();
        }
        fireTableDataChanged();
    }

    public MpjTbCompra getBean(int rowIndex) {
        if (listaCompras == null || rowIndex < 0 || rowIndex >= listaCompras.size()) {
            return null;
        }
        return listaCompras.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return (listaCompras != null) ? listaCompras.size() : 0;
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
