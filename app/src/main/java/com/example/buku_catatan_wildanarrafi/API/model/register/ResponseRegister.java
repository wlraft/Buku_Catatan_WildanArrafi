package com.example.buku_catatan_wildanarrafi.API.model.register;

import com.google.gson.annotations.SerializedName;

public class ResponseRegister{

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRegister{" + 
			"error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}