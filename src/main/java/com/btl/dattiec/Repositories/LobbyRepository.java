package com.btl.dattiec.Repositories;

import com.btl.dattiec.Models.Lobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LobbyRepository extends JpaRepository<Lobby,Long> {

	public List<Lobby> findAll();

	public Lobby getById(Long id);
}
