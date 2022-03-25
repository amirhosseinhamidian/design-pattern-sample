package com.example.designpatternskotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternskotlin.adapter.AudioPlayer
import com.example.designpatternskotlin.adapter.MediaPlayer
import com.example.designpatternskotlin.adapter.SoundAdapter
import com.example.designpatternskotlin.builder.Shape
import com.example.designpatternskotlin.command.*
import com.example.designpatternskotlin.composite.CEO
import com.example.designpatternskotlin.composite.CTO
import com.example.designpatternskotlin.composite.Developer
import com.example.designpatternskotlin.composite.Human
import com.example.designpatternskotlin.facade.FacadeMusicPlayer
import com.example.designpatternskotlin.interpreter.Add
import com.example.designpatternskotlin.interpreter.Context
import com.example.designpatternskotlin.interpreter.Sub
import com.example.designpatternskotlin.interpreter.Terminal
import com.example.designpatternskotlin.iterator.Collection
import com.example.designpatternskotlin.iterator.TreeCollection
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
//        remoteControl.getStackLog()
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

        //region composite
        /*
            In this pattern we have objects that have a member of their own gender
            or similar classes in them.In this template we have several sections:
            1-Component:An interface (or Abstract class) in which we define the main functions,
             the rest of the objects must be implemented.
            2-Leaf:To the objects at the last levels of our graph,
            these objects no longer have a member of themselves or similar classes.
            3-Composite:This is like Leaf, except that it accepts a kind of self as a member,
             that is, to have children in the graph.
             ex: The organization has a CEO, CTO and programmer, we make the organizational chart Composite
         */

        var ceo : Human = CEO("amirhossein")
        var cto : Human = CTO("mehdi")
        var developer1 : Human = Developer("ehsan")
        var developer2 : Human = Developer("hanieh")

        (ceo as CEO).addNode(cto)
        (cto as CTO).addNode(developer1)
        cto.addNode(developer2)

        ceo.showNodes()
        //endregion

        //region Interpreter
        /*
            1-Context:It contains all the information needed in our interpretation operations
             and, if necessary, the functions required for the expressions.
            2-Expression - TerminalExpression - NonTerminalExpression:
            An abstract class interface that defines a function called interpret,
            and the other classes derived from it must override it.

            ex:Suppose we have a sentence in the form "a * b",
             * can be + or - and a and b are integers, we create a model that
              gives us the result of the expression. (This example is very simple,
              otherwise if it was more than a few sentences,
              the Stack should have been used to solve the problem.)
         */

        val context : Context
        val a = Terminal("15")
        val b = Terminal("10")
        var sum = Add(a,b)
        var sub = Sub(a,b)

        Log.e(TAG,"Sub is :$sub \n Sum is :$sum")

        //endregion

        //region iterator
        /*
            This pattern allows you to have a specific code to "navigate your collection"
            1-Iterator - ConcreteIterator: We have Java / Kotlin Iterator in itself and do not need
            to re-implement it. In this interface we have two methods hasNext and next,
            the first to check if there is next and the second to navigate, we inherit from
            this interface and our ConcreteIterator We assume that we implement the algorithm for
            the above two functions.
            2-Collection - ConcreteCollection: In the Collection we have the list or array or
            structure we want, this Collection can generate an Iterator that can be used to navigate
            in the main code, we add and subtract operations on our collection here,
            ConcreteCollection It is definitely the implementation of Collection methods.

            ex: Suppose we have a binary tree and we want to print its items level by level
         */

        val array = arrayOf(0,0,0,0,0,0,0)
        val collection : Collection = TreeCollection(array)
        (collection as TreeCollection).addToTree(1)
        collection.addToTree(2)
        collection.addToTree(3)
        collection.addToTree(4)
        collection.addToTree(5)
        collection.addToTree(6)
        collection.addToTree(7)
        val iterator = collection.createIterator()
        while (iterator.hasNext()) {
            iterator.hasNext()
        }
        //endregion
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}