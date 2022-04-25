/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*
* Clase la cual utilizaremos para conectarnos a la Base de Dato y proximamente su creación automatica
*
*/
package database;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import ventana.menu;

/**
 *
 * @author anlle
 */
public class creationDB {
    
    static menu m = new menu();
    
    static Firestore bd; // Referencia de la BBDD
    
    public static void conectar(){
        try{
            
            FileInputStream refreshToken = new FileInputStream("proyectofap.json"); // Credenciales para poder editar la BBDD
            
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://proyectofap-12da6.firebaseio.com/")
                    .build();
            
            FirebaseApp.initializeApp(options);
            bd = FirestoreClient.getFirestore();
        }
        catch(Exception e){System.out.println("Error al conectarse: " + e);}
    }
}
