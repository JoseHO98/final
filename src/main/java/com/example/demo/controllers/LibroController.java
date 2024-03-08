package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Libro;
import com.example.demo.model.TipoLibro;
import com.example.demo.service.LibroService;
import com.example.demo.service.TipoLibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private TipoLibroService tipolibroService;
	
	@GetMapping("/getAllLibros")
	public String getAllLibros(Model model) {
		List<Libro> listLibro = libroService.getAllLibros();
		model.addAttribute("libro", listLibro);
		return "LibrosList";
	} 
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("tipolibro", tipolibroService.getAllTipoLibro());
		return "libroRegister";
	}
	
	@PostMapping("/register")
	public String createLibro(@RequestParam("nombrelibro") String nombrelibro,
			@RequestParam("autor") String autor,
			@RequestParam("fechapublicacion") String fechapublicacion,
			@RequestParam("id") Long id,Model model) {
		
		Libro libro = new Libro();
		libro.nombrelibro = nombrelibro;
		libro.autor = autor;
		libro.fechapublicacion = fechapublicacion;
		
		TipoLibro tipolibro = tipolibroService.getTipoLibroById(id);
		
		libro.TipoLibro = tipolibro;
		libroService.createLibro(libro);
		
		model.addAttribute("libros", libroService.getAllLibros());
		model.addAttribute("tipolibros", tipolibroService.getAllTipoLibro());
		
		return "redirect:/libro/getAllLibros";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
	    Libro libro = libroService.getLibroById(id);
	    model.addAttribute("libro", libro);
	    model.addAttribute("tipolibros", tipolibroService.getAllTipoLibro());
	    
	    return "libroEdit";
	}
	
	@PostMapping("/edit")
	public String createLibro(@RequestParam("id") Long id, @RequestParam("nombrelibro") String nombrelibro,
			@RequestParam("autor") String autor,
			@RequestParam("fechapublicacion") String fechapublicacion,
			@RequestParam("cod_id_genero") Long CodIdGenero,Model model) {
		
		Libro libro = libroService.getLibroById(id);
		libro.nombrelibro = nombrelibro;
		libro.autor = autor;
		libro.fechapublicacion = fechapublicacion;
		
		TipoLibro tipolibro = tipolibroService.getTipoLibroById(CodIdGenero);
		
		libro.TipoLibro = tipolibro;
		libroService.createLibro(libro);
		
		model.addAttribute("libros", libroService.getAllLibros());
		model.addAttribute("tipolibros", tipolibroService.getAllTipoLibro());
		
		return "redirect:/libro/getAllLibros";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteLibro(@PathVariable Long id,Model model) {
		
		libroService.deleteLibro(id);
		model.addAttribute("libros", libroService.getAllLibros());
		model.addAttribute("tipolibros", tipolibroService.getAllTipoLibro());
		return "redirect:/libro/getAllLibros";
	}
}
