package app.example.parsing

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.example.parsing.config.DataConfig
import app.example.parsing.datamodel.DataGempa
import app.example.parsing.model.ModelGempa
import app.example.parsing.ui.theme.ParsingTheme
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tgl = findViewById<TextView>(R.id.tv_tanggal)
        var jam = findViewById<TextView>(R.id.tv_jam)
        var dtm = findViewById<TextView>(R.id.tv_datetime)
        var koo = findViewById<TextView>(R.id.tv_koordinat)
        var lin = findViewById<TextView>(R.id.tv_lintang)
        var buj = findViewById<TextView>(R.id.tv_bujur)
        var mag = findViewById<TextView>(R.id.tv_magnitude)
        var kdl = findViewById<TextView>(R.id.tv_kedalaman)
        var wlh = findViewById<TextView>(R.id.tv_wilayah)
        var pts = findViewById<TextView>(R.id.tv_potensi)
        var drs = findViewById<TextView>(R.id.tv_dirasakan)
        var shk = findViewById<ImageView>(R.id.foto_shakemap)

        DataConfig().getService()
            .getDataGempa()
            .enqueue(object : retrofit2.Callback<ModelGempa>{
                override fun onResponse(call: Call<ModelGempa>, response: Response<ModelGempa>) {

                    //parsing
                    tgl.setText(response.body()?.infogempa?.gempa?.tanggal)
                    jam.setText(response.body()?.infogempa?.gempa?.jam)
                    dtm.setText(response.body()?.infogempa?.gempa?.dateTime)
                    koo.setText(response.body()?.infogempa?.gempa?.coordinates)
                    lin.setText(response.body()?.infogempa?.gempa?.lintang)
                    buj.setText(response.body()?.infogempa?.gempa?.bujur)
                    mag.setText(response.body()?.infogempa?.gempa?.magnitude)
                    kdl.setText(response.body()?.infogempa?.gempa?.kedalaman)
                    wlh.setText(response.body()?.infogempa?.gempa?.wilayah)
                    pts.setText(response.body()?.infogempa?.gempa?.potensi)
                    drs.setText(response.body()?.infogempa?.gempa?.dirasakan)
                    Picasso.get()
                        .load("https://data.bmkg.go.id/DataMKG/TEWS/"
                                + response.body()?.infogempa?.gempa?.shakemap)
                        .into(shk)
                }

                override fun onFailure(call: Call<ModelGempa>, t: Throwable) {

                }


            })
    }
}

