// src/java/*.java
// peer 4
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Armazenamento {

    private Map<String, String> _mapTraducoes;
    private String _filename;
    
    Armazenamento(String filename) {
        _filename = filename;
                
        System.out.println("Armazenamento.<init>(): " + filename);
        File ficheiro = new File(filename);
        if(ficheiro.exists()) FillMapaTraducoes(ficheiro);           
        else
            throw new RuntimeException("Ficheiro não existe");
    }
    
    private void FillMapaTraducoes(File ficheiro){      
        _mapTraducoes = new HashMap<String, String>();
        System.out.println("FicheiroExiste");
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(getFilename());	
            doc.getDocumentElement().normalize();
            
            Element rootElement = doc.getDocumentElement();
            
            NodeList traducoes = doc.getElementsByTagName("Palavra");
            
            System.out.println("Node List traducoes Lenght: " + traducoes.getLength());
            
            for(int i = 0; i < traducoes.getLength() - 1; i++)
            {
                Node traducao = traducoes.item(i); 
                if(traducao.getNodeType() == Node.ELEMENT_NODE){
                    NamedNodeMap atributosTraducao = traducao.getAttributes();
                    _mapTraducoes.put(atributosTraducao.getNamedItem("Portugues").getNodeValue().toString(), atributosTraducao.getNamedItem("Ingles").getNodeValue().toString());                    
                }
            }            
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
     public String getPalavraTraduzida(String palavra) {
        if(_mapTraducoes.containsKey(palavra))
            return _mapTraducoes.get(palavra);
        return palavra;
    }

    private String getFilename() {
        return _filename;
    }
}
