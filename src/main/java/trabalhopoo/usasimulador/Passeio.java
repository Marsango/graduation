/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;


/**
 *
 * @author gmars
 */
public class Passeio extends VeiculoMotorizado implements IPVA {
        public Passeio(){ //construtor da classe, parametros e seta o desenho
        super(4, 4, 0.75, 5);
        setDesenho("    ____", 0);
        setDesenho(" __/  |_ \\_", 1);
        setDesenho("|  _     _``-.", 2);
        setDesenho("'-(_)---(_)--'\n", 3);
        setvalorIPVA(calcularIPVA()); //usa a função com as constantes da interface IPVA
}
    public void desenhar(){ //exibe o desenho do carro
    for(int i = 0; i < 4; i++){
        System.out.println(getDesenho(i));
}
}
    public double calcularIPVA(){
        return valor_Base * cte_Passeio;
    }
}
