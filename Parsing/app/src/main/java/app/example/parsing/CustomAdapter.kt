package app.example.parsing


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import app.example.parsing.datamodel.DataGempa

class CustomAdapter(context: Context, resource: Int, objects: List<DataGempa>) :
    ArrayAdapter<DataGempa>(context, resource, objects) {

    private class ViewHolder {
        internal var tvTanggal: TextView? = null
        internal var tvJam: TextView? = null
        internal var tvMagnitude: TextView? = null
        // Tambahkan elemen UI lainnya sesuai kebutuhan
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false)

            viewHolder = ViewHolder()
            viewHolder.tvTanggal = convertView.findViewById(R.id.tvTanggal)
            viewHolder.tvJam = convertView.findViewById(R.id.tvJam)
            viewHolder.tvMagnitude = convertView.findViewById(R.id.tvMagnitude)
            // Inisialisasi elemen UI lainnya sesuai kebutuhan

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        // Ambil data dari koleksi dan set ke elemen-elemen UI
        val item = getItem(position)
        if (item != null) {
            viewHolder.tvTanggal?.text = "Tanggal: ${item.tanggal}"
            viewHolder.tvJam?.text = "Jam: ${item.jam}"
            viewHolder.tvMagnitude?.text = "Magnitude: ${item.magnitude}"
            // Set elemen UI lainnya sesuai kebutuhan
        }

        return convertView!!
    }
}
