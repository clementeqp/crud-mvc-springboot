package com.clemen.mvc.controllers;


import com.clemen.mvc.entities.Cliente;
import com.clemen.mvc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping("/")
    public String returnIndex(Model model) {

        List<Cliente> clientes = clienteService.buscarTodos();
        model.addAttribute("clientes", clientes);
        return "index";

    }

    // Ver todos los clientes

    @GetMapping("/index")
    public String verClientes(Model model) {

        List<Cliente> clientes = clienteService.buscarTodos();
        model.addAttribute("clientes", clientes);
        return "index";

    }


    @GetMapping("/formNuevoCliente")
    public String formularioCliente(Model model) {

        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "nuevo_cliente";

    }


    @PostMapping("/guardarCliente")
    public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {

        // Guardar cliente en BD
        clienteService.guardar(cliente);
        return "redirect:/index";

    }

    @GetMapping("/formActualizarCliente/{id}")
    public String formularioCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);

        model.addAttribute("cliente", cliente);
        return "editar_cliente";
    }


    @GetMapping("/borrarCliente/{id}")
    public String eliminarCliente(@PathVariable(value = "id") Long id) {

        this.clienteService.borrar(clienteService.buscarPorId(id));
        return "redirect:/index";

    }

}