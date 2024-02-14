import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise06_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //ucitavamo broj od koga sve duzine imena treba da budu jednake ili krace
        List<String> names = Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toList()); //ucitavanje liste imena
        Predicate<String> checkName = x -> x.length() <= n; //definisanje predikata tj. provera da li je duzina datog stringa manja ili jednaka od n
        names.stream().filter(checkName).forEach(System.out::println); //filtriranje na osnovu predikata,
        // ako ispunjava uslov iz prediakta tj. ime je krace ili jednako od n javice se u rezultatu

        ///nez funkcionalnog kod je isto sto i
        ///  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //
        //        int n = Integer.parseInt(br.readLine());
        //        List<String> names = new ArrayList<>();
        //
        //        String[] nameArray = br.readLine().split("\\s+");
        //        for (String name : nameArray) {
        //            names.add(name);
        //        }
        //
        //        for (String name : names) {
        //            if (name.length() <= n) {
        //                System.out.println(name);
        //            }
        //        }
    }
}
