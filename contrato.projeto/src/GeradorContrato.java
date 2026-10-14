import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class GeradorContrato{
public static void main(String[] args) throws FileNotFoundException {
    

    Scanner entrada = new Scanner(new File("../template/template.txt"), "UTF-8");

    String contrato = "";

    while(entrada.hasNextLine()){
        String linha = entrada.nextLine();
        contrato = contrato + linha + "\n";
        
    }

    contrato = contrato.replace("{{CONTRATANTE_NOME}}", "MARIA CATARINA");

    System.out.println(contrato);



    entrada.close();
}}
