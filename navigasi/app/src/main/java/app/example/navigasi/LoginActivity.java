package app.example.navigasi;

import android.app.Activity;
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

public class LoginActivity extends Activity {


    class LoginActivity : AppCompatActivity() {

        private lateinit var auth: FirebaseAuth

        private lateinit var etEmail: EditText
        private lateinit var etPassword: EditText
        private lateinit var btnLogin: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            // Inisialisasi Firebase Authentication
            auth = FirebaseAuth.getInstance()

            etEmail = findViewById(R.id.etEmail)
            etPassword = findViewById(R.id.etPassword)
            btnLogin = findViewById(R.id.btnLogin)

            btnLogin.setOnClickListener {
                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString().trim()

                // Melakukan proses login dengan Firebase Authentication
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Jika login berhasil, lanjutkan ke aktivitas berikutnya (misalnya: MainActivity)
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        // Jika login gagal, tampilkan pesan kesalahan
                        // (Anda dapat menyesuaikan pesan kesalahan sesuai kebutuhan)
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}
