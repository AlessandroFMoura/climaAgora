package src;

import src.classes.BuscaCidade;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        while (true){
            try {
                System.out.print("Insira o nome da cidades: ");
                String  cidade = scan.nextLine();

                if (cidade.equalsIgnoreCase("sair")) {
                    break;
                }

                System.out.print("Insira o código da região: ");
                String  ddd = scan.nextLine();

                BuscaCidade clima = new BuscaCidade();
                System.out.println(clima.cidades(cidade,ddd));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
