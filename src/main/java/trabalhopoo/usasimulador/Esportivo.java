/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;

/**
 *
 * @author gmars
 */
public class Esportivo extends VeiculoMotorizado implements IPVA {
    public Esportivo(){ //construtor da classe
        super(6, 4, 2.3, 10);
        setDesenho("        __         ", 0);
        setDesenho("      ~( @\\ \\   ", 1);
        setDesenho("   _____]_[_/_>__   ", 2);
        setDesenho("  / __ \\<> |  __ \\      ", 3);
        setDesenho("=\\_/__\\_\\__|_/__\\_D     ", 4);
        setDesenho("   (__)      (__)    \n", 5);
        setvalorIPVA(calcularIPVA()); 
}
    public void desenhar(){ //desenha o veiculo
    for(int i = 0; i < 6; i++){
        System.out.println(getDesenho(i));
}
}
    public double calcularIPVA(){ // calcula o ipva com base nas constantes
        return valor_Base * cte_Esportivo;
    }
}
