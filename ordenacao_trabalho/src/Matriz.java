import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private int linhas;
    private int colunas;

    // Construtor da matriz
    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        matriz = new int[linhas][colunas];
    }

    // Método para preencher a matriz com valores aleatórios
    public void preencherAleatorio(int limiteSuperior) {
        Random rand = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = rand.nextInt(limiteSuperior);
            }
        }
    }

    // Método para inserir um elemento na posição definida
    public void inserirElemento(int linha, int coluna, int valor) {
        linha -= 1;
        coluna -= 1;
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = valor;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    //    Método para remover um elemento de uma posição (substituir por 0)
    public void removerElemento(int linha, int coluna) {
        linha -= 1;
        coluna -= 1;
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = 0;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    // Método para exibir a matriz
    public void exibirMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Algoritmo Bubble Sort em linha
    public void bubbleSortLinha(int linha) {
        linha -= 1;
        if (linha >= 0 && linha < linhas) {
            for (int i = 0; i < colunas - 1; i++) {
                for (int j = 0; j < colunas - i - 1; j++) {
                    if (matriz[linha][j] > matriz[linha][j + 1]) {
                        int temp = matriz[linha][j];
                        matriz[linha][j] = matriz[linha][j + 1];
                        matriz[linha][j + 1] = temp;
                    }
                }
            }
        } else {
            System.out.println("Linha inválida.");
        }
    }

    // Algoritmo Bubble Sort para colunas
    public void bubbleSortColuna(int coluna) {
        coluna -= 1;
        if (coluna >= 0 && coluna < colunas) {
            for (int i = 0; i < linhas - 1; i++) {
                for (int j = 0; j < linhas - i - 1; j++) {
                    if (matriz[j][coluna] > matriz[j + 1][coluna]) {
                        int temp = matriz[j][coluna];
                        matriz[j][coluna] = matriz[j + 1][coluna];
                        matriz[j + 1][coluna] = temp;
                    }
                }
            }
        } else {
            System.out.println("Coluna inválida.");
        }
    }


    // Método recursivo do Merge Sort
    private void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    // Método auxiliar para fazer a mesclagem no Merge Sort
    private void merge(int[] vetor, int inicio, int meio, int fim) {
        // Passo 1: Determinar os tamanhos dos dois subarrays que serão mesclados
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        // Passo 2: Criar arrays temporários para armazenar os subarrays
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        // Passo 3: Copiar os dados para os arrays temporários
        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        // Passo 4: Mesclar os arrays temporários de volta no array original
        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        // Passo 5: Copiar os elementos restantes de esquerda[], se houver
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        // Passo 6: Copiar os elementos restantes de direita[], se houver
        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }


    // Método para achatar a matriz em um vetor
    private int[] achatarMatriz() {
        int[] vetor = new int[linhas * colunas];
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[index++] = matriz[i][j];
            }
        }
        return vetor;
    }

    // Método para reconstruir a matriz a partir de um vetor ordenado
    private void reconstruirMatriz(int[] vetor) {
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[index++];
            }
        }
    }

    // Algoritmo Merge Sort para ordenar a matriz inteira
    public void mergeSortMatriz() {
        int[] vetor = achatarMatriz();
        mergeSort(vetor, 0, vetor.length - 1);
        reconstruirMatriz(vetor);
    }

    // Algoritmo Merge Sort para ordenar uma linha
    public void mergeSortLinha(int linha) {
        linha -= 1; // Ajuste para que o usuário insira de 1 a 4
        if (linha >= 0 && linha < linhas) {
            mergeSort(matriz[linha], 0, colunas - 1);
        } else {
            System.out.println("Linha inválida.");
        }
    }

    // Algoritmo Merge Sort para ordenar uma coluna
    public void mergeSortColuna(int coluna) {
        coluna -= 1; // Ajuste para que o usuário insira de 1 a 4
        if (coluna >= 0 && coluna < colunas) {
            int[] tempColuna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                tempColuna[i] = matriz[i][coluna];
            }
            mergeSort(tempColuna, 0, linhas - 1);
            for (int i = 0; i < linhas; i++) {
                matriz[i][coluna] = tempColuna[i];
            }
        } else {
            System.out.println("Coluna inválida.");
        }
    }

    // Algoritmo Bubble Sort para ordenar a matriz inteira
    public void bubbleSortMatriz() {
        int[] vetor = achatarMatriz();
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        reconstruirMatriz(vetor);
    }
}