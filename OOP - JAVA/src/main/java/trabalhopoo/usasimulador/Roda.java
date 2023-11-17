/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;
import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author gmars
 */
public class Roda implements Serializable { // declaração da classe permitindo gravação em arquivo
    private boolean calibragemPneu;
    public Roda(){ //construtor da classe
        Random rd = new Random();
        boolean estadoPneu = rd.nextBoolean();
        this.calibragemPneu = estadoPneu; 
    }
    public void setCalibragem(boolean calibra){ //setter da calibragem do pneu
        this.calibragemPneu = calibra;
    }
    public boolean getCalibragem(){ //getter da calibragem
        return calibragemPneu;
    }
}