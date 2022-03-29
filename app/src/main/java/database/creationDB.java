/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package database;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anlle
 */
public class creationDB {
    
    static Firestore bd;
    
    public static void conectar(){
        try{
            
            FileInputStream refreshToken = new FileInputStream("proyectofap.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://proyectofap-12da6.firebaseio.com/")
                    .build();
            
            FirebaseApp.initializeApp(options);
            bd = FirestoreClient.getFirestore();
            
            System.out.println("Hola");
        }
        catch(Exception e){System.out.println(e);}
    }
    
    public static void insert(String id, Map data){
        try{
            
            ApiFuture<WriteResult> future = bd.collection("nombres").document(id).set(data);
            System.out.println("Update time : " + future.get().getUpdateTime());
        }
        catch(Exception e){System.out.println(e);}
    }
    
    public static void read(){
        try{
            // asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = bd.collection("nombres").get();
            // future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                System.out.println(document.getId() + " => " + document.getReference().getId());
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}
