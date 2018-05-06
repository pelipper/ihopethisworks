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

        csvUtils.writeLine(csvWriterNoPredicate, Arrays.asList("Initial Numbers", "Collatz Number", "Calculations"));
        List<String> values = new ArrayList<>();
        List<String> calculationSteps = new ArrayList<>();




        for (CollatzCalculation c : collatzProxy.getCalculations(lower, upper)) {
            calculationSteps.add(c.calculationSteps().toString() );

        }


        values.add(collatzProxy.getCollatzNumbers(lower, upper).getInitialInts().toString());
        values.add(realCollatz.getCollatzNumbers(lower, upper).getCollatzNums().toString());


        for (String s : calculationSteps) {
            values.add(s);

        }

        csvUtils.writeLine(csvWriterNoPredicate, values,'|', '\u0000');

        csvWriterNoPredicate.flush();
        csvWriterNoPredicate.close();




    }
}

