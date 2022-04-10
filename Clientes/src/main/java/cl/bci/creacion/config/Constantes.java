package cl.bci.creacion.config;

public class Constantes {

	Constantes() {
		super();
	}
	
	public static final String REG_EXP_PASS = "^([A-Z]){1}([a-z]+){1,}([0-9]{2})$";
	public static final String REG_EXP_EMAIL = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String PASS_NO_VALIDA = "Password no valido";
	public static final String EMAIL_NO_VALIDO = "Email no valido";
	public static final String EMAIL_REGISTRADO = "El correo ya esta Registrado";
	public static final String PARAM_REQUERIDO = "Parametros requeridos";
	public static final String PARAM_REQUERIDO_PHONES = "Telefono requerido";
	public static final String PARAM_REQUERIDO_EMAIL = "Correo requerido";
	public static final String PARAM_REQUERIDO_NOMBRE = "Nombre requerido";
	public static final String PARAM_REQUERIDO_PASSWORD = "Password requerido";
	public static final String ERROR_CREACION = "No se pudo crear";
	public static final String IS_ACTIVE = "activo";
	public static final String SUCCESS = "success";
	public static final String version = "1.0";
	public static final String descripcion = "API Rest bci java/grandle/jpa";
	public static final String packageBase = "cl.bci.creacion";
	public static final String nombre = "Daniela Flores Cruz";
	public static final String email = "dflores874@gmail.com";

	public static final String titulo = "API Rest Clientes";
	}
