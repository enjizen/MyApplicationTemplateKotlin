package cockatoo.enjizen.myapplicationtemplatekotlin.fragment


import android.support.annotation.StringRes
import android.support.v4.app.Fragment

import cc.cloudist.acplibrary.ACProgressFlower
import cockatoo.enjizen.myapplicationtemplatekotlin.view.dialog.AlertDialogFragment
import cockatoo.enjizen.myapplicationtemplatekotlin.view.dialog.ConfirmDialogFragment

/**
 * Created by Wanchalerm Yuphasuk on 27/12/2017 AD.
 */

open class BaseFragment : Fragment(), AlertDialogFragment.OnDialogListener, ConfirmDialogFragment.OnDialogListener {


    private var dialog: ACProgressFlower? = null

    protected fun showLoadingDialog() {

        dialog = ACProgressFlower.Builder(context)
                .build()

        // dialog.setCanceledOnTouchOutside(false);

        dialog!!.show()
    }

    protected fun hideLoadingDialog() {
        dialog!!.dismiss()
    }

    protected fun showAlertDialog(message: String, @StringRes positiveButton: Int) {
        val alertDialogFragment = AlertDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .build()

        alertDialogFragment.isCancelable = false
        alertDialogFragment.show(childFragmentManager, "alert dialog")

    }

    protected fun showAlertConfirmDialog(message: String, @StringRes positiveButton: Int, @StringRes NegativeButton: Int
    ) {
        val confirmDialogFragment = ConfirmDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positiveButton)
                .setNegative(NegativeButton)
                .build()

        confirmDialogFragment.isCancelable = false
        confirmDialogFragment.show(childFragmentManager, "confirm dialog")

    }


    override fun onPositiveButtonClick() {

    }

    override fun onNegativeButtonClick() {

    }
}
