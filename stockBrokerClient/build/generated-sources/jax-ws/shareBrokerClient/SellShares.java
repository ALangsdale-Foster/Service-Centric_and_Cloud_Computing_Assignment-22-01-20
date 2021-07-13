
package shareBrokerClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sellShares complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sellShares"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userInput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantAvailable" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sellShares", propOrder = {
    "userInput",
    "quantAvailable"
})
public class SellShares {

    protected String userInput;
    protected int quantAvailable;

    /**
     * Gets the value of the userInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserInput() {
        return userInput;
    }

    /**
     * Sets the value of the userInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserInput(String value) {
        this.userInput = value;
    }

    /**
     * Gets the value of the quantAvailable property.
     * 
     */
    public int getQuantAvailable() {
        return quantAvailable;
    }

    /**
     * Sets the value of the quantAvailable property.
     * 
     */
    public void setQuantAvailable(int value) {
        this.quantAvailable = value;
    }

}
