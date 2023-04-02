package com.parassapplication.app.modules.forgetpassword.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityForgetPasswordBinding
import com.parassapplication.app.modules.forgetpassword.`data`.viewmodel.ForgetPasswordVM
import com.parassapplication.app.modules.resetpassword.ui.ResetPasswordActivity
import kotlin.String
import kotlin.Unit

class ForgetPasswordActivity :
    BaseActivity<ActivityForgetPasswordBinding>(R.layout.activity_forget_password) {
  private val viewModel: ForgetPasswordVM by viewModels<ForgetPasswordVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.forgetPasswordVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnClickToGetOtpOne.setOnClickListener {
      val destIntent = ResetPasswordActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FORGET_PASSWORD_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ForgetPasswordActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
