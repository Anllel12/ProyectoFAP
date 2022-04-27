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
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;



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
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // a�ade filas a la tabla automaticamente
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
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // a�ade filas a la tabla automaticamente
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
                model.addRow(new Object[]{document.getReference().getId(),document.getData().get("nombre"), document.getData().get("apellidos"), document.getData().get("correo")}); // Pone los datos en cada columna
            }
        }
        catch(Exception e){System.out.println("Error al poner datos en la tabla Clientes: " + e);}
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
    
    public void updateClient(int col, String id, Object value) {
        DocumentReference docRef = database.bd.collection("clientes").document(id);
        ApiFuture<WriteResult> stmt = null;
        System.out.println(col);
        try{
            switch(col){ // segun el numero de la columna hace una cosa u otra
                case 1: stmt = docRef.update("nombre", value.toString()); break;
                case 2: stmt = docRef.update("apellidos", value.toString()); break;
                case 3: stmt = docRef.update("correo", value.toString()); break;
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

    public void registrar(String correo, Map<String, Object> data, String usuarios) {
        try{          
            ApiFuture<WriteResult> stmt = database.bd.collection(usuarios).document(correo).set(data);
            System.out.println("Update time : " + stmt.get().getUpdateTime());
        }
        catch(Exception e){System.out.println("Error al insertar: " + e);}
    }
    
    

    public void login(String correo, String contra) {
         try {
            ApiFuture<QuerySnapshot> stmt = database.bd.collection("usuarios").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = stmt.get().getDocuments();           
            for (QueryDocumentSnapshot document : documents) {
                 
                /* document.getReference().getId(),document.getData().get("nombre"), 
                document.getData().get("apellidos"), document.getData().get("correo")}) */
                /* Object user =new Object[]{(document.getReference(), document.getData().get("correo")});*/
                System.out.println(document.getReference().getId().toString());
                System.out.println(correo);
                if(document.getReference().getId().equals(correo)){
                    System.out.println("si");
                   
                    
                    break;
                }else{
                    System.out.println("no");
                }
            }
        } catch(Exception e){System.out.println("Error al insertar: " + e);}
    }
    public byte[] cifra(String sinCifrar) throws Exception {
	final byte[] bytes = sinCifrar.getBytes("UTF-8");
	final Cipher aes = obtieneCipher(true);
	final byte[] cifrado = aes.doFinal(bytes);
	return cifrado;
}
    private Cipher obtieneCipher(boolean paraCifrar) throws Exception {
	final String frase = "FAP-CONTRASENYAFILTRADRO_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
	final MessageDigest digest = MessageDigest.getInstance("SHA");
	digest.update(frase.getBytes("UTF-8"));
	final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

	final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
	if (paraCifrar) {
		aes.init(Cipher.ENCRYPT_MODE, key);
	} else {
		aes.init(Cipher.DECRYPT_MODE, key);
	}

	return aes;
}
    public String descifra(byte[] cifrado) throws Exception {
	final Cipher aes = obtieneCipher(false);
	final byte[] bytes = aes.doFinal(cifrado);
	final String sinCifrar = new String(bytes, "UTF-8");
	return sinCifrar;
}
        
        
    }

