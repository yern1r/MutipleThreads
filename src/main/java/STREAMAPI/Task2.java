package STREAMAPI;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Jack", 27));
        users.add(new User("Grealish", 28));
        users.add(new User("Carvajal", 30));
        users.add(new User("Vinicius", 23));
        users.add(new User("Rodrygo", 22));
        users.add(new User("Benzema", 32));

        //-----types of creating stream with arrays-----//
        int[] array = {3, 4, 5, 6, 7};
       // Arrays.stream(array).filter()...
        // Stream.of(5,3,4,5,6,88);

        users.stream()
                //.sorted(((o1, o2) -> o1.getName().compareTo(o2.getName())))
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getAge() < 40)
                .limit(3)
                //by map, we can change type of element in stream
                .map(User::getName)
                .forEach(System.out::println);
       long count =  users.stream()

                .filter(user -> user.getAge() < 27)
               .count();
        System.out.println("less than 27 years old: " + count);

        boolean result = users.stream()
                .allMatch(user -> user.getAge() > 18);
                //.anyMatch
                //.noneMatch
        System.out.println("Is it all older than 18? : " + result);

        List<User> sorted = users.stream()
                //(Comparator.comparingInt(User::getAge)
                .sorted(((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())))
                .collect(Collectors.toList());
        System.out.println(sorted);

        Optional<User> oldest = users.stream()
                .filter(user -> user.getAge() < 25)
                .max((Comparator.comparingInt(User::getAge)));

        //Optional is container = can be not empty/empty
        //second thing will be executed if the container is empty
        oldest.ifPresentOrElse(System.out::println, () -> System.out.println("User mot found"));

        //if our container is not empty , so this ok
        //oldest.ifPresent(System.out::println);

        //if(oldest.isPresent()){
        //oldest.ifPresent(user -> System.out.println(oldest.get()));
        //}

         users.stream()
                .filter(user1 -> user1.getName().contains("l"))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("User not found"));

       //------parallelStream-------//
        //stream  divide into parts and work in one time
        //then all they will be collected - then it needs less time
        List<Float> numbers = new ArrayList<>();
        for (int i = 0; i < 30_000_000; i++) {
            numbers.add((float)i);
        }
        long before = System.currentTimeMillis();
        numbers.parallelStream()
                .map((number) -> Math.sin(0.2f + number / 5) * Math.cos(0.2f + number / 5) * Math.cos(0.4f + number / 2))
                .collect(Collectors.toList());
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
