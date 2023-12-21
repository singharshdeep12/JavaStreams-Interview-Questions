import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblems1 {

    public static void main(String[] args) {

        //Program to find occurence of each character in string

        System.out.println("Program to find occurence of each character in string");

        String toFind = "iamfromIndiaandimproudtobeindian";
        //this will print each letter and its total literal occurences
        Arrays.stream(toFind.split(""))
                .collect(Collectors.groupingBy(c->c))
                .forEach((k,v)-> System.out.println(k+"->"+v));

        //this will print each letter and its occurences
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                c->c
                                //or Function.identity()
                                ,Collectors.counting()))
                .forEach((k,v)-> System.out.println(k+"->"+v));

        printDashes();

        //Program to find all duplicate characters in string
        System.out.println("Program to find all duplicate characters in string");
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                Function.identity()
                                ,Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue()>1)
                .forEach((element)-> System.out.println(element.getKey()+"->"+element.getValue()));

        printDashes();

        //Program to find all unique characters in string
        System.out.println("Program to find all unique characters in string");
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                Function.identity()
                                ,Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue()==1)
                .forEach((element)-> System.out.println(element.getKey()+"->"+element.getValue()));

        printDashes();

        //Program to find first non repeat element in string - 1 way
        System.out.println("Program to find first non repeat element in string");
        var toFindArray = Arrays.asList(toFind.split(""));
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                Function.identity()
                                ,Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue()==1)
                .mapToInt(element -> toFindArray.indexOf(element.getKey()))
                .min()
                .ifPresent
                        (min ->
                                System.out.printf("Min index element is {%s} and index is {%d}\n",toFindArray.get(min),
                                        min));
        printDashes();

        //Program to find first non repeat element in string - 2 way using LinkedHashMap
        System.out.println("Program to find first non repeat element in string using LinkedHashMap");
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                Function.identity()
                                ,()-> new LinkedHashMap<>()  //only change
                                ,Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue()==1)
                .findFirst()
                .ifPresent
                        (min ->
                                System.out.printf("Min unique index element is {%s}\n",
                                        min.getKey()));
        printDashes();

        //Program to find first repeated element in string -  using LinkedHashMap
        System.out.println("Program to find first repeated element in string using LinkedHashMap");
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                Function.identity()
                                ,()-> new LinkedHashMap<>()  //only change
                                ,Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue()>1)
                .findFirst()
                .ifPresent
                        (min ->
                                System.out.printf("Min unique index repeated element is {%s}\n",
                                        min.getKey()));
        printDashes();


        //Program to find first repeated element in string -  using LinkedHashMap
        System.out.println("Program to find first repeated element in string using LinkedHashMap");
        Arrays.stream(toFind.split(""))
                .collect
                        (Collectors.groupingBy(
                                Function.identity()
                                ,()-> new LinkedHashMap<>()  //only change
                                ,Collectors.counting()))
                .entrySet()
                .stream().filter(element -> element.getValue()>1)
                .findFirst()
                .ifPresent
                        (min ->
                                System.out.printf("Min unique index repeated element is {%s}\n",
                                        min.getKey()));
        printDashes();

    }

    static void printDashes(){

        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
    }


}
