package com.example.cadastroalunos.ui.pagamento

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cadastroalunos.R
import com.example.cadastroalunos.database.entities.Pagamento
import com.example.cadastroalunos.databinding.FragmentCadastroPagamentoBinding
import com.example.cadastroalunos.viewmodel.PagamentoViewModel
import java.util.Calendar

class CadastroPagamentoFragment : Fragment(R.layout.fragment_cadastro_pagamento) {

    private var _binding: FragmentCadastroPagamentoBinding? = null
    private val binding get() = _binding!!
    private val pagamentoViewModel: PagamentoViewModel by viewModels()
    private val args: CadastroPagamentoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCadastroPagamentoBinding.bind(view)

        binding.textViewNomeAluno.text = args.nomeAluno

        binding.buttonSalvarPagamento.setOnClickListener {
            val valor = binding.editTextValor.text.toString().toFloatOrNull()
            if (valor == null || valor <= 0) {
                binding.editTextValor.error = "Valor inválido"
                return@setOnClickListener
            }

            val calendar = Calendar.getInstance().apply {
                set(binding.datePickerPagamento.year, binding.datePickerPagamento.month, binding.datePickerPagamento.dayOfMonth)
            }

            val pagamento = Pagamento(
                cpfAluno = args.cpfAluno,
                valor = valor,
                data = calendar.time,
                fotoBytes = null
            )

            pagamentoViewModel.inserirPagamento(pagamento)

            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
