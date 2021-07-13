### COMP30231 Service-Centric Cloud Computing

The goal of this coursework is to demonstrate an understanding of using Service Oriented Architecture principles in software applications integration. In the first section, 
you will utilise web services to compose a Shares Brokering system. The Shares Brokering system consists of a shares acquisition service that you should build yourself and 
an external currency conversion service that you need to consume and integrate with the shares acquisition service; both services can be complemented by consuming external 
APIs. The research element of the coursework investigates using advanced (semantic-based) techniques to further extend your application.


1. Implement Shares Brokering service
a)	Current shares on trade should be held in an XML file based on an XSD schema containing: company name, company symbol on the stock exchange, number of available shares, a complex ‘share_price’ element containing currency and value, and date of the last-update of the share price. 
	You can opt to use conventional structures to store the data (arrays, Lists, etc.) instead of XML objects. However, this will affect the standard of your work and also progression into Section-B. 
b)	The web service should allow users to list shares details and update the number of shares on offer when a purchase is made. You might opt to utilise JAXB to generate helper Java classes, which allow reading and populating the XML documents.
	You may choose to implement the core Web Service using as a RESTful service, but for full marks you need to evidence that you can build & communicate a Shares data structure similar to what can be provided by an XML Schema as in 1.a) above. 

c)	Implement a search functionality allowing customers to list shares’ offerings using various criteria such as company details, highest price, etc. More sophisticated search functionality will merit higher marks.
	The choice of client is your decision. Java GUI Apps or JSP are more appreciated but should not be attempted at the expense of providing core functionality.

2. Integrate currency conversion service
Download the pre-coded project with the currency conversion web service from the module’s NOW room site and deploy it. Consume the currency conversion service in the shares brokering service to auto-convert the share price rate to the rate preferred by the customer. 
3. Extend functionality by utilising external REST APIs
a)	Research and utilise external RESTful service to extend the functionality of your shares brokering system. Example of such service can be:
•	A service that returns up-to-date currency exchange rate. 
•	A service that returns the latest share value quote for a particular company. 
b)	Implement your own RESTful service to persist the output of the consumed REST API for off-line use. For instance, your RESTful service can update the exchange rate of your currency conversion service or the latest value of the share price.
In order to achieve the highest marks, you must show initiative and inventiveness beyond the stated specification; the contribution of the advanced functionality depends on technical challenge in its implementation. Examples include:
–	utilising additional external REST APIs (e.g. to display relevant tweets or other info about the shares company)
–	implementing non-java clients to demonstrate SOA’s platform independence
–	creating user accounts for clients allowing them to sell shares back to the brokering service
