package com.quanlychiteunhom.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.entities.Invite;

public interface InviteRepo extends JpaRepository<Invite, Integer> {

    Optional<Invite> findByToken(String token);
}
