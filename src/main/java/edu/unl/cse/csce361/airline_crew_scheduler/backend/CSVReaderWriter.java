/*
 * CSV Reader/Writer, copyright (c) 2019 Christopher A. Bohn, bohn@unl.edu.
 */

package edu.unl.cse.csce361.airline_crew_scheduler.backend;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.net.URL;
import java.util.*;

@SuppressWarnings("unused")
public class CSVReaderWriter {

    @SuppressWarnings("WeakerAccess")
    public static Set<Map<String, String>> readCSVasSet(String filename) {
        Set<Map<String, String>> csvSet = null;
        try (InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(
                CSVReaderWriter.class.getClassLoader().getResourceAsStream("csv/" + filename)))) {
            csvSet = (Set<Map<String, String>>) parseCSV(inputStreamReader, new HashSet<>());
        } catch (NullPointerException nullPointerException) {
            System.err.println("Check spelling of file " + filename + ".");
        } catch (IOException ioException) {
            System.err.println("Error loading " + filename + ".  " + ioException);
        }
        return csvSet;
    }

    public static List<Map<String, String>> readCSVasList(String filename) {
        List<Map<String, String>> csvList = null;
        try (InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(
                CSVReaderWriter.class.getClassLoader().getResourceAsStream("csv/" + filename)))) {
            csvList = (List<Map<String, String>>) parseCSV(inputStreamReader, new LinkedList<>());
        } catch (NullPointerException nullPointerException) {
            System.err.println("Check spelling of file " + filename + ".");
        } catch (IOException ioException) {
            System.err.println("Error loading " + filename + ".  " + ioException);
        }
        return csvList;
    }

    private static Collection<Map<String, String>> parseCSV(InputStreamReader inputStreamReader,
                                                            Collection<Map<String, String>> destination) {
        Map<String, String> line;
        try {
            CSVReaderHeaderAware csvReader = new CSVReaderHeaderAwareBuilder(inputStreamReader).build();
            while ((line = csvReader.readMap()) != null) {
                destination.add(line);
            }
        } catch (NullPointerException ignored) {
            // CSVReaderHeaderAwareBuilder.build() throws NullPointerException if inputStreamReader is empty
        } catch (IOException ioException) {
            System.err.println("Error reading CSV file.  " + ioException);
        } catch (CsvValidationException csvValidationException) {
            System.err.println("Could not validate a line in CSV file.  " + csvValidationException);
        }
        return destination;
    }

    // I'd like to replace this with something that uses openCSV, but it works, and openCSV doesn't seem to have
    // writers that take map<string,string>
    public static boolean writeCSV(String filename, Collection<Map<String, String>> data) {
        boolean wroteFile = true;
        ClassLoader classLoader = CSVReaderWriter.class.getClassLoader();
        URL resource = classLoader.getResource("csv/" + filename);
        if (resource != null) {
            File file = new File(resource.getPath());
            try (OutputStream outputStream = new FileOutputStream(file)) {
                placeCSVonStream(data, outputStream);
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("Could not open " + filename + "; probably due to a bad pathname.  " + fileNotFoundException);
                wroteFile = false;
            } catch (IOException ioException) {
                System.err.println("Error opening " + filename + ".  " + ioException);
                wroteFile = false;
            }
        } else {
            System.err.println("csv/" + filename + " not found. Cannot overwrite file unless it exists.");
            wroteFile = false;
        }
        return wroteFile;
    }

    static void placeCSVonStream(Collection<Map<String, String>> data, OutputStream outputStream) {
        PrintStream writer = new PrintStream(outputStream);
        Set<String> fieldNames = null;
        int number_of_fields = 0;
        for (Map<String, String> row : data) {
            int field_number = 0;
            if (fieldNames == null) {
                fieldNames = row.keySet();
                number_of_fields = fieldNames.size();
                for (String field : fieldNames) {
                    writer.print(field);
                    writer.print(++field_number < number_of_fields ? "," : "\n");
                }
            }
            field_number = 0;
            for (String field : fieldNames) {
                String value = row.get(field);
                writer.print(value != null ? value : "");
                writer.print(++field_number < number_of_fields ? "," : "\n");
            }
        }
    }

    /* LEGACY METHODS */
    public static Set<Map<String, String>> readCSV(String filename) {
        return readCSVasSet(filename);
    }

    static Set<Map<String, String>> parseCSV(InputStream inputStream) {
        return (Set<Map<String, String>>) parseCSV(new InputStreamReader(inputStream), new HashSet<>());
    }
    
/*
    public static void main(String[] args) {
        Set<Map<String, String>> demo = readCSV("demo.csv");
        boolean success = writeCSV("out.csv", demo);
        System.out.println(success ? "Wrote file!" : "Didn't write file");
    }
*/
}
