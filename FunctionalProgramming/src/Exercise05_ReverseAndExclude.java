import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise05_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed() //mapiramo niz strigova u integer i pomocu boxed ih pretvaramo u Integer wrapper klasu
                .collect(Collectors.toList()); //konvertujemo u listu
        int n = Integer.parseInt(br.readLine()); //ucitavamo broj za koji treba da proverimo da li su clanovi niza deljivi sa njim
        Predicate<Integer> isDivisible = x -> x % n == 0; //definisemo predikat tj. tvrdnju koja je istnita ili nije i to ce biti povratna vrednost
        numbers.removeIf(isDivisible); //pozivamo metodu iz klase List koja kao paramtera prima Predicate i uklanja one clanove liste koji ispunjavaju uslov
        Collections.reverse(numbers); //obrtanje redolseda liste
        System.out.println(Arrays.toString(numbers.toArray()) //pretvaramo listu u niz i pozivano to String tj. stampanje liste uz pomoc predefisanih metoda iz Arrays (toString) i toArray za List -> Array
                .replace("[","").replace("]","").replace(",","")); //sklanjamo viskove koji su dosli sa toStrin ([,] i ,) da bi nam se poklopio format outputa za Judge


    }
}
