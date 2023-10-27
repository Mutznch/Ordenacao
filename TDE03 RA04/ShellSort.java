import java.util.Random;

public class ShellSort {
    private static Random rnd = new Random();
    private static int trocas = 0;
    private static int iteracoes = 0;
    private static int tamanho = 0;
    private static int tamanho_inc = 0;

    public static void shellSort(int[] vetor) {
        shellSort(vetor, incrementos());
    }

    private static void shellSort(int[] vetor, int[] incrementos) {
        int span, y, k;
        for(int i = 0; i < tamanho_inc; i++) {
            span = incrementos[i];
            iteracoes++;

            for(int j = span; j < tamanho; j++) {
                y = vetor[j];
                for(k = j - span; k >= 0 && y < vetor[k]; k -= span) {
                    vetor[k + span] = vetor[k];
                    trocas++;
                }
                vetor[k+span] = y;
                trocas++;
            }
        }
    }

    private static int[] incrementos() {
        int x = 1;
        while(h(x) < tamanho) x++;

        tamanho_inc = x - 2;
        int[] incrementos = new int[tamanho_inc];

        for (int i = 0; i < tamanho_inc; i++) {
            incrementos[i] = h(tamanho_inc - i);
        }

        return incrementos;
    }

    private static int h(int i) {
        if (i == 1) return i;
        return 3 * h(i - 1) + 1;
    }

    public static void main(String[] args) {
        tamanho = 15;
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rnd.nextInt();
            System.out.print(" " + vetor[i] + " ");
        }
        System.out.println();
        long tempo = System.currentTimeMillis();

        shellSort(vetor);

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
