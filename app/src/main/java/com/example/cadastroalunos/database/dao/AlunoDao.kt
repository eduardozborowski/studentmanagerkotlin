package com.example.cadastroalunos.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cadastroalunos.database.entities.Aluno

@Dao
interface AlunoDao {

    @Query("SELECT * FROM Aluno")
    fun listarAlunos(): LiveData<List<Aluno>>

    @Query("SELECT * FROM Aluno WHERE cpf = :cpf")
    fun obterAluno(cpf: String): LiveData<Aluno>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirAluno(aluno: Aluno): Long

    @Query("DELETE FROM Aluno WHERE cpf = :cpfAluno")
    suspend fun deletarAluno(cpfAluno: String)

    @Update
    suspend fun atualizarAluno(aluno: Aluno): Int
}
