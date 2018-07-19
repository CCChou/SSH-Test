//package fortesting.hibernate.transaction;
//
//import java.io.IOException;
//
//import javax.annotation.Resource;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;

// TODO use spring AOP replace this

//@Component
//@WebFilter(urlPatterns={"/*"})
//public class SessionFilter extends GenericFilterBean {
//    @Resource
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            sessionFactory.getCurrentSession().beginTransaction();
//            chain.doFilter(request, response);
//            sessionFactory.getCurrentSession().getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            sessionFactory.getCurrentSession().getTransaction().rollback();
//            chain.doFilter(request, response);
//        }
//    }
//}
