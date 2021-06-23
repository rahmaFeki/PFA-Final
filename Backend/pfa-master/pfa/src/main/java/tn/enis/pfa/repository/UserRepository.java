package tn.enis.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.pfa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
