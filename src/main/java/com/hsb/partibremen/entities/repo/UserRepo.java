package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface UserRepo extends BaseRepo<User, UUID> {

}
