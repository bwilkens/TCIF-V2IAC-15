package nl.hu.iac.wsproducer;

import com.sun.xml.ws.developer.ValidationErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
  * custom error handler while validating xml against xsd
  */
public class SchemaValidationErrorHandler extends ValidationErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        handleMessage("Warning", exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        handleMessage("Error", exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        handleMessage("Fatal", exception);
    }

    private String handleMessage(String level, SAXParseException exception) throws SAXException {
        int lineNumber = exception.getLineNumber();
        int columnNumber = exception.getColumnNumber();
        String message = exception.getMessage();
        throw new SAXException("[" + level + "] line nr: " + lineNumber + " column nr: " + columnNumber + " message: " + message);
    }
}