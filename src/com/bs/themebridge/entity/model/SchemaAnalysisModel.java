package com.bs.themebridge.entity.model;

public class SchemaAnalysisModel {

	public String schema_name;
	public String table_name;
	public String num_rows;
	public String mb;

	public String getSchema_name() {
		return schema_name;
	}

	public void setSchema_name(String schema_name) {
		this.schema_name = schema_name;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getNum_rows() {
		return num_rows;
	}

	public void setNum_rows(String num_rows) {
		this.num_rows = num_rows;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

}
