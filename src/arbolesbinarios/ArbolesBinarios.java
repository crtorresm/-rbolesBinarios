/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author christom
 */
public class ArbolesBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinario a1 = new ArbolBinario();
//        a1.Añadir(50);
//        a1.Añadir(34);
//        a1.Añadir(90);
//        a1.Añadir(5);
//        a1.Añadir(72);
//        a1.Añadir(41);
//        a1.Añadir(99);

        a1.Añadir(50);
        a1.Añadir(34);
        a1.Añadir(90);
        a1.Añadir(5);
        a1.Añadir(72);
        a1.Añadir(99);
        a1.Añadir(2);
        a1.Añadir(20);
        a1.Añadir(9);
        a1.Añadir(30);
        a1.Añadir(80);
        a1.Añadir(201);
        a1.Añadir(300);

        a1.MostrarPreorden();
        a1.MostrarInorden();
        a1.MostrarPostorden();
        a1.MostrarAmplitud();
        a1.graficar();

    }

}
