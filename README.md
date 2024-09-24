# 🔢 Matriz - Implementação com Ordenação <br> (Bubble Sort e Merge Sort)

Este repositório contém uma implementação de uma **matriz bidimensional** com funcionalidades de preenchimento, manipulação e ordenação de elementos. A ordenação é feita usando os algoritmos **Bubble Sort** e **Merge Sort**, oferecendo flexibilidade dependendo do tamanho da matriz e da necessidade de desempenho.

## Índice

1. [Estrutura da Classe 🏛️](#estrutura-da-classe-%EF%B8%8F)
2. [Métodos de Manipulação 🫳💻](#métodos-de-manipulação-)
   - [preencherAleatorio()](#preencheraleatorio)
   - [inserirElemento()](#inserirelemento)
   - [removerElemento()](#removerelemento)
   - [exibirMatriz()](#exibirmatriz)
3. [Métodos de Estruturação 🛠️](#métodos-de-estruturação-%EF%B8%8F)
   - [achatarMatriz()](#achatarmatriz)
   - [reconstruirMatriz()](#reconstruirmatriz)
4. [Métodos de Ordenação 1️⃣2️⃣3️⃣](#métodos-de-ordenação-1%EF%B8%8F⃣2%EF%B8%8F⃣3%EF%B8%8F⃣)
   - [bubbleSortLinha()](#bubblesortlinha)
   - [mergeSort()](#mergesort)
   - [merge()](#merge)
   - [mergeSortLinha()](#mergesortlinha)
   - [mergeSortMatriz()](#mergesortmatriz)
   - [bubbleSortMatriz()](#bubblesortmatriz)
5. [Conclusão ✅](#conclusão-)
6. [Como usar ❓](#como-usar-)
7. [Licença 📃](#licença-)

## Estrutura da Classe 🏛️
A matriz é uma estrutura bidimensional composta por linhas e colunas para armazenar dados em forma de elementos. Dessa forma a estruturação da matriz é iniciado pela fundamentação de linhas e colunas
```
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
```
Acima é possível verificar como a matriz é declarada com duas listas “[ ] [ ]”. Após, é necessário declarar as variáveis de linhas e colunas, repare que os atributos estão encapsulados para aumentar a segurança desses atributos contra erros de execução. 
Após isso é declarado o construtor, o qual define a obrigatoriedade dos parâmetros estabelecidos na classe no momento da criação de uma nova matriz.


## Métodos de Manipulação 🫳💻
- ### preencherAleatorio()
```
public void preencherAleatorio(int limiteSuperior) {
        Random rand = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = rand.nextInt(limiteSuperior);
            }
        }
    }
```
Primeiramente, foi criado o método responsável pelo preenchimento da matriz, o qual usa da classe Random para definir um número aleatório, os loops for para percorrer cada linha e coluna da matriz e a atribuição do número com base em um limite superior, que é o número máximo que cada item pode atingir.

- ### inserirElemento()
```
public void inserirElemento(int linha, int coluna, int valor) {
        linha -= 1;
        coluna -= 1;
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = valor;
        } else {
            System.out.println("Posição inválida.");
        }
    }
```
O método recebe como parâmetro a posição do item definido pela linha e coluna, além do valor desejado pelo usuário. Após isso, é necessário reduzir em 1 o valor inserido nas posições, visto que a posição em uma lista é definida de 0 como primeira posição, ao invés de 1, tal qual o usuário está familiarizado. <br>
Por meio da condição de que o valor da linha e coluna seja  maior que 0 e que esteja dentro da quantidade total da lista de linhas e colunas, o item na posição definida recebe o valor proposto, caso contrário, será considerado como inválido.

- ### removerElemento()
```
public void removerElemento(int linha, int coluna) {
        linha -= 1;
        coluna -= 1;
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = 0;
        } else {
            System.out.println("Posição inválida.");
        }
    }
```
Possui os mesmos princípios do método anterior, a diferença é que o valor é da posição especificada se tornará “0”, é claro que, neste caso, não é necessário ter um valor como parâmetro.

- ### exibirMatriz()
```
public void exibirMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
```
Provavelmente seja o método mais solicitado pelo usuário. Com ele é possível exibir os elementos da matriz dispostos em linhas e colunas. O método exibe cada item das colunas em cada linha e distribui um espaçamento adequado para visualização. Partindo da posição inicial 0 até a última posição dentro do limite das listas de linhas e colunas, torna-se possível visualizar a matriz de forma completa.

## Métodos de Estruturação 🛠️
Para utilizar os algoritmos de ordenação em matrizes completas, é preciso converter a estrutura bidimencional em um vetor. Por isso são usados os seguintes métodos
- ### achatarMatriz()
```
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
```
Converte uma matriz bidimensional em um vetor unidimensional. Isso é útil quando se deseja ordenar a matriz inteira, pois o Merge Sort opera em vetores. Essa função percorre cada elemento da matriz e realiza a cópia para o vetor correspondente.

- ### reconstruirMatriz()
```
private void reconstruirMatriz(int[] vetor) {
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[index++];
            }
        }
    }
```
Após ordenar o vetor, este método recria a matriz original a partir do vetor ordenado. Ele percorre o vetor já ordenado e preenche a matriz com os elementos na mesma ordem.


## Métodos de Ordenação 1️⃣2️⃣3️⃣
- ### bubbleSortLinha()
```
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
```
Um dos dois principais algoritmos de ordenação do script. O Bubble Sort atua juntando pares de elementos ordenados com seu adjacente. Sua classificação é quadrática pois seu tempo de execução é dado pela potência de 2 sobre a quantidade de itens, tornando-o ágil em listas pequenas.

- ### mergeSort()
```
private void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }
```
Esse método divide o vetor em duas partes, chamadas recursivamente para ordenar as metades. Ele continua a dividir o vetor até que ele esteja reduzido a vetores de um único elemento, que já estão, por definição, ordenados. Após isso, ele começa a mesclar essas partes ordenadas usando o método merge().


- ### merge()
```
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
```
Combina dois subarrays ordenados. Ele faz isso criando dois arrays temporários: um que contém os elementos da parte esquerda do vetor e outro com os elementos da parte direita. Esses dois arrays são mesclados de volta ao vetor original de maneira ordenada, comparando os elementos de ambos os arrays temporários e copiando o menor deles para o vetor original. Depois de esgotar os elementos de um dos arrays temporários, ele copia os elementos restantes do outro array.

- ### mergeSortLinha()
```
public void mergeSortLinha(int linha) {
        linha -= 1; // Ajuste para que o usuário insira de 1 a 4
        if (linha >= 0 && linha < linhas) {
            mergeSort(matriz[linha], 0, colunas - 1);
        } else {
            System.out.println("Linha inválida.");
        }
    }
```
Recebe uma linha da matriz, ajusta seu índice, visto que o usuário irá começar por 1, e então aplica o Merge Sort apenas àquela linha, tratando-a como um vetor unidimensional.

- ### mergeSortMatriz()
```
public void mergeSortMatriz() {
        int[] vetor = achatarMatriz();
        mergeSort(vetor, 0, vetor.length - 1);
        reconstruirMatriz(vetor);
    }
```
Utiliza os métodos de reconstrução para realizar o Merge Sort na matriz completa. Ele primeiro achata a matriz em um vetor, aplica o Merge Sort nesse vetor e, depois de ordenado, reconstrói a matriz original com os elementos na ordem correta.

- ### bubbleSortMatriz()
```
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
```
Por fim, tal qual o MergeSortMatriz, este método achata a matriz, realiza a aplicação da ordenação em Bubble Sort, e por fim, reestrutura a matriz no modelo bidimensional convencional.

## Conclusão ✅
Cada algoritmo possui suas peculiaridades de operação. Enquanto o Bubble Sort, um algoritmo quadrático, tem um alto desempenho em matrizes pequenas, o Merge Sort apresenta uma alta eficiência em matrizes grandes por ser um algoritmo de recursividade, o qual reparte ao meio cada ciclo da tarefa.
Visto que o objetivo era criar um script responsivo, dando liberdade ao usuário, é de grande interesse que ambos os algoritmos estejam à disposição. Conforme surja a necessidade de escalonamento da matriz, o usuário possui a flexibilidade de aderir ao algoritmo de maior desempenho, aumentando o rendimento e produtividade comparado a um scripts que utilizasse somente uma das metodologias de ordenação.

## Como usar ❓
 - Abra o terminal git bash em uma pasta no seu computador.
 - Insira o comando:
```
https://github.com/KleitonH/algoritmos_ordenacao_trabalho.git
```
- Abra a pasta do projeto uma IDE compatível com Java (ex: Intellij IDEA)
- Clique na classe Main e, logo em seguida, no botão Run ▶️ na parte superior da janela.
- Utilize as informações do Menu para interagir com o programa.

## Licença 📃

Este projeto está licenciado sob os termos da licença MIT. Veja o arquivo [LICENSE](./LICENSE) para mais detalhes.

