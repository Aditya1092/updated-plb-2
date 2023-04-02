package com.parassapplication.app.modules.resetpassword.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityResetPasswordBinding
import com.parassapplication.app.modules.loginpage.ui.LoginPageActivity
import com.parassapplication.app.modules.resetpassword.`data`.viewmodel.ResetPasswordVM
import kotlin.String
import kotlin.Unit

class ResetPasswordActivity :
    BaseActivity<ActivityResetPasswordBinding>(R.layout.activity_reset_password) {
  private val viewModel: ResetPasswordVM by viewModels<ResetPasswordVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.resetPasswordVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnSubmit.setOnClickListener {
      val destIntent = LoginPageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "RESET_PASSWORD_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ResetPasswordActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
