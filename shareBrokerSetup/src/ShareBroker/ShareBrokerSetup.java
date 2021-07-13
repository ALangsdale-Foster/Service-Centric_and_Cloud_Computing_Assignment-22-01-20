/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShareBroker;
import java.io.File;
import java.util.List;
import generated.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author n0650128
 */
public class ShareBrokerSetup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File storageFile = new File("shares.xml");
        Shares shares = new Shares();
        List<Share> sharesList = shares.getShare();
        Share share;
        SharePrice sharePrice;
        
        share = new Share();
        share.setCompanyName("TestName");
        share.setCompanySymbol("TEST");
        share.setAvailableShareQuant(BigInteger.valueOf(420));
        sharePrice = new SharePrice();
        sharePrice.setCurrencyValue((float)4.20);
        sharePrice.setCurrencyName("GBP");
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            sharePrice.setLastUpdated(xmlDate);
        } catch (Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        sharesList.add(share);
        
        share = new Share();
        share.setCompanyName("Airbus");
        share.setCompanySymbol("AIR");
        share.setAvailableShareQuant(BigInteger.valueOf(100));
        sharePrice = new SharePrice();
        sharePrice.setCurrencyValue((float)138.02);
        sharePrice.setCurrencyName("GBP");
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            sharePrice.setLastUpdated(xmlDate);
        } catch (Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        sharesList.add(share);
        
        share = new Share();
        share.setCompanyName("Rolls-Royce");
        share.setCompanySymbol("RR");
        share.setAvailableShareQuant(BigInteger.valueOf(50));
        sharePrice = new SharePrice();
        sharePrice.setCurrencyValue((float)665.60);
        sharePrice.setCurrencyName("GBP");
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            sharePrice.setLastUpdated(xmlDate);
        } catch (Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        sharesList.add(share);
        
        try {
           javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
           javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
           marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
           marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
           marshaller.marshal(shares, storageFile);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    }
}