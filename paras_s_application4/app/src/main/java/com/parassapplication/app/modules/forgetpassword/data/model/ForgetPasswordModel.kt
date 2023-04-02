package com.parassapplication.app.modules.forgetpassword.`data`.model

import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ForgetPasswordModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEntermobileno: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_mobile_no)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFifteenValue: String? = null
)
