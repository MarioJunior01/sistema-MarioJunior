/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.usuarios;

import bean.MpjTbUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mario
 */
public class ControllerUsuarios extends  AbstractTableModel{
   private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public MpjTbUsuario getBean(int rowIndex) {
        return (MpjTbUsuario) lstUsuarios.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lstUsuarios.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 7; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      MpjTbUsuario usuarios = (MpjTbUsuario) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getMpjIdUsuario();
        } else if (columnIndex ==1) {
            return usuarios.getMpjNomeUsuario();        
        } else if (columnIndex ==2) {
            return usuarios.getMpjApelidoUsuario();
        } else if (columnIndex ==3) {
            return usuarios.getMpjCpfUsuario();
        }
        else if (columnIndex ==4) {
            return usuarios.getMpjDataNascimentoUsuario();
        }
        else if (columnIndex ==5) {
            return usuarios.getMpjAtivoUsuario();
        }
         else if (columnIndex ==6) {
            return usuarios.getMpjNivelUsuario();
        }
        return "";
    }
    
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        }
        else if ( columnIndex == 4) {
            return "Data Nascimento";}
         else if ( columnIndex == 5) {
            return "Ativo";}
        else if ( columnIndex == 6) {
            return "Nivel";
        }
        return "";
    }
    
    
}
