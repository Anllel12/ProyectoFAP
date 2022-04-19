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
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // añade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("cantidad").toString(), document.getData().get("unidad")}); // Pone los datos en cada columna
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
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // añade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("apellido").toString(), document.getData().get("contraseña")}); // Pone los datos en cada columna
            }
        }
        catch(Exception e){System.out.println("Error al poner datos en la tabla Usuarios: " + e);}
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
            }  
            WriteResult result = stmt.get();
            System.out.println("Write result: " + result);
        }
        catch(Exception e){System.out.println("Error al editar datos en la tabla Stock: " + e);}
    }
    
}
