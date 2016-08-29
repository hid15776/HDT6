
import java.util.*;
import javax.swing.*;


public class Conjunto { 
	
    //inicializacion de variables
    private Factory factor = new Factory();
    private int opcion; 
    private int experiencia;
    private Boolean subConjunto;
    private String esSubC;
    private String nombre;
    private String conjunto;
    private Set<String> java = null;
    private Set<String> web = null;
    private Set<String> movil = null;
    private Set<String> res1 = null;
    private Set<String> res2 = null;
    private Set<String> res3 = null;
    private Set<String> res4 = null;
    private Set<String> res5 = null;
    private Set<String> res6 = null;
    Scanner keyboard = new Scanner(System.in); 
    
    public Conjunto(){
        
    	//menu 
        do{
        	 opcion =Integer.parseInt(JOptionPane.showInputDialog("Que implementacion"
                     + " desea usar:\n1) HashSet\n2) TreeSet\n3) LinkedHashSet"));
             }
        while(opcion < 0 && opcion > 4);
        java = factor.getSet(opcion);
        web = factor.getSet(opcion);
        movil = factor.getSet(opcion);
        res1 = factor.getSet(opcion);
        res2 = factor.getSet(opcion);
        res3 = factor.getSet(opcion);
        res4 = factor.getSet(opcion);
        res5 = factor.getSet(opcion);
        res6 = factor.getSet(opcion);
    }
    
    public void ingresarDesarrollador(){
    	
        //Ingreso de desarrolladores
    	do{
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del desarrollador: ");
            
            //experiencia java
            experiencia = JOptionPane.showConfirmDialog(null,"¿Posee experiencia en Java?");
            if(experiencia == 0){
                java.add(nombre);
            }
            
            //experiencia Web
            experiencia = JOptionPane.showConfirmDialog(null,"¿Posee experiencia en desarrollo Web?");
            if(experiencia == 0){
                web.add(nombre);
            }
            
            //experiencia elulares
            experiencia = JOptionPane.showConfirmDialog(null,"¿Posee experiencia en desarrollo de celulares?");
            if(experiencia == 0){
                movil.add(nombre);
            }
            
            //ingresar otro desarrollador
            opcion = JOptionPane.showConfirmDialog(null,"¿Desea ingresar otro desarrollador?");
        }while(opcion != 1);
    }
    
    public void resultados(){ 
    	//resultados
    	
        // 1
        res1.addAll(java);
        res1.retainAll(web);
        res1.retainAll(movil);
        System.out.println("Los desarrolladores con experiencia en los tres campos:\n"+res1);
       
        // 2
        res2.addAll(java);
        res2.removeAll(web);
        System.out.println("Desarrolladores Java que no sabe Web:\n"+res2);
        
        // 3
        res3.addAll(web);
        res3.retainAll(movil);
        res3.removeAll(java);
        System.out.println("Desarrolladores Web y de Celulares que no saben Java:\n"+res3);
        
        // 4
        res4.addAll(web);
        res4.addAll(movil);
        res4.removeAll(java);
        System.out.println("Desarrolladores Web o de Celulares que no saben Java:\n"+res4);
        
        // 5
        subConjunto = web.containsAll(java);
        if(subConjunto == true){
        	esSubC = "Si";
        }else{
        	esSubC = "No";
        }
        System.out.println("Es el conjunto de desarrollores Java subconjunto de los desarrolladores Web?" + esSubC);
        
        // 6 y 7
        
        if(java.size() > movil.size() && java.size() > web.size()){
            conjunto = "desarrolladores Java";
            res6=java;
        }else if(movil.size() > java.size() && movil.size() > web.size()){
        	conjunto = "desarrolladores de celulares";
            res6=movil;
        }else if(web.size() > movil.size() && web.size() > java.size()){
        	conjunto = "desarrolladores Web";
            res6=web;
        } else {
            res6=null;
            System.out.println("¿Existen conjuntos del mismo tamano?");
        }
        
       
        if(res6!=null){
            System.out.println("El conjunto mas grande es el de los "+conjunto+" y sus miembros son:\n"+res6);
            
            Set res6orden = new TreeSet(res6);
            System.out.println("Lista ordenada:\n"+res6orden);
        }
    }
}
