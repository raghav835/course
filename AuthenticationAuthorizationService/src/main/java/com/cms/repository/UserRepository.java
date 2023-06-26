package com.cms.repository;

import com.cms.model.User;

public interface UserRepository {

    /**
     * Save a user object in the repository.
     *
     * @param user The user object to be saved.
     * @return The saved user object.
     */
    User save(User user);

    /**
     * Retrieve a user by its username.
     *
     * @param username The username of the user.
     * @return The user object.
     */
    User findByUsername(String username);

    /**
     * Delete a user by its username.
     *
     * @param username The username of the user.
     */
    void deleteByUsername(String username);
}
