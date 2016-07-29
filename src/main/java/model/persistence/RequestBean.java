package model.persistence;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "request")
public class RequestBean implements Serializable {

    private static final long serialVersionUID = 8407192321350802007L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private long id;
    @Column(name = "request_remote_host")
    private String remoteHost;
    @Column(name = "request_content_type")
    private String contentType;
    @Column(name = "request_local_address")
    private String localAddress;
    @Column(name = "request_method")
    private String method;
    @Column(name = "request_path_info")
    private String pathInfo;
    @Column(name = "request_protocol")
    private String protocol;
    @Column(name = "request_remote_user")
    private String remoteUser;
    @Column(name = "request_uri")
    private String uri;
    @Column(name = "request_scheme")
    private String scheme;
    @Column(name = "request_servlet_path")
    private String servletPath;
    @Column(name = "request_content_length")
    private int contentLength;
    @Column(name = "request_url")
    private String url;
    @Column(name = "request_remote_port")
    private int remotePort;
    @Column(name = "request_local_port")
    private int localPort;
    @Column(name = "request_header_names")
    private String headerNames;
    @Column(name = "request_attribute_names", columnDefinition = "text")
    private String attributesNames;
    @Column(name = "request_auth_type")
    private String authType;
    @Column(name = "request_charactect_encoding")
    private String characterEncoding;
    @Column(name = "request_locale")
    private String locale;
    @Column(name = "request_parameter_names", columnDefinition = "text")
    private String parameterNames;
    @Column(name = "request_user_agent")
    private String userAgent;
    @Column(name = "request_accept_encoding")
    private String acceptEncoding;
    @Column(name = "request_origin")
    private String origin;
    @Column(name = "request_accept")
    private String accept;
    @Column(name = "request_connection")
    private String connection;
    @Column(name = "request_date")
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    //==========================================================================
    /**
     * getter..
     *
     * @return id long
     */
    public long getId() {
        return id;
    }

    //==========================================================================
    /**
     * setter..
     *
     * @param id long id
     */
    public void setId(long id) {
        this.id = id;
    }

    //==========================================================================
    /**
     * getter..
     *
     * @return String
     */
    public String getRemoteHost() {
        return remoteHost;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param remoteHost String
     */
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getContentType() {
        return contentType;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param contentType String
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getLocalAddress() {
        return localAddress;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param localAddress String
     */
    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getMethod() {
        return method;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param method String
     */
    public void setMethod(String method) {
        this.method = method;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getPathInfo() {
        return pathInfo;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param pathInfo String
     */
    public void setPathInfo(String pathInfo) {
        this.pathInfo = pathInfo;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getProtocol() {
        return protocol;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param protocol String
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getRemoteUser() {
        return remoteUser;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param remoteUser String
     */
    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getUri() {
        return uri;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param uri String
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getScheme() {
        return scheme;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param scheme String
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getServletPath() {
        return servletPath;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param servletPath String
     */
    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public int getContentLength() {
        return contentLength;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param contentLength int
     */
    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getUrl() {
        return url;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public int getRemotePort() {
        return remotePort;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param remotePort int
     */
    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public int getLocalPort() {
        return localPort;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param localPort int
     */
    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getHeaderNames() {
        return headerNames;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param headerNames String
     */
    public void setHeaderNames(String headerNames) {
        this.headerNames = headerNames;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getAttributesNames() {
        return attributesNames;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param attributesNames String
     */
    public void setAttributesNames(String attributesNames) {
        this.attributesNames = attributesNames;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getAuthType() {
        return authType;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param authType String
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getCharacterEncoding() {
        return characterEncoding;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param characterEncoding String
     */
    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getLocale() {
        return locale;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param locale String
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getParameterNames() {
        return parameterNames;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param parameterNames String
     */
    public void setParameterNames(String parameterNames) {
        this.parameterNames = parameterNames;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getUserAgent() {
        return userAgent;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param userAgent String
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param acceptEncoding String
     */
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getOrigin() {
        return origin;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param origin String
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getAccept() {
        return accept;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param accept String
     */
    public void setAccept(String accept) {
        this.accept = accept;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getConnection() {
        return connection;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param connection String
     */
    public void setConnection(String connection) {
        this.connection = connection;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getDate() {
        return date;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param date String
     */
    public void setDate(String date) {
        this.date = date;
    }

}
