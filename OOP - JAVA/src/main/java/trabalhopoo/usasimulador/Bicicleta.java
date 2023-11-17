/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;

/**
 *
 * @author gmars
 */
public class Bicicleta extends Veiculo {
public Bicicleta(){ //construtor da classe
    super(3, 2);
    setDesenho("   __o", 0);
    setDesenho(" _`\\<,_", 1);
    setDesenho("(*)/ (*)\n", 2);
}
  public boolean mover(){ //se todos os pneus estiverem cheios move a bicicleta
    if(rodasCalibradas() == true){ //verifica se os pneus estao calibradas
        for(int i = 0; i < 3; i++)
        setDesenho("  "+getDesenho(i), i);
        
        return true;
}
    else
        return false;}
public void desenhar(){ //desenha a bicicleta
    for(int i = 0; i < 3; i++){
        System.out.println(getDesenho(i));
}
}
public String toString(){ //funcao auxiliar na hora de imprimir dados dos veiculos
    String aux3 = "";
        if(rodasCalibradas() == true)
            aux3 = "Calibrados";
        else
            aux3 = "Um ou mais pneus murchos";
    return "ID:"+getId()+"\nTipo: Bicicleta \nEstado dos Pneus: "+aux3+"\n";
}
}