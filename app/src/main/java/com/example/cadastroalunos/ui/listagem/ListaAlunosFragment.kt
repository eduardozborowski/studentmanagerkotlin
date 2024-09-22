package com.example.cadastroalunos.ui.listagem

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadastroalunos.R
import com.example.cadastroalunos.databinding.FragmentListaAlunosBinding
import com.example.cadastroalunos.viewmodel.AlunoViewModel

class ListaAlunosFragment : Fragment(R.layout.fragment_lista_alunos) {

    private var _binding: FragmentListaAlunosBinding? = null
    private val binding get() = _binding!!
    private val alunoViewModel: AlunoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListaAlunosBinding.bind(view)

        val adapter = AlunoAdapter(
            onEditClick = { aluno ->
                val action = ListaAlunosFragmentDirections
                    .actionListaAlunosFragmentToCadastroAlunoFragment(aluno.cpf)
                findNavController().navigate(action)
            },
            onDeleteClick = { aluno ->
                alunoViewModel.deletarAluno(aluno.cpf)
            },
            onViewPaymentsClick = { aluno ->
                val action = ListaAlunosFragmentDirections
                    .actionListaAlunosFragmentToListaPagamentoFragment(aluno.cpf, aluno.nome)
                findNavController().navigate(action)
            }
        )

        binding.recyclerViewAlunos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewAlunos.adapter = adapter

        alunoViewModel.listarAlunos().observe(viewLifecycleOwner) { alunos ->
            adapter.submitList(alunos)
        }

        binding.fabAddAluno.setOnClickListener {
            findNavController().navigate(R.id.action_listaAlunosFragment_to_cadastroAlunoFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
