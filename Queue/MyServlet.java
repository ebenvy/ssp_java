package com.lgcns.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public class MyServlet extends HttpServlet{
	MessageQueue mq =new MessageQueue();
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		JsonObject jObj =null;
		BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String buffer;
		StringBuilder sb = new StringBuilder();
		while((buffer =input.readLine())!= null) {
			sb.append(buffer +"\n");
		}
		input.close();
		
		Gson gson = new Gson();
		if(sb.isEmpty()==false)
		{
			String strBody = sb.toString();
			System.out.println(strBody);
			if(strBody!=null && strBody.trim().equals("null")==false )
				jObj = gson.fromJson(strBody, JsonObject.class);
		}
		String line = req.getRequestURI();
		String [] command = line.split("/");
		String result ="";
		if(command[1].equals("SEND")) {
			if(mq.enqueue(command[2],jObj.get("Message").getAsString()) ==true) {
				result ="Ok";
			}
			else {
				result ="Queue Full";
			}
		}
		else if(command[1].equals("CREATE")) {
			if(mq.createQueue(command[2], Integer.parseInt(jObj.get("QueueSize").getAsString()))){
				result ="Ok";
			}
			else {
				result ="Queue Exist";
			}
		}
		else if(command[1].equals("ACK")) {
			mq.remove(command[2], command[3]);
			result ="Ok";
		}
		else if(command[1].equals("FAIL")) {
			mq.changeStatus(command[2], command[3],true);
			result ="Ok";
		}
		Map<String,String> resultMap = new TreeMap<String,String>();
		resultMap.put("Result", result);
		String jsonStr =gson.toJson(resultMap);
		res.setStatus(200);
		res.getWriter().write(jsonStr);
		
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		String line = req.getRequestURI();
		String [] command =line.split("/");
		Map<String,String> resultMap = new TreeMap<String,String>();
		Gson gson = new Gson();
		
		if(command[1].equals("RECEIVE")) {
			Element e = mq.dequeue(command[2]);
			
			if(e!= null) {
				String value =e.getValue();
				String uid =e.getUid();
				
				resultMap.put("Result", "ok");
				resultMap.put("MessageID", uid);
				resultMap.put("Message", value);
			}
			else {
				resultMap.put("Result", "No message");
			}
		}

		String jsonStr =gson.toJson(resultMap);
		res.setStatus(200);
		res.getWriter().write(jsonStr);
	}

}
