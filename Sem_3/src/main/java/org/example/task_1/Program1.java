package org.example.task_1;

/*
* Создайте класс UserData с полями String name, int age, transient String password.
Поле password должно быть отмечено ключевым словом transient.
Реализуйте интерфейс Serializable в вашем классе
В методе маіп создайте экземпляр класса UserData и инициализируйте его данными.
I
Сериализуйте этот объект в файл, используя ObjectOutputStream в сочетании с FileOutputStream
<p>
Задача 2
<p>
Десериализуйте объект из ранее созданного файла обратно в объект Java,
используя ObjectInputStream в сочетании с FileInputStream.
Выведите данные десериализованного объекта UserData.
Сравните данные до сериализации и после десериализации, особенно обратите внимание на поле, помеченное как transient.
Обсудите, почему это поле не было сохранено после десериализации.
* */

import java.io.*;

public class Program1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData userData = new UserData("Seva", 18, "123456789Pq");

        FileOutputStream fileOutputStream = new FileOutputStream("name.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(userData);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("name.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();

    }
}