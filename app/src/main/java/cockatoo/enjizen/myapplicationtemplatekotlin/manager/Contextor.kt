package com.yuphasuk.wanchalerm.householdincome.manager

import android.content.Context

/**
 * Created by Wanchalerm Yuphasuk on 4/1/2018 AD.
 */
class Contextor private constructor() {

    var context: Context? = null
        private set

    fun init(context: Context) {
        this.context = context
    }

    companion object {

        private var instance: Contextor? = null

        internal fun getInstance(): Contextor {
            if (instance == null)
                instance = Contextor()
            return instance as Contextor
        }
    }

}
