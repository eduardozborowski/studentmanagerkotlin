package com.example.cadastroalunos.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "Pagamento",
    foreignKeys = [ForeignKey(
        entity = Aluno::class,
        parentColumns = ["cpf"],
        childColumns = ["cpfAluno"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["cpfAluno"])]
)
data class Pagamento(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cpfAluno: String,
    val valor: Float,
    val data: Date,
    val fotoBytes: ByteArray?
)
