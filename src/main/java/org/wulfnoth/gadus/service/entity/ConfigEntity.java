package org.wulfnoth.gadus.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigEntity {

	@Autowired
	private Environment env;

	public String getNoteFilePath() {
		return env.getProperty("note.file.path");
	}

}
