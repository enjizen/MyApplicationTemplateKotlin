package cockatoo.enjizen.myapplicationtemplatekotlin.model.retrofit

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Inspiron 3458 on 10/26/2016.
 */

class ProvinceModel protected constructor(`in`: Parcel) : Parcelable {
    @SerializedName("provinces")
    @Expose
    var provinceItemModelList: List<ProvinceItemModel>? = null

    init {
        provinceItemModelList = `in`.createTypedArrayList(ProvinceItemModel.CREATOR)
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList(provinceItemModelList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        val CREATOR: Parcelable.Creator<ProvinceModel> = object : Parcelable.Creator<ProvinceModel> {
            override fun createFromParcel(`in`: Parcel): ProvinceModel {
                return ProvinceModel(`in`)
            }

            override fun newArray(size: Int): Array<ProvinceModel?> {
                return arrayOfNulls(size)
            }
        }
    }


}
