package br.com.resource;

import br.com.domain.Address;
import br.com.service.AddressService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    AddressService addressService;

    @GET
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @POST
    @Transactional
    public Address postAddress(Address address){
        addressService.postAddress(address);
        return address;
    }

}
