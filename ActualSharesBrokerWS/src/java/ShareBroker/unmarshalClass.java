/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShareBroker;
import generated.*;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author n0650128
 */
public class unmarshalClass {
    public static void main(String[] args) {
        unmarshalClass unmarshal = new unmarshalClass();
        unmarshal.getShares();
    }

    public List<Share> getShares() {
        File xml = new File("shares.xml");
        Shares shares = new Shares();
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            shares = (Shares) unmarshaller.unmarshal(xml); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        List<Share> output = shares.getShare();
        return output;
    }
}
