package com.example.cadastroalunos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.cadastroalunos.database.AppDatabase
import com.example.cadastroalunos.database.entities.Pagamento
import kotlinx.coroutines.launch

class PagamentoViewModel(application: Application) : AndroidViewModel(application) {
    private val pagamentoDao = AppDatabase.getDatabase(application).pagamentoDao()

    fun inserirPagamento(pagamento: Pagamento) = viewModelScope.launch {
        pagamentoDao.inserirPagamento(pagamento)
    }

    fun listarPagamentosPorAluno(cpfAluno: String): LiveData<List<Pagamento>> {
        return pagamentoDao.listarPagamentosPorAluno(cpfAluno)
    }

    fun deletarPagamento(pagamento: Pagamento) = viewModelScope.launch {
        pagamentoDao.deletarPagamento(pagamento)
    }

    fun atualizarPagamento(pagamento: Pagamento) = viewModelScope.launch {
        pagamentoDao.atualizarPagamento(pagamento)
    }
}
