package cockatoo.enjizen.myapplicationtemplatekotlin.manager.http

import cockatoo.enjizen.myapplicationtemplatekotlin.model.retrofit.ProvinceModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

interface ApiService {

    @GET("masterdata/province")
    fun getProvince(@Query("lang") lang: String): Call<ProvinceModel>

}
