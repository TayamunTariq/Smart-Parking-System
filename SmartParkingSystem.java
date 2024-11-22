import java.util.Scanner;
class Entry
{
	public static int[] ids=new int[]{100,101,102,103,104,105,106,107,108};
	Entry()
    {
		System.out.println("Please Enter your ID:");
		Scanner ob1=new Scanner(System.in);
		int userid=ob1.nextInt();
		boolean entryallowed=false;
		for(int i=0;i<ids.length;i++)
		{
			if(userid==ids[i])
			{
				System.out.println("\n[ENTRY ALLOWED!]");
				entryallowed=true;
				System.out.println("->Access granted to parking area.");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				break;
			}
		}
		if(!entryallowed)
		{
			System.out.println("\n[ENTRY NOT ALLOWED!]");
			System.out.println("->Your ID is not registered in our system.\n");
		}
			
	}
}
class Parkingarea{
    public static int maxs = 4;
    public static int maxp = 2;
    public static int[][] slot1 = new int[maxp][maxs];
    public static int[][] slot2 = new int[maxp][maxs];
    
    void allot(Vehicle v1) {
        boolean slotAssigned = false;
		//System.out.println("Allocating a Parking Slot for Vehicle ID:"+v1.id);
		// Check slot1 for an available slot
        for (int s = 0; s < maxs; s++)
		{
            if (slot1[1][s] == 0) 
			{
                slot1[1][s] = v1.id;
                System.out.println("->Your allotted slot is: P1S"+s+ " in Parking Area 1\n");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                slotAssigned = true;
                break;
            }
        }
        // If no slot available in slot1, check slot2
        if (!slotAssigned) 
		{
            for (int s = 0; s < maxs; s++) 
			{
                if (slot2[1][s] == 0) 
				{ 
                    slot2[1][s] = v1.id;
					System.out.println("->Your allotted slot is: P2S"+s+ " in Parking Area 2\n");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");	
                    slotAssigned = true;
                    break;
                }
            }
        }
        // If no slot is available in either slot1 or slot2
        if (!slotAssigned) 
		{
            System.out.println("Parking is currently full. No slots available.\n");
        }
    }
}
class Vehicle
{
	public static int id;
	public static int i=1;
	final static int maxcapacity=20;
	Vehicle()
	{
		id=i;
		i++;
		if(i==maxcapacity)
		{
			System.out.println("[NO MORE CAPACITY!]");
		}
		System.out.println("VEHICLE REGISTERED. Your allocated Vehicle ID is:"+id);
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		
	}
}
	
class SmartParkingSystem
{
	public static void main(String args[])
	{
		System.out.println("\n*************************************************WELCOME TO THE SMART PARKING SYSTEM**********************************************\n");
		for(int k=0;k<8;k++)
		{
			Entry e1=new Entry();
			Vehicle v1=new Vehicle();
			Parkingarea p1=new Parkingarea();
			p1.allot(v1);
		}
        
        System.out.println("Would you like to enter Parking Area 1? (true/false)");
        Boolean check;
        Scanner inp= new Scanner(System.in);
        check= inp.nextBoolean();
        if(check)
        {
            for(int s=0; s< Parkingarea.maxs; s++)
            {
                System.out.println("Enter Your Alloted Vehicle ID:");
                int newId= inp.nextInt();
                if(newId== Parkingarea.slot1[1][s])
                {
                    System.out.println("Access granted to your alloted slot in Parking Area 1!\n");
					
                }
                else
                {
                    System.out.println("Access Denied! Incorrect ID.\n");
                }
            }
        }
        else
        {
            for(int s=0; s< Parkingarea.maxs; s++)
            {
                System.out.println("Enter Your Alloted Vehicle ID:");
                int newId= inp.nextInt();
                if(newId== Parkingarea.slot2[2][s])
                {
                    System.out.println("Access granted to your alloted Slot in Parking Area 2!\n");					
                }
                else
                {
                    System.out.println("Access Denied! Incorrect ID.\n");
                }
            }
        }
	}
}
		
		
		
		
	
	


		
