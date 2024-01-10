package com.millenialzdev.logindanregisterfirebase;

import android.app.Activity;
import android.os.Bundle

public class ChatActivity extends Activity {

import androidx.appcompat.app.AppCompatActivity

    class ChatActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_chat)

            // Tambahkan logika untuk menampilkan konfigurasi Firebase pada halaman Chat (opsional)
            // contoh: val firebaseConfig = FirebaseApp.getInstance().options.apiKey
        }
    }

}
