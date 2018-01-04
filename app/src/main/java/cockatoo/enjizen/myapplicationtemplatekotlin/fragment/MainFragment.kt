package cockatoo.enjizen.myapplicationtemplatekotlin.fragment


import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

import cockatoo.enjizen.myapplicationtemplatekotlin.R
import cockatoo.enjizen.myapplicationtemplatekotlin.constant.Constant
import cockatoo.enjizen.myapplicationtemplatekotlin.manager.http.CallApiServiceManager
import cockatoo.enjizen.myapplicationtemplatekotlin.model.retrofit.ProvinceItemModel
import cockatoo.enjizen.myapplicationtemplatekotlin.model.retrofit.ProvinceModel
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState)  // Restore Instance
        }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        textViewTest.setText(R.string.label_test_butter_knife)
        if (savedInstanceState == null) {
            feedProvince()
        } else {
            val provinceModel = arguments.getParcelable<ProvinceModel>(Constant.PROVINCE_LIST_ARGUMENT)

            if (provinceModel != null) {
                setDataProvinceSpinner(provinceModel)
            }

        }
    }

    @SuppressLint("StaticFieldLeak")
    private fun feedProvince(){
        object : AsyncTask<String,Void,ProvinceModel>(){

            override fun onPreExecute() {
                super.onPreExecute()

                showLoadingDialog()
            }

            override fun doInBackground(vararg params: String?): ProvinceModel? =
                    CallApiServiceManager.getProvince()

            override fun onPostExecute(provinceModel: ProvinceModel?) {
                super.onPostExecute(provinceModel)

                hideLoadingDialog()

                if (provinceModel != null) {
                    val bundle = Bundle()
                    bundle.putParcelable(Constant.PROVINCE_LIST_ARGUMENT, provinceModel)
                    arguments = bundle
                    setDataProvinceSpinner(arguments.getParcelable<Parcelable>(Constant.PROVINCE_LIST_ARGUMENT) as ProvinceModel)
                } else {
                    showAlertDialog(getString(R.string.call_api_error_message),R.string.ok);
                    //showAlertConfirmDialog(getString(R.string.call_api_error_message), R.string.ok, R.string.cancel)
                }
            }

        }.execute()
    }





    private fun setDataProvinceSpinner(provinceModel: ProvinceModel) {
        val dataAdapter = ArrayAdapter<ProvinceItemModel>(context,
                android.R.layout.simple_spinner_dropdown_item, provinceModel.provinceItemModelList!!)

        spinnerProvince.adapter = dataAdapter

        spinnerProvince.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                /*  provinceId = provinceModel.getProvinceItemModelList().get(position).getId();
                 provinceName = provinceModel.getProvinceItemModelList().get(position).getLabel();*/
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle) {

    }

    override fun onPositiveButtonClick() {
        super.onPositiveButtonClick()

        Toast.makeText(context, "Positive", Toast.LENGTH_LONG).show()
    }

    override fun onNegativeButtonClick() {
        super.onNegativeButtonClick()

        Toast.makeText(context, "Negative", Toast.LENGTH_LONG).show()
    }

    companion object {

        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
