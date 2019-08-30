/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashwin.cacheapp.response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ashwin.karki
 */
public class ResponseGen {
    
    public static Response success(Object entity) {
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    public static Response notFound(Object entity) {
        return Response.status(Response.Status.NOT_FOUND).entity(entity).build();
    }

    public static Response unauthorized(Object entity) {
        return Response.status(Response.Status.UNAUTHORIZED).entity(entity).build();
    }

    public static Response internalError(Object entity) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity).build();
    }

    public static Response internalErrorJSON(Object entity) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity).type(MediaType.APPLICATION_JSON).build();
    }

    public static Response methodNotAllowed(Object entity) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(entity).build();
    }
    
}
