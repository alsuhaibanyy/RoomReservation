package roomreservation;

import java.io.*;
import java.util.*;

class Customer {
	private String name;
	private int room;
	private int roomNo;
	private int totalMembers;

	public int getTotalMembers() {
		return totalMembers;
	}

	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getRoom() {
		return this.room;
	}
}

public class RoomReservation {

	public static void initialize(Customer RoomList[]) {
		for (int i = 0; i < RoomList.length; i++) {
			RoomList[i] = new Customer();
			RoomList[i].setName("EMPTY");
			RoomList[i].setRoom(i + 1);
		}
	}

	public static void viewList(Customer RoomList[]) {
		for (int i = 0; i < RoomList.length; i++) {
			if (RoomList[i].getName() == "EMPTY")
				System.out.println("Room number " + RoomList[i].getRoom()
						+ " is vacant.");
			else
				System.out.println("Room number " + RoomList[i].getRoom()
						+ " is ocupied by " + RoomList[i].getName() + ".");
		}
		System.out.println();
	}

	public static boolean addCustomer(Customer RoomList[], String name,
			int roomNo) {
		// for(int i=0; i<RoomList.length; i++)
		if (RoomList[roomNo - 1].getName().equals("EMPTY")) {
			RoomList[roomNo - 1].setName(name);
			return true;
		}
		return false;
	}

	public static void showEmptyRooms(Customer RoomList[]) {
		System.out.println("Available rooms are:");
		for (int i = 0; i < RoomList.length; i++)
			if (RoomList[i].getName() == "EMPTY")
				System.out.println(RoomList[i].getRoom());
		System.out.println();
	}

	public static boolean deleteCustomer(Customer RoomList[], String name) {
		for (int i = 0; i < RoomList.length; i++)
			if (RoomList[i].getName().equals(name)) {
				RoomList[i].setName("EMPTY");
				System.out.println("Deletion successful.\n");
				return true;
			}
		return false;
	}

	public static int getIndex(Customer RoomList[], String name) {
		for (int i = 0; i < RoomList.length; i++)
			if (RoomList[i].getName().equals(name))
				return i;
		return -1;
	}

	private static void viewOffSeasonPricesList() {
		// TODO Auto-generated method stub
		System.out
				.println("Price List for 1-16 rooms on weekdays are 175$ and weekend rates are 205$\n ");
		System.out
				.println("Price List for 17-32 rooms on weekdays are 325$ and weekend rates are 355$\n ");
		System.out
				.println("Price List for 33-36 rooms on weekdays are 600$ and weekend rates are 630$\n ");
		System.out.println();
	}

	private static void viewPeakSeasonPricesList() {
		// TODO Auto-generated method stub
		System.out
				.println("Price List for 1-16 rooms on weekdays are 140$ and weekend rates are 170$\n ");
		System.out
				.println("Price List for 17-32 rooms on weekdays are 260$ and weekend rates are 290$\n ");
		System.out
				.println("Price List for 33-36 rooms on weekdays are 480$ and weekend rates are 510$\n ");
		System.out.println();
	}

	public static void main(String[] args) {
		Customer[] RoomList = new Customer[36];
		String name;
		int roomNo;
		int totalMembers;
		int counter = 0;
		initialize(RoomList);
		Scanner input = new Scanner(System.in);
		int option = 0;

		do {
			System.out.println("        Hotel Booking Options");
			System.out.println("=====================================");
			System.out.println("1: To View all rooms");
			System.out.println("2: To Add customer to a room");
			System.out.println("3: To Display empty rooms");
			System.out.println("4: To Delete customer from a room");
			System.out.println("5: Find room from customer name");
			System.out.println("6: Price List in Off Season(Aug-May)");
			System.out.println("7: Price List in peak Season(May-Aug)");
			System.out.println("0: Exit");

			System.out.print("\nEnter your choice: ");
			option = input.nextInt();
			System.out.println();

			switch (option) {
			case 1: {
				viewList(RoomList);
				break;
			}
			case 2: {
				System.out.print("Customer's name: ");
				name = input.next();

				System.out.print("Total Members: ");
				totalMembers = input.nextInt();
				if (totalMembers < 3) {
					System.out.print("Please select rooms 1-16 ");
					counter = 1;
				} else if (totalMembers > 2 && totalMembers < 5) {
					System.out.print("Please select rooms 17-32 ");
					counter = 2;
				} else if (totalMembers > 4 && totalMembers < 9) {
					System.out.print("Please select rooms 32-36 ");
					counter = 3;
				} else {
					System.out.print("Sorry no rooms available!!!\n ");
					counter = 0;
					break;
				}
				System.out.print("Room No: ");
				roomNo = input.nextInt();

				if (counter == 1 && roomNo > 16) {
					System.out.println("Please select correct room!\n");
					break;
				}

				if (counter == 2 && (roomNo < 16 || roomNo > 32)) {
					System.out.println("Please select correct room!\n");
					break;
				}
				if (counter == 2 && (roomNo < 32 || roomNo > 36)) {
					System.out.println("Please select correct room!\n");
					break;
				}
				System.out.println();
				if (!addCustomer(RoomList, name, roomNo))
					System.out.println("Room is already booked!");
				break;
			}
			case 3: {
				showEmptyRooms(RoomList);
				break;
			}
			case 4: {
				System.out.print("Customer's name: ");
				name = input.next();
				System.out.println();
				deleteCustomer(RoomList, name);
				break;
			}
			case 5: {
				System.out.print("Customer's name: ");
				name = input.next();
				System.out.println();
				int index = getIndex(RoomList, name);
				if (index == -1 ) {
					System.out.println("Customer not found!\n");
				} else {
					System.out.println("Customer's room: "
							+ RoomList[index].getRoom() + "\n");
				}
				break;
			}
			case 6: {

				viewPeakSeasonPricesList();

				break;
			}
			case 7: {

				viewOffSeasonPricesList();

				break;
			}

			case 0: {
				System.out.println("\nThank you!\n");
				break;
			}
			default: {
				System.out.println("Invalid option!\n");
				break;
			}
			}

		} while (option != 0);
		input.close();
	}

}