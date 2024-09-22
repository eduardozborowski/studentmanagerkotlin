package com.example.cadastroalunos.ui.listagem

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cadastroalunos.R
import com.example.cadastroalunos.databinding.FragmentAlunoDetalhesBinding
import com.example.cadastroalunos.viewmodel.AlunoViewModel

class AlunoDetalhesFragment : Fragment(R.layout.fragment_aluno_detalhes) {

    private lateinit var binding: FragmentAlunoDetalhesBinding
    private val alunoViewModel: AlunoViewModel by viewModels()
    private val args: AlunoDetalhesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAlunoDetalhesBinding.bind(view)

        // Exibir os detalhes do aluno
        binding.textViewNomeAluno.text = args.nomeAluno
        binding.textViewCpfAluno.text = args.cpfAluno

        // Deletar aluno
        binding.buttonDeletarAluno.setOnClickListener {
            alunoViewModel.deletarAluno(args.cpfAluno)
            findNavController().navigate(R.id.action_alunoDetalhesFragment_to_listaAlunosFragment)
        }

        // Editar aluno
        binding.buttonEditarAluno.setOnClickListener {
            val action = AlunoDetalhesFragmentDirections
                .actionAlunoDetalhesFragmentToCadastroAlunoFragment(args.cpfAluno)
            findNavController().navigate(action)
        }

        // Ver os pagamentos do aluno
        binding.buttonVerPagamentos.setOnClickListener {
            val action = AlunoDetalhesFragmentDirections.actionAlunoDetalhesFragmentToListaPagamentoFragment(
                cpfAluno = args.cpfAluno,
                nomeAluno = args.nomeAluno
            )
            findNavController().navigate(action)
        }
    }
}
