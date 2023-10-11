/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package trabalhopoo.usasimulador;
import java.util.Scanner;
/**
 *
 * @author gmars
 */
public class Usasimulador {
   
    public static void main(String[] args) { // declaracao de variaveis auxiliares que serao passadas com parametro, junto com o menu interativo com o usuario
        Scanner ler = new Scanner(System.in);
        Simulador simulador = new Simulador();
        simulador.imprimirOpcoes();
        int auxID;
        double auxGasolina;
        int opcao = 0;
        boolean auxpneu;
        while(opcao != 15){
            opcao = ler.nextInt();
            switch (opcao) {
                case 1: 
                    simulador.incluirVeiculo();
                    break;
                case 2:
                    System.out.println("Digite o ID do veículo a ser removido: \n");
                    auxID = ler.nextInt();
                    simulador.removerVeiculo(auxID);
                    break;
                case 3:
                    System.out.println("Digite o ID do veículo a ser abastecido: \n");
                    auxID = ler.nextInt();
                    System.out.println("Digite a quantia de gasolina:\n ");
                    auxGasolina = ler.nextDouble();
                    simulador.abastecerVeiculo(auxID, auxGasolina);
                    break;
                case 4:
                    System.out.println("Digite o ID do veículo a ser movimentado: \n");
                    auxID = ler.nextInt();
                    simulador.moverVeiculo(auxID);
                    break;
                case 5:
                    simulador.moverVeiculosTipo();
                    break;
                case 6:
                    simulador.moverVeiculo();
                    break;
                case 7:
                    simulador.imprimirDadosTodosVeiculo();
                    break;
                case 8:
                    simulador.imprimirDadosPorTipo();
                    break;
                case 9:
                    System.out.println("Digite o ID do veículo a ter o pneu calibrado/esvaziado: \n");
                    auxID = ler.nextInt();
                    simulador.mudarPneu(auxID);
                    break;
                case 10:
                    simulador.calibrarTodosPneu(true);
                    break;
                case 11:
                    simulador.calibrarTodosPneu(false);
                    break;
                case 12:
                    simulador.imprimirPista();
                    break;
                case 13:
                    simulador.gravarArquivo();
                    break;
                case 14:
                    simulador.lerArquivo();
                    break;
                case 15:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente:");
                    break;
            }
        }
        System.out.print("Programa finalizado.");

}
}
