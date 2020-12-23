package com.btl.dattiec.Service;

import com.btl.dattiec.Models.Customer;
import com.btl.dattiec.Models.Lobby;

import java.util.List;

public interface LobbyService {

	public void delete(Long id);

	public void save(Lobby lobby);

	public void update(Lobby lobby);

	public Lobby getById(Long id);

	public List<Lobby> findAll();

}
