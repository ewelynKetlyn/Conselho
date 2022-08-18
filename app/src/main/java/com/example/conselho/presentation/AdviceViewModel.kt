package com.example.conselho.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conselho.domain.model.Advice
import com.example.conselho.domain.usecase.GetAdviceUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class AdviceViewModel(
    private val getAdviceUseCase: GetAdviceUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val advice = MutableLiveData<Advice>()

    init {
        getAdvice()
    }

    fun getAdvice(){
        viewModelScope.launch {
            getAdviceUseCase()
                .flowOn(dispatcher)
                .onStart { isLoading.value = true }
                .catch {
                    isLoading.value = false
                    Log.d("ERRO: ", "erro ao buscar o conselho")
                }
                .collect{
                    isLoading.value = false
                    advice.value = it
                }
        }
    }
}