/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package database;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.util.HashMap;
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
    public static void insert(){
        try{
            // Add document data with an additional field ("middle")
            Map<String, Object> data = new HashMap<>();
            data.put("first", "Alan");
            data.put("middle", "Mathison");
            data.put("last", "Turing");

            ApiFuture<WriteResult> future = bd.collection("nombres").document("principio").set(data);
            System.out.println("Update time : " + future.get().getUpdateTime());
        }
        catch(Exception e){System.out.println(e);}
    }
}
