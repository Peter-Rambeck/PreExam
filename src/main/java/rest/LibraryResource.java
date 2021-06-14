/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dtos.BookDTO;
import dtos.LibraryDTO;
import facades.LibraryFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author peter
 */
@Path("library")
public class LibraryResource {

    Gson gson = new Gson();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final LibraryFacade FACADE = LibraryFacade.getLibraryFacade(EMF);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LibraryResource
     */
    public LibraryResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello dunkedyr\"}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addBook/{libraryId}")
    public Response AddBook(String jsonBody) {
        // LibraryDTO libraryDTO = gson.fromJson(jsonBody, LibraryDTO.class);
        BookDTO bookDTO = gson.fromJson(jsonBody, BookDTO.class);
        LibraryDTO libraryDTO = FACADE.addBook(bookDTO);
        return Response.ok("Dunkeren").build();
    }
    
    @GET
    @Path("/getlibrary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLibrary() {
        LibraryDTO libraryDTO = FACADE.getLibrary();
        return Response.ok(gson.toJson(libraryDTO)).build();
    }

}
