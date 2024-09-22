package com.example.cadastroalunos.ui.pagamento

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroalunos.database.entities.Pagamento
import com.example.cadastroalunos.databinding.ItemPagamentoBinding
import java.text.SimpleDateFormat
import java.util.Locale

class PagamentoAdapter(
    private val onEditClick: (Pagamento) -> Unit,
    private val onDeleteClick: (Pagamento) -> Unit
) : ListAdapter<Pagamento, PagamentoAdapter.PagamentoViewHolder>(PagamentoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagamentoViewHolder {
        val binding = ItemPagamentoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagamentoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagamentoViewHolder, position: Int) {
        val pagamento = getItem(position)
        holder.bind(pagamento)
    }

    inner class PagamentoViewHolder(private val binding: ItemPagamentoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pagamento: Pagamento) {
            binding.textViewValor.text = "Valor: R$ ${pagamento.valor}"
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            binding.textViewData.text = "Data: ${sdf.format(pagamento.data)}"

            binding.buttonEdit.setOnClickListener {
                onEditClick(pagamento)
            }

            binding.buttonDelete.setOnClickListener {
                onDeleteClick(pagamento)
            }
        }
    }
}

class PagamentoDiffCallback : DiffUtil.ItemCallback<Pagamento>() {
    override fun areItemsTheSame(oldItem: Pagamento, newItem: Pagamento): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pagamento, newItem: Pagamento): Boolean {
        return oldItem == newItem
    }
}
