package cuit.services;

import java.util.List;

import cuit.daos.ManagerDAO;
import cuit.pojos.Manager;

public class ManagerService {
	private ManagerDAO managerDAO = new ManagerDAO();
	
	public List<Manager> findAllManager(){
		return managerDAO.findAllManager();
	}
	
	public Manager getManagerByName(String name) {
		Manager manager = null;
		if(managerDAO.getManagerByName(name)!=null) {
			manager = managerDAO.getManagerByName(name);
			return manager;
		}else {
			System.out.println("数据库中没有这个用户："+name);
			return null;
		}
		
	}
	public Manager getManagerById(int managerid) {
		Manager manager = null;
		if(managerDAO.getManagerById(managerid)!=null) {
			manager = managerDAO.getManagerById(managerid);
			return manager;
		}else {
			System.out.println("数据库中没有这个用户："+managerid);
			return null;
		}
		
	}
	
	public void addManager(Manager manager) {
		managerDAO.addManager(manager);
	}

	public void updateManager(Manager manager) {
		managerDAO.updateManager(manager);
	}
}
