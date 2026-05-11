package com.gramasuvidha.portal.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.grama.LogoutScreen
import com.example.grama.ui.theme.GRAMATheme
import com.gramasuvidha.portal.R

class LogoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GRAMATheme {
                    LogoutScreen(
                        onConfirmLogout = {
                            findNavController().navigate(R.id.action_global_loginFragment)
                        },
                        onCancel = {
                            findNavController().popBackStack()
                        }
                    )
                }
            }
        }
    }
}
