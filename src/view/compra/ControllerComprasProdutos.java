/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.compra;

import bean.MpjTbCompraProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControllerComprasProdutos extends AbstractTableModel {

    private List lstComprasProdutos;

    public void setList(List lstComprasProdutos) {
        this.lstComprasProdutos = lstComprasProdutos;
    }

    public MpjTbCompraProduto getBean(int rowIndex) {
        return (MpjTbCompraProduto) lstComprasProdutos.get(rowIndex);
    }

    public void addBean(MpjTbCompraProduto compraProduto) {
        lstComprasProdutos.add(compraProduto);
        this.fireTableDataChanged();
    }

    public void removeBean(int rowIndex) {
        lstComprasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstComprasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbCompraProduto compraProdutos = (MpjTbCompraProduto) lstComprasProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return compraProdutos.getMpjTbProduto().getMpjIdProduto();
        } else if (columnIndex == 1) {
            return compraProdutos.getMpjTbProduto().getMpjNomeProduto();
        } else if (columnIndex == 2) {
            return compraProdutos.getMpjQuantidadeProduto();
        } else if (columnIndex == 3) {
            return compraProdutos.getMpjValorUnitario();
        } else if (columnIndex == 4) {
            return compraProdutos.getMpjValorUnitario() * compraProdutos.getMpjQuantidadeProduto();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Produto";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Total";
        }
        return "";
    }
}
