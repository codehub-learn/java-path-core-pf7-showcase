package gr.codelearn.core.showcase.exception.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@AllArgsConstructor
public enum Directory {
	FILE_DIRECTORY(System.getProperty("user.home") + File.separator + "data_files" + File.separator);

	@Getter
	String path;
}
