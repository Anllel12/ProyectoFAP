/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * Clase para realizar todas las querys en la BBDD
 *
 */
package database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anlle
 */
public class Query {
    
    creationDB database = new creationDB();
    
    public void insert(String id, Map data, String coleccion){
        try{          
            ApiFuture<WriteResult> stmt = database.bd.collection(coleccion).document(id).set(data);
            System.out.println("Update time : " + stmt.get().getUpdateTime());
        }
        catch(Exception e){System.out.println("Error al insertar: " + e);}
    }
    
    public void delete(String coleccion, String id){
        try{
            ApiFuture<WriteResult> stmt = database.bd.collection(coleccion).document(id).delete();
            System.out.println("Update time : " + stmt.get().getUpdateTime());
        }
        catch(Exception e){System.out.println("Error al eliminar: " + e);}
    }
    
    public void tableStock(JTable table){ // Mostramos la info de la BBDD en la tabla
        try{
            // asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> stmt = database.bd.collection("stock").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = stmt.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // anade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("cantidad").toString(), document.getData().get("unidad"), document.getData().get("coste").toString(), document.getData().get("venta").toString(), document.getData().get("min").toString(), document.getData().get("max").toString()}); // Pone los datos en cada columna
            }
        }
        catch(Exception e){System.out.println("Error al poner datos en la tabla Stock: " + e);}
    }
    
    public void tableUser(JTable table){ // Mostramos la info de la BBDD en la tabla
        try{
            // asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> stmt = database.bd.collection("usuarios").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = stmt.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // anade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("apellido").toString(), document.getData().get("contrase�a").toString()}); // Pone los datos en cada columna
            }
        }
        catch(Exception e){System.out.println("Error al poner datos en la tabla Usuarios: " + e);}
    }
    
    public void tableClient(JTable table){ // Mostramos al info de la BBDD en la tabla
        try{
            // asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> stmt = database.bd.collection("clientes").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = stmt.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // a�ade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("apellidos"), document.getData().get("correo"), document.getData().get("telefono"), document.getData().get("provincia"), document.getData().get("codigo postal"), document.getData().get("localidad"), document.getData().get("direccion")}); // Pone los datos en cada columna
            }
        }
        catch(Exception e){System.out.println("Error al poner datos en la tabla Clientes: " + e);}
    }
    
    public void tableProve(JTable table){ // Mostramos al info de la BBDD en la tabla
        try{
            // asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> stmt = database.bd.collection("proveedores").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = stmt.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // a�ade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("telefono"), document.getData().get("correo")}); // Pone los datos en cada columna
            }
        }
        catch(Exception e){System.out.println("Error al poner datos en la tabla Proveedores: " + e);}
    }

    public void updateStock(int col, String id, Object value) {
        DocumentReference docRef = database.bd.collection("stock").document(id);
        ApiFuture<WriteResult> stmt = null;
        System.out.println(col);
        try{
            switch(col){ // segun el numero de la columna hace una cosa u otra
                case 1: stmt = docRef.update("nombre", value.toString()); break;
                case 2: stmt = docRef.update("cantidad", (int)value); break;
                case 3: stmt = docRef.update("unidad", value.toString()); break;
                case 4: stmt = docRef.update("coste", (int)value); break;
                case 5: stmt = docRef.update("venta", (int)value); break;
                case 6: stmt = docRef.update("min", (int)value); break;
                case 7: stmt = docRef.update("max", (int)value); break;
            }  
            WriteResult result = stmt.get();
            System.out.println("Write result: " + result);
        }
        catch(Exception e){System.out.println("Error al editar datos en la tabla Stock: " + e);}
    }
    
    public void updateClient(int col, String id, Object value) {
        DocumentReference docRef = database.bd.collection("clientes").document(id);
        ApiFuture<WriteResult> stmt = null;
        System.out.println(col);
        try{
            switch(col){ // segun el numero de la columna hace una cosa u otra
                case 1: stmt = docRef.update("nombre", value.toString()); break;
                case 2: stmt = docRef.update("apellidos", value.toString()); break;
                case 3: stmt = docRef.update("correo", value.toString()); break;
                case 4: stmt = docRef.update("telefono", value.toString()); break;
                case 5: stmt = docRef.update("provincia", value.toString()); break;
                case 6: stmt = docRef.update("codigo postal", value.toString()); break;
                case 7: stmt = docRef.update("localidad", value.toString()); break;
                case 8: stmt = docRef.update("direccion", value.toString()); break;
            }  
            WriteResult result = stmt.get();
            System.out.println("Write result: " + result);
        }
        catch(Exception e){System.out.println("Error al editar datos en la tabla Cliente: " + e);}
    }
    
    public void updateUser(int col, String id, Object value) {
        DocumentReference docRef = database.bd.collection("usuarios").document(id);
        ApiFuture<WriteResult> stmt = null;
        System.out.println(col);
        try{
            switch(col){ // segun el numero de la columna hace una cosa u otra
                case 1: stmt = docRef.update("nombre", value.toString()); break;
                case 2: stmt = docRef.update("apellido", value.toString()); break;
                case 3: stmt = docRef.update("contrase�a", value.toString()); break;
            }  
            WriteResult result = stmt.get();
            System.out.println("Write result: " + result);
        }
        catch(Exception e){System.out.println("Error al editar datos en la tabla Stock: " + e);}
    }
    
    public void updateProve(int col, String id, Object value) {
        DocumentReference docRef = database.bd.collection("proveedores").document(id);
        ApiFuture<WriteResult> stmt = null;
        System.out.println(col);
        try{
            switch(col){ // segun el numero de la columna hace una cosa u otra
                case 1: stmt = docRef.update("nombre", value.toString()); break;
                case 2: stmt = docRef.update("telefono", value.toString()); break;
                case 3: stmt = docRef.update("correo", value.toString()); break;
            }  
            WriteResult result = stmt.get();
            System.out.println("Write result: " + result);
        }
        catch(Exception e){System.out.println("Error al editar datos en la tabla Cliente: " + e);}
    }
    
    public boolean registrar(String correo, Map<String, Object> data, String usuarios) {
        try{          
            ApiFuture<WriteResult> stmt = database.bd.collection(usuarios).document(correo).set(data);
            System.out.println("Update time : " + stmt.get().getUpdateTime());
            return true;
        }
        catch(Exception e){System.out.println("Error al insertar: " + e);
        return false;}
    }
    
    public boolean login(String correo, String contra) {
         try {
            ApiFuture<QuerySnapshot> stmt = database.bd.collection("usuarios").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = stmt.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                String email = document.getId().toString();
                String contral = document.getData().get("contrase�a").toString();
                char arrayD[]= contral.toCharArray();
                for(int i=0; i< arrayD.length; i++)
                arrayD[i] =(char)(arrayD[i]-(char)5);
                {
                }
                String desencriptado = String.valueOf(arrayD);
                
                if(contra.equals(desencriptado) && correo.equals(email)){ 
                    return true;
                    
                }
                }
        } catch(Exception e){System.out.println("Error al insertar: " + e);}
        return false;
    }
}
   
        
    