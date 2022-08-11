package com.security.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

	@GetMapping("/")
	public String all() {
		String page = "<!doctype html>\r\n" + "<html lang=\"en\">\r\n" + "\r\n" + "<head>\r\n"
				+ "  <!-- Required meta tags -->\r\n" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + "\r\n"
				+ "  <!-- Bootstrap CSS -->\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n"
				+ "    integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n" + "  <!-- Bootstrap JS -->\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "    integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\r\n"
				+ "    crossorigin=\"anonymous\"></script>\r\n" + "  <title>Hello, world!</title>\r\n" + "</head>\r\n"
				+ "\r\n" + "<body>\r\n" + "  <div class=\"container my-5\">\r\n"
				+ "    <h1>This is a public page (Spring Boot App - JWT Authentication)</h1>\r\n"
				+ "    <hr class=\"text-danger\">\r\n" + "    <ul>\r\n"
				+ "      <li>(GET) <a href=\"https://amit-springboot.herokuapp.com/user\" target=\"_blank\" style=\"text-decoration: none;\">User Page</a></li>\r\n"
				+ "      <li>(GET) <a href=\"https://amit-springboot.herokuapp.com/admin\" target=\"_blank\" style=\"text-decoration: none;\">Admin Page</a></li>\r\n"
				+ "      <li>(GET) <a href=\"https://amit-springboot.herokuapp.com/welcome\" target=\"_blank\" style=\"text-decoration: none;\">Welcome Page</a></li>\r\n"
				+ "      <li>(POST) <a href=\"https://amit-springboot.herokuapp.com/auth/login\" target=\"_blank\" style=\"text-decoration: none;\">Login User</a></li>\r\n"
				+ "      <li>(POST) <a href=\"https://amit-springboot.herokuapp.com/user/register\" target=\"_blank\" style=\"text-decoration: none;\">Register User</a></li>\r\n"
				+ "      <li>(GET) <a href=\"https://amit-springboot.herokuapp.com/user/users\" target=\"_blank\" style=\"text-decoration: none;\">All Users</a> (Admin Only)</li>\r\n"
				+ "      <li>(GET) <a href=\"https://amit-springboot.herokuapp.com/user/user/101\" target=\"_blank\" style=\"text-decoration: none;\">User with id</a> (User Only)</li>\r\n"
				+ "    </ul>\r\n" + "  </div>\r\n" + "</body>\r\n" + "\r\n" + "</html>";
		return page;
	}

	@GetMapping("/user")
	public String user() {
		return "<h1>This page is for normal-user only</h1>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>This page is for superuser only</h1>";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "<h1>This is a private page for all authorized users</h1>";
	}

}
