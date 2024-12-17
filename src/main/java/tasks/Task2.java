package tasks;

import common.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Задача 2
На вход принимаются две коллекции объектов Person и величина limit
Необходимо объеденить обе коллекции
отсортировать персоны по дате создания и выдать первые limit штук.
 */
public class Task2 {

  public static List<Person> combineAndSortWithLimit(Collection<Person> persons1,
                                                     Collection<Person> persons2,
                                                     int limit) {
    List<Person> merged = new ArrayList<>();
    merged.addAll(persons1);
    merged.addAll(persons2);
    merged.sort((Person o1, Person o2) -> o1.createdAt().compareTo(o2.createdAt()));
    if (merged.size() < limit) {
      return merged;
    }
    return merged.subList(0, limit);
  }
}
