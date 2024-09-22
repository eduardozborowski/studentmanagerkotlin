package com.example.cadastroalunos.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Aluno")
data class Aluno(
    @PrimaryKey val cpf: String,
    val nome: String,
    val telefone: String,
    val foto: ByteArray?,
    val ativo: Boolean,
    val tipoCurso: String
)
