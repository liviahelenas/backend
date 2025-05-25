package modelos;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        /* Criando o scanner para entrada do usuário*/
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome de uma cidade: ");
        String cidade = entrada.nextLine();

        /* Criando o objeto que faz a consulta*/
        ConsultaTemperatura consulta = new ConsultaTemperatura();

        /* excessão */
        Temperatura temperatura = null;
        try {
            temperatura = consulta.consultaTemperatura(cidade);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* Mostrando os dados no terminal*/
        System.out.println("🌤️ Cidade: " + temperatura.name());
        System.out.println("🌡️ modelos.Temperatura: " + temperatura.main().temp() + "°C");

        if (temperatura.weather() != null && temperatura.weather().length > 0) {
            System.out.println("📝 Clima: " + temperatura.weather()[0].description());

        } else {
            System.out.println("📝 Clima: informação indisponível.");
        }

        entrada.close();
    }
}