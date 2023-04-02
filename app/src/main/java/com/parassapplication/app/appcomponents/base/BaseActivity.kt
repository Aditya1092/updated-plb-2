package com.parassapplication.app.appcomponents.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.parassapplication.app.R
import com.parassapplication.app.databinding.ActivityHomePageBinding
import com.parassapplication.app.databinding.ActivityLoginPageBinding
import com.parassapplication.app.databinding.ActivitySignUpBinding
import com.parassapplication.app.modules.loginpage.data.viewmodel.LoginPageVM

/**
 * Base class for activities that using databind feature to bind the view
 * also Implements [BaseControllerFunctionsImpl] interface
 * @param T A class that extends [ViewDataBinding] that will be used by the activity layout binding view.
 * @param layoutId the resource layout view going to bind with the [binding] variable
 */
abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    AppCompatActivity(), BaseControllerFunctionsImpl {

    /**
     * activity layout view binding object
     */

    open lateinit var binding: T


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)




        binding = DataBindingUtil.setContentView(this@BaseActivity, layoutId) as T

        binding.lifecycleOwner = this
        addObservers()
        setUpClicks()
        onInitialized()
    }

    open fun onCreateView(view: View, savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }


}