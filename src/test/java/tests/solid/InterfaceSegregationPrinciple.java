package tests.solid;

//https://www.baeldung.com/solid-principles#i
public class InterfaceSegregationPrinciple
{
    /*****  larger interfaces should be split into smaller ones.
     * By doing so, we can ensure that implementing classes only need to be concerned about the methods that are of interest to them *****/

    public interface BearKeeper
    {
        void washTheBear();
        void feedTheBear();
        void petTheBear();
    }

    public interface BearCleaner
    {
        void washTheBear();
    }

    public interface BearFeeder
    {
        void feedTheBear();
    }

    public interface BearPetter
    {
        void petTheBear();
    }

    // Now, thanks to interface segregation, we're free to implement only the methods that matter to us

    public class BearCarer implements BearCleaner, BearFeeder
    {

        public void washTheBear() {
            //I think we missed a spot...
        }

        public void feedTheBear() {
            //Tuna Tuesdays...
        }
    }

    public class CrazyPerson implements BearPetter
    {

        public void petTheBear() {
            //Good luck with that!
        }
    }
}
