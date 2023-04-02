package com.parassapplication.app.modules.resetpassword.`data`.model

import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ResetPasswordModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterNewPassw: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_new_passw)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmNewPas: String? =
      MyApp.getInstance().resources.getString(R.string.msg_confirm_new_pas)

)
