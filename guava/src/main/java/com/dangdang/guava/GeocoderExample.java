/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.guava;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class GeocoderExample {

    private static final Logger logger = LoggerFactory.getLogger(GeocoderExample.class);

    public static void main(String[] args) {
        
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += i+" ";
        }
        
        try {
            final Geocoder geocoder = new Geocoder();
            GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("朝阳").setLanguage("cn").getGeocoderRequest();
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
            if (geocoderResponse.getStatus() == GeocoderStatus.OK) {
                List<GeocoderResult> results = geocoderResponse.getResults();
                if (results != null && !results.isEmpty()) {
                    for (GeocoderResult result : results) {
                        logger.error("-------begin-------------");
                        String address  = result.getFormattedAddress();
                        logger.info("address is {}",address);
                        
                        List<String> types  = result.getTypes();
                        for (String type : types) {
                            logger.debug("type is {}",type);
                        }
                        LatLng latitudeLongitude = result.getGeometry().getLocation();
                        Float[] coords = new Float[2];
                        coords[0] = latitudeLongitude.getLat().floatValue();
                        coords[1] = latitudeLongitude.getLng().floatValue();
                        logger.info("lat is {},lng is {}", coords[0], coords[1]);
                        logger.error("-------end-------------");
                    }

                }
            }
        } catch (IOException ex) {
            logger.error("", ex);
        }
    }
}
