package com.parassapplication.app.modules.homepage.`data`.model

import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HomePageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_take_attendance)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDownloadAttend: String? =
      MyApp.getInstance().resources.getString(R.string.msg_download_attend)

)
