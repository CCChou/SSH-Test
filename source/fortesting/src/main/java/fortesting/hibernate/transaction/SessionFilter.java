package fortesting.hibernate.transaction;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

@WebFilter(urlPatterns={"/*"})
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try {
            factory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            factory.getCurrentSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            factory.getCurrentSession().getTransaction().rollback();
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
