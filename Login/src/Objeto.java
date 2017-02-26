import java.io.Serializable;

public class Objeto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String correo, contrase�a, nickname;
	public boolean registrado;
	
	public Objeto(String correo, String contrase�a, String nickname, String REgistrado){
		this.contrase�a = contrase�a;
		this.correo = correo;
		this.nickname = nickname;
	}
	
	public String getCorreo() {
		return correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public String getNickname() {
		return nickname;
	}
	
	
}
