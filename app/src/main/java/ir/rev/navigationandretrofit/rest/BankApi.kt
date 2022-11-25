package ir.rev.navigationandretrofit.rest


import Answer
import retrofit2.Call
import retrofit2.http.GET

// из гайда по ретрофиту, тут будут запросы
interface BankApi {

    @GET("echo/get/json")
    fun getResult(): Call<Answer>

}

