
public class Character 
{
	private int stamina, knowledge, locationX, locationY, count;
	private String name;
	private Items [] inventory = new Items[5];
	
	Character ()
	{
		int locationX = 2;
		int locationY = 4;
		int stamina = 0;
		int knowledge = 0;
		int count = 0;
		String name = "none";
	}
	
	Character (int stamina, int knowledge, String name)
	{
		this.stamina = stamina;
		this.knowledge = knowledge;
		this.name = name;
	}
	
	public void fillInventory()
	{
		Items item0 = new Items();
		Items item1 = new Items();
		Items item2 = new Items();
		Items item3 = new Items();
		Items item4 = new Items();

		
		inventory[0] = item0;
		inventory[1] = item1;
		inventory[2] = item2;
		inventory[3] = item3;
		inventory[4] = item4;
	
		
	}
	
	public void addItem(int slot, Items item)
	{
		inventory[slot].setName(item.getName());
	}
	
	public void viewInventory() 
	{
		for (int i = 0; i < 5; i++) 
		{

			System.out.print("[ " + inventory[i].getName() + " ] ");

		}
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}

	public int getLocationX() {
		return locationX;
	}

	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Items[] getInventory() {
		return inventory;
	}

	public void setInventory(Items[] inventory) {
		this.inventory = inventory;
	}


	
	
}
