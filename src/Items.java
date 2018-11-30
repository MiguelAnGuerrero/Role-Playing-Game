
public class Items 
{
	private int knowledge;
	private int stamina;
	private String name;
	
	Items ()
	{
		int knowledge = -1;
		int stamina = -1;
		String name = "none";
	}
	
	Items (int knowledge, int stamina)
	{
		this.knowledge = knowledge;
		this.stamina = stamina;
	}

	public int getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	

}
