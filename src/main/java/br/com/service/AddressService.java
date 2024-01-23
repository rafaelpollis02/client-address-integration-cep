package br.com.service;

import br.com.domain.Address;
import br.com.domain.CEPResponse;
import br.com.integration.WebServiceCEP;
import br.com.repository.AddressRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class AddressService {

    @Inject
    AddressRepository addressRepository;

    @Inject
    @RestClient
    WebServiceCEP webServiceCep;

    public List<Address> getAllAddress(){
        return addressRepository.listAll();
    }

    public Address postAddress(Address address){

        Response webService = webServiceCep.getCEPByWebService(address.getCep());
        JsonObject webServiceInfo = webService.readEntity(JsonObject.class);

        address.setLogradouro(webServiceInfo.getString("logradouro"));
        address.setBairro(webServiceInfo.getString("bairro"));
        address.setLocalidade(webServiceInfo.getString("localidade"));
        address.setUf(webServiceInfo.getString("uf"));

        addressRepository.persist(address);
        return address;
    }

}
