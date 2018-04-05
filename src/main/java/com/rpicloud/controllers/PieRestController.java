package com.rpicloud.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rpicloud.dto.ErrorResponse;
import com.rpicloud.models.Pie;
import com.rpicloud.repositories.PieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/pies")

@Api(value = "piesapp")

public class PieRestController {

	@Autowired
	private PieRepository repository;

	@ApiOperation(value = "ACH/PRM - Get customer Account Details", notes = "Connect to the acount's financial institution and restrieve", tags = {
			"customers" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pie list", response = List.class),
			@ApiResponse(code = 400, message = "Bad request", response=ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorization", response=ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response=ErrorResponse.class)})
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public List<Pie> getAllPies() {
		System.out.println("test");
		return (List<Pie>) repository.findAll();
	}

	@ApiOperation(value = "ACH/PRM - Get customer Account Details", notes = "Connect to the acount's financial institution and restrieve", tags = {
			"customers" }, response = Pie.class)

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pie", response = Pie.class),
			@ApiResponse(code = 400, message = "Bad request", response=ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorization", response=ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response=ErrorResponse.class)})

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = { "application/json", "application/xml" })
	public Pie getPieWithId(@PathVariable Long id) {
		return repository.findOne(id);
	}

	@ApiOperation(value = "ACH/PRM - Get customer Account Details", notes = "Connect to the acount's financial institution and restrieve", tags = {
			"customers" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pie list", response = List.class),
			@ApiResponse(code = 400, message = "Bad request", response=ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorization", response=ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response=ErrorResponse.class)})
	@RequestMapping(method = RequestMethod.GET, value = "/findByName", params = { "name" }, produces = {
			"application/json", "application/xml" })
	//@ApiParam(name = "name", value = "pet name", defaultValue = "")
	public List<Pie> findPieWithName(
			@RequestParam(value = "name") String name) {
		return repository.findByName(name);
	}

	@ApiOperation(value = "ACH/PRM - Get customer Account Details", notes = "Connect to the acount's financial institution and restrieve", tags = {
			"customers" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Pie", response = Pie.class),
			@ApiResponse(code = 400, message = "Bad request", response=ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorization", response=ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response=ErrorResponse.class)})

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json",
			"application/xml" })
	public Pie addPie(@RequestBody Pie input) {
		return repository.save(input);
	}
}

// @ApiOperation(value = "getPieWithId", nickname = "getPieWithIdNick", response
// = Pie.class)
// @ApiImplicitParams({
// @ApiImplicitParam(name = "id", value = "Pie id", required = true, dataType =
// "long", paramType = "path", defaultValue="0")
// })
// @ApiResponses(value = {
// @ApiResponse(code = 200, message = "Success", response = Greeting.class),
// @ApiResponse(code = 401, message = "Unauthorized"),
// @ApiResponse(code = 403, message = "Forbidden"),
// @ApiResponse(code = 404, message = "Not Found"),
// @ApiResponse(code = 500, message = "Failure")})
//
