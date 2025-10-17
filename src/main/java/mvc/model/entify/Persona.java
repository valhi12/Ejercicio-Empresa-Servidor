package mvc.model.entify;

public class Persona {
    public String nombre;
    public String dni;
    public char sexo;

    public Persona(String nombre, char sexo, String dni) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.dni = dni;
    }

    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String Imprime(){
        return "Nombre: " + nombre + " dni: " + dni;
    }
}
