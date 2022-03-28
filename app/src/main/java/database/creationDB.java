/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package database;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
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
    static Firestore db;
    public static void conectar(){
        try{
            
            FileInputStream refreshToken = new FileInputStream("proyectofap.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://proyectofap-12da6.firebaseio.com/")
                    .build();
            
            FirebaseApp.initializeApp(options);
            
            System.out.println("Hola");
        }
        catch(Exception e){System.out.println("F");}
    }
    public static boolean insert(String coleccion, String id, Map data){
 
        try{
            DocumentReference docRef = db.collection(coleccion).document(id);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update time : " + result.get().getUpdateTime());
            
            return true;
        }
        catch(Exception e){System.out.println("Puto");}
        
        return false;
    }
}
