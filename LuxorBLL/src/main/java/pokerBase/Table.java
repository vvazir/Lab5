package pokerBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Table implements Serializable {
	
	@XmlElement
	private UUID TableID;
	
	@XmlElement
	private HashMap HashMapPlayer = new HashMap<UUID, Player>();
	
	public Table()
	{
		TableID = UUID.randomUUID();
	}
	public Table AddPlayerToTable(Player p)
	{
		HashMapPlayer.put(p.getPlayerID(), p);
		return this;
	}
	public Table RemovePlayerFromTable(Player p)
	{
		HashMapPlayer.remove(p.getPlayerID());
		return this;
	}
	public HashMap getHashPlayers() {
		return HashMapPlayer;
	}
	
	public static void StateOfTable(Table t)
	{
		System.out.println("----------------------");
		System.out.println("Table : " + t.TableID);
		System.out.println("Table Nbr of Players: " + t.getHashPlayers().size());
		Iterator it = t.getHashPlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			
			System.out.println("Player ID: " + p.getPlayerID().toString());
			System.out.println("Player Position: " + p.getiPlayerPosition());
			System.out.println("Player Name: " + p.getPlayerName());
			System.out.println("----------------------");
		}
		
		System.out.println("----------------------");
		System.out.println(" ");
	}
}
