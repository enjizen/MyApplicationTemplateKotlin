package cockatoo.enjizen.myapplicationtemplatekotlin.manager.http

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Wanchalerm Yuphasuk on 4/1/2018 AD.
 */
object HttpManager {

    var service: ApiService

    init {
        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://203.154.255.55:8080/tipinsuranceAPI-3.0/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        service = retrofit.create(ApiService::class.java)
    }
}