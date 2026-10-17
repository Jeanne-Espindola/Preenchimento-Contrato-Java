import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;




public class GeradorContrato{
public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    

    Scanner entrada = new Scanner(new File("../template/template.txt"), "UTF-8");
    Scanner teclado = new Scanner(System.in);
    String contrato = "";

    while(entrada.hasNextLine()){
        String linha = entrada.nextLine();
        contrato = contrato + linha + "\n";
        
    }

        System.out.print("Nome do contratante: ");
        contrato = contrato.replace("{{CONTRATANTE_NOME}}", teclado.nextLine());
        System.out.print("CPF do contratante: ");
        contrato = contrato.replace("{{CONTRATANTE_CPF}}", teclado.nextLine());
        System.out.print("RG do contratante: ");
        contrato = contrato.replace("{{CONTRATANTE_RG}}", teclado.nextLine());
        System.out.print("Endereco do contratante: ");
        contrato = contrato.replace("{{CONTRATANTE_ENDERECO}}", teclado.nextLine());
        System.out.print("Cidade do contratante: ");
        contrato = contrato.replace("{{CONTRATANTE_CIDADE}}", teclado.nextLine());
        System.out.print("Estado do contratante: ");
        contrato = contrato.replace("{{CONTRATANTE_ESTADO}}", teclado.nextLine());




        System.out.print("Nome do contratado: ");
        contrato = contrato.replace("{{CONTRATADO_NOME}}", teclado.nextLine());
        System.out.print("CPF do contratado: ");
        contrato = contrato.replace("{{CONTRATADO_CPF}}", teclado.nextLine());
        System.out.print("RG do contratado: ");
        contrato = contrato.replace("{{CONTRATADO_RG}}", teclado.nextLine());
        System.out.print("Endereco do contratado: ");
        contrato = contrato.replace("{{CONTRATADO_ENDERECO}}", teclado.nextLine());
        System.out.print("Cidade do contratado: ");
        contrato = contrato.replace("{{CONTRATADO_CIDADE}}", teclado.nextLine());
        System.out.print("Estado do contratado: ");
        contrato = contrato.replace("{{CONTRATADO_ESTADO}}", teclado.nextLine());

        
        System.out.print("Descricao do servico: ");
        contrato = contrato.replace("{{DESCRICAO_SERVICO}}", teclado.nextLine());
        System.out.print("Data de inicio: ");
        contrato = contrato.replace("{{DATA_INICIO}}", teclado.nextLine());
        System.out.print("Data de termino: ");
        contrato = contrato.replace("{{DATA_TERMINO}}", teclado.nextLine());
        System.out.print("Valor total (so o numero): ");
        contrato = contrato.replace("{{VALOR_TOTAL}}", teclado.nextLine());
        System.out.print("Valor por extenso: ");
        contrato = contrato.replace("{{VALOR_EXTENSO}}", teclado.nextLine());
        System.out.print("Forma de pagamento: ");
        contrato = contrato.replace("{{FORMA_PAGAMENTO}}", teclado.nextLine());
        System.out.print("Aviso previo (em dias): ");
        contrato = contrato.replace("{{AVISO_PREVIO_DIAS}}", teclado.nextLine());

        System.out.print("Clausulas adicionais: ");
        contrato = contrato.replace("{{CLAUSULAS_ADICIONAIS}}", teclado.nextLine());
        System.out.print("Cidade do foro: ");
        contrato = contrato.replace("{{FORO_CIDADE}}", teclado.nextLine());
        System.out.print("Estado do foro: ");
        contrato = contrato.replace("{{FORO_ESTADO}}", teclado.nextLine());
        System.out.print("Numero de vias: ");
        contrato = contrato.replace("{{NUMERO_VIAS}}", teclado.nextLine());
        System.out.print("Local da assinatura: ");
        contrato = contrato.replace("{{LOCAL_ASSINATURA}}", teclado.nextLine());
        System.out.print("Data da assinatura: ");
        contrato = contrato.replace("{{DATA_ASSINATURA}}", teclado.nextLine());

        teclado.close();

        System.out.println("\nCONTRATO PREENCHIDO!\n");
        PrintWriter escritor = new PrintWriter("../saida/contrato_preenchido.txt", "UTF-8");
        escritor.println(contrato);
        escritor.close();
        System.out.println("Contrato salvo em saida/contrato_preenchido.txt");
        






    entrada.close();
}}
