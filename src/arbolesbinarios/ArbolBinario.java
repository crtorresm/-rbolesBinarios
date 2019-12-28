/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import Cola.Cola;
import javax.swing.JFrame;

/**
 *
 * @author christom
 */
public class ArbolBinario {

    private Nodo raiz;
    //para procesos internos
    private int cant;
    private int altura;

    public ArbolBinario() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean esVacia() {
        return raiz == null;
    }

    public boolean esHoja() {
        return raiz.getIzquierdo() == null && raiz.getDerecho() == null;
    }

    public void Añadir(int dato) {
        Nodo nuevonodo = new Nodo(dato);
        insertar(nuevonodo, raiz);
    }

    private void insertar(Nodo nuevo, Nodo r) {
        if (esVacia()) {
            raiz = nuevo;
        } else if (nuevo.getDato() < r.getDato()) {
            if (r.getIzquierdo() == null) {
                r.setIzquierdo(nuevo);
            } else {
                insertar(nuevo, r.getIzquierdo());
            }
        } else if (nuevo.getDato() > r.getDato()) {
            if (r.getDerecho() == null) {
                r.setDerecho(nuevo);
            } else {
                insertar(nuevo, r.getDerecho());
            }
        } else {
            System.out.println("Dato " + nuevo.getDato() + " duplicado...");
        }

    }

    public void MostrarPreorden() {
        System.out.print("\nRecorrido en PreOrden: ");
        preorden(raiz);
    }

    private void preorden(Nodo r) {
        if (r == null) {
            return;
        }
        System.out.print(" " + r.getDato());
        preorden(r.getIzquierdo());
        preorden(r.getDerecho());
    }

    public void MostrarInorden() {
        System.out.print("\nRecorrido en InOrden: ");
        inorden(raiz);
    }

    private void inorden(Nodo r) {
        if (r == null) {
            return;
        }
        inorden(r.getIzquierdo());
        System.out.print(" " + r.getDato());
        inorden(r.getDerecho());
    }

    public void MostrarPostorden() {
        System.out.print("\nRecorrido en PostOrden: ");
        postorden(raiz);
    }

    private void postorden(Nodo r) {
        if (r == null) {
            return;
        }
        postorden(r.getIzquierdo());
        postorden(r.getDerecho());
        System.out.print(" " + r.getDato());
    }

    public void MostrarAmplitud() {
        if (esVacia()) {
            return; //verificar si el àrbol esta vacio
        }

        System.out.print("\nRecorrido en Amplitud: ");
        Cola cola1 = new Cola();

        cola1.Encolar(raiz);
        while (!cola1.esVacia()) {
            Nodo dato = cola1.Desencolar();

            System.out.print(dato.getDato() + " ");
            if (dato.getIzquierdo() != null) {
                cola1.Encolar(dato.getIzquierdo());
            }
            if (dato.getDerecho() != null) {
                cola1.Encolar(dato.getDerecho());
            }
        }

    }

    //cantidad de nodos del árbol
    public int cantidadNodos() {
        cant = 0;
        cantidadNodos(raiz);
        return cant;
    }

    private void cantidadNodos(Nodo r) {
        if (r != null) {
            cant++;
            cantidadNodos(r.getIzquierdo());
            cantidadNodos(r.getDerecho());
        }
    }

    //cantidad nodos hoja del árbol
    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return cant;
    }

    private void cantidadNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.getIzquierdo() == null && reco.getDerecho() == null) {
                cant++;
            }
            cantidadNodosHoja(reco.getIzquierdo());
            cantidadNodosHoja(reco.getDerecho());
        }
    }
    //cantidad de nodos completos

    public int nodosCompletos(Nodo r) {
        if (r== null) {
            return 0;
        } else {
            if (r.getIzquierdo() != null && r.getDerecho() != null) {
                return nodosCompletos(r.getIzquierdo()) + nodosCompletos(r.getDerecho()) + 1;
            }
            return nodosCompletos(r.getIzquierdo()) + nodosCompletos(r.getDerecho());
        }
    }

    //altura del arbol
    public int alturaArbol() {
        altura = 0;
        alturaArbol(raiz, 1);
        return altura;
    }

    private void alturaArbol(Nodo r, int nivel) {
        if (r != null) {
            alturaArbol(r.getIzquierdo(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(r.getDerecho(), nivel + 1);
        }
    }

    //nivel del arbol
    public int nivelArbol() {
        altura = 0;
        nivelArbol(raiz, 0); //inicia en 0
        return altura;
    }

    private void nivelArbol(Nodo r, int nivel) {
        if (r != null) {
            nivelArbol(r.getIzquierdo(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            nivelArbol(r.getDerecho(), nivel + 1);
        }
    }

    //Valor menor
    public int menorValor() {
        Nodo r = raiz;
        if (raiz != null) {

            while (r.getIzquierdo() != null) {
                r = r.getIzquierdo();
            }
        }
        return (r.getDato());
    }

    //mayor Valor
    public int mayorValor() {
        Nodo r = raiz;
        if (raiz != null) {
            while (r.getDerecho() != null) {
                r = r.getDerecho();
            }
        }
        return (r.getDato());
    }
    
    
    //graficar Àrbol
    public void graficar()
    { GraficaArbolBinario Migrafico=new GraficaArbolBinario(this);
        JFrame ventana=new JFrame("Mi Árbol Binario");
        ventana.getContentPane().add(Migrafico);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(800,600);
        ventana.setVisible(true);
    }

}
