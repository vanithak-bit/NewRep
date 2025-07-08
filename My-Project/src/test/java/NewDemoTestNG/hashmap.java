package NewDemoTestNG;

import java.util.HashMap;

public class hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		
		//Add key value pairs
		map.put("Apple", 3);
		map.put("Banana", 5);
		map.put("Cherry",7);
				
		System.out.println(map.get("Cherry"));
		System.out.println(map.containsKey("Banana"));
		
		map.remove("Banana");
		
		for (String i:map.keySet())
		{
		 System.out.println(map.get(i));
		}

	
	}

}
