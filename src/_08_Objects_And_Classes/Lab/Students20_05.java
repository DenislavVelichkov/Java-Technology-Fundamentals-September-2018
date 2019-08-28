package _08_Objects_And_Classes.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students20_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Student20> student20List = new ArrayList<>();
        String cmd = sc.nextLine();

        while (!cmd.equals("end")) {
            String[] tokens = cmd.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String city = tokens[3];

            /*if (isStudentExist(student20List, firstName, lastName)) {
                Student20 student = getStudent(student20List, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHomeTown(city);
            } else {
                Student20 student20 = new Student20(firstName, lastName, age, city);
                student20List.add(student20);
            }*/

            Student20 student = student20List.stream().filter(s -> s.getFirstName().equals(firstName)
                    && s.getLastName().equals(lastName))
                    .findFirst()
                    .orElse(null);

            if (student == null) {
                Student20 studentToAdd = new Student20(firstName, lastName, age, city);
                studentToAdd.setFirstName(firstName);
                studentToAdd.setLastName(lastName);
                studentToAdd.setAge(age);
                studentToAdd.setHomeTown(city);
                student20List.add(studentToAdd);
            } else {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHomeTown(city);
            }

            cmd = sc.nextLine();
        }

        String filterCity = sc.nextLine();

        for (Student20 student20 : student20List) {
            if (student20.getHomeTown().equals(filterCity)) {
                System.out.printf("%s %s is %d years old%n", student20.getFirstName(), student20.getLastName()
                        , student20.getAge(), student20.getHomeTown());
            }
        }
    }

    private static Student20 getStudent(List<Student20> student20List, String firstName, String lastName) {
        Student20 existingStudent = null;

        for (Student20 student20 : student20List) {
            if (student20.getFirstName().equals(firstName) && student20.getLastName().equals(lastName)) {
                existingStudent = student20;
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExist(List<Student20> students, String firstName, String lastName) {
        for (Student20 student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}

class Student20 {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Student20(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }
}