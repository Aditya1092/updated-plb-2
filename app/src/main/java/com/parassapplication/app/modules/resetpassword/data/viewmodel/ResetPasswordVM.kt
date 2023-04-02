package com.parassapplication.app.modules.resetpassword.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.parassapplication.app.modules.resetpassword.`data`.model.ResetPasswordModel
import org.koin.core.KoinComponent

class ResetPasswordVM : ViewModel(), KoinComponent {
  val resetPasswordModel: MutableLiveData<ResetPasswordModel> =
      MutableLiveData(ResetPasswordModel())

  var navArguments: Bundle? = null
}
