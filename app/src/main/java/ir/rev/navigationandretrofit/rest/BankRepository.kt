package ir.rev.navigationandretrofit.rest

import Answer
import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// экземпляр репозитория для банка
class BankRepository {

    private val bankApi: BankApi

    init {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl("https://reqbin.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        bankApi = retrofit.create(BankApi::class.java)
    }

    fun isBankOnline(): Call<Answer> {
        return bankApi.getResult()
    }

    companion object {
        private const val TAG = "CheckResult"
    }

}