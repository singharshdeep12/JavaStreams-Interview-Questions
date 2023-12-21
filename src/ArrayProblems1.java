import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ArrayProblems1 {

    public static void main(String[] args) {

        int[] numbers = {8, 3, 11, 6, 10, 2, 9, 5, 10, 19};


        //Program to find second highest number in an array - 1
        System.out.println("Program to find second highest number in an array - 1");
        Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(2)
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        printDashes();

        //Program to find second highest number in an array - 2
        System.out.println("Program to find second highest number in an array - 2");
        Arrays.stream(numbers)
                .boxed()
                .distinct()
                .sorted((a,b)->Integer.compare(b,a))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        printDashes();


        String[] strings = {
                "Apple12345678",
                "Banana",
                "Apple12345678",
                "Orange",
                "Grapes",
                "Cherry",
                "Pineapple",
                "Strawberry"
        };

        //Program to find longest string from given array
        System.out.println("Program to find longest string from given array - 1");
        Arrays.stream(strings)
                .max(Comparator.comparingInt(s->s.length()))
                .ifPresent(System.out::println);

        printDashes();
        //Program to find longest string from given array - 2
        System.out.println("Program to find longest string from given array - 2");
        Arrays.stream(strings)
                .reduce((a,b)->{
                    if(Integer.compare(a.length(),b.length())>0)
                        return a;
                    else return b;
                })
                .ifPresent(System.out::println);
        printDashes();


        //Program to find all elements in number array starting with 1
        System.out.println("Program to find all elements in number array starting with 1");
        Arrays.stream(numbers)
                .mapToObj(number->String.valueOf(number))
                .filter(element -> element.startsWith("1"))
                .forEach(System.out::println);

        printDashes();


        //Program to find all elements in number array starting with 1
        System.out.println("Program to find all elements in number array starting with 1");
        Arrays.stream(numbers)
                .mapToObj(number->String.valueOf(number))
                .filter(element -> element.startsWith("1"))
                .forEach(System.out::println);

        printDashes();


        //Program to use String.join
        System.out.println("Program to use String.join");
        System.out.println(String.join("-",strings));
        printDashes();

        //Skip Limit example
        System.out.println("Skip limit example");
        IntStream.rangeClosed(1,10).skip(3).limit(5)
                .forEach(System.out::println);

        printDashes();

    }

    static void printDashes(){
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
    }

}
