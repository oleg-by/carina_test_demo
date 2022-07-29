package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.utils.R;

import java.util.*;

public class MobileUtils {

    public static Set<String> getListOfProducts() {
        Set<String> productList = new HashSet<>();
        productList.add("Sauce Lab Back Packs");
        if (MobileUtils.isIOS()) {
            productList.add("Sauce Lab Bike Light");
        }
        productList.add("Sauce Lab Bolt T-Shirt");
        productList.add("Sauce Lab Fleece T-Shirt");
        productList.add("Sauce Lab Onesie");
        productList.add("Test.");
        return productList;
    }

    public static SortedMap<String, Double> getMapOfProducts(){
        SortedMap<String, Double> productMap = new TreeMap<>();
        productMap.put("Sauce Lab Back Packs", 29.99);
        productMap.put("Sauce Lab Bike Light", 9.99);
        productMap.put("Sauce Lab Bolt T-Shirt", 15.99);
        productMap.put("Sauce Lab Fleece T-Shirt", 49.99);
        productMap.put("Sauce Lab Onesie", 7.99);
        if (MobileUtils.isIOS()) {
            productMap.put("Test.allTheThings() T-Shirt", 15.99);
        } else {
            productMap.put("Test.sllTheThings() T-Shirt", 15.99);
        }
        return productMap;
    }

    public static boolean isIOS() {
        String platformName = R.CONFIG.get("capabilities.platformName");
        if (platformName.isEmpty() && platformName.length() == 0) {
            throw new RuntimeException("Cannot check platform because platformName capability is empty");
        }
        return platformName.equalsIgnoreCase("IOS");
    }
}
