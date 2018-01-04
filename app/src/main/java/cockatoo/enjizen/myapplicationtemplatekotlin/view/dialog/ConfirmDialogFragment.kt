package cockatoo.enjizen.myapplicationtemplatekotlin.view.dialog


import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cockatoo.enjizen.myapplicationtemplatekotlin.R
import cockatoo.enjizen.myapplicationtemplatekotlin.constant.Constant
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*


/**
 * A simple [Fragment] subclass.
 */
class ConfirmDialogFragment : DialogFragment() {





    private var message: String? = null
    private var positive: Int = 0
    private var negative: Int = 0


    private val onDialogListener: OnDialogListener?
        get() {
            val fragment = parentFragment
            try {
                return if (fragment != null) {
                    Log.i("Return", "Result = Fragment")
                    fragment as OnDialogListener
                } else {
                    Log.i("Return", "Result = Activity")
                    activity as OnDialogListener
                }
            } catch (ignored: ClassCastException) {
            }

            return null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            restoreArguments(arguments)
        } else {
            onRestoreInstanceState(savedInstanceState)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =// Inflate the layout for this fragment
            inflater!!.inflate(R.layout.fragment_confirm_dialog, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

    }


    private fun setupView() {
        tvMessage.text = message
        btnPositive.setText(positive)
        btnNegative.setText(negative)

        btnPositive.setOnClickListener {
            val listener = onDialogListener
            listener?.onPositiveButtonClick()
            dismiss()
        }

        btnNegative.setOnClickListener {
            val listener = onDialogListener
            listener?.onNegativeButtonClick()
            dismiss()
        }


    }

    private fun restoreArguments(bundle: Bundle) {
        message = bundle.getString(Constant.KEY_MESSAGE)
        positive = bundle.getInt(Constant.KEY_POSITIVE)
        negative = bundle.getInt(Constant.KEY_NEGATIVE)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState!!.putString(Constant.KEY_MESSAGE, message)
        outState.putInt(Constant.KEY_POSITIVE, positive)
        outState.putInt(Constant.KEY_NEGATIVE, negative)

    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle) {
        message = savedInstanceState.getString(Constant.KEY_MESSAGE)
        positive = savedInstanceState.getInt(Constant.KEY_POSITIVE)
        negative = savedInstanceState.getInt(Constant.KEY_NEGATIVE)
    }

    interface OnDialogListener {
        fun onPositiveButtonClick()

        fun onNegativeButtonClick()
    }


    open class Builder {
        private var message: String? = null
        private var positive: Int = 0
        private var negative: Int = 0

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setPositive(@StringRes positive: Int): Builder {
            this.positive = positive
            return this
        }

        fun setNegative(@StringRes negative: Int): Builder {
            this.negative = negative
            return this
        }

        fun build(): ConfirmDialogFragment =
                ConfirmDialogFragment.newInstance(message, positive, negative)
    }

    companion object {

        fun newInstance(message: String?, @StringRes positive: Int, @StringRes negative: Int): ConfirmDialogFragment {
            val fragment = ConfirmDialogFragment()
            val bundle = Bundle()
            bundle.putString(Constant.KEY_MESSAGE, message)
            bundle.putInt(Constant.KEY_POSITIVE, positive)
            bundle.putInt(Constant.KEY_NEGATIVE, negative)
            fragment.arguments = bundle
            return fragment
        }
    }

}// Required empty public constructor
