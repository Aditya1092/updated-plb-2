package com.parassapplication.app.modules.signup.`data`.model

import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SignUpModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSignUp: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnteryourFull: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_your_full)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnteryourEmai: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_your_emai)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterpassword: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_enter_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmpasswor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_confirm_passwor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAbout: String? = MyApp.getInstance().resources.getString(R.string.lbl_about)

)
