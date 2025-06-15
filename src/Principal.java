package src;

import src.classes.BuscaCidade;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        try (Scanner scan = new Scanner(System.in)){
            System.out.print("Insira o nome da cidade: ");
            String cidade = scan.nextLine();
            System.out.print("Insira o código telefônico da reguião: ");
            String ddd = scan.nextLine();

            BuscaCidade clima = new BuscaCidade();
            clima.cidade(cidade,ddd);
              System.out.println(clima.cidade(cidade,ddd));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
