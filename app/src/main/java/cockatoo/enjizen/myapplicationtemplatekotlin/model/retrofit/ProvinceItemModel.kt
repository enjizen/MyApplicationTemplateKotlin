package cockatoo.enjizen.myapplicationtemplatekotlin.model.retrofit

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

class ProvinceItemModel protected constructor(`in`: Parcel) : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("label")
    @Expose
    var label: String? = null

    init {
        id = `in`.readString()
        label = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(label)
    }

    override fun describeContents(): Int {
        return 0
    }


    override fun toString(): String {

        return label!!
    }

    companion object {

        val CREATOR: Parcelable.Creator<ProvinceItemModel> = object : Parcelable.Creator<ProvinceItemModel> {
            override fun createFromParcel(`in`: Parcel): ProvinceItemModel {
                return ProvinceItemModel(`in`)
            }

            override fun newArray(size: Int): Array<ProvinceItemModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}
