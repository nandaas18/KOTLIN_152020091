package app.example.navigasi
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


    @Dao
    interface NoteDao {
        @Query("SELECT * FROM notes")
        suspend fun getAllNotes(): List<Note>

        @Insert
        suspend fun insert(note: Note)

        @Delete
        suspend fun delete(note: Note)

        @Query("UPDATE notes SET title = :title, content = :content WHERE id = :id")
        suspend fun update(id: Long, title: String, content: String)
    }

