package com.bs.themebridge.entity.model;

public class DirectoryReaderModel {

	public String fileName;
	public String creationTime;
	public String lastAccessTime;
	public long lastModifiedTime;
	public String isDirectory;
	public boolean isRegularFile;
	public boolean isSymbolicLink;
	public long filesize;
	public boolean isOther;
	public String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(String lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long l) {
		this.lastModifiedTime = l;
	}

	public String getIsDirectory() {
		return isDirectory;
	}

	public void setIsDirectory(String isDirectory) {
		this.isDirectory = isDirectory;
	}

	public boolean isRegularFile() {
		return isRegularFile;
	}

	public void setRegularFile(boolean isRegularFile) {
		this.isRegularFile = isRegularFile;
	}

	public boolean isSymbolicLink() {
		return isSymbolicLink;
	}

	public void setSymbolicLink(boolean isSymbolicLink) {
		this.isSymbolicLink = isSymbolicLink;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public boolean isOther() {
		return isOther;
	}

	public void setOther(boolean isOther) {
		this.isOther = isOther;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
