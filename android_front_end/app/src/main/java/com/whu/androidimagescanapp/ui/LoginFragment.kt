package com.whu.androidimagescanapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.whu.androidimagescanapp.R

class LoginFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "LOGIN_FRAGMENT"
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    private var loginButton:ImageView? = null
    private var backButton:ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false).let {
            loginButton = it.findViewById(R.id.login_login_button)
            backButton = it.findViewById(R.id.login_back_button)
            it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton?.let { it.setOnClickListener(this) }
        backButton?.let { it.setOnClickListener(this) }
    }

    override fun onClick(view: View?) {
        view ?: return
        when(view.id) {
            R.id.login_login_button -> {
                activity?.supportFragmentManager?.apply {
                    popBackStack()
                    beginTransaction()
                        .replace(R.id.main_activity_container, MainPageFragment.newInstance(), MainPageFragment.TAG)
                        .commitAllowingStateLoss()
                }
            }
            R.id.login_back_button -> {
                activity?.onBackPressed()
            }
        }
    }
}