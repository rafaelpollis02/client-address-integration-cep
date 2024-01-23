package br.com.integration;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://viacep.com.br/ws")
public interface WebServiceCEP {

    @GET
    @Path("{cep}/json")
    Response getCEPByWebService(String cep);
}
