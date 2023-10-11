/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;
import java.io.File;
import java.io.FileOutputStream ;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
/**
 *
 * @author gmars
 */
public class Simulador {
 private Veiculo veiculos[]; // declaração vetor de veiculos
 private int totalVeiculos = 0; // numero de veiculos que estao atualemente no vetor
   
    public Simulador(){
        veiculos = new Veiculo[20]; // cria o vetor com 20 espaços
    }    
    public int getTotalVeiculos(){ // getter que retorna o total de veiculos atualmente no vetor
    return totalVeiculos;
    }  
    public void incluirVeiculo(){ //adiciona veiculo na ultima posicao do vetor
        if(totalVeiculos < 20){// verifica se o array está cheio
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o tipo de Veículo desejado \nBicicleta (B)\nMotocicleta (M)\nCarro de Passeio (C)\nCarro Esportivo (E)");
        String opc = ler.nextLine();
        switch(opc){ // switch case para decidir qual o tipo de veiculo a ser adicionado
            case "B": veiculos[totalVeiculos] = new Bicicleta();
            break;
            
            case "M": veiculos[totalVeiculos] = new Motocicleta();
            break;
            
            case "C": veiculos[totalVeiculos] = new Passeio();
            break;
            
            case "E": veiculos[totalVeiculos] = new Esportivo();
            break;
            
            default:
                System.out.println("Opção invalida, voltando ao menu.");
                return;
        }
        totalVeiculos++;
        System.out.println("Veículo incluido com sucesso");
    }
        else
            System.out.println("Simulador no limite máximo de veículos");
        return;
    }
    public void removerVeiculo(int id){ //remove um veiculo a criterio do usuario e atualiza a posicao do vetor, total de veiculos e id dos veiculos
        if(id < 0 || id > 19){
            System.out.println("Veículo inválido! Voltando ao menu... ");
            return;
        }
            
        if (totalVeiculos == 1 && veiculos[id] != null){ // quando tem apenas um veículo no vetor
            veiculos[id].setGlobalId(0);
            veiculos[id] = null;
            totalVeiculos--;
            System.out.println("Veículo removido com sucesso!");
        }
        else if((totalVeiculos > 0) && (veiculos[id] != null)){ //demais casos onde vetor não está vazio e o veículo existe
        
        veiculos[id] = null;
        if(veiculos[id+1] != null){
        for(int j = id; j < totalVeiculos -1; j++){
            veiculos[j] = veiculos[j+1];
            veiculos[j].setId(j);
            veiculos[j+1] = null;
            
        }
        veiculos[id].setGlobalId(veiculos[id].getGlobalId() - 1);
        }
        totalVeiculos--; // atualiza total de veiculos
        System.out.println("Veículo removido com sucesso!");
    }
        else
            System.out.println("ERRO! Não foi possível remover o veículo desejado! Veículo não existe!");
        return;
    }
    public void abastecerVeiculo(int id, double quantiaGasosa){// abastece um veiculo com quantia definida pelo usuario
        if(id > totalVeiculos - 1 || id < 0){ //verifica se o veículo existe
         System.out.println("Veículo não existe");
         return;
        }
            
        if(veiculos[id] instanceof Bicicleta){ // verifica se é uma instancia de bicicleta
            System.out.println("O veículo é uma bicicleta e não pode ser abastecido!");
            return;
        }
        if(quantiaGasosa <= 0){ // verifica quantias de gasolinas iguais ou menor que 0
            System.out.println("Quantidade de gasolina inválida!");
            return;
        }
            
        VeiculoMotorizado vh = (VeiculoMotorizado) veiculos[id]; // cria uma instancia auxilar
        vh.abastecer(quantiaGasosa); // chama o metodo
        veiculos[id] = vh; // insere a auxiliar dentro do vetor com o combustivel atualizado
        System.out.println("Veículo abastecido com sucesso!");
    }
    public void moverVeiculo(int id){// move um veiculo se for possivel
     if(id > totalVeiculos - 1 || id < 0){ //verifica se o veículo existe
         System.out.println("Veículo não existe");
         return;
     }
         
     boolean aux = veiculos[id].mover();
     if (aux == true)
         System.out.println("Veiculo movido com sucesso!");
     else
         System.out.println("Não foi possível mover o veículo!");
    }
    public void moverVeiculo(){ // move todos os veiculos do vetor (sobrecarga do metodo anterior)
        for(int i = 0; i < totalVeiculos; i++){
            veiculos[i].mover();
        }
        System.out.println("Veiculos movidos, verifique a pista de corrida!");
    }
    public void moverVeiculosTipo(){ //move veiculos por tipo
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o tipo de Veículo desejado \nBicicleta (B)\nMotocicleta (M)\nCarro de Passeio (C)\nCarro Esportivo (E)");
        String opc = ler.nextLine();        
        switch(opc){//mesmo switch case usado anteriormente pra verificar o tipo de veiculos
            case "B": for(Veiculo b : veiculos) 
                if(b instanceof Bicicleta)
                    b.mover();
                    System.out.println("Bicicletas movidas com sucesso.");
                break;
            
            case "M": for(Veiculo m : veiculos) 
                if(m instanceof Motocicleta)
                    m.mover();
                    System.out.println("Motocicletas movidas com sucesso.");
                break;
            
            case "C": for(Veiculo c : veiculos) 
                if(c instanceof Passeio)
                    c.mover();
                    System.out.println("Carros de passeio movidos com sucesso.");
                break;
            
            case "E": for(Veiculo e : veiculos) 
                if(e instanceof Esportivo)
                    e.mover();
                    System.out.println("Carros esportivos movidos com sucesso");
                break;
            
            default:
                System.out.println("Tipo inválido. Retornando ao menu.");
                break;
        }
    }
    public void imprimirDadosTodosVeiculo(){ //imprime os dados de todos os veiculos
        int cont = 0;
        for(Veiculo v : veiculos){
        if(v instanceof Veiculo)
        System.out.println(v);
    }
        if(totalVeiculos == 0)
            System.out.println("Simulador vazio.");
    }
    public void imprimirDadosPorTipo(){ //imprime dados por tipo
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o tipo de Veículo desejado \nBicicleta (B)\nMotocicleta (M)\nCarro de Passeio (C)\nCarro Esportivo (E)");
        String opc = ler.nextLine();
        if(totalVeiculos == 0)
            System.out.println("Simulador vazio.");
        switch(opc){
            case "B": for(Veiculo b : veiculos) 
                if(b instanceof Bicicleta)
                    System.out.println(b);
                break;
            
            case "M": for(Veiculo m : veiculos) 
                if(m instanceof Motocicleta)
                    System.out.println(m);
                break;
            
            case "C": for(Veiculo c : veiculos) 
                if(c instanceof Passeio)
                    System.out.println(c);
                break;
            
            case "E": for(Veiculo e : veiculos) 
                if(e instanceof Esportivo)
                    System.out.println(e);
                break;
            
            default:
                System.out.println("Tipo inválido. Retornando ao menu.\n");
                break;
        }        
    }
    public void mudarPneu(int id){ //escolhe um pneu de 1 a 4 e seta, pneu 0 foi descartado pois ficaria estranho, atualizacao é feita manualmente na passagem de parametros pra funcao auxiliar
        if(id > totalVeiculos - 1 || id < 0){
            System.out.println("Veículo não existe, retornando ao menus.");
            return;
        }        
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha um pneu de 1 a "+veiculos[id].getTotalPneus()+":");
        int pneu = ler.nextInt();
        while(pneu < 1 || pneu >  veiculos[id].getTotalPneus()){
        System.out.printf("Pneu inválido, tente novamente.\n");  
        System.out.println("Escolha um pneu de 1 a "+veiculos[id].getTotalPneus()+":");
        pneu = ler.nextInt();
        }
        System.out.println("Deseja esvaziar (E) ou calibrar o pneu (C)?");
        Scanner ler2 = new Scanner(System.in);
        String aux = ler2.nextLine();
        boolean mudar = true;
        while(!"C".equals(aux) && !"E".equals(aux)){
            System.out.println("Opção inválida! Tente novamente:");
            aux = ler.nextLine();
        }
        if("E".equals(aux))
            mudar = false;
        else if("C".equals(aux))
            mudar = true;
        veiculos[id].setCalibragem(pneu - 1, mudar);
        System.out.println("Estado do pneu alterado com sucesso");
    }
    public void calibrarTodosPneu(boolean mudar){ //muda o estado de todos os pneus de determinado veiculo
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o tipo de Veículo desejado \nBicicleta (B)\nMotocicleta (M)\nCarro de Passeio (C)\nCarro Esportivo (E)");
        String opc = ler.nextLine();  
        switch(opc){
            case "B": for(Veiculo b : veiculos) 
                if(b instanceof Bicicleta){
                for(int i = 0; i < 2 ; i++)
                b.setCalibragem(i, mudar);
                }
                System.out.println("Bicicletas tiveram seus pneus alterados sucesso");
                
                break;
             
            case "M": for(Veiculo m : veiculos) 
                if(m instanceof Motocicleta){
                for(int i = 0; i < 2 ; i++)
                m.setCalibragem(i, mudar);
                }
                System.out.println("Motocicletas tiveram seus pneus alterados sucesso");
                
                break;
            
            case "C": for(Veiculo c : veiculos) 
                if(c instanceof Passeio){
                for(int i = 0; i < 4 ; i++)
                c.setCalibragem(i, mudar);
                }
                System.out.println("Carros de passeio tiveram seus pneus alterados com sucesso");
                
                break;
            
            case "E": for(Veiculo e : veiculos) 
                if(e instanceof Esportivo){
                for(int i = 0; i < 4 ; i++)
                e.setCalibragem(i, mudar);
                }
                System.out.println("Carros esportivos tiveram seus pneus alterados com sucesso");
                
                break;
            
            default:
                System.out.println("Tipo inválido. Retornando ao menu.");
                break;
        }    
    }
    public void imprimirPista(){ // exibe o estado atual da pista de corrida
        for(int i = 0; i < totalVeiculos; i++){
            veiculos[i].desenhar();
        }
        if(totalVeiculos == 0)
            System.out.println("Simulador vazio.");
    }
    public void gravarArquivo(){ //grava o vetor de veiculos num arquivo txt
        File arquivo = new File("carros.txt");
        try{
            try (FileOutputStream fout = new FileOutputStream(arquivo); ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                oos.writeObject(veiculos);
                
                oos.flush();
            }
            System.out.println("Arquivo gravado com sucesso!");
        }catch (IOException ex){
            System.err.println("erro: " + ex.toString());
        }
    }
    public void lerArquivo(){ // le o arquivo gravado anteriormente
        File arquivo = new File("carros.txt");
        int cont = 0;
        try{
            try (FileInputStream fin = new FileInputStream(arquivo); ObjectInputStream oin = new ObjectInputStream(fin)) {
                veiculos = (Veiculo[]) oin.readObject();
            }
            for (Veiculo v : veiculos){ //percorre vetor gravado no arquivo e exibe todos os valores não nulos
                if(v != null){
                cont++;
                }
            
}
            this.totalVeiculos = cont;
            if(cont == 0){
                veiculos[0] = new Motocicleta();
                veiculos[0].setGlobalId(0);
                veiculos[0] = null;
            }
            else
                veiculos[0].setGlobalId(cont);
            System.out.println("Arquivo lido com sucesso!");
        }catch (IOException | ClassNotFoundException ex){
            System.err.println("erro: " + ex.toString());
        }
    }
    public void imprimirOpcoes(){ // exibe as opções do menu inicial
        System.out.printf("Bem-vindo ao simulador de corrida! Para prosseguir, escolha uma opção: \n"
                + "(1) Incluir veículo \n"
                + "(2) Remover veículo \n"
                + "(3) Abastecer veículo \n"
                + "(4) Movimentar um veículo \n"
                + "(5) Movimentar veículos por tipo \n"
                + "(6) Movimentar todos os veículos\n"
                + "(7) Imprimir todos os dados de todos os veiculos\n"
                + "(8) Imprimir dados de veículos por tipo\n"
                + "(9) Esvaziar/calibrar um pneu específico \n"
                + "(10) Calibrar todos os pneus de veículos por tipo \n"
                + "(11) Esvaziar todos os pneus de veículos por tipo \n"
                + "(12) Imprimir pista de corrida \n"
                + "(13) Gravar veículos em arquivo \n"
                + "(14) Ler veículos do arquivo\n"
                + "(15) Sair da aplicação\n");
    }
}
