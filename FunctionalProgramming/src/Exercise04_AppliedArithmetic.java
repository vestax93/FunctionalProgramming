import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Exercise04_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //citac za input, mogao je i Scanner
        int[] numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(); //ucitavanje Stringova i pretvaranje u integer

        Function<int[], int[]> increaseByOne = (int[] a) -> Arrays.stream(a).map(x -> x += 1).toArray();
        //definisanje funkcije koja vraca ceo niz ciji su svi elementi uvecani za 1
        Function<int[], int[]> decreaseByOne = (int[] a) -> Arrays.stream(a).map(x -> x -= 1).toArray();
        //definisanje funkcije koja vraca ceo niz ciji su svi elementi umanjeni za 1
        Function<int[], int[]> multiplyByTwo = (int[] a) -> Arrays.stream(a).map(x -> x *= 2).toArray();
        //definisanje funkcije koja vraca ceo niz ciji su svi elementi pomozeni sa 2
        Consumer<int[]> print = (int[] a) -> Arrays.stream(a).forEach(x -> System.out.print(x + " "));
        //stampanje clanova niza koriscenje forEach metode
        String command = "";
        while(true){
            command = br.readLine(); //ucitavanje komande
            if(command.equals("end")){ //uslova za prekidanje petlje
                break;
            }
            switch(command){
                case "add":
                    numbers = increaseByOne.apply(numbers); //prosledjujemo niz numbers u increaseByOne i onda rezultat upisujemo u numbers
                    break;
                case "subtract":
                    numbers = decreaseByOne.apply(numbers); //prosledjujemo niz numbers u decreaseByOne i onda rezultat upisujemo u numbers
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers); //prosledjujemo niz numbers u multiplyByTwo i onda rezultat upisujemo u numbers
                    break;
                case "print":
                    print.accept(numbers); //prosledjujemo niz Consumer-u i on stampa sv elemente
                    System.out.println();
                    break;
            }
        }
    }
}
