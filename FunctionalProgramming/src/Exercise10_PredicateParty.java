import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise10_PredicateParty  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guestList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList()); //ucitavamo prvu liniju u listu gostiju


        String input;
        while (!"Party!".equals(input = reader.readLine())) { //petlja se vrti dok se ne napise Party!
            String[] tokens = input.split("\\s+");
            modifyList(tokens[0], guestList, createFilter(tokens[1], tokens[2]));
            ///token[0] - naredba Remove ili Double
            //token[1] - kriterijum: StartsWith, EndsWith i Length
            //token[2] - vrednost na osnovu koje se gleda kriterijum (slovo kojim ime pocinje ili se zavrsava ili broj za duzinu imena)
        }

        if (guestList.size() > 0) {
            guestList = guestList.stream().sorted().collect(Collectors.toList());
            System.out.println(guestList.toString().replaceAll("[\\[\\]]","") + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
    private static void modifyList(String command, List<String> guestList, Predicate<String> filter) {
        switch (command) {
            case "Remove":
                guestList.removeIf(filter); //sklanjamo one clanove koji ispunjavaju uslov iz predikata
                break;
            case "Double":
                for (int i = 0; i < guestList.size(); i++) { //prolazimo kroz listu i dupliramo clanove
                    if (filter.test(guestList.get(i))) { //testiramo da li ispunjava kriterijum
                        guestList.add(i, guestList.get(i)); //dodajemo duplikat u listu
                        i++;
                    }
                }
                break;
        }
    }
    private static Predicate<String> createFilter (String command, String subString) { //command je StartsWith, EndsWith ili Length, substring je kriterijum
        //vraca Predicate
        Predicate<String> filter = null; //definisemo
        switch (command) {
            case "StartsWith":
                filter = string -> string.startsWith(subString); //pozivanje odgovarajuce metode startsWith i prosledjivanje vrednosti za poredjenje (substring)
                break;
            case "EndsWith":
                filter = string -> string.endsWith(subString);  //pozivanje odgovarajuce metode endsWith i prosledjivanje vrednosti za poredjenje (substring)

                break;
            case "Length":
                filter = string -> string.length() == Integer.parseInt(subString); //poredjenje duzine imena i zadatog broj (prtvoriti iz Stringa u int prvo)
                break;
        }
        return filter;
    }
}

