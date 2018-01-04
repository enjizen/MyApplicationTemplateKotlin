package cockatoo.enjizen.myapplicationtemplatekotlin

import android.app.Application
import com.yuphasuk.wanchalerm.householdincome.manager.Contextor

/**
 * Created by streami.t.mobiledeveloper1 on 3/1/2018 AD.
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Contextor.getInstance().init(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}