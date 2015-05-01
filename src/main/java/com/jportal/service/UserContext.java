package com.jportal.service;

import com.jportal.model.Profile;
import com.jportal.model.Useraccess;


/**
 * Manages the current {@link CalendarUser}. This demonstrates how in larger applications it is good to abstract out
 * accessing the current user to return the application specific user rather than interacting with Spring Security
 * classes directly.
 *
 * @author Rob Winch
 *
 */
public interface UserContext {

    /**
     * Gets the currently logged in {@link CalendarUser} or null if there is no authenticated user.
     *
     * @return
     */
	Useraccess getCurrentUser();

    /**
     * Sets the currently logged in {@link CalendarUser}.
     * @param user the logged in {@link CalendarUser}. Cannot be null.
     * @throws IllegalArgumentException if the {@link CalendarUser} is null.
     */
    void setCurrentUser(Useraccess user);
}
