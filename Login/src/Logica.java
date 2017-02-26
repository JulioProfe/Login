import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Logica implements Observer {
	private Comunicacion com;
	private ArrayList<Objeto> usuariosRegistrados;

	public Logica() {
		com = new Comunicacion();
		com.addObserver(this);
		new Thread(com).start();
		usuariosRegistrados = new ArrayList<>();
	}

	public void update(Observable o, Object ob) {
		System.out.println("objeto recibido " + ob.getClass());
		Object recibido = ob;
		System.out.println("usuario registrados: " + usuariosRegistrados.size());

		if (recibido instanceof Objeto) {

			Objeto usu = (Objeto) recibido;
			System.out.println("usuario nombre:" + usu.nickname);
			if (usu.registrado) {
				System.out.println("peticion de registro recibida");
				usuariosRegistrados.add(usu);
				String aprovadon = new String("AprobadoRegistro");
				com.mandarMensajote(aprovadon);

			} else if (!usuariosRegistrados.isEmpty()) {
				for (int i = 0; i < usuariosRegistrados.size(); i++) {
					Objeto usuregis = usuariosRegistrados.get(i);

					if (usuregis.nickname.equals(usu.nickname) & usuregis.contraseña.equals(usu.contraseña)) {
						System.out.println("peticion de inicio aprovada");
						// mando aprovacion de inicio de sesion
						String aprovadon = new String("AprobadoLogin");

					} else if (!usu.registrado) {
						System.out.println("contraseña o usuario incorecto");
						String aprovadon = new String("NoAprobadoLogin");
						com.mandarMensajote(aprovadon);
					}
				}
			} else {
				System.out.println("Usuario no registrado");
				String aprovadon = new String("NoAprobadoLogin");
				com.mandarMensajote(aprovadon);
			}

		}

	}

}
