/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
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
    
    public void insert(String id, Map data){
        try{
            
            ApiFuture<WriteResult> future = database.bd.collection("nombres").document(id).set(data);
            System.out.println("Update time : " + future.get().getUpdateTime());
        }
        catch(Exception e){System.out.println(e);}
    }
    
    public void tableStock(JTable table){ // Mostramos al info de la BBDD en la tabla
        try{
            // asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = database.bd.collection("stock").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // añade filas a la tabla automaticamente
                model.addRow(new Object[]{document.getData().get("nombre"), document.getData().get("cantidad").toString(), document.getData().get("unidad")});
            }
        }
        catch(Exception e){System.out.println(e);}
    }
    
}
