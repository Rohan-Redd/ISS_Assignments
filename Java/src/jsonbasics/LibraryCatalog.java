// Reading content from JSON file and displaying it.

package jsonbasics;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LibraryCatalog {

    public static void main(String[] args) {
        try {
            // Mentioning the path to the JSON file. Note: provide the path accordingly
            String filePath = "C:/Users/Adavelli Rohan Reddy/Desktop/ISS/Java/src/jsonbasics/books.json";
            File jsonFile = new File(filePath);

            // Parsing JSON file to JsonNode
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode booksNode = objectMapper.readTree(jsonFile);

            // Displaying details about each book
            for (JsonNode bookNode : booksNode) {
                String title = bookNode.get("title").asText();
                String author = bookNode.get("author").asText();
                String genre = bookNode.get("genre").asText();
                int year = bookNode.get("year").asInt();

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Genre: " + genre);
                System.out.println("Year: " + year);
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
