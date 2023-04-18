package com.parassapplication.app.modules.loginpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityLoginPageBinding
import com.parassapplication.app.databinding.ActivitySignUpBinding
import com.parassapplication.app.modules.forgetpassword.ui.ForgetPasswordActivity
import com.parassapplication.app.modules.homepage.ui.HomePageActivity
import com.parassapplication.app.modules.loginpage.data.viewmodel.LoginPageVM
import com.parassapplication.app.modules.signup.ui.SignUpActivity




class LoginPageActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {
  private val viewModel: LoginPageVM by viewModels<LoginPageVM>()
    override lateinit var binding: ActivityLoginPageBinding
  private lateinit var firebaseAuth: FirebaseAuth
    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      setContentView(binding.root)
      binding.txtSignUp.setOnClickListener {
        startActivity(Intent(this, SignUpActivity::class.java))
      }

      firebaseAuth = FirebaseAuth.getInstance()


    binding.btnLoginOne.setOnClickListener {
      val email = binding.etGroupTwelve.text.toString()
      val password = binding.txtEnterpassword.text.toString()
      firebaseAuth.signInWithEmailAndPassword(email.toString(), password.toString())
        .addOnCompleteListener(this) { task ->
          if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "signInWithEmail:success")

            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)


          } else {
            // If sign in fails, display a message to the user.
            Log.w(TAG, "signInWithEmail:failure", task.exception)
            Toast.makeText(
              baseContext, "Authentication failed.",
              Toast.LENGTH_SHORT
            ).show()

          }
        }


    }




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

