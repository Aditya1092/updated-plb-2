package com.parassapplication.app.modules.about.ui

import androidx.activity.viewModels
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityAboutBinding
import com.parassapplication.app.modules.about.`data`.viewmodel.AboutVM
import kotlin.String
import kotlin.Unit

class AboutActivity : BaseActivity<ActivityAboutBinding>(R.layout.activity_about) {
  private val viewModel: AboutVM by viewModels<AboutVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.aboutVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ABOUT_ACTIVITY"

  }
}
