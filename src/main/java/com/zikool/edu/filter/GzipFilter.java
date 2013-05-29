package com.zikool.edu.filter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		MyResponse my = new MyResponse(response);
		chain.doFilter(request, my);
		byte buffer[] = my.getBuffer();
		System.out.println(buffer.length);
		
		String cilentHead = request.getHeader("Accept-Encoding");
		if(cilentHead==null || !cilentHead.toLowerCase().contains("gzip")){
			response.getOutputStream().write(buffer);
			return;
		}

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(buffer);
		gout.close();
		
		byte gzip[] = bout.toByteArray();
		
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", "" + gzip.length);
		response.getOutputStream().write(gzip);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
}


class MyResponse extends HttpServletResponseWrapper{

	private ByteArrayOutputStream bout = new ByteArrayOutputStream(1024*10);
	private HttpServletResponse response;
	private PrintWriter pw = null;
	
	
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(bout,response.getCharacterEncoding()));
		return pw;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyServletOutputStream(bout);
	}
	public byte[] getBuffer() throws IOException{
		if(bout!=null){
			bout.flush();
		}
		if(pw!=null){
			pw.close();
		}
		return bout.toByteArray();
	}
}

class MyServletOutputStream  extends ServletOutputStream{
	ByteArrayOutputStream bout;
	public MyServletOutputStream(ByteArrayOutputStream bout){
		this.bout = bout;
	}
	
	@Override
	public void write(int b) throws IOException {
		bout.write(b);
	}
	
}

