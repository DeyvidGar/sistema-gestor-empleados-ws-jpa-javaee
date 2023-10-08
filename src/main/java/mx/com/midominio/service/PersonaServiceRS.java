package mx.com.midominio.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import mx.com.midominio.data.IPersonaDao;
import mx.com.midominio.domain.Persona;

@Stateless
@Path("/personas")//ejb rs
public class PersonaServiceRS {
    //Inject: capa DAO, capa de datos
    @Inject
    private IPersonaDao personaDao;
    
    @GET//peticion gttp get
    @Produces(value = MediaType.APPLICATION_JSON)//retornamos solo info json
    public List<Persona> listPersonas(){
        List<Persona> personas = personaDao.allPersona();
        System.out.println("personas = " + personas);
        return personas;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /personas/{id} || ejemplo: /personas/1
    public Persona findPersona(@PathParam("id") int id){ // le informamos a ws la varialble del path
        Persona persona = personaDao.findPersona(new Persona(id));
        System.out.println("persona = " + persona);
        return persona;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON) //post ademas de producir info, consume info recibida del front
    @Produces(value = MediaType.APPLICATION_JSON)
    public Persona insertPersona(Persona persona){
        System.out.println("request: " + persona);
        personaDao.insertPersona(persona);
        System.out.println("response: " + persona);
        return persona; // enviamos info al front
    }

    //Todo:functions update and delete
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("actualizar/{id}") // path:/personas/acutualizar/?
    public Response updatePersona(@PathParam("id") int id, Persona updatePersona){
        Persona persona = personaDao.findPersona(new Persona(id));
        if(persona == null) return Response.status(Status.NOT_FOUND).build();
        
        System.out.println("persona = " + updatePersona);
        personaDao.updatePersona(updatePersona);
        System.out.println("persona actualizada = " + updatePersona);
        return Response.ok().entity(updatePersona).build();
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("eliminar/{id}")
    public Response deletePersona(@PathParam("id") int id){
        Persona persona = personaDao.findPersona(new Persona(id));
        if(persona == null) Response.status(Status.NOT_FOUND).build();
        
        System.out.println("deletePersona = " + persona);
        personaDao.deltePersona(persona);
        System.out.println("persona despues metodo: " + persona);
        return Response.ok().build();
    }
    
}
