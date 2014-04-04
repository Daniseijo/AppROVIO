package com.example.accesoURL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class RovioModel
{
	// Commands
	private static final int
		PARAR 					= 0,
		ADELANTE				= 1,
		ATRAS 					= 2,
		LAT_IZQUIERDA 			= 3,
		LAT_DERECHA				= 4,
		ROT_IZQUIERDA			= 5,
		ROT_DERECHA				= 6,
		DIAG_ADEL_IZQUIERDA		= 7,
		DIAG_ADEL_DERECHA 		= 8,
		DIAG_ATR_IZQUIERDA		= 9,
		DIAG_ATR_DERECHA		= 10,
		CAM_POS_ALTA			= 11, 
		CAM_POS_BAJA			= 12,
		CAM_POS_MEDIA			= 13,
		ROT_IZQUIERDA_20		= 17,
		ROT_DERECHA_20			= 18;
	
	private String respuesta = "";
	
	private static final String
		ip = "roviolisw.servebeer.com",
		url = "http://"+ip+"/rev.cgi?Cmd=nav&action=18&drive=",
		speed = "&speed=";
	
	
	public static String moveForward(){	return sendOrder(ADELANTE, 1);}
	public static void moveBack(){ sendOrder(ATRAS,1); }
	public static void moveLeft(){ sendOrder(LAT_IZQUIERDA,1); }
	public static void moveRight(){ sendOrder(LAT_DERECHA,1); }

	public static String sendOrder(final int subject, final int param){
		String respuestaString = "";
		try
    	{
    		HttpClient client = new DefaultHttpClient();
            HttpGet command = new HttpGet(url+subject+speed+param);
            HttpResponse respuesta = client.execute(command);
            StatusLine statusLine = respuesta.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
            	ByteArrayOutputStream out = new ByteArrayOutputStream();
            	respuesta.getEntity().writeTo(out);
            	out.close();
            	respuestaString = out.toString();
            }else{
            	respuesta.getEntity().getContent().close();
            	throw new IOException(statusLine.getReasonPhrase());
            }
    	}		  
    	catch(Exception e)
    	{
    		e.printStackTrace();               
    	}	
		return respuestaString;
	}
	
	/**
	public static String sendOrder(final int subject, final int param)
    {
    	AsyncTask<Void, Void, Void> at = new AsyncTask<Void, Void, Void>()
    	{
	        @Override
	        protected Void doInBackground(Void... params)
	        {
	        	try
	        	{
	        		HttpClient client = new DefaultHttpClient();
	                HttpGet command = new HttpGet(url+subject+speed+param);
	                HttpResponse respuesta = client.execute(command);
	                StatusLine statusLine = respuesta.getStatusLine();
	                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
	                	ByteArrayOutputStream out = new ByteArrayOutputStream();
	                	respuesta.getEntity().writeTo(out);
	                	out.close();
	                	String respuestaString = out.toString();
	                }else{
	                	respuesta.getEntity().getContent().close();
	                	throw new IOException(statusLine.getReasonPhrase());
	                }
	        	}		  
	        	catch(Exception e)
	        	{
	        		e.printStackTrace();               
	        	}
				return null;
	        }
    	};
    	at.execute();
    	return "";
    }
    */
    
	
}
