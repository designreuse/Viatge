package br.com.joocebox.model;

import java.io.Serializable;


public class FileMeta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private String fileSize;
	private String fileType;
	private String fileTmpPath;
	
	public FileMeta() {

	}
	
	public String getFileName() {
		return fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileTmpPath() {
		return fileTmpPath;
	}
	public void setFileTmpPath(String fileTmpPath) {
		this.fileTmpPath = fileTmpPath;
	}
}
