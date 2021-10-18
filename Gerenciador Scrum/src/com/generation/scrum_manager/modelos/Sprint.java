package com.generation.scrum_manager.modelos;

import java.util.ArrayList;

public class Sprint {
	
	private  ArrayList<UserStory> sprint = new ArrayList<>();
	
	public void atualiza(UserStory userStory, ArrayList<UserStory> backLog) {
		sprint.add(userStory);
		backLog.remove(userStory);
	}

	public String get(int valor) {
		return sprint.get(valor).infoBase();
	}
	
	public void getList()
	{
		for(UserStory funcao: sprint)
		{
			System.out.println(funcao.infoBase());
		}
	}

	public int size()
	{return sprint.size();}
	
	public UserStory getBase(int val)
	{
		return sprint.get(val);
	}

}
