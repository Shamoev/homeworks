package edu.sourceit.homeworks.homework8.duplicates;

import java.util.*;

import static java.util.Arrays.asList;

public class RemoveDuplicatesFromListWithIterator {
    public static void main(String[] args) {
        List<User> users = asList(new User("John"), new User("Sara"),
                new User("Mike"), new User("David"), new User("Sara"),
                new User("Mike"), new User("David"), new User("Sara"));

        users = new ArrayList<>(users);
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User currentUser = iterator.next();
            int count = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).equals(currentUser)) {
                    count++;
                }
            }
            if (count > 1) {
                iterator.remove();
            }
        }

        System.out.println(Arrays.asList(users));
    }

}
