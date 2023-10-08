package mx.com.midominio.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.midominio.domain.Persona;

@Stateless //ejb de tipo stateless, para injectar la dependencia persistence
public class PersonaDaoImple implements IPersonaDao {

    @PersistenceContext(unitName = "PersonaPU") //inject persistence
    EntityManager em;//para conexion a bd
    
    @Override
    public List<Persona> allPersona() {
        return em.createNamedQuery("Persona.allPersona").getResultList(); //query creado en la clase domain
    }

    @Override
    public Persona findPersona(Persona persona) {
        return em.find(Persona.class, persona.getId());
    }
    
    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
        em.flush();//para retornar el objeto persistido en la bd
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void deltePersona(Persona persona) {
        em.remove(em.merge(persona));//acutaliza el estado de la bd y remueve el objeto
    }
    
}
