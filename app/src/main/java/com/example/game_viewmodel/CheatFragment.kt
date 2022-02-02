package com.example.game_viewmodel

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_cheat.*

class CheatFragment:Fragment(R.layout.fragment_cheat), View.OnClickListener {
    private val gameViewModel: GameViewModel by activityViewModels()
var cheating=true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvcheatquestion.text=arguments?.getString("question")
        btnshowanswer.setOnClickListener(this)
        btnback.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.btnshowanswer){
            cheating=false
            tvanswer.text=arguments?.getString("answer")
            gameViewModel.questlist[gameViewModel.currentquestion].Cheat=cheating
        }
        if (v?.id==R.id.btnback){
            findNavController().navigate(CheatFragmentDirections.actionCheatFragmentToGameFragment(gameViewModel.questlist[gameViewModel.currentquestion].Cheat))
        }
    }
}