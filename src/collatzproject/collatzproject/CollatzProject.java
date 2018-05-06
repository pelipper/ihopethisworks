package collatzproject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollatzProject {
    //
    public static void main(String[] args) throws IOException {
        //initializations
        int lower = 1;
        int upper = 10;
        CsvUtils csvUtils = new CsvUtils();
        FileWriter csvWriterNoPredicate = new FileWriter(new File("src/csvOut/noPredicate.csv"));
        FileWriter csvWriterPrimes = new FileWriter(new File("src/csvOut/primes.csv"));
        FileWriter csvWriterPower = new FileWriter(new File("src/csvOut/power.csv"));
        FileWriter csvWriterMult = new FileWriter(new File("src/csvOut/mult.csv"));
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        CollatzProxy collatzProxy = new CollatzProxy(lower, upper);


        csvUtils.writeLine(csvWriterNoPredicate, Arrays.asList("Initial Numbers :", "Collatz Number :", "Calculations :"));
        List<String> initialNumbers = new ArrayList<>();
        List<String> collatzNumbers = new ArrayList<>();
        List<String> calculationSteps = new ArrayList<>();
        List<String> values = new ArrayList<>();


        for (Integer i: collatzProxy.getCollatzNumbers(lower, upper).getInitialInts()
             ) { initialNumbers.add(i.toString());

        }
        System.out.println(initialNumbers);

        for (Integer i: collatzProxy.getCollatzNumbers(lower, upper).getCollatzNums()
                ) {
            collatzNumbers.add(i.toString());

        }
        System.out.println(collatzNumbers);
        for (CollatzCalculation c : collatzProxy.getCalculations(lower, upper)) {
            calculationSteps.add(c.calculationSteps().toString() );

        }
        System.out.println(calculationSteps);



        for(int z=0;z<collatzNumbers.size();z++)
        {
            values.add(initialNumbers.get(z));
            values.add(collatzNumbers.get(z));
            values.add(calculationSteps.get(z));
            values.add(":");

        }
        System.out.println(values);


        csvUtils.writeLine(csvWriterNoPredicate, values);

        csvWriterNoPredicate.flush();
        csvWriterNoPredicate.close();




    }
}

