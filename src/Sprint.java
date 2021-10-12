import java.util.ArrayList;

public class Sprint {
	
	private ArrayList<Base> sprint = new ArrayList<>();
	
	public void adicionaUserStory(Base userStory) {
		sprint.add(userStory);
	}
	public String get(int valor) {
		return sprint.get(valor).infoBase();
	}
	
	public void getList()
	{
		for(Base funcao: sprint)
		{
			System.out.println(funcao.infoBase());
		}
	}
	
	public int size()
	{
		return sprint.size();
		
	}
	
	public Base getBase(int val)
	{
		return sprint.get(val);
	}
}
