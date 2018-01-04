package cockatoo.enjizen.myapplicationtemplatekotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import cockatoo.enjizen.myapplicationtemplatekotlin.R
import cockatoo.enjizen.myapplicationtemplatekotlin.fragment.MainFragment


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.content_container, MainFragment.newInstance())
                    .commit()
        }

    }
}
