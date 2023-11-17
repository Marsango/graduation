/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo.usasimulador;

/**
 *
 * @author gmars
 */
public interface IPVA {
    public  final double cte_Passeio = 1.3;
    public final double cte_Motocicleta = 0.75;
    public final double cte_Esportivo = 3.15;
    public final double valor_Base = 500.00;
    public double calcularIPVA();
}