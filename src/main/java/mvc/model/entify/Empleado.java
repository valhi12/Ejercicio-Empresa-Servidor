package mvc.model.entify;

import mvc.excepciones.DatosNoCorrectosException;

public class Empleado extends Persona{

    private int categoria;
    public int ayos;

    public Empleado(String nombre, char sexo, String dni, int categoria, int ayos) {
        super(nombre, sexo, dni);
        this.ayos = ayos;
        this.categoria = categoria;

        if(this.categoria < 0 || this.categoria > 10){
            throw new DatosNoCorrectosException("Datos no correctos");
        }
    }

    public Empleado(String nombre, char sexo, String dni) {
        super(nombre, sexo, dni);
        this.categoria = 1;
        this.ayos= 0;

    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni(){
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    public char getSexo(){
        return sexo;
    }



    public void setCategoria(int i){
        this.categoria = categoria;
    }

    public int getCategoria(){
        return categoria;
    }

    public int incrAnyo(){
        return ayos++;
    }

    public int getAnyos(){
        return ayos;
    }

    public String Imprime(){
        return "Empleado: " + "Nombre: " + nombre + " dni: " + dni + " sexo: " + sexo + " categoria: "+ categoria + " años: " + ayos;
    }


}


