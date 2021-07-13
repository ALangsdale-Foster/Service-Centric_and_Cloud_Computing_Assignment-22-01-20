<%-- 
    Document   : index
    Author     : n0650128
--%>

<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Broker WS</title>
    </head>
    <body>
        <h1>Stock Broker WS</h1>
        
        

            <%-- start web service invocation --%><hr/>
    <form method ="post">
        <input type="submit" name ="getShares" value ="Display All Shares">
    
    <%
        if (request.getParameter("getShares") != null) {
    try {
	shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
	shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
	// TODO process result here
	java.util.List<shareBrokerClient.Share> output = port.getAvailableShares();
	java.util.List<shareBrokerClient.SharePrice> priceOutput;
        out.println("<table bg-color=#ddd>");
        out.println("<tr>");
        out.println("<th>Company Name</th>");
        out.println("<th>Company Symbol</th>");
        out.println("<th>Shares Available</th>");
        out.println("<th>Price</th>");
        out.println("<th>Currency</th>");
        out.println("<th>Last Update</th>");
        out.println("</tr>");
        
        for(int i = 0; i < output.size(); i++) {
            out.println("<tr>");
            out.println("<th>" + output.get(i).getCompanyName() + "</th>");
            out.println("<th>" + output.get(i).getCompanySymbol() + "</th>");
            out.println("<th>" + output.get(i).getAvailableShareQuant() + "</th>");
            
            priceOutput = output.get(i).getSharePrice();
            for(int j = 0; j < priceOutput.size(); j++) {
                out.println("<th>" + priceOutput.get(j).getCurrencyValue());
                out.println("<th>" + priceOutput.get(j).getCurrencyName());
                out.println("<th>" + priceOutput.get(j).getLastUpdated());
                out.println("</tr>");
            }
        }
        out.println("</table>");
    } catch (Exception ex) {

    }
        }
    %>
    </form>
    <%-- end web service invocation --%><hr/>
    <form method ="post">
        <input type ="submit" name ="search" value="Search For Share">
        <input type ="text" name="searchVal" placeholder ="Enter Name Here">
            <%-- start web service invocation --%><hr/>
            
    <%
        if(request.getParameter("search") != null){
           
    try {
	shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
	shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
	String searchString = request.getParameter("searchVal");
	java.lang.String searchValue = searchString;
	// TODO process result here
	java.util.List<shareBrokerClient.Share> output = port.searchShare(searchValue);
        java.util.List<shareBrokerClient.SharePrice> priceOutput;
	out.println("<table bg-color=#dddddd>");
        out.println("<tr>");
        out.println("<th>Company Name</th>");
        out.println("<th>Company Symbol</th>");
        out.println("<th>Shares Available</th>");
        out.println("<th>Price</th>");
        out.println("<th>Currency</th>");
        out.println("<th>Last Update</th>");
        out.println("</tr>");
        
        for(int i = 0; i < output.size(); i++) {
            if(output.get(i).getAvailableShareQuant().intValue() > 0) {
                out.println("<tr>");
                out.println("<th>" + output.get(i).getCompanyName() + "</th>");
                out.println("<th>" + output.get(i).getCompanySymbol() + "</th>");
                out.println("<th>" + output.get(i).getAvailableShareQuant() + "</th>");
                
                priceOutput = output.get(i).getSharePrice();
                for(int j = 0; j < priceOutput.size(); j++) {
                    out.println("<th>" + priceOutput.get(j).getCurrencyValue());
                    out.println("<th>" + priceOutput.get(j).getCurrencyName());
                    out.println("<th>" + priceOutput.get(j).getLastUpdated());
                    out.println("</tr>");
                }
            }
        }
        out.println("</table>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
        }
    %>
    <%-- end web service invocation --%><hr/>

    </form>
    
    <form method ="post">
        <input type="submit" name ="buyShare" value="buyShare">
        <input type="text" name ="input" placeholder ="Enter Company">
        <input type="text" name ="quant" placeholder ="Enter Quantity">
    <%-- start web service invocation --%><hr/>
    <%
        if(request.getParameter("buyShare") != null) {
    try {
	shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
	shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
	 // TODO initialize WS operation arguments here
	int quantity = Integer.parseInt(request.getParameter("quant"));
	java.lang.String shareSymbol = request.getParameter("input");
	// TODO process result here
	java.util.List<shareBrokerClient.Share> output = port.buyShares(quantity, shareSymbol);
        java.util.List<shareBrokerClient.SharePrice> priceOutput;
	out.println("<table>");
        out.println("<tr>");
        out.println("<th>Company Name</th>");
        out.println("<th>Company Symbol</th>");
        out.println("<th>Shares Available</th>");
        out.println("<th>Price</th>");
        out.println("<th>Currency</th>");
        out.println("<th>Last Update</th>");
        out.println("</tr>");
        
        for(int i = 0; i < output.size(); i++) {
            if(output.get(i).getAvailableShareQuant().intValue() > 0) {
                out.println("<tr>");
                out.println("<th>" + output.get(i).getCompanyName() + "</th>");
                out.println("<th>" + output.get(i).getCompanySymbol() + "</th>");
                out.println("<th>" + output.get(i).getAvailableShareQuant() + "</th>");
                
                priceOutput = output.get(i).getSharePrice();
                for(int j = 0; j < priceOutput.size(); j++) {
                    out.println("<th>" + priceOutput.get(j).getCurrencyValue());
                    out.println("<th>" + priceOutput.get(j).getCurrencyName());
                    out.println("<th>" + priceOutput.get(j).getLastUpdated());
                    out.println("</tr>");
                }
            }
        }
        out.println("</table>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
        }
    %>
    <%-- end web service invocation --%><hr/>
    </form>
    
    <form method = "post">
        <input type ="submit" name="sellShare" value="sellShare">
        <input type="text" name="userInput" placeholder="Enter Company Name">
        <input type="text" name="shareQuant" placeholder="Enter Quantity">
        <%-- start web service invocation --%><hr/>
    <%
        if(request.getParameter("sellShare") != null){
    try {
	shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
	shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String userInput = request.getParameter("userInput");
	int quantAvailable = Integer.parseInt(request.getParameter("shareQuant"));
	// TODO process result here
	java.util.List<shareBrokerClient.Share> output = port.sellShares(userInput, quantAvailable);
	java.util.List<shareBrokerClient.SharePrice> priceOutput;
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Company Name</th>");
        out.println("<th>Company Symbol</th>");
        out.println("<th>Shares Available</th>");
        out.println("<th>Price</th>");
        out.println("<th>Currency</th>");
        out.println("<th>Last Update</th>");
        out.println("</tr>");
        
        for(int i = 0; i < output.size(); i++) {
            out.println("<tr>");
            out.println("<th>" + output.get(i).getCompanyName() + "</th>");
            out.println("<th>" + output.get(i).getCompanySymbol() + "</th>");
            out.println("<th>" + output.get(i).getAvailableShareQuant() + "</th>");
            
            priceOutput = output.get(i).getSharePrice();
            for(int j = 0; j < priceOutput.size(); j++) {
                out.println("<th>" + priceOutput.get(j).getCurrencyValue());
                out.println("<th>" + priceOutput.get(j).getCurrencyName());
                out.println("<th>" + priceOutput.get(j).getLastUpdated());
                out.println("</tr>");
            }
        }
        out.println("</table>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
        }
    %>
    <%-- end web service invocation --%><hr/>
    
    </form>
    
    <form method = get>
        <input type ="submit" name="getHighest" value ="getHighest"
            <%-- start web service invocation --%><hr/>
    <%
        if(request.getParameter("getHighest") != null) {
    try {
	shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
	shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
	// TODO process result here
	java.util.List<shareBrokerClient.Share> output = port.searchHighestPrice();
        java.util.List<shareBrokerClient.SharePrice> priceOutput;
	out.println("<table>");
        out.println("<tr>");
        out.println("<th>Company Name</th>");
        out.println("<th>Company Symbol</th>");
        out.println("<th>Shares Available</th>");
        out.println("<th>Price</th>");
        out.println("<th>Currency</th>");
        out.println("<th>Last Update</th>");
        out.println("</tr>");
        
        for(int i = 0; i < output.size(); i++) {
            if(output.get(i).getAvailableShareQuant().intValue() > 0) {
                out.println("<tr>");
                out.println("<th>" + output.get(i).getCompanyName() + "</th>");
                out.println("<th>" + output.get(i).getCompanySymbol() + "</th>");
                out.println("<th>" + output.get(i).getAvailableShareQuant() + "</th>");
                
                priceOutput = output.get(i).getSharePrice();
                for(int j = 0; j < priceOutput.size(); j++) {
                    out.println("<th>" + priceOutput.get(j).getCurrencyValue());
                    out.println("<th>" + priceOutput.get(j).getCurrencyName());
                    out.println("<th>" + priceOutput.get(j).getLastUpdated());
                    out.println("</tr>");
                }
            }
        }
        out.println("</table>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
        }
    %>
    <%-- end web service invocation --%><hr/>

    </form>
    <table>
    <form method = "get">
        <select name ="selectCurrency" onchange=" this.form.submit()">
               <%-- start web service invocation --%><hr/>
    <%
    try {
	docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
	docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
	// TODO process result here
	java.util.List<java.lang.String> result = port.getCurrencyCodes();
	Iterator i = result.iterator();
        while(i.hasNext()) {
            String code = (String) i.next();
            out.println("<option id='" + code.substring(0, 3) + "'value='" + code.substring(0, 3) + "'>" + code + "</option>");
        }
    } catch (Exception ex) {
    }
    %>
    <%-- end web service invocation --%><hr/>
 
    </form>
    <form>
        <form method ="get">
            <%
                String selection = "";
        double conversionVal = 0.0;
        if(request.getParameter("selectCurrency") != null){
            String symbol = request.getParameter("selectCurrency");
            URL url = new URL("http://localhost:9090/stockBrokerClient/webresources/exchangeAPI?symbol=" + symbol );
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            if(conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            } 
            
            BufferedReader ins = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String inString;
            
            StringBuilder sb = new StringBuilder();
           
            while((inString = ins.readLine())!= null) {
                sb.append(inString);
            }
            
            String newString = sb.toString();
            
            double val = Double.parseDouble(newString);
            
            ins.close();
            
            try {
            shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
            shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
            java.util.List<shareBrokerClient.Share> result = port.getAvailableShares();
            java.util.List<shareBrokerClient.SharePrice> price;
            out.println("<tr>");
            out.println("<th>Company Name</th>");
            out.println("<th>Company Symbol</th>");
            out.println("<th>Quantity Available</th>");
            out.println("<th>Currency</th>");
            out.println("<th>Price</th>");
            out.println("<th>Last Update</th>");
            for (int i = 0; i < result.size(); i++){
                out.println("<th>" + result.get(i).getCompanyName() + "</th>");
                out.println("<th>" + result.get(i).getCompanySymbol() + "</th>");
                out.println("<th>" + result.get(i).getAvailableShareQuant() + "</th>");
                price = result.get(i).getSharePrice();
                for (int j = 0; j < price.size(); j++) {
                    double prices = price.get(j).getCurrencyValue();
                    double output = prices/val;
                    
                    out.println("<th>" + symbol + "</th>");
                    out.println("<th>" + output + "</th>");
                    out.println("<th>" + price.get(j).getLastUpdated() + "</th>");
                    out.println("</tr>");
                }
            }
        } catch(Exception e) {
        }
        }

                %>
        </form>
    </form>
    </table>
    <table>
        <table>
    <form method = "get">
        <select name ="selectCurrency" onchange=" this.form.submit()">
               <%-- start web service invocation --%><hr/>
    <%
    try {
	docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
	docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
	// TODO process result here
	java.util.List<java.lang.String> result = port.getCurrencyCodes();
	Iterator i = result.iterator();
        while(i.hasNext()) {
            String code = (String) i.next();
            out.println("<option id='" + code.substring(0, 3) + "'value='" + code.substring(0, 3) + "'>" + code + "</option>");
        }
    } catch (Exception ex) {
    }
    %>
    <%-- end web service invocation --%><hr/>
 
    </form>
    <form method = post>
        <%
        String selection2 = "";
        double conversionVal2 = 0.0;
        if(request.getParameter("selectCurrency") != null){
            String selectCurr = request.getParameter("selectCurrency");
            try{
                docwebservices.CurrencyConversionWSService service = new docwebservices.CurrencyConversionWSService();
                docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
                java.lang.String arg0 = "GBP";
                java.lang.String arg1 = selectCurr.substring(0,3);
                selection2 = arg1;
                double result = port.getConversionRate(arg0, arg1);
                conversionVal2 = result;
            }catch (Exception e) {
            
            }
        
        
        try {
            shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
            shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
            java.util.List<shareBrokerClient.Share> result = port.getAvailableShares();
            java.util.List<shareBrokerClient.SharePrice> price;
            out.println("<tr>");
            out.println("<th>Company Name</th>");
            out.println("<th>Company Symbol</th>");
            out.println("<th>Quantity Available</th>");
            out.println("<th>Currency</th>");
            out.println("<th>Price</th>");
            out.println("<th>Last Update</th>");
            for (int i = 0; i < result.size(); i++){
                out.println("<th>" + result.get(i).getCompanyName() + "</th>");
                out.println("<th>" + result.get(i).getCompanySymbol() + "</th>");
                out.println("<th>" + result.get(i).getAvailableShareQuant() + "</th>");
                price = result.get(i).getSharePrice();
                for (int j = 0; j < price.size(); j++) {
                    DecimalFormat df = new DecimalFormat("0.00##");
                    String decResult = df.format(price.get(j).getCurrencyValue() * conversionVal2);
                    out.println("<th>" + selection2 + "</th>");
                    out.println("<th>" + decResult + "</th>");
                    out.println("<th>" + price.get(j).getLastUpdated() + "</th>");
                    out.println("</tr>");
                }
            }
        } catch(Exception e) {
        }
        }  else {
                try {
                    shareBrokerClient.ShareBrokerWS_Service service = new shareBrokerClient.ShareBrokerWS_Service();
            shareBrokerClient.ShareBrokerWS port = service.getShareBrokerWSPort();
            java.util.List<shareBrokerClient.Share> result = port.getAvailableShares();
            java.util.List<shareBrokerClient.SharePrice> price;
            out.println("<tr>");
            out.println("<th>Company Name</th>");
            out.println("<th>Company Symbol</th>");
            out.println("<th>Quantity Available</th>");
            out.println("<th>Currency</th>");
            out.println("<th>Price</th>");
            out.println("<th>Last Update</th>");
            for (int i = 0; i < result.size(); i++){
                out.println("<th>" + result.get(i).getCompanyName() + "</th>");
                out.println("<th>" + result.get(i).getCompanySymbol() + "</th>");
                out.println("<th>" + result.get(i).getAvailableShareQuant() + "</th>");
                price = result.get(i).getSharePrice();
                for (int j = 0; j < price.size(); j++) {
                    DecimalFormat df = new DecimalFormat("0.00##");
                    Double GBP = 1.0;
                    String decResult = df.format(price.get(j).getCurrencyValue() * GBP);
                    out.println("<th>" + "GBP" + "</th>");
                    out.println("<th>" + decResult + "</th>");
                    out.println("<th>" + price.get(j).getLastUpdated() + "</th>");
                    out.println("</tr>");
                }
            }
        } catch(Exception e) {
        }
                }
        %>
    </form>
    </table>
    </body>
</html>
