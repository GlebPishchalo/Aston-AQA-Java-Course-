package astonaqa.lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Universitet {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Dmitrii", 17, Gender.MAN),
                new Student("Maxim", 20, Gender.MAN),
                new Student("Ekaterina", 20, Gender.WOMAN),
                new Student("Michail", 28, Gender.MAN)
        );


        double avgAge = calcAvgAge(students);
        System.out.println("Average age of male: " + Math.round(avgAge*100)/100.0);
        List<Student> potentialConscripts = checkWhoGoArmy(students);
        System.out.println("Students who go army: " + potentialConscripts);

    }

    private static double calcAvgAge(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }


    private static List<Student> checkWhoGoArmy(List<Student> students) {
        return students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27 && student.getGender() == Gender.MAN)
                .collect(Collectors.toList());
    }


    static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}

    enum Gender {
        MAN, WOMAN
    }
