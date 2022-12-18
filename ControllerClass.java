package com.p1.Healthman;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerClass {

	
	@Autowired
	RegisterRepo repo1;
	
	
	
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	
	@RequestMapping("/security")
	public String security() {
		return "security";
	}
	
	@RequestMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	
	
	
	@RequestMapping("/ambulancebook")
	public String Controller1() {
		
		
		return "login";
		
	}
	
	@RequestMapping("/register")
	public String Register(@ModelAttribute RegisterClass reg) {
		
		repo1.save(reg);
		
		//Cookie ck=new Cookie(reg.getEmail(),reg.getName());
		
		return "loginpage";
		
	}
	
	@RequestMapping("/LoginValidation")
	public String LoginValidation(@RequestParam String email,@RequestParam String password,@ModelAttribute RegisterClass reg) {
		Connection con=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HealthCare","root","@#milanekanna8899420176#@");
			pst=con.prepareStatement("select * from register_class where email=?");
			
			ResultSet rs=pst.executeQuery();
		
			String emaildb=rs.getString(1);
			System.out.println(emaildb);
			pst.setString(1, emaildb);	
			
			if(email.equals(emaildb)) { 
				return "ambulancebook";
		}else { 
				return "not_registered";
			
		}
	
		
		}catch(Exception e) {
			
		}
		
			return null;
	}
	
	@RequestMapping("/appointment")
	public String Appointment() {
		
		return "loginpage1";
		
	}
	
	@RequestMapping("/LoginValidation1")
	public String LoginValidation1(@RequestParam String email2,@RequestParam String password2,@ModelAttribute RegisterClass reg) {
		String email1=reg.getEmail();
		String password1=reg.getPassword();
		
		if(email2.equals(email1) && password2.equals(password1)) {
			return "appointment";
		}else {
			return "not_registered";
		}
		
	}
	
	@RequestMapping("/appointment1")
	public String AppointmentData(@RequestParam String city,@RequestParam String date,HttpServletRequest req)
	{
		
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HealthCare","root","@#milanekanna8899420176#@");
			
		}catch(Exception e) {
			
		}
		
		//Ghaziabad
			
			if(city.equals("Ghaziabad") && date.equals("today")) {
				try {
				pst=con.prepareStatement("select * from ghaziabad where did%2=0");
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {

					String docid=rs.getString(1);
					String docname=rs.getString(2);
					String exp=rs.getString(3);
					String spc=rs.getString(4);
					String address=rs.getString(5);
					HttpSession session=req.getSession();
					session.setAttribute("docid", docid);
					session.setAttribute("docname", docname);
					session.setAttribute("exp", exp);
					session.setAttribute("spc", spc);
					session.setAttribute("address", address);
					
				}
				
				}catch(Exception e) {
					
				}
			}else if(date.equals("tomorrow")) {
				try {
					pst=con.prepareStatement("select * from ghaziabad where did%2!=0");
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {

						String docid=rs.getString(1);
						String docname=rs.getString(2);
						String exp=rs.getString(3);
						String spc=rs.getString(4);
						String address=rs.getString(5);
						HttpSession session=req.getSession();
						session.setAttribute("docid", docid);
						session.setAttribute("docname", docname);
						session.setAttribute("exp", exp);
						session.setAttribute("spc", spc);
						session.setAttribute("address", address);
						
					}
					
					}catch(Exception e) {
						
					}
			}
			
			//Delhi
			else if(city.equals("Delhi") && date.equals("today")) {
				try {
				pst=con.prepareStatement("select * from Delhi where did%2=0");
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {

					String docid=rs.getString(1);
					String docname=rs.getString(2);
					String exp=rs.getString(3);
					String spc=rs.getString(4);
					String address=rs.getString(5);
					HttpSession session=req.getSession();
					session.setAttribute("docid", docid);
					session.setAttribute("docname", docname);
					session.setAttribute("exp", exp);
					session.setAttribute("spc", spc);
					session.setAttribute("address", address);
					
				}
				
				}catch(Exception e) {
					
				}
			}else if(date.equals("tomorrow")) {
				try {
					pst=con.prepareStatement("select * from Delhi where did%2!=0");
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {

						String docid=rs.getString(1);
						String docname=rs.getString(2);
						String exp=rs.getString(3);
						String spc=rs.getString(4);
						String address=rs.getString(5);
						HttpSession session=req.getSession();
						session.setAttribute("docid", docid);
						session.setAttribute("docname", docname);
						session.setAttribute("exp", exp);
						session.setAttribute("spc", spc);
						session.setAttribute("address", address);
						
					}
					
					}catch(Exception e) {
						
					}

			}
			
		//Gurgaon
			
			else if(city.equals("Gurgaon") && date.equals("today")) {
				try {
				pst=con.prepareStatement("select * from gurgaon where did%2=0");
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {

					String docid=rs.getString(1);
					String docname=rs.getString(2);
					String exp=rs.getString(3);
					String spc=rs.getString(4);
					String address=rs.getString(5);
					HttpSession session=req.getSession();
					session.setAttribute("docid", docid);
					session.setAttribute("docname", docname);
					session.setAttribute("exp", exp);
					session.setAttribute("spc", spc);
					session.setAttribute("address", address);
					
				}
				
				}catch(Exception e) {
					
				}
			}else if(date.equals("tomorrow")) {
				try {
					pst=con.prepareStatement("select * from gurgaon where did%2!=0");
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {

						String docid=rs.getString(1);
						String docname=rs.getString(2);
						String exp=rs.getString(3);
						String spc=rs.getString(4);
						String address=rs.getString(5);
						HttpSession session=req.getSession();
						session.setAttribute("docid", docid);
						session.setAttribute("docname", docname);
						session.setAttribute("exp", exp);
						session.setAttribute("spc", spc);
						session.setAttribute("address", address);
						
					}
					
					}catch(Exception e) {
						
					}

			}
		
		//Moradabad
			else if(city.equals("Moradabad") && date.equals("today")) {
				try {
				pst=con.prepareStatement("select * from Moradabad where did%2=0");
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {

					String docid=rs.getString(1);
					String docname=rs.getString(2);
					String exp=rs.getString(3);
					String spc=rs.getString(4);
					String address=rs.getString(5);
					HttpSession session=req.getSession();
					session.setAttribute("docid", docid);
					session.setAttribute("docname", docname);
					session.setAttribute("exp", exp);
					session.setAttribute("spc", spc);
					session.setAttribute("address", address);
					
				}
				
				}catch(Exception e) {
					
				}
			}else if(date.equals("tomorrow")) {
				try {
					pst=con.prepareStatement("select * from Moradabad where did%2!=0");
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {

						String docid=rs.getString(1);
						String docname=rs.getString(2);
						String exp=rs.getString(3);
						String spc=rs.getString(4);
						String address=rs.getString(5);
						HttpSession session=req.getSession();
						session.setAttribute("docid", docid);
						session.setAttribute("docname", docname);
						session.setAttribute("exp", exp);
						session.setAttribute("spc", spc);
						session.setAttribute("address", address);
						
					}
					
					}catch(Exception e) {
						
					}

			}
			
			
	//meerut
			else if(city.equals("Meerut") && date.equals("today")) {
				try {
				pst=con.prepareStatement("select * from Meerut where did%2=0");
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {

					String docid=rs.getString(1);
					String docname=rs.getString(2);
					String exp=rs.getString(3);
					String spc=rs.getString(4);
					String address=rs.getString(5);
					HttpSession session=req.getSession();
					session.setAttribute("docid", docid);
					session.setAttribute("docname", docname);
					session.setAttribute("exp", exp);
					session.setAttribute("spc", spc);
					session.setAttribute("address", address);
					
				}
				
				}catch(Exception e) {
					
				}
			}else if(date.equals("tomorrow")) {
				try {
					pst=con.prepareStatement("select * from Meerut where did%2!=0");
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {

						String docid=rs.getString(1);
						String docname=rs.getString(2);
						String exp=rs.getString(3);
						String spc=rs.getString(4);
						String address=rs.getString(5);
						HttpSession session=req.getSession();
						session.setAttribute("docid", docid);
						session.setAttribute("docname", docname);
						session.setAttribute("exp", exp);
						session.setAttribute("spc", spc);
						session.setAttribute("address", address);
						
					}
					
					}catch(Exception e) {
						
					}

			}
			
			

			return "display";
	
			
	}
	
	
}
