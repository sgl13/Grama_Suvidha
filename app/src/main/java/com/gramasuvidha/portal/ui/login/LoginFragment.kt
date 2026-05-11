package com.gramasuvidha.portal.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.grama.LoginScreen
import com.example.grama.ui.theme.GRAMATheme
import com.gramasuvidha.portal.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GRAMATheme {
                    LoginScreen(
                        onLoginSuccess = {
                            findNavController().navigate(R.id.action_loginFragment_to_projectListFragment)
                        },
                        onRegisterClick = {
                            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                        }
                    )
                }
            }
        }
    }
}
