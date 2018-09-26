package com.findat.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findat.model.User;
import com.findat.service.UserService;

@WebServlet(
        name = "UserServlet",
        urlPatterns = {"/user"}
)
public class UserServlet extends HttpServlet {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action!=null){
            switch (action) {           
	            case "searchById":
	                searchUserById(req, resp);
	                break;           
	            case "searchByName":
	                searchUserByName(req, resp);
	                break;
            }
        }
        else{
            List<User> result = userService.getAllUsers();
            forwardListUsers(req, resp, result);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("En el doPost");
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addUserAction(req, resp);
                break;
            case "edit":
                editUserAction(req, resp);
                break;            
            case "remove":
                removeUserByName(req, resp);
                break;            
        }

    } 

    private void searchUserById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
        long idUser = Integer.valueOf(req.getParameter("idUser"));
        User user = null;
        try {
            user = userService.getUser(idUser);
        } 
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("user", user);
        req.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-user.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
    
    private void searchUserByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
        String userName = req.getParameter("userName");
        List<User> result = userService.searchUsersByName(userName);        
        forwardListUsers(req, resp, result);
    }

    private void forwardListUsers(HttpServletRequest req, HttpServletResponse resp, List<User> userList)
            throws ServletException, IOException {
    	
        String nextJSP = "/jsp/list-users.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    } 
    
    private void addUserAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String username = req.getParameter("username");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String nif = req.getParameter("nif");
        User user = new User(username, name, lastName, nif, email);
        long idUser = userService.addUser(user);
        List<User> userList = userService.getAllUsers();
        req.setAttribute("idUser", idUser);
        String message = "The new employee has been successfully created.";
        req.setAttribute("message", message);
        forwardListUsers(req, resp, userList);
    }

    private void editUserAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String username = req.getParameter("username");
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String nif = req.getParameter("nif");       
        String email = req.getParameter("email");
        long idUser = Integer.valueOf(req.getParameter("idUser"));
        User user = new User(username, name, lastName, nif, email, idUser);
        user.setId(idUser);
        boolean success = userService.updateUser(user);
        String message = null;
        if (success) {
            message = "The employee has been successfully updated.";
        }
        List<User> employeeList = userService.getAllUsers();
        req.setAttribute("idEmployee", idUser);
        req.setAttribute("message", message);
        forwardListUsers(req, resp, employeeList);
    }  

    private void removeUserByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idEmployee = Integer.valueOf(req.getParameter("idUser"));
        boolean confirm = userService.deleteUser(idEmployee);
        if (confirm){
            String message = "The user has been successfully removed.";
            req.setAttribute("message", message);
        }
        List<User> employeeList = userService.getAllUsers();
        forwardListUsers(req, resp, employeeList);
    }
}
