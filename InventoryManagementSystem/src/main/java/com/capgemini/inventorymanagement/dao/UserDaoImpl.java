package com.capgemini.inventorymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.inventorymanagement.entities.Userdata;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Userdata addUser(Userdata u) {
		// TODO Auto-generated method stub
		Userdata e=em.merge(u);
		return e;
	}

	@Override
	public List<Userdata> getAllUsers() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m from Userdata m");
		List<Userdata> userlist=q.getResultList();
		return userlist;
	}

	@Override
	public Userdata deleteUser(int userId) 
	{
		// TODO Auto-generated method stub
		Userdata ud=em.find(Userdata.class,userId);
		if(ud!=null)
			{em.remove(ud);
			}
        return ud;
	}

	@Override
	public Userdata updateUser(Userdata u) {
		// TODO Auto-generated method stub
		Userdata ud=em.find(Userdata.class,u.getUserId());
		if(ud!=null)
		{

			ud.setUsername(u.getUsername());
			ud.setUserPassword(u.getUserPassword());
			ud.setUserPhoneno(u.getUserPhoneno());
			ud.setUserEmail(u.getUserEmail());
		}
		return ud;
}
}

