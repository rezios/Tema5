/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author AlumMati
 */
public class GestorCorreo {

        
        CarpetaCorreo recibidos = new CarpetaCorreo();
        CarpetaCorreo eliminados = new CarpetaCorreo();

    public static void main(String[] argm) throws IOException {

       new GestorCorreo();

    }

       
    public GestorCorreo(){
        menuprincipal();
    }


    
    public void menuprincipal(){
        BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
        
        Correo correo1 = new Correo ("c","asd","asd","asd");
        Correo correo2 = new Correo ("a","asd","asd","asd");
        Correo correo3 = new Correo ("f","asd","asd","asd");
        Correo correo4 = new Correo ("b","asd","asd","asd");
        Correo correo5 = new Correo ("d","asd","asd","asd");
        
        recibidos.añadirC(correo1);
        recibidos.añadirC(correo2);
        recibidos.añadirC(correo3);
        recibidos.añadirC(correo4);
        recibidos.añadirC(correo5);
        
        
        int respuesta;
        int r;

        try {
        do {
            System.out.println("\n******MENU PRINCIPAL****** \n"
                    + "      " + "1. Mostrar correos\n"
                    + "      " + "2. Añadir un correo\n"
                    + "      " + "3. Borrar un correo\n"
                    + "      " + "4. Buscar un correo\n"
                    + "      " + "0. Terminar\n"
                    + "Elige una opción:");
            respuesta = Integer.parseInt(tec.readLine());

            switch (respuesta) {
                case 1:
                    
                    System.out.println("******Menu secundario******" + "      " + "1. Recibidos\n" + "      " + "2. Eliminados\n" + "Elige una opción:");
                    r = Integer.parseInt(tec.readLine());
                    
                    if (r == 1) {
                        
                        recibidos.ordenarC();
                        recibidos.mostrarC();
                    } else {
                        eliminados.ordenarC();
                        eliminados.mostrarC();
                    }
                    break;

                case 2:

                    String o,
                     d,
                     a,
                     m;

                    System.out.println("Introduce Origen");
                    o = tec.readLine();
                    System.out.println("Introduce Destino");
                    d = tec.readLine();
                    System.out.println("Introduce Asunto");
                    a = tec.readLine();
                    System.out.println("Introduce Mensaje");
                    m = tec.readLine();

                    Correo correonuevo = new Correo(o, d, a, m);

                    recibidos.añadirC(correonuevo);

                    break;
                case 3:

                    System.out.println("******Menu secundario******\n" + "      " + "1. Recibidos\n" + "      " + "2. Eliminados\n" + "Elige una opción:");
                    r = Integer.parseInt(tec.readLine());

                    if (r == 1) {
                        int pos;
                        System.out.println("Introduce la posición del correo a borrar");
                        pos = Integer.parseInt(tec.readLine());

                        Correo h = recibidos.borrarC(pos);

                        int i = 0;
                        while (eliminados.aCorreo[i] != null) {
                            i++;
                        }
                        eliminados.aCorreo[i] = h;

                        /*otra manera

                                        int i=0;
                                        while(eliminados.aCorreo[i]!=null){
                                            i++;
                                        }
                                        eliminados.aCorreo[i]= recibidos.borrarC(pos);
                         */
                    } else {
                        int pos;
                        System.out.println("Introduce la posición del correo a borrar");
                        pos = Integer.parseInt(tec.readLine());

                        Correo h = eliminados.borrarC(pos);
                        System.out.println("Has eliminado el siguiente correo para siempre");
                        h.toString();
                    }

                    break;
                case 4:

                    System.out.println("******Menu secundario******\n" + "      " + "1. Recibidos\n" + "      " + "2. Eliminados\n" + "Elige una opción:");
                    r = Integer.parseInt(tec.readLine());

                    if (r == 1) {
                        String ori;
                        System.out.println("Escribre el correo a buscar");
                        ori = tec.readLine();

                        Correo h = recibidos.busca(ori);

                        if (h == null) {
                            System.out.println("El correo no existe");
                        } else {
                            System.out.println(h.toString());
                        }

                    } else {
                        String ori;
                        System.out.println("Escribre el correo a buscar en eliminados");
                        ori = tec.readLine();

                        Correo h = eliminados.busca(ori);

                        if (h == null) {
                            System.out.println("El correo no existe en eliminados");
                        } else {
                            h.toString();
                        }
                    }

                    break;
            }
        } while (respuesta != 0);
        }catch (IOException ex){System.err.println("error de entrada"+ex.getMessage());}
    }
    
    
    public String comprobarcorreo(String email){
        
        if(email.startsWith("@")||email.endsWith("@") && email.startsWith(".")||email.endsWith(".")){
            System.err.println("LAS LIAO PARDA, introduce bien el e-mail"+ email +", melón!");
        }else{
            
        
        }
        
        
        
        return "";
                
    }
    
    
    
}
