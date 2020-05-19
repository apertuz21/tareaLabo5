package com.uca.tareaLabo5.controller;

import com.uca.tareaLabo5.dao.EstudianteDAO;
import com.uca.tareaLabo5.domain.Estudiante;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
    private EstudianteDAO estudianteDAO;

    @RequestMapping("/inicio")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = new Estudiante();
        mav.addObject("estudiante", estudiante);
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/ingresarEstudiante")
    public ModelAndView insert(@Valid @ModelAttribute Estudiante estudiante, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if(result.hasErrors()) {
        	mav.setViewName("index");
        }else {
        	 try {
                 estudianteDAO.insert(estudiante);
                 Estudiante alumno = new Estudiante();
                 mav.addObject("estudiante", alumno);
                 mav.setViewName("index");
             }catch (Exception e){
                 e.printStackTrace();
             }
        }
        return mav;
    }
    @RequestMapping("/listado")
    public ModelAndView listado(){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> studentList = null;
        try {
        	studentList = estudianteDAO.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiantes", studentList);
        mav.setViewName("listado");
        return mav;
    }
}
