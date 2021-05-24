import java.util.Random;

public class Vetor {
    /**
     * ---------> Classe Vetor <---------
     * Acesso: public
     * Prioridade: acesso intermediário
     * Pacote: entregas.ordenacao
     * Atributos: lista[], tamanho
     */
    private int lista[];
    private int tamanho;

    public Vetor(int qtd_elementos) {
        /**
         ---------> Construtor Vetor <---------
         Acesso: public
         Entrada: qtd_elementos
         Objetivo: Construir o vetor a partir de um inteiro passado como argumento
         Saída: modificação direta do objeto (todos os atributos)
         */
        this.lista = new int[qtd_elementos];
        this.tamanho = qtd_elementos;
    }

    public int[] getLista() {
        /**
         ---------> Getter getLista <---------
         Acesso: public
         Entrada: -
         Objetivo: Obter lista
         Saída: lista
         */
        return lista;
    }

    public int getTamanho() {
        /**
         ---------> Getter getTamanho <---------
         Acesso: public
         Entrada: -
         Objetivo: Obter valor do tamanho
         Saída: tamanho
         */
        return tamanho;
    }

    public void setLista(int[] lista) {
        /**
         ---------> Setter setLista <---------
         Acesso: public
         Entrada: vetor de inteiros
         Objetivo: Modificar atributos do objeto que tem relação com a lista
         Saída: void
         */
        this.lista = lista;
        this.tamanho = lista.length;
    }

    public void setTamanho(int tamanho) {
        /**
         ---------> Setter setTamanho <---------
         Acesso: public
         Entrada: tamanho
         Objetivo: Modificar atributos do objeto que tem relação com o tamanho
         Saída: void
         */
        this.tamanho = tamanho;
        this.lista = new int[tamanho];
    }

    public void preencheAleatorio() {
        /**
         ---------> Método preencheAleatorio <---------
         Acesso: public
         Entrada: -
         Objetivo: Preencher lista do objeto com valores aleatórios
         Saída: void
         */
        Random random = new Random();
        for (int i = 0; i < this.tamanho; i++) {
            this.lista[i] = random.nextInt(100);
        }
    }

    public void imprime() {
        /**
         ---------> Método imprime <---------
         Acesso: public
         Entrada: -
         Objetivo: Imprimir lista do objeto
         Saída: void
         */
        for (int i = 0; i < this.lista.length; i++) {
            System.out.format("Posição %d   Valor %d%n", i, this.lista[i]);
        }
    }

    public void bubbleSort() {
        /**
         ---------> Método bubbleSort <---------
         Acesso: public
         Entrada: -
         Objetivo: Ordenar lista
         Saída: void
         */
        for (int i = 0; i < this.tamanho - 1; i++) {
            for (int j = 0; j < this.tamanho - 1 - i; j++) {
        /* Se o valor da posição atual do vetor for maior que o proximo valor,
          então troca os valores de lugar no vetor. */
                if (this.lista[j] > this.lista[j + 1]) {
                    int aux = this.lista[j];
                    this.lista[j] = this.lista[j + 1];
                    this.lista[j + 1] = aux;
                }
            }
        }
    }

    public void selectionSort() {
        /**
         ---------> Método selectionSort <---------
         Acesso: public
         Entrada: -
         Objetivo: Ordenar lista
         Saída: void
         */
        for (int j = 0; j < this.tamanho - 1; j++) {
            int menor = j;
            for (int i = j; i < this.tamanho; i++) {
                if (this.lista[i] < this.lista[menor]) {
                    menor = i;
                }
            }
            if (this.lista[j] > this.lista[menor]) {
                int aux = this.lista[j];
                this.lista[j] = this.lista[menor];
                lista[menor] = aux;
            }
        }
    }

    public void insertionSort() {
        /**
         ---------> Método insertionSort <---------
         Acesso: public
         Entrada: -
         Objetivo: Ordenar lista
         Saída: void
         */
        for (int i = 1; i < this.tamanho; i++) {
            int aux = this.lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j] > aux) {
                lista[j + 1] = lista[j];
                j -= 1;
            }
            lista[j + 1] = aux;
        }
    }

    public void mergeSort(int[] listaAux, int base, int fim) {
        /**
         ---------> Método mergeSort <---------
         Acesso: public
         Entrada: listaAux, base, fim
         Objetivo: Ordenar lista
         Saída: void
         */
        if (fim <= base) return;

        int meio = (base + fim) / 2;
        mergeSort(this.lista, base, meio);
        mergeSort(this.lista, meio + 1, fim);
        mergeAuxiliar(this.lista, base, meio, fim);
    }

    public void mergeAuxiliar(int[] listaAux, int base, int meio, int fim) {
        /**
         ---------> Método mergeAuxiliar <---------
         Acesso: public
         Entrada: listaAux, base, meio, fim
         Objetivo: Auxiliar o método Merge Sort na ordenação da lista do objeto
         Saída: void
         */
        int[] ladoEsquerdo = new int[meio - base + 1];
        int[] ladoDireito = new int[fim - meio];

        for (int i = 0; i < ladoEsquerdo.length; i++)
            ladoEsquerdo[i] = listaAux[base + i];
        for (int i = 0; i < ladoDireito.length; i++)
            ladoDireito[i] = listaAux[meio + i + 1];

        int controladorEsquerdo = 0;
        int controladorDireito = 0;

        for (int i = base; i < fim + 1; i++) {
            if (controladorEsquerdo < ladoEsquerdo.length && controladorDireito < ladoDireito.length) {
                if (ladoEsquerdo[controladorEsquerdo] < ladoDireito[controladorDireito]) {
                    listaAux[i] = ladoEsquerdo[controladorEsquerdo];
                    controladorEsquerdo++;
                } else {
                    listaAux[i] = ladoDireito[controladorDireito];
                    controladorDireito++;
                }
            } else if (controladorEsquerdo < ladoEsquerdo.length) {
                listaAux[i] = ladoEsquerdo[controladorEsquerdo];
                controladorEsquerdo++;
            } else if (controladorDireito < ladoDireito.length) {
                listaAux[i] = ladoDireito[controladorDireito];
                controladorDireito++;
            }
        }
    }

    public void quickSort(int inicio, int fim) {
        /**
         ---------> Método quickSort <---------
         Acesso: public
         Entrada: inicio, fim
         Objetivo: Ordenar lista
         Saída: void
         */
        if (inicio < fim) {
            int posicao = this.quickAuxiliar(inicio, fim);
            this.quickSort(inicio, posicao-1);
            this.quickSort(posicao+1, fim);
        }
    }

    public int quickAuxiliar(int inicio, int fim) {
        /**
         ---------> Método quickAuxiliar <---------
         Acesso: public
         Entrada: inicio, fim
         Objetivo: Auxiliar o método Quick Sort na ordenação da lista do objeto
         Saída: número inteiro
         */
        int pivo = this.lista[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (this.lista[j] <= pivo) {
                i += 1;
                int aux = this.lista[i];
                this.lista[i] = this.lista[j];
                this.lista[j] = aux;
            }
        }
        int aux = this.lista[i + 1];
        this.lista[i+1] = this.lista[fim];
        this.lista[fim] = aux;
        return (i + 1);
    }
}
