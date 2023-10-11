/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;

/**
 *
 * @author gmars
 */
public class Motocicleta extends VeiculoMotorizado implements IPVA{
    public Motocicleta(){ //construtor da classe
        super(3, 2, 0.25, 3);
        setDesenho("   ,_oo", 0);
        setDesenho(".-/c-//::          ", 1);
        setDesenho("(_)'==(_)\n", 2);
        setvalorIPVA(calcularIPVA()); 
}
    public void desenhar(){ //desenha o veiculo
    for(int i = 0; i < 3; i++){
        System.out.println(getDesenho(i));
}
}
    public double calcularIPVA(){ //calcula o IPVA com base nas constantes
        return valor_Base * cte_Motocicleta;
    }
}
