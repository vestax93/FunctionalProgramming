import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Exercise01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<String> names = Arrays.asList(sc.nextLine().split("\\s+")); //ucitana imena u listu stringova
        Consumer<String> extractName = n -> System.out.println(n); // Consumer dobija input parametar, ne[to radi sa njim, ali nikad ne vraca povratnu vrednost
        //na osnovu String parametra n on ce odstampati na ekranu svako n u novom redu

        for(String name : names){
            extractName.accept(name); //accept sluzi za prosledjivanje paramtera Consumer-u i onda consumer radi ono sto je definisano
            // sa desne strane strelice
        }
    }
}
