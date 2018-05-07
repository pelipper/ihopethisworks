package collatzproject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stuart Pellitier, Eli Poulos, Clay Wightman
 */
public class CollatzProject {

    public static void main(String[] args) throws IOException {
        //initializations
        int lower = 1;
        int upper = 100;

        CSVWriter CSVWriter = new CSVWriter();

        //Change filename to correspond to the predicate type, or it will overwrite the previous file.
        FileWriter csvWriterNoPredicate = new FileWriter(new File("src/csvOut/multiplesOf5.csv"));
        CollatzProxy collatzProxy = new CollatzProxy(lower, upper);

        //CSV column headers
        CSVWriter.writeLine(csvWriterNoPredicate, Arrays.asList("Initial Numbers", "Collatz Number",  "Result of each calculation"));


        List<String> initialNumbers = new ArrayList<>();
        List<String> collatzNumbers = new ArrayList<>();
        List<String> calculationSteps = new ArrayList<>();
        List<String> values = new ArrayList<>();

        //change predicateType and predicateNumber here to create a new filtered list.
        for (Integer i : collatzProxy.getCollatzNumbers(lower, upper, "Multiple", 5).getInitialInts()) {
            initialNumbers.add(i.toString().replaceAll(", $", ""));
        }

        for (Integer i : collatzProxy.getCollatzNumbers(lower, upper).getCollatzNums()) {
            collatzNumbers.add(i.toString().replaceAll(", $", ""));
        }

        //change predicateType and predicateNumber here to create a new filtered list.
        for (CollatzCalculation c : collatzProxy.getCalculations(lower, upper,"Multiple",5)) {
            calculationSteps.add(c.calculationSteps().toString().replaceAll("[\\] , \\[] *", " "));
        }

        //format and write values to .csv
        for (int z = 0; z < calculationSteps.size(); z++) {
            values.add(initialNumbers.get(z));
            values.add(collatzNumbers.get(z));
            values.add(calculationSteps.get(z));
            CSVWriter.writeLine(csvWriterNoPredicate, values);
            values.remove(initialNumbers.get(z));
            values.remove(collatzNumbers.get(z));
            values.remove(calculationSteps.get(z));
            values.remove(",");
        }
        csvWriterNoPredicate.flush();
        csvWriterNoPredicate.close();


    }
}


