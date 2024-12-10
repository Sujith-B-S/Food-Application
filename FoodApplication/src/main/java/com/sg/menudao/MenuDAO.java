package com.sg.menudao;

import java.util.List;

import com.sg.menupojo.Menu;

public interface MenuDAO {
	
	List<Menu> fetchOnId(int id);
	public Menu getMenu(int id);
	public List<Menu> getRatedMenu(double rating);

}
