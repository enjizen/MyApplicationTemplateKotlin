package cockatoo.enjizen.myapplicationtemplatekotlin.manager.http

import cockatoo.enjizen.myapplicationtemplatekotlin.R
import cockatoo.enjizen.myapplicationtemplatekotlin.model.retrofit.ProvinceModel
import com.yuphasuk.wanchalerm.householdincome.manager.Contextor
import java.io.IOException


/**
 * Created by Wanchalerm Yuphasuk on 3/1/2018 AD.
 */
object CallApiServiceManager {
    fun getProvince() : ProvinceModel? {
        val call = HttpManager.service.getProvince(Contextor.getInstance().context!!.getString(R.string.local_upper))
        return try {
            call.execute().body()
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }

    }
}