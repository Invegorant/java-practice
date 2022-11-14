package tests.solid;

//https://www.baeldung.com/solid-principles#s
public class SingleResponsibilityPrinciple
{
    /***** A class should only have one responsibility and not be filled with excessive functionality *****/

    public class Book
    {

        private String name;
        private String author;
        private String text;

        //constructor, getters and setters

        // methods that directly relate to the book properties
        public String replaceWordInText(String word, String replacementWord){
            return text.replaceAll(word, replacementWord);
        }

        public boolean isWordInText(String word){
            return text.contains(word);
        }


        //This code violates the single responsibility principle we outlined earlier.
        //To fix it, we should implement a separate class that deals only with printing our texts. BookPrinter is below
        void printTextToConsole(){
            // our code for formatting and printing the text
        }
    }

    public class BookPrinter {

        // methods for outputting text
        void printTextToConsole(String text){
            //our code for formatting and printing the text
        }

        void printTextToAnotherMedium(String text){
            // code for writing to any other location..
        }
    }
}
