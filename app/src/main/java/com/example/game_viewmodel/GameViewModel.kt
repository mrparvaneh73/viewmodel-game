package com.example.game_viewmodel
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {
    var currentquestion=0
fun question():ArrayList<Data>{
    val questiones:ArrayList<Data> = arrayListOf (
     Data(1,"tehran is capital of iran","TRUE",true),
     Data(2,"paris is capital of turky","FALSE",true),
     Data(3,"Is China the largest country in the world.","FALSE",true),
     Data(4,"5+9 = 14","TRUE",true),
      Data(5,"Australia is both a country and a continent","TRUE",true),
     Data(6,"Humans have 4 senses","FALSE",true),
      Data(7,"you need oxygen for breathing","TRUE",true),
      Data(8," The national flag of America has stars and stripes on it.","TRUE",true),
    Data(9,"Baby panda is bigger than a mouse after being born","FALSE",true),
    Data(10,"The smallest particle of an element is the molecule","FALSE",true)
    )

    return questiones
}
    val questlist=question()
    fun firstquestion():String?{
        return question()[currentquestion].Question
    }
   fun nextqustion(): String? {

       if(currentquestion==9) currentquestion=0 else currentquestion++
       return questlist[currentquestion].Question

    }
    fun prevquestion(): String? {
        if(currentquestion==0) currentquestion=9 else currentquestion--
        return questlist[currentquestion].Question
    }
    fun correct():String?{
       return questlist[currentquestion].Answer
    }
    fun currently():Int{
       return currentquestion++
    }

}