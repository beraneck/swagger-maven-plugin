package com.github.kongchen.jaxrs.api.car;


import com.github.kongchen.model.Customer;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;

/**
 * Created with IntelliJ IDEA.
 * User: kongchen
 * Date: 5/13/13
 */
@Path("/v2/car")
@Api(value = "/v2/car", description = "Operations about cars v2", position = 2,
authorizations = @Authorization(value = "oauth2", scopes = {@AuthorizationScope(scope = "car2", description = "nothing")}))
@Produces( {"application/json"})
public class CarResourceV2 {
    @GET
    @Path("/{carId}")
    @ApiOperation(value = "Find car by ID", notes = "To get car info by car's Id",
            response = Customer.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Car not found")})
    public Customer getCarById(
            @ApiParam(value = "ID of car that needs to be fetched", allowableValues = "range[10,20]",
                    required = true) @PathParam("carId") String carId)
            throws NotFoundException {
        return new Customer();
    }
}
