package com.btl.dattiec.Controllers;


import com.btl.dattiec.Models.Lobby;
import com.btl.dattiec.Service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/lobby")
public class LobbyController {

	@Autowired
	private LobbyService lobbyService;

	@GetMapping
	public String goLobby(Model model) {

		List<Lobby> lobbies = lobbyService.findAll();

		model.addAttribute("lobbies", lobbies);
		return "lobby";
	}

	@GetMapping("/get")
	public String getLobby(@RequestParam(value = "id") Long id, Model model) {

		Lobby lobby = lobbyService.getById(id);
		model.addAttribute("lobby", lobby);

		return "lobby-detail";
	}

	@PostMapping("/add")
	public String addLobby(@ModelAttribute(value = "lobby") Lobby lobby) {

		lobbyService.save(lobby);
		return "redirect:/lobby";
	}

	@GetMapping("/add")
	public String addLobby(Model model) {
		Lobby lobby = new Lobby();
		model.addAttribute("lobby", lobby);

		return "add-lobby";
	}

	@GetMapping("/delete")
	public String deleteLobby(@RequestParam(value = "id") Long id) {
		lobbyService.delete(id);
		return "redirect:/lobby";
	}

	@PostMapping("/update")
	public String updateLobby(@ModelAttribute(value = "lobby") Lobby lobby) {

		lobbyService.update(lobby);
		return "redirect:/lobby";
	}
}
