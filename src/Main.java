import java.util.Scanner;


public class Main {
    /**
     * ---------> Classe Main <---------
     * Acesso: public
     * Prioridade: principal
     * Pacote: entregas.ordenacao
     * Atributos: -
     */
    public static void main(String[] args) {
        /**
         ---------> Método main <---------
         Acesso: public
         Entrada: vetor padrão
         Objetivo: Método principal
         Saída: void
         */
        Scanner scan = new Scanner(System.in);  // Instanciando objeto para leitura
        int opc;
        Vetor lista = new Vetor(0); // Instanciando lista através do construtor padrão da classe vetor
        while (1 == 1) {
            System.out.format("Programa de FS - Ordenção");
            System.out.format("%n0 - Sair");
            System.out.format("%n1 - Criar lista aleatória");
            System.out.format("%n2 - Imprime lista");
            System.out.format("%n3 - Ordenar com Bubble Sort");
            System.out.format("%n4 - Ordenar com Insertion Sort");
            System.out.format("%n5 - Ordenar com Selection Sort");
            System.out.format("%n6 - Ordenar com Merge Sort");
            System.out.format("%n7 - Ordenar com Quick Sort");
            System.out.format("%nDigite o número correspondente a opção desejada: ");
            opc = scan.nextInt();   // Lendo opção digitada
            if (opc == 0)   // Escolha sair
                System.exit(0);
            else if (opc > 1 && opc < 8 && lista.getTamanho() == 0) // Caso escolha algo que não possa ser executado, pois a lista está vazia
                System.out.println("Não há como executar isso, lista vazia!");
            else {
                switch (opc) {
                    case 1: // Escolha construir vetor aleatório
                        System.out.format("Qual o tamanho: ");
                        int tamanho = scan.nextInt();
                        lista.setTamanho(tamanho);  // Modifica tamanho do objeto antes instanciado
                        lista.preencheAleatorio();
                        System.out.println("Lista preenchida");
                        lista.imprime();
                        break;
                    case 2: // Escolha imprimir lista
                        System.out.println("Lista atual:");
                        lista.imprime();
                        break;

                    case 3: // Ordenação Bubble Sort
                        lista.bubbleSort();
                        System.out.println("Ordenada!");
                        break;
                    case 4: // Ordenação Insertion Sort
                        lista.insertionSort();
                        System.out.println("Ordenada!");
                        break;
                    case 5: // Ordenação Selection Sort
                        lista.selectionSort();
                        System.out.println("Ordenada!");
                        break;
                    case 6: // Ordenação Merge Sort
                        int[] aux = {1};
                        lista.mergeSort(aux, 0, lista.getTamanho() - 1);
                        System.out.println("Ordenada!");
                        break;
                    case 7: // Ordenação Quick Sort
                        lista.quickSort(0, lista.getTamanho() - 1);
                        System.out.println("Ordenada!");
                        break;
                    default: // Caso o valor digitado não corresponda a uma alternativa valida
                        System.out.println("Digite uma opção válida!");
                }
            }
        }
    }
}
