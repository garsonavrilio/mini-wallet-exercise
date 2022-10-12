package com.example.miniwalletexercise.filter;

import static com.example.miniwalletexercise.constant.HeaderConstant.AUTHORIZATION;

import com.example.miniwalletexercise.constant.ApiConstant;
import com.example.miniwalletexercise.service.auth.AuthService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationFilter implements Filter {

  @Autowired
  private AuthService authService;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    if (req.getRequestURI().equals(ApiConstant.INIT)) {
      chain.doFilter(request, response);
    } else {
      if (authService.hasAccess(req.getHeader(AUTHORIZATION))) {
        chain.doFilter(request, response);
      } else {
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized : Invalid Token");
      }
    }
  }
}
