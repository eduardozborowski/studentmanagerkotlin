package com.example.cadastroalunos.ui.pagamento

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadastroalunos.R
import com.example.cadastroalunos.databinding.FragmentListaPagamentosBinding
import com.example.cadastroalunos.viewmodel.PagamentoViewModel

class ListaPagamentoFragment : Fragment(R.layout.fragment_lista_pagamentos) {

    private var _binding: FragmentListaPagamentosBinding? = null
    private val binding get() = _binding!!
    private val pagamentoViewModel: PagamentoViewModel by viewModels()
    private val args: ListaPagamentoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListaPagamentosBinding.bind(view)

        val adapter = PagamentoAdapter(
            onEditClick = { pagamento ->
            },
            onDeleteClick = { pagamento ->
                pagamentoViewModel.deletarPagamento(pagamento)
            }
        )

        binding.recyclerViewPagamentos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPagamentos.adapter = adapter

        pagamentoViewModel.listarPagamentosPorAluno(args.cpfAluno).observe(viewLifecycleOwner) { pagamentos ->
            adapter.submitList(pagamentos)
        }

        // Botão para adicionar novo pagamento
        binding.fabAddPagamento.setOnClickListener {
            val action = ListaPagamentoFragmentDirections
                .actionListaPagamentoFragmentToCadastroPagamentoFragment(args.cpfAluno, args.nomeAluno)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
