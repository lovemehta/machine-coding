package com.lovemehta.splitwise.repositories;

import java.util.HashMap;

import com.lovemehta.splitwise.models.Group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupRepository {

	public static HashMap<Integer, Group> groups = new HashMap<Integer, Group>();

}
