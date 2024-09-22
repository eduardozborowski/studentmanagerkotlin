package com.example.cadastroalunos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.cadastroalunos.database.AppDatabase
import com.example.cadastroalunos.database.entities.Aluno
import kotlinx.coroutines.launch

class AlunoViewModel(application: Application) : AndroidViewModel(application) {

    private val alunoDao = AppDatabase.getDatabase(application).alunoDao()

    fun inserirAluno(aluno: Aluno) = viewModelScope.launch {
        alunoDao.inserirAluno(aluno)
    }

    fun listarAlunos(): LiveData<List<Aluno>> {
        return alunoDao.listarAlunos()
    }

    fun deletarAluno(cpf: String) = viewModelScope.launch {
        alunoDao.deletarAluno(cpf)
    }

    fun obterAluno(cpf: String): LiveData<Aluno> {
        return alunoDao.obterAluno(cpf)
    }

    fun atualizarAluno(aluno: Aluno) = viewModelScope.launch {
        alunoDao.atualizarAluno(aluno)
    }
}
