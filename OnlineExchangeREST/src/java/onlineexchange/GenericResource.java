/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexchange;

import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * REST Web Service
 *
 * @author n0650128
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of onlineexchange.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String fetchExchange(String symbol) throws IOException {
        String finalVal="";
        try {
            symbol = "CAD";
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + symbol + "&symbols=GBP");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(conn.getResponseCode() != 200) {
                //throw new IOException(conn.getResponseMessage());
                return finalVal = "1";
            }
            BufferedReader ins = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inString;
            StringBuilder sb = new StringBuilder();
            while((inString = ins.readLine())!= null) {
                sb.append(inString);
            }
            String newString = sb.toString();
            
            finalVal = newString.replaceAll("[^0-9\\.]","");
            
            
        } catch(MalformedURLException e){
            
        }
        return finalVal;
    }
}
