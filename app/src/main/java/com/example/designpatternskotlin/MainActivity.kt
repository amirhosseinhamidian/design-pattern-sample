package com.example.designpatternskotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.designpatternskotlin.adapter.AudioPlayer
import com.example.designpatternskotlin.adapter.MediaPlayer
import com.example.designpatternskotlin.adapter.SoundAdapter
import com.example.designpatternskotlin.builder.Shape
import com.example.designpatternskotlin.chainofresponsibility.*
import com.example.designpatternskotlin.command.*
import com.example.designpatternskotlin.composite.CEO
import com.example.designpatternskotlin.composite.CTO
import com.example.designpatternskotlin.composite.Developer
import com.example.designpatternskotlin.composite.Human
import com.example.designpatternskotlin.decorate.BigOrange
import com.example.designpatternskotlin.decorate.BloodyOrange
import com.example.designpatternskotlin.decorate.Orange
import com.example.designpatternskotlin.decorate.ThompsonOrange
import com.example.designpatternskotlin.facade.FacadeMusicPlayer
import com.example.designpatternskotlin.flyweight.Computer
import com.example.designpatternskotlin.flyweight.OsShareVars.getOs
import com.example.designpatternskotlin.flyweight.OsType
import com.example.designpatternskotlin.interpreter.Add
import com.example.designpatternskotlin.interpreter.Context
import com.example.designpatternskotlin.interpreter.Sub
import com.example.designpatternskotlin.interpreter.Terminal
import com.example.designpatternskotlin.iterator.Collection
import com.example.designpatternskotlin.iterator.TreeCollection
import com.example.designpatternskotlin.mediator.Cpu
import com.example.designpatternskotlin.mediator.HardwareMediator
import com.example.designpatternskotlin.mediator.Ram
import com.example.designpatternskotlin.memento.CareTaker
import com.example.designpatternskotlin.memento.ClipBoard
import com.example.designpatternskotlin.objectpool.ComputerObjectPool
import com.example.designpatternskotlin.observer.ElectricMotor
import com.example.designpatternskotlin.observer.Thermometer
import com.example.designpatternskotlin.prototype.ShapeCloneMaker
import com.example.designpatternskotlin.singleton.SingletonClass
import com.example.designpatternskotlin.strategy.ContextStrategy
import com.example.designpatternskotlin.strategy.RemoveZerosStrategy
import com.example.designpatternskotlin.strategy.SortAscendStrategy
import com.example.designpatternskotlin.strategy.SortDescendStrategy
import com.example.designpatternskotlin.template.House
import com.example.designpatternskotlin.template.Type1House

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        strategy()
    }

    fun builder() {
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
    }

    fun singleton() {
        //region singleton
        SingletonClass.instance.getLog()
        //endregion
    }

    fun adapter() {
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
    }

    fun facade() {
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
    }

    fun command() {
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
    }

    fun observer() {
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
    }

    fun prototype() {
        //region prototype
        /*
            In Prototype, instead of creating an object from scratch,
             we create a clone of the object, that is, we copy the object to another object.
         */

        val cloneMaker = ShapeCloneMaker()
        val circle = cloneMaker.getShape("circle")

        //endregion
    }

    fun composite() {
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
    }

    fun interpreter() {
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
    }

    fun iterator() {
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

    fun mediator() {
        //region mediator
        /*
            If the connections are complex and large, we will have problems later due to changes or ...,
            then we need an intermediary that is located between two objects.
         */

        val mediator = HardwareMediator()
        val cpu = Cpu(mediator)
        val ram = Ram(mediator)
        cpu.sendMessage("hi ram",ram)
        ram.sendMessage("sallam",cpu)
        //endregion
    }

    fun objectPool() {
        //region object pool
        /*
            In Object Pool, we store a set of objects that cost a lot to build, and whenever
            we need them, we borrow an object from the Pool, and when we're done, we return
            that object to the Pool.

            First we create an Abstract class called ObjectPool, we have to implement
            some methods in this class and just define some methods:
            1-create: This method is simply defined and implemented in the ObjectPool
            derived class, whose job is to create a new object for ObjectPool.

            2-validate: It is simply defined and its output is Boolean, which takes an object
            as an input, in the implementation in the child class, whether the object is valid or not.

            3-expire: In ObjectPool each object has a timeout, it must expire if the object expires,
            this function is simply defined and implemented in the child class

            4-checkOut: This function is implemented in the ObjectPool class itself and returns
            the output of the object. The function of this function is to remove an object
            from the list called unLocked and add it to the list called lock and return it.
            In the meantime, it should check if the date Expire an object if it expires or
            is not valid (in which case it creates an object and returns it), this is the
            Synchronized function.

            5-checkIn: This function is implemented in the ObjectPool itself and its task
            is to take an object as input and vice versa checkOut, that is, to transfer from locked
            to unLocked, in the meantime it also updates the time of the object, this function is
             also Synchronized.

            Note: It is better to make the instance that you get from the Object Pool as a Singleton
         */

        val objectPool = ComputerObjectPool()
        objectPool.create()
        objectPool.create()
        objectPool.create()

        val mohammadComputer = objectPool.checkOut()
        val aliComputer = objectPool.checkOut()

        objectPool.checkIn(mohammadComputer)

        Log.e("objectPool","${objectPool.locked}"+"   "+ "${objectPool.unLocked}")
        //endregion
    }

    fun decorate() {
        //region decorate
        /*
            We have a Component in Decorator which is an interface or abstract class from which
             the rest of our classes are to be derived. For example, suppose the "fruit" class
             is the class we are considering, now ConcreteComponent becomes a class like "orange".
             Decorator is an abstract class that is derived from Component and also has a Component
             inside it (a variable of the Component genus is a member of it), ConcreteDecorator
             is also a class that is derived from Decorator, using Decorator we can see new properties.
             Add the Component class
         */

        val orange = BigOrange(ThompsonOrange(BloodyOrange(Orange())))
         Log.e("decorate",orange.getName())
        //endregion
    }

    fun memento() {
        //region memento
        /*
            In this pattern, we go back to the past and the previous states of the object.
            The benefit of using this pattern in operations such as undo or creating a log of
            application records on the object or ... is.

            1-Originator: It is an object that we intend to apply Memento to the method and we
            can recover it later

            2-Memento: A class containing the information to be retrieved

            3-Caretaker: The class that commands the retrieval operation

            ex:There are different texts in the phone clipboard, we write a code with Memento that
            can access all these texts and can delete the last text.

            Note: One of the best template combinations is the Memento and Command combination,
            we have operations in Command like undo and redo that can be better implemented with Memento
         */

        val clipBoard = ClipBoard()
        val careTaker = CareTaker()

        careTaker.add(clipBoard.copy("Ali"))
        careTaker.add(clipBoard.copy("Hasan"))
        careTaker.add(clipBoard.copy("Behnam"))


        careTaker.get(1)?.let {
            Log.e("Memento",it.data)
        }
        careTaker.undo()
        //endregion
    }

    fun chainOfResponsibility() {
        //region chain of responsibility
        /*
            A task is given to the chain and it is moved between the members of the chain until
            it reaches the right member of the chain that it can do it.

            The handler is the main clause of the class (interface or abstract) that has a member of
             its own type (for example, a Linked List) that forms the chain, the ConcreteHandler
             classes are handler implementations. The code of the Client section sends the request
             to the Handler to be processed.

             ex: Suppose we have an object called Job, Job can be necessary or unnecessary,
             it can be fast or slow, and it can be easy or hard, we have three levels of power in
             an organization: professional, intermediate and novice. The professional force has
             to do the necessary and slow and hard work, the average force can do all the work and
             the novice force has only to do the unnecessary, fast and easy tasks, our modeling
             is such that the forces are the Handler, the chain We have the forces and we give them
             a task, this task rotates between the forces until it is connected to the right person
             , when this happens, that force must change the status to the working position
             so that it does not get a new job.
         */

        val chain = Chain(SeniorLevel(SeniorLevel(MidLevel(SeniorLevel(JuniorLevel(null))))))
        val job1 = Job("folan 1",true,true,true)
        val job2 = Job("folan 2",false,true,true)
        val job3 = Job("folan 3",true,false,true)
        val job4 = Job("folan 4",true,true,false)
        val job5 = Job("folan 5",false,false,false)
        val job6 = Job("folan 6",true,false,false)
        chain.handler.handle(job1)
        chain.handler.handle(job2)
        chain.handler.handle(job3)
        chain.handler.handle(job4)
        chain.handler.handle(job5)
        chain.handler.handle(job6)
        chain.handler.handle(job1)
        //endregion
    }

    fun template() {
        //region template
        /*
            Definition of a body in the Abstract class mode in which there is a hierarchy of
            functions (step) in which the order is important, classes inheriting from this class
            have the right to override the steps, but should not be a function of this hierarchy
            Manipulate the chin.

            ex: Suppose you want to create the House class, to build the house we have these steps
            in order: beam + wall + door and window, now you can build the door and window before
            the beam, but to put them together you must wait the last step Connect them, the function
            that calls these steps back and forth is called modifying the template method and
            should not be overridden (it is final in Java and not open in Kathleen), this method is
            implemented in the House class itself but the rest of the methods are like the wall method
            (makeWalls) should be implemented in child classes, in fact we created a general template
            for home building that all types of homes inherit.
         */

        val houseType1 : House = Type1House()
        houseType1.buildHouse()
        //endregion
    }

    fun strategy() {
        //region strategy
            /*
                The architecture of this template is such that a class called Context has a Strategy
                in it and changes the Strategy according to the conditions. The Strategy is an interface
                or abstract class from which we inherit several classes.
             */

        val list : MutableList<Int> = ArrayList()
        list.add(1)
        list.add(4)
        list.add(0)
        list.add(9)

        var context = ContextStrategy(SortAscendStrategy(),list)
        val list1 = context.doStrategy()
        Log.e("SortAscendStrategy",list1.toString())

        context = ContextStrategy(SortDescendStrategy(),list)
        val list2 = context.doStrategy()
        Log.e("SortDescendStrategy",list2.toString())

        context = ContextStrategy(RemoveZerosStrategy(),list)
        val list3 = context.doStrategy()
        Log.e("RemoveZerosStrategy",list3.toString())
        //endregion
    }

    fun flyWeight(){
        //region fly weight
        /*
            An object in Flyweight has two types of elements, intrinsic and extrinsic, the inherent
            variables are for the same group of objects, for example, suppose we have a computer class,
            this class has an operating system variable that is either Linux or Windows Or it has a Mac
            and a variable for Ram, which can be any number, we consider the operating system as
            an inherent variable and Ram as an external.

            ex:Suppose we need 2,000 computers, so we need 2,000 space for Windows and 2,000 space
            for Ram to store their value, but we do not want to waste memory like that, so we share
            that variable inherently. We distribute computers so that class 3 can be used for it.
         */

        val listOfComputers : MutableList<Computer> = ArrayList<Computer>()
        for (ram in 1024..2048){
            listOfComputers.add(Computer(getOs(OsType.WIN),ram))
            listOfComputers.add(Computer(getOs(OsType.LIN),ram))
            listOfComputers.add(Computer(getOs(OsType.MAC),ram))
        }
        //endregion
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}