package br.com.joocebox.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileDeleteStrategy;

public class JooceBoxFileUtils {

	public void deleteFilesInFolder(File path) {
		for (File file : path.listFiles()) {
			try {
				FileDeleteStrategy.FORCE.delete(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
