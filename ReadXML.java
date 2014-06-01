import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ReadXML {
    public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException {

        int noun = 0;
        int verb = 0;
        String[] textWords = {"Hello", "world", "I", "am", "OK"};


        File xmlFile =  new File("\\Users\\\u041b\u0430\u043d\u0430\\IdeaProjects\\First\\primer.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList textList = doc.getElementsByTagName("text");

        System.out.println("Number of texts:" + textList.getLength());                  //абзацы

        NodeList words = doc.getElementsByTagName("word");

        System.out.println("Number of words:" + words.getLength());                  // слова

        for (int i = 0; i < textList.getLength(); i++) {
//            (double) 1 / 2
            Element textElement = (Element) textList.item(i);
            NodeList wordList = textElement.getElementsByTagName("word");

            for (int temp = 0; temp < wordList.getLength(); temp++) {

                Element wordElement = (Element) wordList.item(temp);

                if ("noun".equals(wordElement.getAttribute("pos"))) {
                    noun += 1;
                }
                if("verb".equals(wordElement.getAttribute("pos"))){
                    verb += 1;
                }
                System.out.println(textElement.getElementsByTagName("word").item(temp).getTextContent());
            }


            if (i == 1){
                for (int w = 0; w < textWords.length; w++){
                    Element e = doc.createElement("word");
                    Attr pos = doc.createAttribute("pos");
                    e.appendChild(pos);
                    pos.setValue("noun");
               //     e.;
                    textElement.appendChild(e);
                }
            }
        }

        System.out.println("Nouns: " + noun);
        System.out.println("Verbs: " + verb);
//            if (textNode.getNodeType() == Node.ELEMENT_NODE) {

//             Element eElement = (Element) textNode;


//            }


    }
