import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//  Intermediate Operations: filter, map, flatMap, distinct, sorted, peek, limit, skip(result in a stream ,lazily loaded not executed until a terminal operation is called
// Terminal Operations: forEach, forEachOrdered, toArray, reduce, collect, min, max, count, anyMatch, allMatch, noneMatch, findFirst, findAny(produce actual output)
public class Main {
    public static void main(String[] args) {

        List<Integer> al=new ArrayList<>();

        for(int i=0;i<50;i++) {
            al.add(11);
            al.add(50);
            al.add(120);
            al.add(60);
        }

    /*Intermediate Operations: */
        //distinct count
        long dist=al.stream().distinct().count();
        System.out.println(dist);

        //filter operation
        List<Integer> al2=al.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(al2);

        //map operation
        List<Integer>al3=al.stream().distinct().map(i->i*2).collect(Collectors.toList());
        System.out.println(al3);

        //sorted Operation
        al.stream().distinct().sorted((i1,i2)->i1.compareTo(i2)).forEach(System.out::println);//ascending ,for descending put -
        al.stream().distinct().sorted(Integer::compareTo).forEach(System.out::println);

        //peek Operation used to perform some operation on the stream and check intermediate state of each element in a stream pipeline
        al.stream().distinct().sorted((i1,i2)->i1.compareTo(i2)).peek(System.out::println).forEach(System.out::println);

        //skip operation

        //limit operation used to limit the stream to n elements
        al.stream().limit(3).forEach(System.out::println);

        //skip operation ,skip certain number of elements from the stream ,here first 3 elements are skipped
        al.stream().skip(3).forEach(System.out::println);




    /*Terminal Operations: */

        //forEach used to perform some operation on each element in the stream
        al.stream().distinct().sorted((i1,i2)->i1.compareTo(i2)).forEach(System.out::println);

        al.stream().forEach(num -> {
            int doubledNum = num * 2;
            System.out.println("Original: " + num + ", Doubled: " + doubledNum);
        });

        al.stream().forEach(i->{

            if(i%2==0)
            System.out.println("Even");


        });

        //Min() Max() returns Optional since it is terminal operation and use get() to get result from Optional These methods require a Comparator to compare the elements of the stream. Here’s how you can use them:

        long answer=al.stream().min((i1,i2)->i1.compareTo(i2)).get();


        //toArray() used to convert stream to array
        Integer[]arr=al.stream().toArray(Integer[]::new);



        //any match all match none match return type boolean
        boolean answer2=al.stream().anyMatch(i->i%2==0);
        System.out.println(answer2);
        boolean answer3=al.stream().allMatch(i->i%2==0);
        System.out.println(answer3);
        boolean answer4=al.stream().noneMatch(i->i%2==0);
        System.out.println(answer4);

        //findFirst findAny return Optional and get() to get result from Optional

        al.stream().findFirst().get();
        al.stream().findAny().get();


        //Stream.of used to get Stream from a group of objects or array.
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(System.out::println);
        String[]str={"Ajay","Vijay","Rashi","Himani","Neha"};
        Stream.of(str).forEach(System.out::println);

    //collect is a terminal method too
        al.stream().sorted().collect(Collectors.toList());




    }
}