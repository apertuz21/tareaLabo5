package com.uca.tareaLabo5.domain;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "estudiante")
public class Estudiante {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_usuario")
    private Integer codigo;
    
    @Size(message = "El campo no debe contener más de 30 caracteres", max =30)
    @NotEmpty(message = "Ingrese un nombre porfavor")
    @Column(name = "nombre")
    private String nombre;
    
    @Size(message = "El campo no debe contener más de 30 caracteres", max =30)
    @NotEmpty(message = "Ingrese un apellido porfavor")
    @Column(name = "apellido")
    private String apellido;
    
    @NotNull(message = "El campo no puede estar vacío")
    @Min(value = 18, message = "No puede ser menor a 18 años")
    @Column(name = "edad")
    private Integer edad;
    
    @Column(name = "estado")
    private Boolean estado;
    
    public Estudiante(){}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    public Boolean getEstado() {
    	return estado;
    }
    
    public String getEstadoDelegate() {
    	if(this.estado == null)  return "";
    	else return estado == true ? "Activo":"Inactivo";
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
