package com.pragati.security.test2.controller;

import com.pragati.security.test2.model.Credentials;
import com.pragati.security.test2.model.TokenResponse;
import com.pragati.security.test2.service.LoginService;
import com.pragati.security.test2.util.JWTUtil;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    private LoginService loginService;

    @POST
    @Path("/login")
    public Response login(Credentials credentials) {
        if (credentials == null) return Response.status(Response.Status.BAD_REQUEST).build();

        boolean ok = loginService.validate(credentials.getUsername(), credentials.getPassword());
        if (!ok) return Response.status(Response.Status.UNAUTHORIZED).build();

        Set<String> roles = loginService.getRoles(credentials.getUsername());
        String token = JWTUtil.generateToken(credentials.getUsername(), roles);

        return Response.ok(new TokenResponse(token)).build();
    }
}
