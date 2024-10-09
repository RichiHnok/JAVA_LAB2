package com.laba2.parsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.laba2.entity.Gem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxTask {

	private static final Path XML_PATH = Paths.get( "src\\main\\resources\\gems.xml");
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
		GemHandler handler = new GemHandler();
		saxParser.parse(XML_PATH.toFile(), handler);
		List<Gem> gems = handler.getGems();
		for(Gem gem : gems){
			System.out.println(gem);
		}
	}

	private static class GemHandler extends DefaultHandler{

		private static final String GEMS = "Gems";
		private static final String GEM_ID = "gemId";
		private static final String NAME = "name";
		private static final String ORIGIN = "origin";
		private static final String GEM = "Gem";
		private static final String PRECIOUSNESS = "Preciousness";
		private static final String COLOR = "Color";
		private static final String TRANSPARENCY = "Transparency";
		private static final String CUT = "Cut";
		private static final String VISUAL_PARAMETRES = "VisualParametres";
		private static final String VALUE = "Value";

		private List<Gem> gems = null;
		private Gem gem = null;
		private StringBuilder data = null;

		public List<Gem> getGems(){
			return gems;
		}
		
		boolean bPreciousness = false;
		boolean bColor = false;
		boolean bTransparency = false;
		boolean bCut = false;
		boolean bValue = false;
		
		@Override
		public void startDocument() throws SAXException {
			gems = new ArrayList<>();
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			switch (qName) {
            case GEM:
					String id = attributes.getValue(GEM_ID);
					String name = attributes.getValue(NAME);
					String origin = attributes.getValue(ORIGIN);
					gem = new Gem();
					gem.setGemId(id);
					gem.setName(name);
					gem.setOrigin(origin);
					break;
            case PRECIOUSNESS: bPreciousness = true; break;
            case COLOR: bColor = true; break;
            case TRANSPARENCY: bTransparency = true; break;
            case CUT: bCut = true; break;
            case VALUE: bValue = true; break;
        }

		  data = new StringBuilder();
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(bPreciousness){
				gem.setPreciousness(data.toString());
				bPreciousness = false;
			}else if(bColor){
				gem.setColor(data.toString());
				bColor = false;
			}else if(bTransparency){
				gem.setTransparency(Integer.parseInt(data.toString()));
				bTransparency = false;
			}else if(bCut){
				gem.setCut(data.toString());
				bCut = false;
			}else if (bValue) {
				gem.setValue(Double.parseDouble(data.toString()));
				bValue = false;
			}

			if(qName.equals(GEM)){
				gems.add(gem);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			data.append(ch, start, length);
		}
	}
}
