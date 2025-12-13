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

        int resposta = JOptionPane.showConfirmDialog(
                null,
                cad,
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return resposta == JOptionPane.YES_OPTION;
    }

    public static int srToInt(String num) {
        return Integer.parseInt(num);

    }

    public static String intToStr(int num) {

        return String.valueOf(num);
    }

    public static double strToDouble(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return 0;
        }
        valor = valor.replace(",", "."); // converte vírgula em ponto
        return Double.parseDouble(valor);
    }

    public static String doubleToStr(double num) {
        return Double.toString(num);
    }

    public static String dateToStr(Date dataDt) {
        String dataStr = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataStr = df.format(dataDt);
        } catch (Exception ex) {
            dataStr = null;
        }
        return dataStr;

    }

    public static Date strToDate(String dataStr) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            return df.parse(dataStr.trim());
        } catch (ParseException | NullPointerException ex) {
            return null; // retorna null se a data for inválida ou nula
        }
    }

}
