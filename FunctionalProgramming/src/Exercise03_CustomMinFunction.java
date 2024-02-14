import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Exercise03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")) //mapiramo iz niza strigova u niz int
                .mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> minInteger = (int[] p) -> Arrays.stream(p).min().getAsInt(); //definisemo funkciju koja prima niz integera, a vraca Integer tj. minimum u nizu
        System.out.println(minInteger.apply(numbers)); //pozivamo fukciju i ona vraca minimum
    }
}
