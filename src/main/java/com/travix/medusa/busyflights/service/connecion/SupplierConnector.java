package com.travix.medusa.busyflights.service.connecion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Sends a POST request to a supplier.
 *
 * @author Anna_Kovacshazi
 */
//TODO refactor the whole class, try to use some other JSON parser
public class SupplierConnector {
    private final Logger logger = LoggerFactory.getLogger(SupplierConnector.class);

    //TODO this method could be instrumented
    public Object send(JSONObject jsonObject, String uri, Class c) {
        Object response = new Object();
        URL url = null;
        try {
            url = new URL(uri);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(jsonObject.toString());
            out.close();
            response = convertStreamToObject(connection.getInputStream(), c);
        } catch (Exception e) {
            //TODO do something with the error
            logger.error("Error occurred during calling uri: " + uri + ", with" + jsonObject.toString());
            logger.error(e.getMessage(), e.getCause());
        }
        return response;
    }

    //TODO can be done better
    private static Object convertStreamToObject(InputStream is, Class c) {
        Object response = null;
        String line;

        if (c.equals(ToughJetResponse.class)) {
            response = new ArrayList<ToughJetResponse>();
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<ToughJetResponse>>() {}.getType();
                response = gson.fromJson(line, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}