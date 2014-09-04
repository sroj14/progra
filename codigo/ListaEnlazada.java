package tareaProgramada1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ListaEnlazada{
    
    /**Atributos de la lista*/
     private Nodo nodoActual;
     private Nodo primerNodo;
	 private Nodo ultimoNodo;
	 private int tamaño;
     
	public class Nodo{
     /**Atributos del nodo*/
        private final String ruta;
        private String artista;
        private String titulo;
        private String album;
        private String año;
        private String genero;
        private String nombre;
        private Nodo anterior; 
        private Nodo siguiente;
        private BufferedImage foto;
        /**Constructor nodo sin parametros*/
        public Nodo(){
            this.siguiente = null;
            this.anterior = null;
            this.ruta = null;
            this.nombre = null;
            this.foto = null;
        }
        
        /**Constructor de nodo con parametros*/
        public Nodo(String ruta, String nombre, String artista, String album, String año, String genero, BufferedImage foto){
        
        this.siguiente = null;
        this.anterior  = null;
        this.ruta = ruta;
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.año = año;
        this.genero = genero;
        this.foto = foto;
        }
        
         public Nodo obtenerAnterior(){
            return this.anterior;
         }

        public Nodo obtenerSiguiente(){
            return this.siguiente;
        }
       
        public String obtenerRuta(){
         return this.ruta;
         }

        public void establecerSiguiente(Nodo siguiente){
        	this.siguiente = siguiente;
        }
        
        public void establecerAnterior(Nodo anterior){
                this.anterior = anterior;
        }

        public String obtenerNombre(){
          return this.nombre;
        }

        public String obtenerArtista(){
          return this.artista;
        }

        public String obtenerAlbum(){
          return this.album;
        }

        public String obtenerAño(){
           return this.año;
        }

        public String obtenerGenero(){
           return this.genero;
        }
        
        public void cambiarNombre(String nuevo){
          this.nombre= nuevo;
        }

        public void cambiarArtista(String nuevo){
          this.artista= nuevo;
        }

        public void cambiarAlbum(String nuevo){
          this.album = nuevo;
        }

        public void cambiarAño(String nuevo){
           this.año = nuevo;
        }

        public void cambiarGenero(String nuevo){
           this.genero = nuevo;
        }}
        
     public ListaEnlazada(){
        this.nodoActual = null;
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.tamaño     = 0;
    }
    
     public Nodo obtenerPrimero(){
         return this.primerNodo;
     }

     public BufferedImage obtenerFoto(){
     	return this.nodoActual.foto;
     }
     
    public void agregarCancion(String ruta, String nombre, String artista, String album, String año, String genero, BufferedImage foto){

       
         Nodo nuevo = new Nodo(ruta, nombre, artista, album, año, genero,foto);
        if (this.primerNodo == null){

            this.primerNodo = nuevo;
            this.ultimoNodo = nuevo;
            this.nodoActual = nuevo;
        }
        
        else{
            this.nodoActual = this.ultimoNodo; 
            this.ultimoNodo.establecerSiguiente(nuevo);
            this.ultimoNodo = nuevo;
            this.ultimoNodo.establecerAnterior(this.nodoActual);
            this.nodoActual = this.ultimoNodo;
        }
        this.tamaño++;
    } 
    
    public void eliminarCancion(int indice){
         this.nodoActual = this.primerNodo;
        if (this.obtenerTamaño() == 1){
            this.primerNodo = null;
            this.ultimoNodo = null;
            this.nodoActual = null;
        }
         else{
         for(int cont=0;cont<this.tamaño;cont++){
         	if (cont == this.tamaño-1 && cont == indice){
         		this.ultimoNodo = this.nodoActual.obtenerAnterior();
         		break;
         	}

         	if (cont == 0 && cont == indice){
         		this.primerNodo = this.nodoActual.obtenerSiguiente();
         		break;
         	}

            if (cont == indice){
             this.nodoActual.obtenerAnterior().establecerSiguiente(this.nodoActual.obtenerSiguiente());
             this.nodoActual.obtenerSiguiente().establecerAnterior(this.nodoActual.obtenerAnterior());
             this.nodoActual = this.nodoActual.obtenerSiguiente();           
              break;
            } 
            this.nodoActual = this.nodoActual.obtenerSiguiente();
         }}

      this.tamaño--; 
     }

     public Nodo obtenerUltimo(){
         return this.ultimoNodo;
     }
     
     public int obtenerTamaño(){
         return this.tamaño;
     }
     
     public Boolean buscarNodo(String nombreCancion){

        this.nodoActual = this.primerNodo;
        for(int contador = 0; contador!=this.tamaño; contador++){
          if(nombreCancion==this.nodoActual.obtenerNombre()){

            return true;
           }
           else{
           this.nodoActual=this.nodoActual.obtenerSiguiente();
           }
        }
             
     return false;  
     }

     public Nodo obtenerActual(){
        return this.nodoActual;
     }
    
     public Boolean buscarCancionNombre(String nombre){
        while(this.nodoActual != null){
            if (this.nodoActual.obtenerNombre().equals(nombre)){
 
                return true;

             }
             this.nodoActual=this.nodoActual.obtenerSiguiente();
             }
                return false;
             } 

     public Boolean buscarCancionArtista(String artista){
        while(this.nodoActual != null){
            if (this.nodoActual.obtenerArtista().equals(artista)){
                return true;

             }
             this.nodoActual=this.nodoActual.obtenerSiguiente();
             }
                return false;
             } 

     public Boolean buscarCancionGenero(String genero){
        while(this.nodoActual != null){
            if (this.nodoActual.obtenerGenero().equals(genero)){
                return true;

             }
             this.nodoActual=this.nodoActual.obtenerSiguiente();
             }
                return false;
             } 

     public Boolean buscarCancionAlbum(String album){
        while(this.nodoActual != null){
            if (this.nodoActual.obtenerAlbum().equals(album)){
                return true;

             }
             this.nodoActual=this.nodoActual.obtenerSiguiente();
             }
                return false;
             } 

      public void establecerActual(Nodo nuevo){
        this.nodoActual = nuevo;

      }   

}
