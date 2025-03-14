package com.dataaccess.webservicesserver;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * The Number Conversion Web Service, implemented with Visual DataFlex, provides functions that
 *       convert numbers into words or dollar amounts.
 *     
 *
 * This class was generated by Apache CXF 3.3.4
 * 2024-06-28T15:53:15.253+02:00
 * Generated source version: 3.3.4
 *
 */
@WebServiceClient(name = "NumberConversion",
                  wsdlLocation = "file:/Users/anastasiyashafalovich/Desktop/homework5/src/test/resources/wsdl/numberconversion.wsdl",
                  targetNamespace = "http://www.dataaccess.com/webservicesserver/")
public class NumberConversion extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversion");
    public final static QName NumberConversionSoap = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversionSoap");
    public final static QName NumberConversionSoap12 = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversionSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/anastasiyashafalovich/Desktop/homework5/src/test/resources/wsdl/numberconversion.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(NumberConversion.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/anastasiyashafalovich/Desktop/homework5/src/test/resources/wsdl/numberconversion.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public NumberConversion(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public NumberConversion(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NumberConversion() {
        super(WSDL_LOCATION, SERVICE);
    }

    public NumberConversion(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public NumberConversion(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public NumberConversion(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap")
    public NumberConversionSoapType getNumberConversionSoap() {
        return super.getPort(NumberConversionSoap, NumberConversionSoapType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap")
    public NumberConversionSoapType getNumberConversionSoap(WebServiceFeature... features) {
        return super.getPort(NumberConversionSoap, NumberConversionSoapType.class, features);
    }


    /**
     *
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap12")
    public NumberConversionSoapType getNumberConversionSoap12() {
        return super.getPort(NumberConversionSoap12, NumberConversionSoapType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap12")
    public NumberConversionSoapType getNumberConversionSoap12(WebServiceFeature... features) {
        return super.getPort(NumberConversionSoap12, NumberConversionSoapType.class, features);
    }

}
