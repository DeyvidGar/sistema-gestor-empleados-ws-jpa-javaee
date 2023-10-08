package mx.com.midominio.data;

//metodos que se pueden utlizar en el servicio RS

import java.util.List;
import mx.com.midominio.domain.Persona;

public interface IPersonaDao {
    public List<Persona> allPersona();
    public Persona findPersona(Persona persona);
    public void insertPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void deltePersona(Persona persona);
}
