package STREAMAPI;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100 ; i++){
            numbers.add((int)(Math.random()*1000));
        }
        List<Integer> filtered = filter(numbers, (n) -> n > 0);
        for ( int i : filtered) {
            System.out.println(i);
        }

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

