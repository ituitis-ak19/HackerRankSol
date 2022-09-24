import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.math.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
    int res = 0;
    List<Integer> a = new ArrayList<Integer>();
    for(int i = 0; i<k; i++){
        a.add(0);
    }
    
    for(int i=0; i< s.size(); i++){
        int b = s.get(i) % k;
        Integer sss = a.get(b);
        a.set(b, sss+1);
    }
    
    if(a.get(0)>0){
        res+=1;
    }
    
    if(k%2 == 0){
        res += Math.min(a.get(k/2), 1);
    }
    
    for(int i = 1 ; i<(k+1)/2; i++){
        if(!(i==k-i)){
            res += Math.max(a.get(i), a.get(k-i));
        }
    }
    return res;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
