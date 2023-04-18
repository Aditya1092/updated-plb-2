package com.parassapplication.app.modules.camera.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore

import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.viewModels
import com.parassapplication.app.R
import com.parassapplication.app.appcomponents.base.BaseActivity
import com.parassapplication.app.databinding.ActivityCameraBinding
import com.parassapplication.app.modules.camera.`data`.viewmodel.CameraVM
import kotlin.String
import kotlin.Unit

class CameraActivity : BaseActivity<ActivityCameraBinding>(R.layout.activity_camera) {
  private val viewModel: CameraVM by viewModels<CameraVM>()
  private lateinit var videoView: VideoView
  private var ourRequestCode : Int = 123


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_camera)
    videoView = findViewById(R.id.videoView)

    val mediaCollection = MediaController(this)
    mediaCollection.setAnchorView(videoView)
    videoView.setMediaController(mediaCollection)


  }

  fun startVideo(view: View){
    val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
    if(intent.resolveActivity(packageManager) != null){
      startActivityForResult(intent, ourRequestCode)
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
     if (requestCode == ourRequestCode && resultCode == RESULT_OK){
       val videoUri = data?.data
       videoView.setVideoURI(videoUri)
       videoView.start()
     }
  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.cameraVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "CAMERA_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CameraActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
