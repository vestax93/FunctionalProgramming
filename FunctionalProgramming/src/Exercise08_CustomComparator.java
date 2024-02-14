import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise08_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray(); //ucitavanje brojeva u niz
        int[] evens = Arrays.stream(numbers).filter(x -> x % 2 == 0).boxed().sorted(Integer::compareTo)
                .mapToInt(Integer::intValue).toArray();
        //1. filtriramo niz brojeva tako da samo ostanu oni koji ispunjavaju uslov tj. koji su deljivi sa 2
        //2. stavljamo ih u Integer wrapper klasu i sortiramo pomocu komparatora (odredjuje nacin poredjenja elemenata medju sobom)
        //3. konvertujemo iz Integer u int i pretvaramo u niz
        int[] odds = Arrays.stream(numbers).filter(x -> x % 2 != 0).boxed().sorted(Integer::compareTo)
                .mapToInt(Integer::intValue).toArray();
        //1. filtriramo niz brojeva tako da samo ostanu oni koji ispunjavaju uslov tj. koji nisu deljivi sa 2
        //2. stavljamo ih u Integer wrapper klasu i sortiramo pomocu komparatora (odredjuje nacin poredjenja elemenata medju sobom)
        //3. konvertujemo iz Integer u int i pretvaramo u niz

        Arrays.stream(evens).forEach(x -> System.out.print(x + " ")); //stampamo prvo parne brojeve
        Arrays.stream(odds).forEach(x -> System.out.print(x + " ")); //stampamo neparne
/// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputNumbers = br.readLine().split("\\s+");
//
//        int[] numbers = new int[inputNumbers.length];
//        for (int i = 0; i < inputNumbers.length; i++) {
//            numbers[i] = Integer.parseInt(inputNumbers[i]);
//        }
//
//        int[] evens = new int[numbers.length];
//        int[] odds = new int[numbers.length];
//        int evenCount = 0;
//        int oddCount = 0;
//
//        for (int number : numbers) {
//            if (number % 2 == 0) {
//                evens[evenCount++] = number;
//            } else {
//                odds[oddCount++] = number;
//            }
//        }
//
//        // Sortiranje parnih brojeva
//        Arrays.sort(evens, 0, evenCount);
//        // Sortiranje neparnih brojeva
//        Arrays.sort(odds, 0, oddCount);
//
//        for (int i = 0; i < evenCount; i++) {
//            System.out.print(evens[i] + " ");
//        }
//
//        for (int i = 0; i < oddCount; i++) {
//            System.out.print(odds[i] + " ");
//        }
//    }
//}
    }
}
