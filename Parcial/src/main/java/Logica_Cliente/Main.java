/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica_Cliente;

import Logica_Negocio.Contacto;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Main {

    static Scanner lec = new Scanner(System.in);
    private static ArrayList<Contacto> listacontactos = new ArrayList<>();

    public static void main(String[] args) {

        int opc = 0;
        int numContactos = 0;

        do {
            System.out.println("******Zona Virtual S.A******");
            System.out.println("******Aplicacion de lista de contactos******");
            System.out.println("1. Agregar Nuevo contacto");
            System.out.println("2. Mostrar lista de contactos ");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja a partir los nombres");
            System.out.println("5. Ordenar por Insercion a partir de los numeros telefonicos");
            System.out.println("6. salir");
            System.out.println("Ingrese una opcion:");
            opc = lec.nextInt();
            switch (opc) {
                case 1:
                    System.out.println();
                    AgregarContactos();
                    System.out.println();

                    break;
                case 2:
                    System.out.println();
                    MostrarLista();
                    System.out.println();

                    break;
                case 3:
                    System.out.println();
                    Buscar();
                    System.out.println();

                    break;
                case 4:
                    System.out.println();
                    OrdenamientoBurbuja();
                    System.out.println();
                    MostrarLista();
                    System.out.println();

                    break;
                case 5:
                    System.out.println();
                    OrdenamientoInsercion();
                    System.out.println();
                    MostrarLista();

                    break;
                case 6:

                    break;

                default:
                    throw new AssertionError();
            }
        } while (opc != 6);

    }

    //Metodos 
    public static void AgregarContactos() {
        int numContactos;
        String nombre;
        int telefono;

        System.out.println("Ingrese el numero de contactos a ingresar: ");
        numContactos = lec.nextInt();
        lec.nextLine();
        for (int i = 0; i < numContactos; i++) {

            System.out.println("Ingrese el nombre del contacto #" + (i + 1));
            nombre = lec.nextLine();
            System.out.println("Ingrese el telefono del contacto #" + (i + 1));
            telefono = lec.nextInt();
            lec.nextLine();
            Contacto objContacto = new Contacto(nombre, telefono);
            listacontactos.add(objContacto);
        }
    }

    public static void MostrarLista() {
        if (listacontactos.isEmpty()) {
            System.out.println("La lista esta vacia");

        } else {
            for (int i = 0; i < listacontactos.size(); i++) {
                System.out.println("-----Contacto#" + (i + 1) + "-----");
                System.out.println("El nombre del contacto es:" + listacontactos.get(i).getNombre());
                System.out.println("El Numero de telefono del contacto es:" + listacontactos.get(i).getNumeroTelefono());
            }
        }

    }

    public static void Buscar() {
        String buscar;
        int posicion = 0;
        int bandera = 0;

        if (listacontactos.isEmpty()) {
            System.out.println("La lista esta vacia");

        } else {
            lec.nextLine();
            System.out.println("Ingrese el nombre que quiere buscar: ");
            buscar = lec.nextLine();

            for (int i = 0; i < listacontactos.size(); i++) {
                if (listacontactos.get(i).getNombre().equalsIgnoreCase(buscar)) {
                    posicion = i;
                    System.out.println("El nombre que se buscó es :" + listacontactos.get(i).getNombre() + " y se encuentra en la posicion " + (posicion + 1));
                    bandera = 1;
                    break;

                }

            }
            if (bandera != 1) {
                System.out.println("no se encontro el contacto");
            }
        }

    }

    public static void OrdenamientoBurbuja() {
        for (int i = 0; i < listacontactos.size() - 1; i++) {
            for (int j = 0; j < listacontactos.size() - i - 1; j++) {
                Contacto contacto1 = listacontactos.get(j);
                Contacto contacto2 = listacontactos.get(j + 1);
                if (contacto1.getNombre().compareTo(contacto2.getNombre()) > 0) {
                    listacontactos.set(j, contacto2);
                    listacontactos.set(j + 1, contacto1);

                }
            }
        }
    }

    public static void OrdenamientoInsercion() {
        for (int i = 1; i < listacontactos.size(); i++) {
            boolean agregado = false;
            for (int j = i; j > 0 && !agregado; j--) {
                Contacto contact = listacontactos.get(j);
                Contacto contact2 = listacontactos.get(j - 1);
                if (contact.getNumeroTelefono() < contact2.getNumeroTelefono()) {
                    listacontactos.set(j, contact2);
                    listacontactos.set(j - 1, contact);
                } else {
                    agregado = true;
                }
            }
        }

    }

}
