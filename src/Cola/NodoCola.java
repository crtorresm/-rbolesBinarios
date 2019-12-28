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
public class NodoCola {

    private Nodo dato;
    private NodoCola sig;

    public NodoCola(Nodo valor) {
        dato = valor;
        sig = null;
    }

    public Nodo getDato() {
        return dato;
    }

    public void setDato(Nodo dato) {
        this.dato = dato;
    }

    public NodoCola getSig() {
        return sig;
    }

    public void setSig(NodoCola sig) {
        this.sig = sig;
    }
}
