package tasks;

import common.Person;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Задача 3
Отсортировать коллекцию сначала по фамилии, по имени (при равной фамилии), и по дате создания (при равных фамилии и имени)
 */
public class Task3 {

  public static List<Person> sort(Collection<Person> persons) {
    List<Person> result = new ArrayList<>(persons);
    result.sort((Person o1, Person o2) -> {
      int res = o1.secondName().compareTo(o2.secondName());
      if (res == 0) {
        res = o1.firstName().compareTo(o2.firstName());
        if (res == 0) {
          res = o1.createdAt().compareTo(o2.createdAt());
        }
      }
      return res;
    });
    return result;
  }
}
