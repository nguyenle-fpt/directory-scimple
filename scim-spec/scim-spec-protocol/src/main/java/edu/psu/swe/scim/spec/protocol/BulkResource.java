package edu.psu.swe.scim.spec.protocol;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.swe.scim.spec.protocol.data.BulkResponse;
import edu.psu.swe.scim.spec.protocol.data.SearchRequest;
import edu.psu.swe.scim.spec.resources.ScimResource;

//@formatter:off
/**
* From SCIM Protocol Specification, section 3, page 9
* 
* @see <a href="https://tools.ietf.org/html/rfc7644#section-3.2">Scim spec section 3.2</a>
* 
* Resource Endpoint         Operations             Description
 -------- ---------------- ---------------------- --------------------
   Bulk     /Bulk            POST (Section 3.7)     Bulk updates to one
                                                    or more resources.

* @author chrisharm
*
*/
//@formatter:on

@Path("Bulk")
@Api("ResourceType")
public interface BulkResource {

  /**
   * @see <a href="https://tools.ietf.org/html/rfc7644#section-3.7">Bulk Operations</a>
   * @return
   */
  @POST
  @Produces("application/scim+json")
  @ApiOperation(value="Bulk Operations", response=BulkResponse.class, code=200)
  @ApiResponses(value={
      @ApiResponse(code=400, message="Bad Request"),
      @ApiResponse(code=500, message="Internal Server Error"),
      @ApiResponse(code=501, message="Not Implemented")
    })
  default Response find(SearchRequest request){
    return Response.status(Status.NOT_IMPLEMENTED).build();
  }
  
}
