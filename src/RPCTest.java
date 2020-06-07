import java.util.Random;
import java.util.Scanner;

class User {

	private String name;
	private String rpc;
	private String rpcNum;
	
	public int getRpcNum() {		
		for(int i=0;i<3;i++) {
			if(rpc.equals(RPCGame.RPC[i])) {
				return i;
			}
		}		
		return 0;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public void generateRPC() {		
		Random random = new Random();
		int value = random.nextInt(3);		
		rpc = RPCGame.RPC[value];
	}
	public String getRpc() {
		return rpc;		
	}
	
	public void setRpc(String rpc) {
		this.rpc = rpc;		
	}
	
	public void printCompare(User user) {
	
		System.out.println("-------- 가위 바위 보 !----------"); 
		System.out.printf("[ %s ] VS [ %s ] \n", this.name, user.name);
		
		int myNum = getRpcNum();
		int userNum = user.getRpcNum();
		
		
		if ((myNum == 0 && userNum == 0) || (myNum == 1 && userNum == 1) || (myNum == 2 && userNum == 2)){ 
				System.out.println(this.name + ":" + this.getRpc() + "  " + user.name + ":" + user.getRpc() +  " " +"무승부..."); 
		} else if ((myNum == 0 && userNum == 1) || (myNum == 1 && userNum == 2) || (myNum == 2 && userNum == 0)) { 
			System.out.println(this.name + ":" + this.getRpc() + "  " + user.name + ":" + user.getRpc() +" " +"승리!"); 
		} 
		else if ((myNum == 0 && userNum == 2) || (myNum == 1 && userNum == 0) || (myNum == 2 && userNum == 1)) { 
			System.out.println(this.name + ":" + this.getRpc() + "  " + user.name + ":" + user.getRpc() + " " +"패배ㅠㅠ");
		}
		
	}
}

class RPCGame{
	
	final static String[] RPC = {"가위","바위","보"};
	
	public boolean isRPCString(String rpc) {
		boolean isRPC = false;
		
		for(String str : RPC) {
			if(rpc.trim().equals(str))
				return true;
		}
		
		return isRPC;
	}
	
		
	public void execute() {
		User computer = new User("컴퓨터");
		User person = new User("사람");
		
		Scanner scanner = new Scanner(System.in);
		String personRPC = null;
		
		while(true) {
			System.out.println("가위 바위 보 입력하세요");
			
			try {
				personRPC = scanner.next();
				boolean isRPC = isRPCString(personRPC);
				
				if(isRPC == false) {
					continue;
				}else {
					person.setRpc(personRPC);
					computer.generateRPC();//컴퓨터 
				}
				
				computer.printCompare(person);
							
				
				
			} catch (Exception e) {
				System.out.println("잘못입력하였습니다.");
				continue;
			}			
		}
	
	}	
}
public class RPCTest {

	public static void main(String[] args) {
		RPCGame rpcGame = new RPCGame();
		rpcGame.execute();

	}

}
