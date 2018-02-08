package com.example.abstraction.beans;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Component {
	
	private ArrayList<Function> functions;
	private String name;
		
	public static class Function{
		@JsonProperty("type")
		private static final String type = "function";
		private String name;
		private ArrayList<Parameter> parameters;
		@JsonProperty("return_type")
		private String returnType;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<Parameter> getParameters() {
			return parameters;
		}
		public void setParameters(ArrayList<Parameter> parameters) {
			this.parameters = parameters;
		}
		public String getReturnType() {
			return returnType;
		}
		public void setReturnType(String returnType) {
			this.returnType = returnType;
		}
		public static String getType() {
			return type;
		}
	}
	
	public static class Parameter{
		private String name;
		private String type;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
}
