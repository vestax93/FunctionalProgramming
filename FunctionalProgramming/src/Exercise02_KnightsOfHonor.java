import java.util.Scanner;
import java.util.function.Consumer;

public class Exercise02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split("\\s+"); //upisujemo imena u niz stringova

        Consumer<String> sirName = n -> System.out.printf("Sir %s%n", n); //uzima n kao parametar i stampa Sir + n i novi red posle toga
        for (String name : names){ //prolazimo kroz list imena
            sirName.accept(name); //pozivamo Consumera da ispise ono sto je definisano sa desne strane strelice
        }
    }
}
