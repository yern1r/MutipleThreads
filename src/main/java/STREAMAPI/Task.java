package STREAMAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {

        // --- we are creating collections of numbers ---
        // -- then randomly adding numbers in this collection
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100 ; i++){
            numbers.add((int)(Math.random()*100 + 100));
        }
        List<String> list = numbers.stream()
                .filter((integer -> integer % 2 == 0 && integer % 5 == 0))
                //we are just using another method, we are not changing data type of parameter
                //name of class where is our method and the method what we will use
                .map((Math::sqrt))
                .map((sqrt) -> "Sqrt : " + sqrt)
                //.map((Task::mapToString))
                .collect(Collectors.toList());

        for (String result: list) {
            System.out.println(result);
        }
    }

    //private static String mapToString(double a){
      //  return "Sqrt : " + a;
    //}
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

