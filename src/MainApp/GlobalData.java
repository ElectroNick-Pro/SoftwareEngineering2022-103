package MainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import MainApp.pages.Retrieve;

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

            config.put("dataDir", Path.of(doc.getElementsByTagName("dataDir").item(0).getTextContent()));

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
            var pagePaths = new HashMap<Path, JFrame>();
            pagePaths.put(Path.of("page1"), new Retrieve(){{
                setSize(960, 540);
            }});

            config.put("pagePaths", pagePaths);

            config.put("welcomePage", Path.of(doc.getElementsByTagName("welcomePage").item(0).getTextContent()));

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}