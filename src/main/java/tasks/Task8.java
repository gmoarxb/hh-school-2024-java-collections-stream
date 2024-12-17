package tasks;

import common.Person;
import common.PersonService;
import common.PersonWithResumes;
import common.Resume;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
  Еще один вариант задачи обогащения
  На вход имеем коллекцию персон
  Сервис умеет по personId искать их резюме (у каждой персоны может быть несколько резюме)
  На выходе хотим получить объекты с персоной и ее списком резюме
 */
public class Task8 {
  private final PersonService personService;

  public Task8(PersonService personService) {
    this.personService = personService;
  }

  public Set<PersonWithResumes> enrichPersonsWithResumes(Collection<Person> persons) {
    Set<Integer> personIds = new HashSet<>();
    for (Person person : persons) {
      personIds.add(person.id());
    }
    Set<Resume> resumes = personService.findResumes(personIds);

    Set<PersonWithResumes> result = new HashSet<>();
    for (Person person : persons) {
      Set<Resume> personResumes = new HashSet<>();
      for (Resume resume : resumes) {
        if (resume.personId() == person.id()) {
          personResumes.add(resume);
        }
      }
      result.add(new PersonWithResumes(person, personResumes));
    }
    return result;
  }
}
