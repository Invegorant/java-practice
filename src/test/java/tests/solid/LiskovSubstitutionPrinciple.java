package tests.solid;

//https://www.baeldung.com/solid-principles#l
public class LiskovSubstitutionPrinciple
{
    /***** If class A is a subtype of class B,
     *  we should be able to replace B with A without disrupting the behavior of our program *****/

    public interface Car
    {

        void turnOnEngine();
        void accelerate();
    }

    public interface Engine
    {
        void on();
        void powerOn(int powerAmount);
    }

    // Let's implement our interface and provide some code for the methods
    public class MotorCar implements Car {

        private Engine engine;

        //Constructors, getters + setters

        public void turnOnEngine() {
            //turn on the engine!
            engine.on();
        }

        public void accelerate() {
            //move forward!
            engine.powerOn(1000);
        }
    }

    /* As our code describes, we have an engine that we can turn on, and we can increase the power.
       But wait — we are now living in the era of electric cars
     */

    public class ElectricCar implements Car
    {

        public void turnOnEngine() {
            throw new AssertionError("I don't have an engine!");
        }

        public void accelerate() {
            //this acceleration is crazy!
        }
    }

    /* By throwing a car without an engine into the mix, we are inherently changing the behavior of our program.
       This is a blatant violation of Liskov substitution and is a bit harder to fix than our previous two principles.
       One possible solution would be to rework our model into interfaces that take into account the engine-less state of our Car.
     */
}
