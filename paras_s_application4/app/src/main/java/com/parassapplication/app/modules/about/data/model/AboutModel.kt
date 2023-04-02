package com.parassapplication.app.modules.about.`data`.model

import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AboutModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtABOUT: String? = MyApp.getInstance().resources.getString(R.string.lbl_about2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_team_members)

)
