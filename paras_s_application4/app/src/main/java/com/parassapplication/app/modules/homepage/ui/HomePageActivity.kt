package com.parassapplication.app.modules.homepage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityHomePageBinding
import com.parassapplication.app.modules.camera.ui.CameraActivity
import com.parassapplication.app.modules.homepage.`data`.viewmodel.HomePageVM
import kotlin.String
import kotlin.Unit

class HomePageActivity : BaseActivity<ActivityHomePageBinding>(R.layout.activity_home_page) {
  private val viewModel: HomePageVM by viewModels<HomePageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homePageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtGroupNine.setOnClickListener {
      val destIntent = CameraActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "HOME_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomePageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
