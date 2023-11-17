/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;
import java.util.Random;
import java.io.Serializable;
/**
 *
 * @author gmars
 */
public abstract class  Veiculo implements Serializable { // declara a classe pra ser gravada em arquivo
    private static int globalId = 0; // ID global associado com o último elemento do vetor
    private int id; //ID único de cada carro, é atualizado conforme sua posição no vetor
    private String[] desenho; //string que armazena o desenho
    private Roda rodas[];  //vetor de rodas
    private final int quantidadeRodas; //variavel que indica a quantidade de rodas
    
    public Veiculo(int tamDesenho, int quantidadeRodas){
        this.id = globalId; // associa o ID com a posição do veiculo no vetor
        this.desenho = new String[tamDesenho]; //vetor de strings para representar graficamente o veiculo
        this.quantidadeRodas = quantidadeRodas;
        this.rodas = new Roda[quantidadeRodas]; //cria um vetor de rodas com a quantia de rodas passada pelas subclasses
        for(int i = 0; i < quantidadeRodas; i++){ // declaração do vetor de rodas e atribuição do boolean
            rodas[i] = new Roda();
        }
        globalId++; // incrementa o ID global para não dar conflito com carros de mesmo ID
    }

    public void setDesenho(String A, int i){ //setter do vetor desenho
        desenho[i] = A;
    }
    public String getDesenho(int i){ //getter do vetor desenho
        return desenho[i];
    }
    public boolean rodasCalibradas(){ // função auxiliar que verifica se todos os pneus estão calibrados
        for(int i = 0; i < quantidadeRodas; i++){
            if (rodas[i].getCalibragem() == false)
                return false;
        }
        return true;
    }
    public void setId(int id){ //setter do id
        this.id = id;
    }
    public void setGlobalId(int id){ //setter do globalId, usado pra atualizar o ID quando há remoção de veículo
        globalId = id;
    }
    public int getId(){ //getter do id
        return id;
    }
    public int getGlobalId(){ // getter do globalId
        return globalId;
    }
    public int getTotalPneus(){ //getter que verifica a quantia total de rodas
        return quantidadeRodas;
    }
    public abstract boolean mover(); // funcao abstrata para mover os veiculos 

    public abstract void desenhar(); //funcao abstrata para desenhar os veiculos
    public void setCalibragem(int roda, boolean mudar){ //setter da calibragem de um pneu especifico
        rodas[roda].setCalibragem(mudar);
    }
}

