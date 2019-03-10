package org.wulfnoth.gadus.service.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wulfnoth.gadus.service.Main;
import org.wulfnoth.gadus.service.entity.FileInfo;
import org.wulfnoth.md.MarkdownParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class TransformController {

	@RequestMapping("/transform")
	public String transform(Model model, String filepath) {
		File file = new File(Main.config.getNoteFilePath() + "/" + filepath.replaceAll("_-_", "/"));
		model.addAttribute("title", "测试title");
		String content = MarkdownParser.parser(file).getContent();
//		StringBuilder sb = new StringBuilder();
//		sb.append("<div th:fragment=\"copy\">\n").append(content).append("\n</div>");
//		System.out.println(sb.toString());
//		model.addAttribute("content", sb.toString());
		model.addAttribute("content", content);
		return "transform";
	}


	@RequestMapping("/index")
	public String index() {
		return "/index";
	}

	private List<FileInfo> recursiveSearchMDFile(File file, String parentPath, String filename) {
		if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			if (subFiles!=null) {
				if (!StringUtils.isEmpty(parentPath)) {
					parentPath = parentPath + "_-_";
				}
				List<FileInfo> fileInfos = new ArrayList<>();
				for (File subFile : subFiles) {
					if (subFile.isDirectory()) {
						fileInfos.addAll(recursiveSearchMDFile(subFile,
								parentPath + subFile.getName(),
								filename));
					} else if (subFile.getName().endsWith(".md") && subFile.getName().contains(filename)){
						fileInfos.add(new FileInfo(parentPath + subFile.getName(), subFile.getName()));
					}
				}
				return fileInfos;
			}
		}

		return Collections.emptyList();
	}

	@RequestMapping("/getfile")
	public String getLists(Model model, String filename) {
		System.out.println(filename);
		File file = new File(Main.config.getNoteFilePath() + "/");

		model.addAttribute("infos", recursiveSearchMDFile(file, "", filename));
		return "/list";
	}

}
