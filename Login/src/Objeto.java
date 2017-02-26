import java.io.Serializable;

public class Objeto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String correo, contraseña, nickname;
	public boolean registrado;
	
	public Objeto(String correo, String contraseña, String nickname, String REgistrado){
		this.contraseña = contraseña;
		this.correo = correo;
		this.nickname = nickname;
	}
	
	public String getCorreo() {
		return correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getNickname() {
		return nickname;
	}
	
	
}
