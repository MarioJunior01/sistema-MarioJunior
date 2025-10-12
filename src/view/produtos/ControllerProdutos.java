/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.produtos;

import bean.MpjTbProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControllerProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }

    public MpjTbProduto getBean(int rowIndex) {
        return (MpjTbProduto) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 9; //To change body of generated methods, choose Tools | Templates.
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return ("Nome Produto");
        } else if (columnIndex == 3) {
            return ("Nome Fabricante");
        } else if (columnIndex == 4) {
            return ("Data Fabricacao");

        } else if (columnIndex == 5) {
            return ("Data de Validade");
        } else if (columnIndex == 6) {
            return "Preco";
        } else if (columnIndex == 7) {
            return "Descricao";
        }
        else if (columnIndex == 8) {
            return "Sgmento Produto";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpjTbProduto produtos = (MpjTbProduto) lstProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return produtos.getMpjIdProduto();
        } else if (columnIndex == 1) {
            return produtos.getMpjNomeProduto();
        } else if (columnIndex == 2) {
            return produtos.getMpjNomeFabricante();
        } else if (columnIndex == 3) {
            return produtos.getMpjDataFabricaoProduto();
        } else if (columnIndex == 4) {
            return produtos.getMpjDataFabricaoProduto();
        } else if (columnIndex == 5) {
            return produtos.getMpjValidadeProduto();
        } else if (columnIndex == 6) {
            return produtos.getMpjPrecoProduto();
        } else if (columnIndex == 7) {
            return produtos.getMpjDescricaoProduto();
        }
        else if (columnIndex == 8) {
            return produtos.getMpjSegmentoProduto();
        }
        return "";
    }

}
