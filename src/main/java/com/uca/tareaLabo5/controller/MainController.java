package com.uca.tareaLabo5.controller;

import com.uca.tareaLabo5.dao.EstudianteDAO;
import com.uca.tareaLabo5.domain.Estudiante;
import com.uca.tareaLabo5.service.EstudianteService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
    private EstudianteService estudianteService;
	
	//formulario para ingresar estudiante
    @RequestMapping("/insertarEstudiante")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = new Estudiante();
        mav.addObject("estudiante", estudiante);
        mav.setViewName("index");
        return mav;
    }
    
   //Mostrar Lista de Estudiantes con opciones
    @RequestMapping("/estudiantes")
    public ModelAndView listado(){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> studentList = null;
        try {
        	studentList = estudianteService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiantes", studentList);
        mav.setViewName("listadoMain");
        return mav;
    }
    
    //Guardar estudiante
    @RequestMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute Estudiante estudiante, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if(result.hasErrors()) {
        	mav.setViewName("index");
        }else {
        	estudianteService.save(estudiante);
        	List <Estudiante> studentList = null;
        	 try {
        		 studentList = estudianteService.findAll();
             }catch (Exception e){
                 e.printStackTrace();
             }
        	 mav.addObject("estudiantes", studentList);
        	 mav.setViewName("listado");
        }
        return mav;
    }
    
    //borrar estudiante
    @RequestMapping(value = "/searchDelete", method = RequestMethod.POST, params="action=eliminar")
    public ModelAndView delete(@RequestParam(value="codigo") int id) {
    	ModelAndView mav = new ModelAndView();
    	List <Estudiante> studentList = null;
    	try {
    		estudianteService.delete(id);
    		studentList = estudianteService.findAll();
    	}  catch (Exception e) {
    		e.printStackTrace();
    	}
    	mav.addObject("estudiantes", studentList);
    	mav.setViewName("listado");
    	return mav;
    }
    
    
    //Mostrar estudiante por id
    @RequestMapping(value = "/searchDelete", method = RequestMethod.POST, params="action=buscar")
    public ModelAndView findOne(@RequestParam(value="codigo") int id) {
    	ModelAndView mav = new ModelAndView();
    	Estudiante estudiante = null;
    	try {
    		estudiante = estudianteService.findOne(id);
    	}  catch (Exception e) {
    		e.printStackTrace();
    	}
    	mav.addObject("estudiante", estudiante);
    	mav.setViewName("estudiante");
    	return mav;
    }
    
    //borrar estudiante
    @RequestMapping(value = "/filtrar")
    public ModelAndView filtro(@RequestParam(value="nombre") String cadena) {
    	ModelAndView mav = new ModelAndView();
    	List <Estudiante> studentList = null;
    	try {
    		studentList = estudianteService.filtrarPor(cadena);
    	}  catch (Exception e) {
    		e.printStackTrace();
    	}
    	mav.addObject("estudiantes", studentList);
    	mav.setViewName("listado");
    	return mav;
    }
    
    //Editar estudiante por id
    @RequestMapping(value = "/edit")
    public ModelAndView edit(@RequestParam(value="codigo") int id) {
    	ModelAndView mav = new ModelAndView();
    	Estudiante estudiante = null;
    	try {
    		estudiante = estudianteService.findOne(id);
    		
    	}  catch (Exception e) {
    		e.printStackTrace();
    	}
    	mav.addObject("estudiante", estudiante);
    	mav.setViewName("editarEstudiante");
    	return mav;
    }
}
