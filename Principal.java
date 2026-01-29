import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        System.out.println("Fecha y hora actual: " + obtenerFechaHora());

        Usuario[] alumnos = pedirUsu();
        for(int i = 0; i < alumnos.length; i++){
            System.out.print(alumnos[i]);
        }


    }
    
    public static String obtenerFechaHora() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ahora.format(formatter);
    }

    public static Usuario[] pedirUsu() {
        int numero = 0;
        
        while (true) {
            try {
                System.out.print("¿Cuántos usuarios quieres crear? ");
                numero = Integer.parseInt(teclado.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
            }
        }
        Usuario[] alumnos = new Usuario[numero];
        for(int i = 0; i < numero; i++){
            System.out.print("Introduce el nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Introduce los apellidos: ");
            String apellidos = teclado.nextLine();
            System.out.print("Introduce el correo: ");
            String email = teclado.nextLine();

            Usuario usu = new Usuario(nombre, apellidos, email);
            alumnos[i] = usu;
        }



        return alumnos;
    }
    
}