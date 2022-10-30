package com.atomicsoftware.indesign.parser;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;

public class XPathParser {

    private Document document;

    public XPathParser(File file) throws Exception {
        this.document = loadDocument(file);
    }
    private Document loadDocument(File file) throws Exception {
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new FileInputStream(file));
    }

    public NodeList parse(String expression) throws XPathExpressionException {
        return (NodeList) XPathFactory.newInstance().newXPath()
                .compile(expression)
                .evaluate(document, XPathConstants.NODESET);
    }
}
