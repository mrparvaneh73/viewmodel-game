package com.example.game_viewmodel

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment(R.layout.fragment_game), View.OnClickListener {
    private val gameViewModel: GameViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disablenext()
        tvqus.text = gameViewModel.firstquestion()
        btntrue.setOnClickListener(this)
        btnfalse.setOnClickListener(this)
        btncheat.setOnClickListener(this)

        btnnext.setOnClickListener {

            tvqus.text = gameViewModel.nextqustion()
            disablenext()
            disableprev()
            btnfalse.isEnabled = true
            btntrue.isEnabled = true

        }
        btnprev.setOnClickListener {

            tvqus.text = gameViewModel.prevquestion()
            disablenext()
            disableprev()
            btnfalse.isEnabled = true
            btntrue.isEnabled = true

        }

        btncheat.setOnClickListener {
            findNavController().navigate(
                GameFragmentDirections.actionGameFragmentToCheatFragment(
                    gameViewModel.questlist[gameViewModel.currentquestion].Question,
                    gameViewModel.questlist[gameViewModel.currentquestion].Answer
                )
            )
        }

    }


    fun disablenext() {
        if (gameViewModel.currentquestion == 0) btnprev.isEnabled = false else btnprev.isEnabled =
            true
    }

    fun disableprev() {
        if (gameViewModel.currentquestion == 9) btnnext.isEnabled = false else btnnext.isEnabled =
            true

    }


    override fun onClick(v: View?) {
        var correct = gameViewModel.correct()
        var cheating = gameViewModel.questlist[gameViewModel.currentquestion].Cheat
        if (cheating == false) {
            if (v!!.id == R.id.btntrue || v!!.id == R.id.btnfalse) {
                Toast.makeText(requireContext(), "cheating", Toast.LENGTH_SHORT).show()
            }
        } else if (cheating == true) {
            if (v!!.id == R.id.btntrue) {
                if (btntrue.tag.toString() == correct) {
                    Toast.makeText(requireContext(), "Correct", Toast.LENGTH_SHORT).show()
                    btnfalse.isEnabled = false
                    btntrue.isEnabled = false
                } else {
                    Toast.makeText(requireContext(), "Incorrect", Toast.LENGTH_SHORT).show()
                    btnfalse.isEnabled = false
                    btntrue.isEnabled = false
                }
            } else if (v!!.id == R.id.btnfalse) {
                if (btnfalse.tag.toString() == correct) {
                    Toast.makeText(requireContext(), "Correct", Toast.LENGTH_SHORT).show()
                    btnfalse.isEnabled = false
                    btntrue.isEnabled = false
                } else {
                    Toast.makeText(requireContext(), "Incorrect", Toast.LENGTH_SHORT).show()
                    btnfalse.isEnabled = false
                    btntrue.isEnabled = false
                }
            }
        }

    }

}





