import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise09_ListOfPredicate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()); //ucitavamo niz integera

        Predicate<Integer> isDivisible = x -> { //definisemo predikat za proveru da li je zadati broj deljiv sa svim brojevaima iz niza
            for(Integer number : numbers){
                if(x % number != 0){
                    return  false; //cim nije deljiv sa barem jednim, vracamo false
                }
            }
            return true; //zavrsila se petlja, nije vratio false => broj je deljiv sa svim brojevima iz niza
        };
        for(int i = 1; i <= n; i++){ //idemo od 1 do n tj. zadatog broj
            if(isDivisible.test(i)){ //za svaki broj proveravamo da li je deljiv sa svim ostalima pozivanjem .test()
                System.out.print(i + " "); //ako prodje proveru stampamo ga
            }
        }
        ///   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //        int n = Integer.parseInt(br.readLine());
        //        String[] numberStrings = br.readLine().split("\\s+"); // Čitamo brojeve kao stringove
        //        List<Integer> numbers = new ArrayList<>();
        //
        //        for (String numStr : numberStrings) {
        //            numbers.add(Integer.parseInt(numStr)); // Konvertujemo stringove u brojeve i dodajemo u listu
        //        }
        //
        //        Predicate<Integer> isDivisible = x -> {
        //            for (Integer number : numbers) {
        //                if (x % number != 0) {
        //                    return false;
        //                }
        //            }
        //            return true;
        //        };
        //
        //        for (int i = 1; i <= n; i++) {
        //            if (isDivisible.test(i)) {
        //                System.out.print(i + " ");
        //            }
        //        }
        //    }
        //}
    }
}
