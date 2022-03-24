package com.example.designpatternskotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternskotlin.adapter.AudioPlayer
import com.example.designpatternskotlin.adapter.MediaPlayer
import com.example.designpatternskotlin.adapter.SoundAdapter
import com.example.designpatternskotlin.builder.Shape
import com.example.designpatternskotlin.command.*
import com.example.designpatternskotlin.facade.FacadeMusicPlayer
import com.example.designpatternskotlin.observer.ElectricMotor
import com.example.designpatternskotlin.observer.Thermometer
import com.example.designpatternskotlin.prototype.ShapeCloneMaker
import com.example.designpatternskotlin.singleton.SingletonClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region Builder
        /*
            ex: We want to create a shape with these components:
            1-Area (Necessary)
            2-Environment (Necessary)
            3-Color (Optional)
            4-Name (Optional)
         */

        val shape:Shape = Shape.Builder()
            .perimeter(10f)
            .area(15f)
            .name("shape")
            .color(Color.BLACK)
            .build()
        shape.getLog()

        //endregion

        //region singleton
        SingletonClass.instance.getLog()
        //endregion

        //region adapter

        /*
            We have two media playback formats.
             We have a MediaClass and we want to do this with the help of two soundPlayer and moviePlayer interfaces.
         */

        val audioPlayer = AudioPlayer()
        val mediaPlayer1 = MediaPlayer(audioPlayer)
        mediaPlayer1.play("mp3","du hast")

        val soundAdapter = SoundAdapter()
        val mediaPlayer2 = MediaPlayer(soundAdapter)
        mediaPlayer2.play("vlc","grown up")
        //endregion

        //region facade
        /*
        ex: We have a music player that includes a music player, a display, and a speaker.
         The system is defined in such a way that when music is playing,
         information is displayed on the screen and played from the band,
         through the monitor we can control the music.
         We must also note that the music player and speaker only work when they are on,
         you also control this on the monitor
         */

        val facadeMusicPlayer = FacadeMusicPlayer()
        facadeMusicPlayer.turnOnSystem()
        facadeMusicPlayer.playMusic("Waka Waka - Shakira")

        //endregion

        //region command
        /*
            We have several sections in this pattern:
            1-Command: An interface that includes the definition of the main functions.
            2-ConcreteCommand: We build this class based on Command and implement the functions
             we had in Command according to this class.
            3-Invoker: The class that delivers the Command to the request.
            4-Receiver: Request that command

            ex: We write a program that can change the color of a class called Light
            to three lights red, blue and white according to Command.
         */

        val remoteControl = RemoteControl()
        val light = Light()

        remoteControl.pressButton(LightWhiteCommand(light))
        remoteControl.pressButton(LightRedCommand(light))
        remoteControl.pressButton(LightBlueCommand(light))
        remoteControl.undoButton()
        remoteControl.getStackLog()
        //endregion

        //region observer
        /*
            We have a thermometer, as soon as the temperature changes,
            if the temperature is above 80 degrees,
            turn off the engine and if it is below 80, turn on the engine.
         */

        val motor = ElectricMotor()
        val thermometer = Thermometer()

        thermometer.addPropertyChangeListener(motor)

        thermometer.temperature = 10
        thermometer.temperature = 50
        thermometer.temperature = 200

        thermometer.removePropertyChangeListener(motor)

        thermometer.temperature = 10
        thermometer.temperature = 50
        thermometer.temperature = 200
        //endregion

        //region prototype
        /*
            In Prototype, instead of creating an object from scratch,
             we create a clone of the object, that is, we copy the object to another object.
         */

        val cloneMaker = ShapeCloneMaker()
        val circle = cloneMaker.getShape("circle")

        //endregion
    }
}