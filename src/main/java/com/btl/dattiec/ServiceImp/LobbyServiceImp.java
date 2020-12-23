package com.btl.dattiec.ServiceImp;

import com.btl.dattiec.Models.Lobby;
import com.btl.dattiec.Repositories.LobbyRepository;
import com.btl.dattiec.Service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobbyServiceImp implements LobbyService {

	private LobbyRepository lobbyRepository;

	@Autowired
	private LobbyServiceImp(LobbyRepository lobbyRepository) {
		this.lobbyRepository = lobbyRepository;
	}

	@Override
	public void delete(Long id) {
		Lobby lobby = this.getById(id);
		this.lobbyRepository.delete(lobby);
	}

	@Override
	public void save(Lobby lobby) {
		this.lobbyRepository.save(lobby);
	}

	@Override
	public void update(Lobby lobby) {
		Lobby newLobby = this.getById(lobby.getId());
		newLobby.setCode(lobby.getCode());
		newLobby.setName(lobby.getName());
		newLobby.setPrice(lobby.getPrice());
		newLobby.setNote(lobby.getNote());
		newLobby.setType(lobby.getType());
		this.lobbyRepository.save(newLobby);
	}

	@Override
	public Lobby getById(Long id) {
		return this.lobbyRepository.getById(id);
	}

	@Override
	public List<Lobby> findAll() {
		return this.lobbyRepository.findAll();
	}
}
