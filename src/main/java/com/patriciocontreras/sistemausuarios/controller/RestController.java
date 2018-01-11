package com.patriciocontreras.sistemausuarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patriciocontreras.sistemausuarios.model.ContacModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	//este metodo devuelve un json
	@GetMapping("/checkrest")
	public ResponseEntity<ContacModel> checkRest(){
		ContacModel cm = new ContacModel(2, "fernanda", "suarez", "344388", "chillan");
		return new ResponseEntity<ContacModel>(cm,HttpStatus.OK);
	}
	
}
