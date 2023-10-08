package mx.com.midominio.web;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
//import jakarta.ws.rs.container.ContainerRequestContext;
//import jakarta.ws.rs.container.ContainerResponseContext;
//import jakarta.ws.rs.container.ContainerResponseFilter;
//import jakarta.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * esta clase es la politica de sugiridad de ws sirve para compartir el servicio
 * web entre el cliente y servidor
 *
 * @author david
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        MultivaluedMap<String, Object> headers = crc1.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }

//    @Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
//        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Access-Control-Allow-Credentials", "true");
//        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
//        headers.add("Access-Control-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
//}

}
