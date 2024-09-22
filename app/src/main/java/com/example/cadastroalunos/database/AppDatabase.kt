package com.example.cadastroalunos.database

import android.content.Context
import androidx.room.*
import com.example.cadastroalunos.database.dao.AlunoDao
import com.example.cadastroalunos.database.dao.PagamentoDao
import com.example.cadastroalunos.database.entities.Aluno
import com.example.cadastroalunos.database.entities.Pagamento

@Database(entities = [Aluno::class, Pagamento::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alunoDao(): AlunoDao
    abstract fun pagamentoDao(): PagamentoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
