package STREAMAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Jack", 27));
        users.add(new User("Grealish", 28));
        users.add(new User("Carvajal", 30));
        users.add(new User("Vinicius", 23));
        users.add(new User("Rodrygo", 22));
        users.add(new User("Benzema", 32));

        users.stream()
                //.sorted(((o1, o2) -> o1.getName().compareTo(o2.getName())))
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getAge() < 40)
                .limit(3)
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
                .sorted(((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())))
                .collect(Collectors.toList());
        System.out.println(sorted);
    }
}
