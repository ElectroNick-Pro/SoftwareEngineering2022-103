package MainApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import MainApp.pages.*;

public class GlobalData {
    public static Map<String, Object> data = new HashMap<>();
    public static Map<String, Object> config = new HashMap<>();

    public static void init(String[] args) {

        var factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        factory.setIgnoringElementContentWhitespace(true);

        try {
            var builder = factory.newDocumentBuilder();
            var doc = args.length == 0 ? 
                builder.parse(ClassLoader.getSystemClassLoader().getResourceAsStream("MainApp/config/config.xml")) : 
                builder.parse(Path.of(args[0]).toFile());

            var dataPath = Path.of(doc.getElementsByTagName("dataDir").item(0).getTextContent());
            if(!dataPath.toFile().exists()) {
                if(!dataPath.toFile().mkdirs()) {
                    System.exit(1);
                }
                JOptionPane.showMessageDialog(null, "Database files are now in directory "+dataPath.toAbsolutePath().toString(), "File Ready", JOptionPane.PLAIN_MESSAGE);
            }
            config.put("dataDir", dataPath);

            var tz = new SimpleDateFormat(doc.getElementsByTagName("timeStrFormat").item(0).getTextContent());
            tz.setTimeZone(TimeZone.getTimeZone(doc.getElementsByTagName("timeZone").item(0).getTextContent()));
            config.put("timezone", tz);

            var nodeLs = doc.getElementsByTagName("model");
            int n = nodeLs.getLength();
            var userModels = new LinkedList<String>();
            for(int i = 0; i < n; i++) {
                userModels.add(nodeLs.item(i).getTextContent());
            }
            config.put("userModels", userModels);

            // copy internal files
            for(var model : userModels) {
                var filePath = dataPath.resolve(model+".csv");
                if(filePath.toFile().exists()) {
                    continue;
                }
                Files.copy(ClassLoader.getSystemResourceAsStream("MainApp/data/"+model+".csv"), filePath);
            }

            var dig = MessageDigest.getInstance(doc.getElementsByTagName("digest-algorithm").item(0).getTextContent());
            config.put("digest", dig);

            var welcomeStr = doc.getElementsByTagName("welcomePage").item(0).getTextContent();
            var welcomePath = Path.of(welcomeStr);
            config.put("welcomePage", welcomePath);

            var pagePaths = new HashMap<Path, JFrame>();
            pagePaths.put(welcomePath, new Welcome());
            config.put("pagePaths", pagePaths);

        } catch (SAXException | IOException | ParserConfigurationException | NoSuchAlgorithmException | DOMException e) {
            e.printStackTrace();
        }

    }
}