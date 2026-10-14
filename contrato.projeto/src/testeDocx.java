import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class testeDocx {
    public static void main(String[] args) throws IOException {
        ZipFile zip = new ZipFile("../template/template_contrato_prestacao_servicos.docx");

        // 1. Ler o texto do contrato (document.xml)
        ZipEntry entradaXml = zip.getEntry("word/document.xml");
        InputStream fluxo = zip.getInputStream(entradaXml);
        String xml = new String(fluxo.readAllBytes(), StandardCharsets.UTF_8);
        fluxo.close();

        // 2. Trocar um campo
        xml = xml.replace("{{CONTRATANTE_NOME}}", "Maria Souza");

        // 3. Montar o novo .docx, copiando os arquivos da caixa original
        ZipOutputStream saida = new ZipOutputStream(new FileOutputStream("../saida/teste.docx"));
        Enumeration<? extends ZipEntry> entradas = zip.entries();
        while (entradas.hasMoreElements()) {
            ZipEntry entrada = entradas.nextElement();
            saida.putNextEntry(new ZipEntry(entrada.getName()));

            if (entrada.getName().equals("word/document.xml")) {
                saida.write(xml.getBytes(StandardCharsets.UTF_8));
            } else {
                InputStream original = zip.getInputStream(entrada);
                saida.write(original.readAllBytes());
                original.close();
            }
            saida.closeEntry();
        }
        saida.close();
        zip.close();

        System.out.println("Arquivo criado em saida/teste.docx");
    }
}