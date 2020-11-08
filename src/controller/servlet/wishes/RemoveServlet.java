package controller.servlet.wishes;

import app.AppContext;
import bean.remote.WishBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/galleria.remove(wish)")
public class RemoveServlet extends HttpServlet {

    @EJB
    private WishBeanRemote wishBeanRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppContext appContext = AppContext.parseContext(req.getServletContext());
        String UID = appContext.getUserID();
        String IID = req.getParameter("id");
        wishBeanRemote.removeImageFromWishlist(IID, UID);
        resp.sendRedirect("galleria.oh?p=d");
    }
}
