package com.lovemehta.splitwise.repositories;

import java.util.HashMap;

import com.lovemehta.splitwise.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRepository {

	public static HashMap<Integer, User> users = new HashMap<Integer, User>();

}
