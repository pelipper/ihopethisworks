package collatzproject;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CsvUtils {
    private static final char defaultSeperator = ',';

    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, defaultSeperator, ' ');
    }

    public static void WriteLine(Writer w, List<String> values, char seperators) throws IOException {
        writeLine(w, values, seperators, ' ');
    }

    private static String followCsvFormat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

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
