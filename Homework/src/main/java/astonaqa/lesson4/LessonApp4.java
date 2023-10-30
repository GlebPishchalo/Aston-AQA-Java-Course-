package astonaqa.lesson4;

public class LessonApp4 {


    public static void main(String[] args) {

//Задание 1
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "engineer", "ivivan@mailbox.com", "89239493", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "electrik", "petrov@mailbox.com", "82323423", 15000, 35);
        persArray[2] = new Person("Sidrova Irina", "buhgalter", "sidorocva@mailbox.com", "83443493", 35831, 41);
        persArray[3] = new Person("Antonov Viktor", "ekolog", "antoniov@mailbox.com", "83535353", 24242, 24);
        persArray[4] = new Person("Shelest Ivan", "direktor", "direktor@mailbox.com", "83252353", 94545, 42);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                persArray[i].Info();
                System.out.println();
            }
        }
//Задание 2
        Park park = new Park();
        Park.Attractions attraction1 = park.new Attractions("Koleso obozreniya", 15, "s 10:00 do 12:00");
        attraction1.Info();

    }
}
