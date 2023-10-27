import java.util.Random;

public class SelectionSort {
    private static Random rnd = new Random();
    private static int trocas = 0;
    private static int iteracoes = 0;

    public static void selectionSort(int[] vetor, int tamanho) {
        int menor, temp = 0;

        for (int i = 0; i < tamanho - 1; i++) {
            menor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[j] < vetor[menor]) menor = j;
            }
            temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
            if (i != menor) trocas++;
            iteracoes++;
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

        selectionSort(vetor, tamanho);

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
