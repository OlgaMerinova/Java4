import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.w3c.dom.Text;

// 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
// 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
// 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
// 4.Отсортировать по возрасту используя дополнительный список индексов.




public class main {
    
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        // FileWriter writer = new FileWriter("description.sql"); // 1.Сохранить в файл строку 
        // writer.append("Hello!");
        // writer.flush();

        // String str = " ";
        String str1 = "";
        

        // FileReader reader = new FileReader("description.sql");
        // while(reader.ready()) {
        //     str += (char)reader.read();

        // }
        // reader.close();

        FileReader reader1 = new FileReader("people.sql");
        while(reader1.ready()) {
            str1 += (char) reader1.read();
        }
        reader1.close();

        String [] str2 = str1.split("\r\n");

        // for (int i=0; i<str2.length; i++) {
        //     String [] people = str2[i].split(" ");

        //     System.out.println(people[0] + " " + people[1].charAt(0) + "." + " " + people[2].charAt(0) + "." + " " + people[3] + " " + people[4]); // 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
        // }

        // System.out.println(str); загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader

        ArrayList<String>family = new ArrayList<>();
        ArrayList<String>name = new ArrayList<>();
        ArrayList<String>soname = new ArrayList<>();
        ArrayList<Integer>age = new ArrayList<>();
        ArrayList<Boolean>gender = new ArrayList<>();
        LinkedList<Integer>index = new LinkedList<>();
        

        for (int i=0; i<str2.length; i++) {
            String [] people1 = str2[i].split(" ");
            family.add(people1[0] + " ");
            name.add(people1[1].charAt(0)+ "." + " ");
            soname.add(people1[2].charAt(0)+ "." + " ");
            age.add(Integer.valueOf(people1[3]));
            gender.add(people1[4].equals("М") ? true: false);
            index.add(i);
        }
        for (int i=0; i<index.size(); i++) {
            System.out.printf(family.get(index.get(i)));
            System.out.printf(name.get(index.get(i)));
            System.out.printf(soname.get(index.get(i)));
            System.out.printf(age.get(index.get(i)).toString() + " ");
            System.out.printf(gender.get(index.get(i)) ? "М" : "Ж" + "," + " ");
            System.out.println();
        } //3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.

    
        ArrayList<Integer> tmp = new ArrayList<>(age);
        Collections.sort(tmp);

        for (int i = 0; i<tmp.size(); i++) {
            int j = age.indexOf(tmp.get(i));
            index.set(i, j);
        }

        for (int i=0; i<index.size(); i++) {
            System.out.println(family.get(index.get(i)) + name.get(index.get(i)) + soname.get(index.get(i)) + age.get(index.get(i)) + (gender.get(index.get(i)) ? "М" : "Ж") + " " );
            System.out.println();
        }












    }


}

