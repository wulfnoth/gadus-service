package org.wulfnoth.gadus.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Created on 2019/1/10.
 */
@RestController
public class TransformController {

	@RequestMapping("/test")
	public String test(String name) {
		return "hello" + name;
	}



	@RequestMapping("/list")
	public String getLists() {
		StringBuilder sb = new StringBuilder();
		File file = new File("data/xgboost/paper_note.md");
		sb.append("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<title>list</title>\n\t</head>\n")
				.append("\t<body>\n").append("<p><a href=\"test?name=")
				.append(file.getName())
				.append("\">")
				.append(file.getName())
				.append("</a></p>\n")
				.append("\t</body>\n</html>");
		return sb.toString();
	}

}
