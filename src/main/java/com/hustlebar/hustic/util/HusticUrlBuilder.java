package com.hustlebar.hustic.util;

/**
 * @author tham
 */

public class HusticUrlBuilder {

    public static final String buildGet(HusticClientWrapper wrapper,
                              String index, String type, String id) {
        return new StringBuilder(buildBase(wrapper, index, type))
                .append("/")
                .append(id)
                .toString();
    }

    private static final String buildBase(HusticClientWrapper wrapper,
                                          String index, String type) {
        return new StringBuilder(wrapper.getBaseUri())
                .append("/")
                .append(index)
                .append("/")
                .append(type)
                .toString();
    }
}
