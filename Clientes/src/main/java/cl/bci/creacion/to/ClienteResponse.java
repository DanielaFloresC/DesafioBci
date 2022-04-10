package cl.bci.creacion.to;

import java.util.Date;


public class ClienteResponse {

	private String mensaje;
	private String id;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private String isactive;
	
	
	
	public ClienteResponse(String mensaje) {
		super();
		this.mensaje = mensaje;
	}


	public ClienteResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	public Date getLast_login() {
		return last_login;
	}


	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	
	
	
	
}
