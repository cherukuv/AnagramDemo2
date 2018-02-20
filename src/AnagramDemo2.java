/*
 * Program: 
 * 1. This program will find all the anagrams from given text or string
 * User input: cat pat gat tac act apt kat agt tat
 * Output: [act, cat, tac]
 *         [pat, apt]
 *         [gat, agt]
 * Author: vignan cheruku
 */
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class AnagramDemo2{
	  
    public static void main(String[] args) throws IOException {
    	 System.out.println("Please enter text or paragraph\n");
		 Scanner sc = new Scanner(System.in);
		 getAnagramsFromInput(new StringReader(sc.nextLine()))
         .forEach(System.out::println);

    }
    
    private static String standardize(String check) {
        return Stream.of(check.split("")).sorted().collect(Collectors.joining());
    }

    public static List<Set<String>> getAnagramsFromInput(Reader reader) {
    Map<String, Set<String>> map = new BufferedReader(reader).lines()
                                     .flatMap(Pattern.compile("\\W+")::splitAsStream)
                                     .collect(Collectors.groupingBy(AnagramDemo2::standardize, Collectors.toSet()));
        return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }

}
