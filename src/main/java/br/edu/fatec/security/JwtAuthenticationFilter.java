package br.edu.fatec.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import br.edu.fatec.model.Usuario;

public class JwtAuthenticationFilter extends GenericFilterBean {

    private String tokenHeader = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String authorization = servletRequest.getHeader(tokenHeader);
            if (authorization != null) {
                Usuario usuario = JwtUtils.parseToken(authorization.replaceAll("Bearer ",""));
                Authentication credentials = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(credentials);
            
                HttpServletResponse res = (HttpServletResponse) response;

                res.setHeader("Access-Control-Allow-Origin", "*");
                res.setHeader("Access-Control-Allow-Credentials", "true");
                res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                res.setHeader("Access-Control-Max-Age", "3600");
                res.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Token");
                res.setHeader("Access-Control-Expose-Headers", "Token");
            
            
            }
            
    
            chain.doFilter(request, response);
        }
        catch(Throwable t) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());
        }
    }
}