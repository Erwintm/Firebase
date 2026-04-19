package com.example.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MiServicioFirebase : FirebaseMessagingService() {

    // Este método se ejecuta cuando Firebase le asigna un "ID" único a tu celular
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Imprimimos el token en el Logcat para poder copiarlo después
        Log.d("FCM_TOKEN", "Mi token es: $token")
    }

    // Este método se activa cuando llega un mensaje desde el servidor
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Por ahora, solo imprimiremos el mensaje en la consola de Android Studio
        remoteMessage.notification?.let {
            Log.d("FCM_MENSAJE", "Título: ${it.title}")
            Log.d("FCM_MENSAJE", "Cuerpo: ${it.body}")
        }
    }
}