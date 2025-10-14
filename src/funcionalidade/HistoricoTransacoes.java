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

    private static final String ARQUIVO_CSV = "historico-transacoes/historico/historico_transacoes.csv";
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Salva uma transação no arquivo CSV.
     *
     * @param acao A ação realizada.
     * @param detalhes Detalhes da transação.
     */
    public static void salvar(String acao, String detalhes) {
        File arquivo = new File(ARQUIVO_CSV);

        try {
            // Garante que os diretórios existem
            File diretorio = arquivo.getParentFile();
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            boolean novoArquivo = arquivo.createNewFile(); // cria o arquivo se não existir

            // Try-with-resources garante o fechamento automático do FileWriter
            try (FileWriter fw = new FileWriter(arquivo, true)) {
                // Adiciona cabeçalho se o arquivo é novo
                if (novoArquivo) {
                    fw.append("DataHora,Ação,Detalhes\n");
                }

                String dataHora = LocalDateTime.now().format(FORMATADOR);

                // Substitui vírgulas em detalhes por ponto e vírgula para não quebrar o CSV
                String linha = String.format("%s,%s,%s%n", dataHora, acao, detalhes.replace(", ", " ; "));
                fw.append(linha);
            }

        } catch (IOException e) {
            System.err.println("Erro ao salvar histórico de transações: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método de teste rápido
}
