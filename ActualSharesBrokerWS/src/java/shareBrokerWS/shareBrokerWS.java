/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shareBrokerWS;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import ShareBroker.*;
import generated.Share;
import generated.SharePrice;
import generated.Shares;
import java.io.File;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import javax.jws.WebParam;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

/**
 *
 * @author n0650128
 */
@WebService(serviceName = "shareBrokerWS")
public class shareBrokerWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getAvailableShares")
    public List<Share> getAvailableShares() {
        Shares sharesList = unmarshalAll();
        List<Share> returnShares = sharesList.getShare();
        Iterator i = returnShares.iterator();
        Share nextShare;
        Shares outputShares = new Shares();
        List<Share> returnShares2 = outputShares.getShare();
        
        while(i.hasNext()){
            nextShare = (Share) i.next();
            int bigval = nextShare.getAvailableShareQuant().intValue();
            if(bigval > 0) {
                returnShares2.add(nextShare);
            }
        }
        
        return returnShares2;
    }
    
    @WebMethod(operationName = "unmarshalAll")
    public Shares unmarshalAll() {
        Shares shares = new Shares();
        String filepath = "E:\\Final Year\\SCC\\Coursework\\shareBrokerSetup\\shares.xml";
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            shares = (Shares) unmarshaller.unmarshal(new java.io.File(filepath));//NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return shares;
    }
    
    @WebMethod(operationName = "buyShares")
    public List<Share> buyShares(@WebParam(name = "quantity") int quantity, 
            @WebParam(name = "shareSymbol") String shareSymbol) {
        String filepath = "E:\\Final Year\\SCC\\Coursework\\shareBrokerSetup\\shares.xml";
        File xml = new File(filepath);
        shareSymbol = shareSymbol.toUpperCase();
        Shares shares = unmarshalAll();
        List<Share> listShares = shares.getShare();
        
        for (int x = 0; x < listShares.size(); x++) {
            if((listShares.get(x).getCompanyName().toUpperCase().equals(shareSymbol)) || (listShares.get(x).getCompanySymbol().toUpperCase().equals(shareSymbol))){
                if(quantity <= listShares.get(x).getAvailableShareQuant().intValue()) {
                    int value = listShares.get(x).getAvailableShareQuant().intValue();
                    int newval = value - quantity;
                    BigInteger bigval = BigInteger.valueOf(newval);
                    listShares.get(x).setAvailableShareQuant(bigval);
                }
            }
        }
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shares, xml);
            
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listShares;
    }
    
    @WebMethod(operationName = "sellShares")
    public List<Share> sellShares(@WebParam(name = "userInput") String input,
        @WebParam(name = "quantAvailable") int quantAvailable) {
        String filepath = "E:\\Final Year\\SCC\\Coursework\\shareBrokerSetup\\shares.xml";
        File xml = new File(filepath);
        String userInput = input.toUpperCase();
        Share share;
        Shares shares = unmarshalAll();
        List<Share> sharesList = shares.getShare();
        Iterator i = sharesList.iterator();
        while(i.hasNext()){
            share = (Share) i.next();
            if (share.getCompanyName().toUpperCase().equals(userInput)) {
                int sharequant = share.getAvailableShareQuant().intValue();
                int val = sharequant + quantAvailable;
                share.setAvailableShareQuant(BigInteger.valueOf(val));
            }
        }
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shares, xml);
            
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return sharesList;
    }
    
    
    @WebMethod(operationName = "searchShare")
    public List<Share> searchShare(@WebParam(name = "searchValue") String searchValue) {
        String searchParam = searchValue.toUpperCase();
        Shares shares = unmarshalAll();
        Share share;
        SharePrice price;
        List<Share> output = shares.getShare();
        Shares newShares = new Shares();
        List<Share> newOutput = newShares.getShare();
        
        Iterator i = output.iterator();
        while(i.hasNext()) {
            boolean flag = false;
            share = (Share) i.next();
            
            Iterator j = share.getSharePrice().iterator();
            while(j.hasNext()){
                price = (SharePrice) j.next();
                
                try {
                    if ((share.getCompanyName().toUpperCase().contains(searchParam)) || (share.getCompanySymbol().toUpperCase().contains(searchParam))){
                        flag = true;
                        break;
                    } else if ((price.getCurrencyValue() < Float.parseFloat(searchParam)) && (price.getCurrencyValue() > 0)){
                        flag = true;
                        break;
                    }
                    
                } catch (NumberFormatException e) {
                    flag = false;
                }
            }
            if (flag == true) {
                newOutput.add(share);
            }
            
        }
        return newOutput;
    }
    
    @WebMethod(operationName = "searchHighestPrice")
    public List<Share> searchHighestPrice() {
         String filepath = "E:\\Final Year\\SCC\\Coursework\\shareBrokerSetup\\shares.xml";
        /*File xml = new File(filepath);
        Shares shares = unmarshalAll();
        List<Share> listShares = shares.getShare();
        Shares newShares = new Shares();
        List<Share> newOutput = newShares.getShare();
        SharePrice sharePrice;
        Share share = new Share();
        float largest = 0;
        for (int x = 0; x < listShares.size(); x++) {
            if(largest < listShares.get(x).getSharePrice().get(x).getCurrencyValue()){
                share = listShares.get(x);
                largest = listShares.get(x).getSharePrice().get(x).getCurrencyValue();
            }
        }
       
        newOutput.add(share);*/
        
        Shares shares = unmarshalAll();
        Share share;
        SharePrice sharePrice;
        List<Share> returnList = shares.getShare();
        float largest = 0;
        
        Shares newShares = new Shares();
        List<Share> newList = newShares.getShare();
        
        Share largestShare = new Share();
        
        Iterator i = returnList.iterator();
        while(i.hasNext()){
            share = (Share) i.next();
            Iterator j = share.getSharePrice().iterator();
            while(j.hasNext()){
                sharePrice = (SharePrice)j.next();
                try{
                    if(sharePrice.getCurrencyValue() > largest) {
                        largest = sharePrice.getCurrencyValue();
                        largestShare = share;
                    }
                } catch (Exception e) {
                   /*do something with exception*/
                }
            }
        }
        
        newList.add(largestShare);
        
        return newList;
    }
    
}
