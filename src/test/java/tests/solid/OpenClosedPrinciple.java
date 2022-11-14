package tests.solid;

//https://www.baeldung.com/solid-principles#o
public class OpenClosedPrinciple
{
    /***** Classes should be open for extension, closed for modification.
     *  In doing so, we stop ourselves from modifying existing code and causing potential new bugs *****/

    public class Guitar {

        private String make;
        private String model;
        private int volume;

        //Constructors, getters & setters
    }

    /* At this point, it might be tempting to just open up the Guitar class and add a flame pattern
    — but who knows what errors that might throw up in our application.
    Instead, let's stick to the open-closed principle and simply extend our Guitar class */

    public class SuperCoolGuitarWithFlames extends Guitar {

        private String flameColor;

        //constructor, getters + setters
    }
    // By extending the Guitar class, we can be sure that our existing application won't be affected.
}
