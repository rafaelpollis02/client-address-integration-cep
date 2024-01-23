package br.com.resource;

import br.com.domain.Client;
import br.com.service.ClientService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    public List<Client> getAllClient(){
        return clientService.getAllClient();
    }

    @POST
    @Transactional
    public Client postClient(Client client){
        clientService.postClient(client);
        return client;
    }

}
