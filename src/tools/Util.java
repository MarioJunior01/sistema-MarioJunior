package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            if (componentes[i] instanceof JPasswordField) {
                ((JPasswordField) componentes[i]).setText("");
            }
            if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            }

        }
    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean perguntar(String cad) {

        JOptionPane.showConfirmDialog(null, cad, "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return true;
    }

    public static int srToInt(String num) {
        return Integer.parseInt(num);

    }

    public static String intToStr(int num) {

        return String.valueOf(num);
    }

    public static double strToDouble(String num) {
        return Double.parseDouble(num);

    }

    public static String doubleToStr(double num) {
        return Double.toString(num);
    }

    public static String dateToStr(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         String dataStr = formato.format(data);

        return dataStr;

    }

    public static Date strToDate(String data) throws ParseException {
           SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");             
        return formato.parse(data);

    }
}


