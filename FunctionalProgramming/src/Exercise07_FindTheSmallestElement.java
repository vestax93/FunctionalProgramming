import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise07_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()); //ucitavanje brojeva u listu

        Function<List<Integer>, Integer> indexOfMinimum = listNumbers -> {
            int min = listNumbers.stream().min(Integer::compareTo).get(); //trazimo minimum u listi, prosledjujemo metodu preko koje ce se porediti brojevi medju sobom
            //get sluzi da konveruje iz Optional u int
            return listNumbers.lastIndexOf(min); //pronalazi poslednju poziciju tj indeks date vrednosti (min)
        };
        System.out.println(indexOfMinimum.apply(numbers));//stampanje minimima koji smo dobili iz funkcije kojoj smo prosledili listu brojeva
/// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = br.readLine().split("\\s+");
//        List<Integer> numbers = new ArrayList<>();
//        for (String numStr : input) {
//            int num = Integer.parseInt(numStr);
//            numbers.add(num);
//        }
//
//        Function<List<Integer>, Integer> indexOfMinimum = new Function<List<Integer>, Integer>() {
//            @Override
//            public Integer apply(List<Integer> listNumbers) {
//                int min = Integer.MAX_VALUE;
//                int minIndex = -1;
//                for (int i = 0; i < listNumbers.size(); i++) {
//                    int current = listNumbers.get(i);
//                    if (current < min) {
//                        min = current;
//                        minIndex = i;
//                    }
//                }
//                return minIndex;
//            }
//        };
//
//        System.out.println(indexOfMinimum.apply(numbers));
//    }
//}
//Ovaj kod ručno čita unos i izračunava indeks minimuma u listi brojeva bez korišćenja Stream API-ja.
//
//
//
//
//Is this conversation helpful so far?
    }
}
