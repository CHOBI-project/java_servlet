package io.github.java_servlet.Counter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/*
アプリケーションスコープでどこのサーブレットでもgetできるようになっている。UraniServletに追加してみた
 */
@WebListener
public class CounterListener implements ServletContextListener {
    //アプリケーション起動時の処理
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Integer count = 0;
        context.setAttribute("count", count);
        System.out.println("アプリが起動しました");
    }

    //アプリケーション終了時の処理
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("アプリが終了しました");
    }
}
