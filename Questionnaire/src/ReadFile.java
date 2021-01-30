import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("result.txt");
        FileReader fileReader2 = new FileReader("result.txt");
        BufferedReader bufferedReaderForAge = new BufferedReader(fileReader);
        BufferedReader bufferedReaderForCity = new BufferedReader(fileReader2);
        System.out.println(middleAge(bufferedReaderForAge));
        searchCity(bufferedReaderForCity, "Москва");
    }

    public static double middleAge(BufferedReader bufferedReader) throws Exception{
        int rolling = 0;
        int rollingTrue = 1;
        double sumAge = 0;
        int numberPeople = 0;
        while (bufferedReader.ready()) {
            if (rolling == rollingTrue) {
                sumAge += parseLineForAge(bufferedReader.readLine());
                rollingTrue += 3;
                numberPeople++;
            }
            bufferedReader.readLine();
            rolling++;
        }
        return sumAge/numberPeople;
    }

    public static void searchCity(BufferedReader bufferedReader, String city) throws Exception{
        int rolling = 0;
        int rollingName = 0;
        int rollingAge = 1;
        int rollingCity = 2;
        String name = "";
        String age = "";
        String newCity = "";
        while (bufferedReader.ready()) {
            if (rolling == rollingName) {
                name = bufferedReader.readLine();
                rollingName += 4;
            } else if (rolling == rollingAge) {
                age = bufferedReader.readLine();
                rollingAge += 4;
            } else if (rolling == rollingCity) {
                newCity = bufferedReader.readLine();
                if (parseLineForCity(newCity).equals(city)) {
                    System.out.println(name + "\n" + age + "\n" + newCity + "\n");
                }
                rollingCity += 4;
            } else {
                bufferedReader.readLine();  // Каждый раз, когда мы мишем эту строчку,
                                            // наш bufferedReader выводит текущую строку и переходит на новую
            }
            rolling++;
        }

    }

    public static int parseLineForAge(String line) {
        String[] list = line.split(" ");
        return Integer.parseInt(list[1]);
    }

    public static String parseLineForCity(String line) {
        String[] list = line.split(" ");
        return list[1];
    }
}