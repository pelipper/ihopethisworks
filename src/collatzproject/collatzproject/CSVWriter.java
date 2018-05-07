package collatzproject;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVWriter {
    private static final char defaultSeperator = ',';

    /**
     * @param w      Writer object that designates what file to write to
     * @param values List of values to write to csv file
     * @throws IOException
     */
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, defaultSeperator, ' ');
    }

    /**
     * @param w          Writer object that designates what file to write to
     * @param values     List of values to write to csv file
     * @param seperators custom seperator to use, useful because ',' is the defaule list element seperator in Java.
     * @throws IOException
     */
    public static void WriteLine(Writer w, List<String> values, char seperators) throws IOException {
        writeLine(w, values, seperators, ' ');
    }

    /**
     * @param value file name
     * @return result the modified path that follows csv format.
     */
    private static String followCsvFormat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    /**
     *
     * @param w          Writer object that designates what file to write to
     * @param values     List of values to write to csv file
     * @param seperators custom seperator to use, useful because ',' is the defaule list element seperator in Java.
     * @param customQuote optional custom character to use as quote to wrap around each item in list to be exported to csv file.
     * @throws IOException
     */
    public static void writeLine(Writer w, List<String> values, char seperators, char customQuote) throws IOException {
        boolean first = true;
        if (seperators == ',') {
            seperators = defaultSeperator;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String value : values) {
            if (!first) {
                stringBuilder.append(seperators);
            }

            if (customQuote == ' ') {
                stringBuilder.append(followCsvFormat(value));
            } else {
                stringBuilder.append(customQuote).append(followCsvFormat(value)).append(customQuote);
            }
            first = false;
        }
        stringBuilder.append("\n");
        w.append(stringBuilder.toString());
    }


}
