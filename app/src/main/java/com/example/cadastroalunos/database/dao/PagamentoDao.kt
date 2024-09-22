package com.example.cadastroalunos.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cadastroalunos.database.entities.Pagamento

@Dao
interface PagamentoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirPagamento(pagamento: Pagamento): Long

    @Delete
    suspend fun deletarPagamento(pagamento: Pagamento)

    @Update
    suspend fun atualizarPagamento(pagamento: Pagamento)

    @Query("SELECT * FROM Pagamento WHERE cpfAluno = :cpfAluno")
    fun listarPagamentosPorAluno(cpfAluno: String): LiveData<List<Pagamento>>
}
