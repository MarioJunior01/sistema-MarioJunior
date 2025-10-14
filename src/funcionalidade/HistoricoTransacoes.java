/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidade;

/**
 *
 * @author mario
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoTransacoes {

    private static final String ARQUIVO_CSV = "historico_transacoes.csv";

    // Salva uma transação no arquivo CSV
    public static void salvar(String acao, String detalhes) {
        File arquivo = new File(ARQUIVO_CSV);
        FileWriter fw = null;
        try {
            boolean novoArquivo = arquivo.createNewFile(); // cria se não existir
            fw = new FileWriter(arquivo, true); // true = append

            // Cabeçalho se for novo arquivo
            if (novoArquivo) {
                fw.append("DataHora,Ação,Detalhes\n");
            }

            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            // Formata a linha CSV
            String linha = String.format("%s,%s,%s\n", dataHora, acao, detalhes.replace(",", ";"));
            fw.append(linha);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
