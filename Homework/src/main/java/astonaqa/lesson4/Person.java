package astonaqa.lesson4;

public class Person {
    String fio;
    String dolzhnost;
    String email;
    String phone_number;
    double zp;
    int age;

    public Person(String fio, String dolzhnost, String email, String phone_number, double zp, int age) {
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.email = email;
        this.phone_number = phone_number;
        this.zp = zp;
        this.age = age;
    }

    void Info() {
        System.out.println("Информация о сотруднике: ");
        System.out.println("ФИО- " + fio);
        System.out.println("Должность- " + dolzhnost);
        System.out.println("Емэйл- " + email);
        System.out.println("Номер телефона- " + phone_number);
        System.out.println("Заработная плата- " + zp);
        System.out.println("Возраст- " + age);
    }


}

