import java.util.Random;

public class QuickSort {
    private static Random rnd = new Random();
    private static int trocas = 0;
    private static int iteracoes = 0;
    private static int tamanho;

    public static void quickSort(int[] vetor) {
        quickSort(vetor, 0, tamanho - 1);
    }

    public static void quickSort(int[] vetor, int inferior, int superior) {
        int pivo;
        if (inferior >= superior)
            return;

        pivo = particiona(vetor, inferior, superior);

        quickSort(vetor, inferior, pivo - 1);
        quickSort(vetor, pivo + 1,superior);
    }

    public static int particiona(int[] vetor, int inferior, int superior) {
        int temp, pivo = inferior;

        iteracoes++;

        while(inferior <= superior) {
            while (vetor[inferior] <= vetor[pivo]) {
                inferior += 1;
                if (inferior == tamanho) {
                    temp = vetor[pivo];
                    vetor[pivo] = vetor[tamanho - 1];
                    vetor[tamanho - 1] = temp;
                    trocas++;
                    return tamanho - 1;
                }
            }
            while (vetor[superior] > vetor[pivo]) {
                superior -= 1;
            }
            if(inferior < superior) {
                temp = vetor[inferior];
                vetor[inferior] = vetor[superior];
                vetor[superior] = temp;
                trocas++;
            }
        }
        temp = vetor[pivo];
        vetor[pivo] = vetor[superior];
        vetor[superior] = temp;
        trocas++;
        return superior;
    }

    public static void main(String[] args) {
        tamanho = 50;
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rnd.nextInt();
            //System.out.print(" " + vetor[i] + " ");
        } System.out.println();

        long tempo = System.currentTimeMillis();

        quickSort(vetor);

        tempo = System.currentTimeMillis() - tempo;

        for (int i = 0; i < tamanho; i++) {
            //System.out.print(" " + vetor[i] + " ");
        } System.out.println();

        System.out.println("Tempo de Execução: " + tempo +
                "\nNumero de Iterações: " + iteracoes +
                "\nNumero de Trocas: " + trocas);
    }
}
