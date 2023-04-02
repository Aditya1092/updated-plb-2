package com.parassapplication.app.modules.loginpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityLoginPageBinding
import com.parassapplication.app.modules.forgetpassword.ui.ForgetPasswordActivity
import com.parassapplication.app.modules.homepage.ui.HomePageActivity
import com.parassapplication.app.modules.loginpage.`data`.viewmodel.LoginPageVM
import com.parassapplication.app.modules.signup.ui.SignUpActivity
import kotlin.String
import kotlin.Unit

class LoginPageActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {
  private val viewModel: LoginPageVM by viewModels<LoginPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginPageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSignUp.setOnClickListener {
      val destIntent = SignUpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtForgetpassword.setOnClickListener {
      val destIntent = ForgetPasswordActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnLoginOne.setOnClickListener {
      val destIntent = HomePageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "LOGIN_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginPageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
