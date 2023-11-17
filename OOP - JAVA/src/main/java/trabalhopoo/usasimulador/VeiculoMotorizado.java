/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package trabalhopoo.usasimulador;
import java.util.Random;
/**
 *
 * @author gmars
 */
public abstract class VeiculoMotorizado extends Veiculo { //VeiculoMotorizado é subclasse de Veiculo
    private double gastoVeiculo;
    private double gasosa;
    private double valorIPVA;
    private double valorVenda;
    private boolean IPVA;
    private int tamDes;
    private String espaco = "";
    
    public VeiculoMotorizado(int tamDes, int quantidadeRodas, double gastoVeiculo, int movimento){ //construtor da classe
        super(tamDes, quantidadeRodas);
        this.gastoVeiculo = gastoVeiculo;
        this.gasosa = 2.5;
        Random rd = new Random();
        this.IPVA = rd.nextBoolean(); //atribui um valor aleatorio pro ipva
        this.tamDes = tamDes;
        for(int i = 0; i < movimento; i++)
            espaco += " ";
        if (gastoVeiculo == 0.25)
            valorVenda = 2000*(1+rd.nextInt(4));
        else if(gastoVeiculo == 0.75)
            valorVenda = 5000*(1+rd.nextInt(4));
        else if(gastoVeiculo == 2.3)
            valorVenda = 10000*(1+rd.nextInt(4));
    }
    public void abastecer(double quantia){ //adiciona combustivel ao veiculo
        gasosa += quantia;
    }
    public void setvalorIPVA(double ipva){//setter do valor do ipva
        valorIPVA = ipva;
    }
    public double getvalorIPVA(){ //getter do valor do ipva
        return valorIPVA;
    }
    public boolean getIPVA(){//getter do estado do ipva (pago ou não)
        return IPVA;
    }
    public void setIPVA(boolean ipva){//setter do estado do ipva (pago ou não)
        this.IPVA = ipva;
    }
    public final String toString(){ //funcao tostring que retorna os dados dos veiculos
        String aux = "", aux2 = "", aux3 = "";
        if(IPVA == true)
            aux = "Pago";
        else
            aux = "Atrasado";
        if(rodasCalibradas() == true)
            aux3 = "Calibrados";
        else
            aux3 = "Um ou mais pneus murchos";
        if(gastoVeiculo == 0.75)
            aux2 = "Carro de Passeio";
        else if(gastoVeiculo == 0.25)
            aux2 = "Motocicleta";
        else if(gastoVeiculo == 2.3)
            aux2 = "Carro Esportivo";
        return "ID:"+getId()+"\nTipo de veículo: "+aux2+"\nEstado dos pneus: "+aux3+"\nValor de venda: R$"+valorVenda+"\nGasto do veículo/andada: "+gastoVeiculo+"l \nGasolina no tanque: "+String.format("%.2f",gasosa)+"l \nValor do IPVA: R$"+valorIPVA+"\nIPVA: "+aux+"\n";
    }
    public final boolean mover(){ //move o veiculo se for possivel
    if((rodasCalibradas() == true) && (getIPVA() == true) && (gasosa >= gastoVeiculo)){
        for(int i = 0; i < tamDes; i++)
        setDesenho(espaco+getDesenho(i), i);
        
        gasosa -= gastoVeiculo;
        
        return true;
}
    else
        return false;
    }
}
