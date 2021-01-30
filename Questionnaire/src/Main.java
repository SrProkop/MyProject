import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        File file = new File("result.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true); //true - при повторном вызове мы не записываем заного, а дополняем файл
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите ваше имя: ");
        String name = reader.readLine();
        System.out.println("Введите ваш возраст: ");
        String age = reader.readLine();
        System.out.println("Введите ваш город проживания: ");
        String city = reader.readLine();

        fileWriter.write("Имя: " + name + "\n");
        fileWriter.write("Возраст: " + age + "\n");
        fileWriter.write("Город: " + city + "\n");
        fileWriter.append("\n");
        fileWriter.append("\n");
        fileWriter.close();
    }

}
