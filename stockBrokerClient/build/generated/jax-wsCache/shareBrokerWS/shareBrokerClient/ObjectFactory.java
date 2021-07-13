
package shareBrokerClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the shareBrokerClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuyShares_QNAME = new QName("http://shareBrokerWS/", "buyShares");
    private final static QName _BuySharesResponse_QNAME = new QName("http://shareBrokerWS/", "buySharesResponse");
    private final static QName _GetAvailableShares_QNAME = new QName("http://shareBrokerWS/", "getAvailableShares");
    private final static QName _GetAvailableSharesResponse_QNAME = new QName("http://shareBrokerWS/", "getAvailableSharesResponse");
    private final static QName _SearchHighestPrice_QNAME = new QName("http://shareBrokerWS/", "searchHighestPrice");
    private final static QName _SearchHighestPriceResponse_QNAME = new QName("http://shareBrokerWS/", "searchHighestPriceResponse");
    private final static QName _SearchShare_QNAME = new QName("http://shareBrokerWS/", "searchShare");
    private final static QName _SearchShareResponse_QNAME = new QName("http://shareBrokerWS/", "searchShareResponse");
    private final static QName _SellShares_QNAME = new QName("http://shareBrokerWS/", "sellShares");
    private final static QName _SellSharesResponse_QNAME = new QName("http://shareBrokerWS/", "sellSharesResponse");
    private final static QName _UnmarshalAll_QNAME = new QName("http://shareBrokerWS/", "unmarshalAll");
    private final static QName _UnmarshalAllResponse_QNAME = new QName("http://shareBrokerWS/", "unmarshalAllResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: shareBrokerClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnmarshalAllResponse }
     * 
     */
    public UnmarshalAllResponse createUnmarshalAllResponse() {
        return new UnmarshalAllResponse();
    }

    /**
     * Create an instance of {@link Shares }
     * 
     */
    public Shares createShares() {
        return new Shares();
    }

    /**
     * Create an instance of {@link Share }
     * 
     */
    public Share createShare() {
        return new Share();
    }

    /**
     * Create an instance of {@link BuyShares }
     * 
     */
    public BuyShares createBuyShares() {
        return new BuyShares();
    }

    /**
     * Create an instance of {@link BuySharesResponse }
     * 
     */
    public BuySharesResponse createBuySharesResponse() {
        return new BuySharesResponse();
    }

    /**
     * Create an instance of {@link GetAvailableShares }
     * 
     */
    public GetAvailableShares createGetAvailableShares() {
        return new GetAvailableShares();
    }

    /**
     * Create an instance of {@link GetAvailableSharesResponse }
     * 
     */
    public GetAvailableSharesResponse createGetAvailableSharesResponse() {
        return new GetAvailableSharesResponse();
    }

    /**
     * Create an instance of {@link SearchHighestPrice }
     * 
     */
    public SearchHighestPrice createSearchHighestPrice() {
        return new SearchHighestPrice();
    }

    /**
     * Create an instance of {@link SearchHighestPriceResponse }
     * 
     */
    public SearchHighestPriceResponse createSearchHighestPriceResponse() {
        return new SearchHighestPriceResponse();
    }

    /**
     * Create an instance of {@link SearchShare }
     * 
     */
    public SearchShare createSearchShare() {
        return new SearchShare();
    }

    /**
     * Create an instance of {@link SearchShareResponse }
     * 
     */
    public SearchShareResponse createSearchShareResponse() {
        return new SearchShareResponse();
    }

    /**
     * Create an instance of {@link SellShares }
     * 
     */
    public SellShares createSellShares() {
        return new SellShares();
    }

    /**
     * Create an instance of {@link SellSharesResponse }
     * 
     */
    public SellSharesResponse createSellSharesResponse() {
        return new SellSharesResponse();
    }

    /**
     * Create an instance of {@link UnmarshalAll }
     * 
     */
    public UnmarshalAll createUnmarshalAll() {
        return new UnmarshalAll();
    }

    /**
     * Create an instance of {@link SharePrice }
     * 
     */
    public SharePrice createSharePrice() {
        return new SharePrice();
    }

    /**
     * Create an instance of {@link UnmarshalAllResponse.Return }
     * 
     */
    public UnmarshalAllResponse.Return createUnmarshalAllResponseReturn() {
        return new UnmarshalAllResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "buyShares")
    public JAXBElement<BuyShares> createBuyShares(BuyShares value) {
        return new JAXBElement<BuyShares>(_BuyShares_QNAME, BuyShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuySharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "buySharesResponse")
    public JAXBElement<BuySharesResponse> createBuySharesResponse(BuySharesResponse value) {
        return new JAXBElement<BuySharesResponse>(_BuySharesResponse_QNAME, BuySharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "getAvailableShares")
    public JAXBElement<GetAvailableShares> createGetAvailableShares(GetAvailableShares value) {
        return new JAXBElement<GetAvailableShares>(_GetAvailableShares_QNAME, GetAvailableShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "getAvailableSharesResponse")
    public JAXBElement<GetAvailableSharesResponse> createGetAvailableSharesResponse(GetAvailableSharesResponse value) {
        return new JAXBElement<GetAvailableSharesResponse>(_GetAvailableSharesResponse_QNAME, GetAvailableSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHighestPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "searchHighestPrice")
    public JAXBElement<SearchHighestPrice> createSearchHighestPrice(SearchHighestPrice value) {
        return new JAXBElement<SearchHighestPrice>(_SearchHighestPrice_QNAME, SearchHighestPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHighestPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "searchHighestPriceResponse")
    public JAXBElement<SearchHighestPriceResponse> createSearchHighestPriceResponse(SearchHighestPriceResponse value) {
        return new JAXBElement<SearchHighestPriceResponse>(_SearchHighestPriceResponse_QNAME, SearchHighestPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchShare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "searchShare")
    public JAXBElement<SearchShare> createSearchShare(SearchShare value) {
        return new JAXBElement<SearchShare>(_SearchShare_QNAME, SearchShare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchShareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "searchShareResponse")
    public JAXBElement<SearchShareResponse> createSearchShareResponse(SearchShareResponse value) {
        return new JAXBElement<SearchShareResponse>(_SearchShareResponse_QNAME, SearchShareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "sellShares")
    public JAXBElement<SellShares> createSellShares(SellShares value) {
        return new JAXBElement<SellShares>(_SellShares_QNAME, SellShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "sellSharesResponse")
    public JAXBElement<SellSharesResponse> createSellSharesResponse(SellSharesResponse value) {
        return new JAXBElement<SellSharesResponse>(_SellSharesResponse_QNAME, SellSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnmarshalAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "unmarshalAll")
    public JAXBElement<UnmarshalAll> createUnmarshalAll(UnmarshalAll value) {
        return new JAXBElement<UnmarshalAll>(_UnmarshalAll_QNAME, UnmarshalAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnmarshalAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shareBrokerWS/", name = "unmarshalAllResponse")
    public JAXBElement<UnmarshalAllResponse> createUnmarshalAllResponse(UnmarshalAllResponse value) {
        return new JAXBElement<UnmarshalAllResponse>(_UnmarshalAllResponse_QNAME, UnmarshalAllResponse.class, null, value);
    }

}
