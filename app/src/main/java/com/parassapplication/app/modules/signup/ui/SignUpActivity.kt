package com.parassapplication.app.modules.signup.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivitySignUpBinding
import com.parassapplication.app.modules.loginpage.ui.LoginPageActivity
import com.parassapplication.app.modules.signup.`data`.viewmodel.SignUpVM
import kotlin.String
import kotlin.Unit

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
  private val viewModel: SignUpVM by viewModels<SignUpVM>()
  override lateinit var binding: ActivitySignUpBinding
  private lateinit var firebaseAuth: FirebaseAuth

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUpVM = viewModel
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivitySignUpBinding.inflate(layoutInflater)
    setContentView(binding.root)
    firebaseAuth = FirebaseAuth.getInstance()
    binding.btnSignUpOne.setOnClickListener {
      val name = binding.txtEnteryourFull.text.toString()
      val email = binding.txtEnteryourEmai.text.toString()
      val password = binding.txtEnterpassword.text.toString()
      val confirmPassword = binding.txtConfirmpasswor.text.toString()
      if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
        if (password == confirmPassword) {
          firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
              val intent = Intent(this, LoginPageActivity::class.java)
              startActivity(intent)
            } else {
              Toast.makeText(this, "weak password", Toast.LENGTH_SHORT).show()

            }
          }
        } else {
          Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
        }
      }else {
        Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
      }
    }

  }

  override fun setUpClicks(): Unit {
    binding.btnSignUpOne.setOnClickListener {
      val destIntent = LoginPageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtllogin.setOnClickListener {
      val desIntent = LoginPageActivity.getIntent(this , null)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
