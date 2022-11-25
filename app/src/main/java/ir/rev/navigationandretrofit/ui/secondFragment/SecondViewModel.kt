package ir.rev.navigationandretrofit.ui.secondFragment

import Answer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.rev.navigationandretrofit.rest.BankRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondViewModel : ViewModel() {

    private val TAG = "checkResult"

    private val repository = BankRepository()

    private val _isBankOnlineLiveData = MutableLiveData<Boolean>()
    val isBankOnlineLiveData: LiveData<Boolean> = _isBankOnlineLiveData

    // запрос в сеть проверки работае ли банк или нет
    fun checkBankIsOnline() {
        repository.isBankOnline().enqueue(object : Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                val currentResponse = response.body()
                if (currentResponse != null) {
                    _isBankOnlineLiveData.postValue(currentResponse.success)
                } else {
                    Log.d(TAG, "ошибка загрузки ответ пустой")
                }
            }

            override fun onFailure(call: Call<Answer>, throwable: Throwable) {
                Log.d(TAG, "ошибка загрузки", throwable)
            }

        })
    }

}