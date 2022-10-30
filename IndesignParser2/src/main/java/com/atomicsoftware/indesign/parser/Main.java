package com.atomicsoftware.indesign.parser;

import com.jcabi.xml.XMLDocument;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class Main {

    public static final String FILES_PATH = "/Users/harshawasalathanthri/Atomic/acs/tech-experiments/indesign-experiment/_demo/files/";

    public static void main(String[] args) throws Exception {
        XPathParser parser = new XPathParser(new File(FILES_PATH, "RandL_TG_Set4_TemplateLesson_source.xml"));
        NodeList nodeList = parser.parse("data//page[name='1']//items");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println(new XMLDocument(node));
            System.out.println();
        }
    }
}
