package com.whu.androidimagescanapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.whu.androidimagescanapp.R


class OpeningFragment: Fragment(), View.OnClickListener {

    private var loginButton:ImageView? = null
    private var registerButton:ImageView? = null

    companion object {
        const val TAG = "OPENING_FRAGMENT"
        @JvmStatic
        fun newInstance() = OpeningFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_opening, container, false).let {
            loginButton = it.findViewById(R.id.opening_login_button)
            registerButton = it.findViewById(R.id.opening_register_button)
            it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton?.setOnClickListener(this)
        registerButton?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view ?: return
        when(view.id) {
            R.id.opening_register_button, R.id.opening_login_button -> {
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.main_activity_container, LoginFragment.newInstance(), LoginFragment.TAG)
                    ?.addToBackStack(LoginFragment.TAG)
                    ?.commit()
            }
        }
    }
}