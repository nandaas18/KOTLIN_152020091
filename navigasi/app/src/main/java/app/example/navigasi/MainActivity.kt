package app.example.navigasi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        adapter = NoteAdapter(onNoteClickListener = { note ->
            // Handle note item click
            Toast.makeText(this, "Clicked on note: ${note.title}", Toast.LENGTH_SHORT).show()
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        noteViewModel.allNotes.observe(this, Observer { notes ->
            notes?.let {
                adapter.submitList(it)
            }
        })

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                noteViewModel.insert(Note(title = title, content = content))
            } else {
                Toast.makeText(this, "Title and content cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        btnDelete.setOnClickListener {
            val title = etTitle.text.toString().trim()

            if (title.isNotEmpty()) {
                val noteToDelete = adapter.currentList.find { it.title == title }
                noteToDelete?.let { noteViewModel.delete(it) }
            } else {
                Toast.makeText(this, "Enter the title to delete", Toast.LENGTH_SHORT).show()
            }
        }

        btnUpdate.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val noteToUpdate = adapter.currentList.find { it.title == title }
                noteToUpdate?.let { noteViewModel.update(it.id, title, content) }
            } else {
                Toast.makeText(this, "Title and content cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
