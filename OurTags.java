package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;




/*
 * This class implements custom tags we made(youtube tag) 
 * and also give example of jersey framework.
 */
@Path("/hello")
public class OurTags extends SimpleTagSupport{

	String idYoutube;
	public void doTag() throws JspException, IOException
	  {
	  JspWriter out = getJspContext().getOut();
	  out.print("<iframe width=" +"560 " +" height=" + "315 "+" src="+"https://www.youtube.com/embed/"+idYoutube +" frameborder="+"0" +" allowfullscreen>"+"</iframe>");

	  
	  }
	public String getIdYoutube() {
		return idYoutube;
	}
	public void setIdYoutube(String idYoutube) {
		this.idYoutube = idYoutube;
	}

	@GET
	@Produces("text/plain")
	public String getClichedMessage() {
		return "Java EE Project";
}
}
