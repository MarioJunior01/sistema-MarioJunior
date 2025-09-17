package tools;

import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author u1845853
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            //instanceof
            

            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
            if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(-1);
            }
            if (componentes[i] instanceof JPasswordField){
                ((JPasswordField) componentes[i]).setText("");
            }
              if (componentes[i] instanceof JCheckBox){
                ((JCheckBox) componentes[i]).setSelected(false);
            }

            
                        
        }
    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean perguntar(String cad) {
        int resposta = JOptionPane.showConfirmDialog(null, cad);
        System.out.println(resposta);
        if (resposta != 0) {

            return true;
        } else {
            return false;
        }
    }

    public static int srToInt(String num) {
        return Integer.parseInt(num);

    }

    public static String intToStr(int num) {

        return String.valueOf(num);
    }

    public static double strToDouble(String num) {
        return 0;

    }

    public static String doubleToStr(double  num) {
        
       StringBuilder  numSbuilde = new  StringBuilder();
         numSbuilde.append("");
          return numSbuilde.toString();

    }

    public static String dateToStr(Date data) {

        return ""; 
		
    }
     public static Date strToDate(Date data) {

        return null; 
		
    }
}

//primeiro commit - Pacotes tools e view. Util.java finalizado.
// segundo commit - Tela principal e telas dos cadastros finalizados
// terceiro commit - Telas de cadastros usando o Util.java
