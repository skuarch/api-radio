package model.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.log4j.Logger;

/**
 * class for help
 *
 * @author skuarch
 */
public class StationUtilities {

    private static final Logger LOGGER = Logger.getLogger(StationUtilities.class);
    private static final String ERROR_STRING_NULL_EMPTY = "stationurl is null or empty";

    //==========================================================================
    public static String getIPAddress(String stationUrl) {

        if (stationUrl == null || stationUrl.length() < 1 || stationUrl.equals("")) {
            LOGGER.error(ERROR_STRING_NULL_EMPTY);
            return null;
        }

        String[] parts;
        String ip = null;

        try {

            parts = stationUrl.split(":");
            ip = parts[1];
            ip = ip.replace("/", "");
            ip = ip.replace("/", "");

        } catch (Exception e) {
            LOGGER.error("StationUtilities.getIPAddress()", e);
        } finally {
            stationUrl = null;
            parts = null;
        }

        return ip;
    }

    //==========================================================================
    public static int getPort(String stringUrl) {

        if (stringUrl == null || stringUrl.length() < 1 || stringUrl.equals("")) {
            LOGGER.error(ERROR_STRING_NULL_EMPTY);
            return 0;
        }

        int port = 0;
        String[] parts = null;
        String stringPort;

        try {

            parts = stringUrl.split(":");

            if (parts.length != 3) {
                return 80;
            }

            stringPort = cleanString(parts[2]);

            if (parts[2] != null) {
                port = Integer.parseInt(stringPort);
            } else {
                return 80;
            }

        } catch (Exception e) {
            LOGGER.error("StationUtilities.getPort()", e);
            return 80;
        } finally {
            stringUrl = null;
        }

        return port;
    } // end getPort

    //==========================================================================
    public static int getUrlPort(String stringUrl) {

        if (stringUrl == null || stringUrl.length() < 1 || stringUrl.equals("")) {
            LOGGER.error(ERROR_STRING_NULL_EMPTY);
            return 0;
        }

        URL url = null;
        int port = 0;

        try {

            url = new URL(stringUrl);
            port = url.getPort();

        } catch (Exception e) {
            LOGGER.error("StationUtilities.getUrlPort()", e);
        } finally {
            stringUrl = null;
        }

        return port;
    } // end getPort

    //==========================================================================
    public static boolean hasURLPath(String stringUrl) {

        if (stringUrl == null || stringUrl.length() < 1 || stringUrl.equals("")) {
            LOGGER.error(ERROR_STRING_NULL_EMPTY);
            return false;
        }

        URL url;
        URI uri;
        String path;
        boolean flag = false;

        try {

            url = new URL(stringUrl);
            uri = url.toURI();

            path = uri.getPath();

            if (path != null && path.length() > 0) {
                flag = true;
            }

        } catch (MalformedURLException | URISyntaxException e) {
            LOGGER.error("StationUtilities.hasURLPath()", e);
        } finally {
            url = null;
            uri = null;
            path = null;
            stringUrl = null;
        }

        return flag;

    } // end urlHasUri

    //==========================================================================
    public static String cleanString(String string) {

        string = string.replace(";", "");
        string = string.replace("/;", "");
        string = string.replace("\";", "");
        string = string.replace("&", "");
        string = string.replace("?", "");
        string = string.replace("/", "");
        string = string.trim();

        return string;

    }

} // end class
