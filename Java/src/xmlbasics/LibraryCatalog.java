// Reading content from XML file and displaying it.

package xmlbasics;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LibraryCatalog {

    public static void main(String[] args) {
        try {
        	// Mentioning the path to the XML file. Note: provide the path accordingly
            String filePath = "C:/Users/Adavelli Rohan Reddy/Desktop/ISS/Java/src/xmlbasics/books.xml";
            File xmlFile = new File(filePath);

            // Parsing XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Displaying details about each book
            NodeList bookList = document.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    String title = getElementValue(bookElement, "title");
                    String author = getElementValue(bookElement, "author");
                    String genre = getElementValue(bookElement, "genre");
                    int year = Integer.parseInt(getElementValue(bookElement, "year"));

                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Genre: " + genre);
                    System.out.println("Year: " + year);
                    System.out.println("-------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getElementValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
