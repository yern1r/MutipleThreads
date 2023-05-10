package STREAMAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Director director = new Director();
        /* this code and code below are same
        Worker worker = (*int* n) -> {
            for (int i = 0 ; i < n; i++){
                System.out.println("I am working , boss");
            }
            return "Success";
        };
        String result = director.force(worker , 5);
      */
       /* String result = director.force((int n) -> {
            for(int i = 0; i < n; i++){
                System.out.println("I am working boss!");
            }
            return "Success";
        },5);
        System.out.println(result);
    */
        // --- we are creating collections of numbers ---
        // -- then randomly adding numbers in this collection
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100 ; i++){
            numbers.add((int)(Math.random()*1000));
        }

        // filter by hands:
        // --- then we add filter , after we put this values into another collection
        // -- filter : n > 0
        // List<Integer> filtered = filter(numbers, (n) -> n > 0);
        // --- there is also filter map which change type into string ,also saving this into new collection
        // List<String> mapped = map(filtered);
        //for ( String i : mapped) {
        //            System.out.println(i);
        //        }

        List<String> list = numbers.stream()
                //--- operators with streams in the middle of process
                //-- they do something with streams and return
                .filter( (n) -> n % 2 == 0)
                .map((integer -> "Number : " + integer))
                .filter((string) -> string.endsWith("0"))
                .map((string) -> string + "!")
                //--- operators with streams in the ending of process
                //-- end stream work, also started work)
                //-0nly one terminal operator
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);
        }
    }
    private static List<String> map(List<Integer> numbers){
        List<String> result = new ArrayList<>();
        for (int number : numbers){
            result.add("Number: " + number);
        }
        return result;
    }
    private static List <Integer> filter(List<Integer> list, Predicate predicate){
        List<Integer> result = new ArrayList<>();
        for (int i : list) {
            if (predicate.test(i)){
                result.add(i);
            }
        }
        return  result;
    }
}

