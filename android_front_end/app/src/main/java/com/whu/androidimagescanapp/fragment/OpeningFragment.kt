package com.whu.androidimagescanapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.whu.androidimagescanapp.R


class OpeningFragment: Fragment(), View.OnClickListener {

    private var openingBackground:ImageView? = null
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
            openingBackground = it.findViewById(R.id.opening_background)
            loginButton = it.findViewById(R.id.opening_login_button)
            registerButton = it.findViewById(R.id.opening_register_button)
            it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openingBackground?.setOnClickListener(this)
        loginButton?.setOnClickListener(this)
        registerButton?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view ?: return
        when(view.id) {
            R.id.opening_background -> {
                Toast.makeText(view.context,view.context.getString(R.string.have_not_implement),Toast.LENGTH_SHORT).show()
            }
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