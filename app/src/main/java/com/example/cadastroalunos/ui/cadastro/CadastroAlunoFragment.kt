package com.example.cadastroalunos.ui.cadastro

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cadastroalunos.R
import com.example.cadastroalunos.database.entities.Aluno
import com.example.cadastroalunos.databinding.FragmentCadastroAlunoBinding
import com.example.cadastroalunos.viewmodel.AlunoViewModel
import java.io.ByteArrayOutputStream

class CadastroAlunoFragment : Fragment(R.layout.fragment_cadastro_aluno) {

    private var _binding: FragmentCadastroAlunoBinding? = null
    private val binding get() = _binding!!
    private val alunoViewModel: AlunoViewModel by viewModels()
    private var fotoBitmap: Bitmap? = null

    private val REQUEST_CODE_CAMERA = 1
    private val REQUEST_CAMERA_PERMISSION = 100

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCadastroAlunoBinding.bind(view)

        binding.buttonSelecionarFoto.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                openCamera()
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(android.Manifest.permission.CAMERA),
                    REQUEST_CAMERA_PERMISSION
                )
            }
        }

        binding.buttonSalvarAluno.setOnClickListener {
            salvarAluno()
        }

        val cpfAluno = arguments?.getString("cpfAluno")
        if (cpfAluno != null) {
            alunoViewModel.obterAluno(cpfAluno).observe(viewLifecycleOwner) { aluno ->
                if (aluno != null) {
                    preencherDadosAluno(aluno)
                }
            }
        }
    }

    private fun salvarAluno() {
        val nome = binding.editTextNome.text.toString()
        val cpf = binding.editTextCpf.text.toString()
        val telefone = binding.editTextTelefone.text.toString()
        val ativo = binding.checkBoxAtivo.isChecked
        val tipoCurso = if (binding.radioButtonGraduacao.isChecked) "Graduação" else "Pós-graduação"
        val foto = fotoBitmap?.let { bitmapToByteArray(it) }

        val aluno = Aluno(cpf, nome, telefone, foto, ativo, tipoCurso)
        alunoViewModel.inserirAluno(aluno)

        Toast.makeText(requireContext(), "Aluno salvo com sucesso!", Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }

    private fun preencherDadosAluno(aluno: Aluno) {
        binding.editTextNome.setText(aluno.nome)
        binding.editTextCpf.setText(aluno.cpf)
        binding.editTextCpf.isEnabled = false
        binding.editTextTelefone.setText(aluno.telefone)
        binding.checkBoxAtivo.isChecked = aluno.ativo
        if (aluno.tipoCurso == "Graduação") {
            binding.radioButtonGraduacao.isChecked = true
        } else {
            binding.radioButtonPosGraduacao.isChecked = true
        }
        aluno.foto?.let {
            binding.imageViewFoto.setImageBitmap(byteArrayToBitmap(it))
        }
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CODE_CAMERA)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(requireContext(), "Permissão de câmera negada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            fotoBitmap = data?.extras?.get("data") as Bitmap
            binding.imageViewFoto.setImageBitmap(fotoBitmap)
        }
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

    private fun byteArrayToBitmap(bytes: ByteArray): Bitmap {
        return android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
