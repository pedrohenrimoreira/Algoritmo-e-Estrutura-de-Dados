import java.util.Scanner;

public class ArrayHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int casos = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número de casos

        while (casos > 0) {
            int qtsLinhas = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número de linhas

            int qtsCaso = 0;
            int somaLetras = 0;

            while (qtsLinhas > 0) {
                String string = scanner.nextLine();

                int i = 0;
                int qtsLetra = 0;

                while (i < string.length()) {
                    somaLetras += (string.charAt(i) - 'A') + qtsCaso + qtsLetra;

                    i++;
                    qtsLetra++;
                }

                qtsCaso++;

                qtsLinhas--;
            }

            System.out.println(somaLetras);

            casos--;
        }

        scanner.close();
    }
}
