package resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.LabSeqService;

@Path("/labseq")
public class LabSeqResource {

    private final LabSeqService labSeqService;

    public LabSeqResource(LabSeqService labSeqService) {
        this.labSeqService = labSeqService;
    }

    @GET
    @Path("/{n}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLabSeqValue(@PathParam("n") int n){
        return Integer.toString(labSeqService.calculateLabSeq(n));
    }
}
