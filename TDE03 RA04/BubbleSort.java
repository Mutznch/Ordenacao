import java.util.Random;

public class BubbleSort {
    private static Random rnd = new Random();
    private static int trocas = 0;
    private static int iteracoes = 0;

    public static void bubbleSort(int[] vetor, int tamanho) {
        int trocas, temp = 0;

        for (int i = 0; i < tamanho; i++) {
            trocas = 0;
            for (int j = 1; j < (tamanho - i); j++) {
                if (vetor[j-1] > vetor[j]) {
                    temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                    trocas++;
                }
            }
            iteracoes++;
            BubbleSort.trocas += trocas;
            if (trocas == 0) break;
        }
    }

    public static void main(String[] args) {
        int tamanho = 50;
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rnd.nextInt();
            System.out.print(" " + vetor[i] + " ");
        }
        System.out.println();
        long tempo = System.currentTimeMillis();

        bubbleSort(vetor, tamanho);

        tempo = System.currentTimeMillis() - tempo;

        for (int i = 0; i < tamanho; i++) {
            System.out.print(" " + vetor[i] + " ");
        }
        System.out.println();
        System.out.println("Tempo de Execução: " + tempo +
                            "\nNumero de Iterações: " + iteracoes +
                            "\nNumero de Trocas: " + trocas);
    }
}
