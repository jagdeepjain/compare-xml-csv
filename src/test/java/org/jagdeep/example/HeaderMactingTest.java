/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class HeaderMactingTest {
    
    ReadXML xml = new ReadXML();
    ReadCSV csv = new ReadCSV();
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void test() throws ParserConfigurationException, SAXException,
            IOException {
        assertTrue(CollectionUtils.isEqualCollection(xml.getHeaders(),
                csv.getHeaders()));
    }
    
}
