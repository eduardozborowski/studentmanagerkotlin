package com.example.cadastroalunos.ui.listagem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroalunos.database.entities.Aluno
import com.example.cadastroalunos.databinding.ItemAlunoBinding

class AlunoAdapter(
    private val onEditClick: (Aluno) -> Unit,
    private val onDeleteClick: (Aluno) -> Unit,
    private val onViewPaymentsClick: (Aluno) -> Unit
) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    private var alunos: List<Aluno> = listOf()

    fun submitList(alunos: List<Aluno>) {
        this.alunos = alunos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val binding = ItemAlunoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlunoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.bind(aluno)
    }

    override fun getItemCount(): Int = alunos.size

    inner class AlunoViewHolder(private val binding: ItemAlunoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(aluno: Aluno) {
            binding.textViewNomeAluno.text = aluno.nome

            // Editar Aluno
            binding.buttonEditarAluno.setOnClickListener {
                onEditClick(aluno)
            }

            // Deletar Aluno
            binding.buttonDeletarAluno.setOnClickListener {
                onDeleteClick(aluno)
            }

            // Ver Pagamentos
            binding.buttonVerPagamentos.setOnClickListener {
                onViewPaymentsClick(aluno)
            }

            // Exibir foto do aluno
            aluno.foto?.let {
                binding.imageViewFotoAluno.setImageBitmap(
                    android.graphics.BitmapFactory.decodeByteArray(it, 0, it.size)
                )
            }
        }
    }
}
