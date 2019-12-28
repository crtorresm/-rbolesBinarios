/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import arbolesbinarios.Nodo;

/**
 *
 * @author christom
 */
public class Cola {

    private NodoCola primero, ultimo;

    public Cola() {
        primero = null;
        ultimo = null;
    }

    public boolean esVacia() {
        return primero == null && ultimo == null;
    }

    public void Encolar(Nodo dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (esVacia()) {
            primero = nuevo;
        } else {
            ultimo.setSig(nuevo);
        }
        ultimo = nuevo;
    }

    public Nodo Desencolar() {
        Nodo r = null;
        if (!esVacia()) {
            r = primero.getDato();
            primero = primero.getSig();
            if (primero == null) {
                ultimo = null;
            }
        }
        return r;
    }

   }
