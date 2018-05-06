package collatzproject;


import java.io.IOException;

public class CollatzProject {
    //
    public static void main(String[] args) throws IOException {
        int lower = 1;
        int upper = 10;
        CsvUtils csvUtils = new CsvUtils();
        String csvOutFile = "src/csvOut";
//        FileWriter csvWriter = new FileWriter(csvOutFile);
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        CollatzProxy collatzProxy = new CollatzProxy(lower, upper);
//        csvUtils.writeLine(csvWriter, Arrays.asList("Initial Numbers", "Collatz Number", "Calculation"));


        System.out.println("initial list of numbers" + "\n" + collatzProxy.getCollatzNumbers(lower, upper).getInitialInts()+"\n");

            System.out.println("Collatz numbers for initial list" + "\n" + realCollatz.getCollatzNumbers(lower, upper).getCollatzNums()+"\n");

        System.out.println("Calculation Steps");
        for (CollatzCalculation c : collatzProxy.getCalculations(lower, upper)){
            System.out.print(c.calculationSteps() + ",");

        }


        }
    }

