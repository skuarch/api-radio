package interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import model.bean.RequestBean;
import model.repository.request.RequestBeanRepository;

/**
 *
 * @author skuarch
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private RequestBeanRepository requestBeanRepository;
    private static final Logger LOGGER = Logger.getLogger(RequestInterceptor.class);

    // ==========================================================================
    /**
     * prehandle.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param object Object
     * @return boolean
     * @throws Exception if something is wrong
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        return true;
    }

    // ==========================================================================
    /**
     * empty.
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param o Object
     * @param mav ModelAndView
     * @throws Exception if something happens
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav)
            throws Exception {
        // empty
    }

    // ==========================================================================
    /**
     * empty.
     *
     * @param request HttpServletRequest
     * @param hsr1 HttpServletResponse
     * @param o Object
     * @param excptn Exception
     * @throws Exception if something happens
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse hsr1, Object o, Exception excptn)
            throws Exception {
        createRequestBean(request);
    }

    // ==========================================================================
    /**
     * save request into DB.
     *
     * @param req HttpServletRequest
     */
    private void createRequestBean(final HttpServletRequest req) {

        HttpServletRequestWrapper request = new HttpServletRequestWrapper(req);
        RequestBean requestBean = new RequestBean();

        try {

            if (request.getRequestURL().toString() != null) {
                requestBean.setUrl(request.getRequestURL().toString());
            }

            if (request.getRemoteHost() != null) {
                requestBean.setRemoteHost(request.getRemoteHost());
            }

            if (request.getContentType() != null) {
                requestBean.setContentType(request.getContentType());
            }

            if (request.getRemoteHost() != null) {
                requestBean.setRemoteHost(request.getRemoteHost());
            }

            if (request.getLocalAddr() != null) {
                requestBean.setLocalAddress(request.getLocalAddr());
            }

            if (request.getMethod() != null) {
                requestBean.setMethod(request.getMethod());
            }

            if (request.getPathInfo() != null) {
                requestBean.setPathInfo(request.getPathInfo());
            }

            if (request.getProtocol() != null) {
                requestBean.setProtocol(request.getProtocol());
            }

            if (request.getRemoteUser() != null) {
                requestBean.setRemoteUser(request.getRemoteUser());
            }

            if (request.getRequestURI() != null) {
                requestBean.setUri(request.getRequestURI());
            }

            if (request.getScheme() != null) {
                requestBean.setScheme(request.getScheme());
            }

            if (request.getServletPath() != null) {
                requestBean.setServletPath(request.getServletPath());
            }

            requestBean.setContentLength(request.getContentLength());

            requestBean.setRemotePort(request.getRemotePort());

            requestBean.setLocalPort(request.getLocalPort());

            if (request.getHeaderNames() != null) {
                Enumeration<String> e = request.getHeaderNames();
                StringBuilder sb = new StringBuilder();
                while (e.hasMoreElements()) {
                    sb.append(e.nextElement()).append(", ");
                }
                requestBean.setHeaderNames(sb.toString());
            }

            if (request.getAttributeNames() != null) {
                Enumeration<String> e = request.getAttributeNames();
                StringBuilder sb = new StringBuilder();
                while (e.hasMoreElements()) {
                    sb.append(e.nextElement()).append(", ");
                }
                requestBean.setAttributesNames(sb.toString());
            }

            if (request.getAuthType() != null) {
                requestBean.setAuthType(request.getAuthType());
            }

            if (request.getCharacterEncoding() != null) {
                requestBean.setCharacterEncoding(request.getCharacterEncoding());
            }

            if (request.getScheme() != null) {
                requestBean.setScheme(request.getScheme());
            }

            if (request.getLocale() != null) {
                requestBean.setLocale(request.getLocale().toString());
            }

            if (request.getParameterNames() != null) {
                Enumeration<String> e = request.getParameterNames();
                StringBuilder sb = new StringBuilder();
                while (e.hasMoreElements()) {
                    sb.append(e.nextElement()).append(", ");
                }
                requestBean.setParameterNames(sb.toString());
            }

            if (request.getHeader("User-Agent") != null) {
                requestBean.setUserAgent(request.getHeader("User-Agent"));
            }

            if (request.getHeader("Accept-Encoding") != null) {
                requestBean.setAcceptEncoding(request.getHeader("Accept-Encoding"));
            }

            if (request.getHeader("Origin") != null) {
                requestBean.setOrigin(request.getHeader("Origin"));
            }

            if (request.getHeader("Accept") != null) {
                requestBean.setAccept(request.getHeader("Accept"));
            }

            if (request.getHeader("Connection") != null) {
                requestBean.setConnection(request.getHeader("Connection"));
            }

            requestBeanRepository.save(requestBean);

        } catch (Exception e) {
            LOGGER.error("RequestInterceptor.createRequestBean()", e);
        }

    }

} // end class
