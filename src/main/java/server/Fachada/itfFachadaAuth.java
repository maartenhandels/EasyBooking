package server.Fachada;

public interface itfFachadaAuth {

	public void registroUs(String nombre, String email,String contranenya);
	public void iniciarSesion (String email, String contrasenya);
	public void cerrarSesion ();
}
