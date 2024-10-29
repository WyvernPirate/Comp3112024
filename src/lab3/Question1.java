import java.io.*;
import java.util.*;

public class Question1 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = null;
        FileWriter writer = null;
        FileWriter errorWriter = null;

        try {
            // Declarations
            scanner = new Scanner(new FileReader("C://VS//Java//Comp3112024//src//lab3//students.txt"));
            writer = new FileWriter("Output.txt");
            errorWriter = new FileWriter("errors.txt");

            ArrayList<int[]> students = new ArrayList<>(); // Stores int arrays (id, mark)
            int count = 0;

            // While loop to read file contents
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                    if (tokenizer.countTokens() != 2) { // Check for expected format (id, mark)
                        throw new Exception("Invalid data format: " + line);
                    }
                    int id = Integer.parseInt(tokenizer.nextToken());
                    int mark = Integer.parseInt(tokenizer.nextToken());
                    students.add(new int[] { id, mark });
                } catch (NumberFormatException e) {
                    errorWriter.write("Error parsing data: " + line + " (" + e.getMessage() + ")\n");
                } catch (Exception e) {
                    errorWriter.write("Error: " + e.getMessage() + "\n");
                }
                count++;
            }

            // Sorting and saving top 10 students (part b)
            sortAndSaveTopStudents(students, writer);

            // Calculate average (original code)
            double sum = 0;
            for (int[] student : students) {
                sum += student[1];
            }
            double average = sum / students.size();
            writer.write("Average of all students: " + String.valueOf(average));

        } catch (Exception e) {
            errorWriter.write("Error: " + e.getMessage() + "\n");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Log or handle IOException while closing writer
                    System.err.println("Error closing output file: " + e.getMessage());
                }
            }
            if (errorWriter != null) {
                try {
                    errorWriter.close();
                } catch (IOException e) {
                    // Log or handle IOException while closing errorWriter
                    System.err.println("Error closing error file: " + e.getMessage());
                }
            }
        }
    }

    // New method to sort and save top students
    private static void sortAndSaveTopStudents(ArrayList<int[]> students, FileWriter writer) throws Exception {
        students.sort(Comparator.comparingInt(s -> -s[1])); // Sort by mark descending (negative for descending)
        int numTopStudents = Math.min(students.size(), 10); // Limit to top 10 or all students
        writer.write("\nTop " + numTopStudents + " Students:\n");
        for (int i = 0; i < numTopStudents; i++) {
            writer.write("Student ID: " + students.get(i)[0] + ", Mark: " + students.get(i)[1] + "\n");
        }
    }
}