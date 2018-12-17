package edu.abc.ruanjianbei.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.abc.ruanjianbei.model.bean.UserBean;
import edu.abc.ruanjianbei.model.dao.UserDao;
import edu.abc.ruanjianbei.model.dao.UserDaoImp;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao dao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        dao=new UserDaoImp();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String methodName=request.getParameter("method");
        switch(methodName) {
            case "login":
                login(request,response);
                break;
            case "register":
                register(request,response);
                break;
            case "loginOff":
                loginOff(request,response);
                break;
            case "checkUserExists":
                checkUserExists(request,response);
            default:
                break;
        }

    }
    /*
     * 处理登录方法
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String account=request.getParameter("account").trim();
        String password=request.getParameter("password").trim();
        System.out.println("登录操作"+account+"\t"+password);
        UserBean user=dao.login(account, password);

        if(user!=null){
            //会话范围内存储用户资料
            request.getSession().setAttribute("loginedUser", user);
            String rememberMe=request.getParameter("rememberMe");
            System.out.println("记住我"+rememberMe);
            //用户勾选保存用户名密码就将用户名密码存储在cookie中
            if(rememberMe!=null) {

            }else {

            }

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            request.setAttribute("loginResultInfo", "userError");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    /*
     * 处理注册方法
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String account=request.getParameter("account").trim();
        String password=request.getParameter("password").trim();
        System.out.println("注册操作"+account+"\t"+password);
        UserBean user=new UserBean();
        user.setAccount(account);
        user.setPassword(password);
        boolean result=dao.add(user);
        if(result) {
            request.getSession().setAttribute("loginedUser", user);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else {
            request.setAttribute("loginResultInfo", "registerError");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
    /*
     * 处理注销方法
     */
    protected void loginOff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("退出登陆");
        request.getSession().removeAttribute("loginedUser");
        response.sendRedirect("index.jsp");
    }
    /*
     * 验证注册的用户是否存在
     */
    protected void checkUserExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("ajax检测用户名是否已经存在");
        String account=request.getParameter("account");
        boolean result=dao.checkUserExist(account);

        response.setContentType("text/html;charset=UTF-8");//(text/html   text/xml   text/json)
        //获取响应对象的输出流
        PrintWriter out=response.getWriter();
        out.write(result+"");
        out.flush();
        out.close();
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
