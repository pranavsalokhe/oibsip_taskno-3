import java.util.*;

class Transaction{
	public int sum=0;
	//public int sub;
	String transaction_string;
	String transaction_string1="";
	public void transaction(){
		System.out.println("********************Transaction History********************");
		System.out.println(transaction_string1);
	}
}

class Withdraw extends Transaction{
	int withdraw_value;
	public int withdraw(int withdraw_value){
		this.withdraw_value=withdraw_value;
		if(sum>=withdraw_value){
		sum=sum-withdraw_value;
		//sub=withdraw_value-0;
		transaction_string="Withdraw amount:"+withdraw_value+"\n";
		transaction_string1=transaction_string1.concat(transaction_string);
		System.out.println("********************Withdraw amount********************");
		System.out.println("Withdraw amount:"+withdraw_value);
		
		}
		else{
			System.out.println("Insufficient Balance...");
		}
		return sum;
	}
}

class Deposite extends Withdraw{
	int deposit_value;
	public int deposit(int deposit_value){
		this.deposit_value=deposit_value;
		sum=deposit_value+sum;
		transaction_string="Deposited amount:"+deposit_value+"\n";
		transaction_string1=transaction_string1.concat(transaction_string);
		return deposit_value;
	}
}
class Transfer extends Deposite{
	String name;
	int account_no;
	int transfer_amount;
	public void transfer(String name,int account_no,int transfer_amount){
	//System.out.println("Transfer value in account:"+sum);
	this.name=name;
	this.account_no=account_no;
	this.transfer_amount=transfer_amount;
	if(sum>=transfer_amount){
	System.out.println("You have successfully transfer amount to:"+name+"\naccount number is:"+account_no+"\nTransfering amount is:"+transfer_amount);
	sum=sum-transfer_amount;
	transaction_string="You send money to:"+name+", account number:"+account_no+", transfering amount:"+transfer_amount+"\n";
	transaction_string1=transaction_string1.concat(transaction_string);
	}
	else{
		System.out.println("Sorry money is Insufficient...");
	}
	}
}
class Balance extends Transfer{
	public void balance(){
	System.out.println("********************Balance********************");
	System.out.println("Remainning Balance in your account is:"+sum);
	}
}

public class Atm{
	public static void main(String[] args){
		String user_name="";
		String password="";
		String us="";
		String pass="";
		Scanner x=new Scanner(System.in);			
		Balance t =new Balance();
		while(true){
		System.out.println("1.sign up\n2.sign in");
		int ch=x.nextInt();
		switch(ch){
			case 1:System.out.print("User Name:");
					user_name=x.next();
					System.out.println();
					System.out.print("Password:");
					password=x.next();
					break;
			case 2:System.out.print("User Name:");
					us=x.next();
					System.out.println();
					System.out.print("Password:");
				    pass=x.next();
					if(user_name.equals(us) && password.equals(pass)){
					System.out.println("Login Successfully...");
					while(true){
					System.out.println("**********Welcome to atm**********");
					System.out.println("1.Transaction History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Show Balance\n6.Quit");
					System.out.println("Enter your choice:");
					int choice=x.nextInt();
					switch(choice){
						case 1: t.transaction();
								break;
						case 2: System.out.println("Enter how many money we can withdraw:");
								int withdraw_value=x.nextInt();
								int with=t.withdraw(withdraw_value);
								System.out.println("Amount remainning in your account:"+with);
								break;
						case 3: System.out.println("Enter deposit value:");
								int deposit_value=x.nextInt();
								int depo=t.deposit(deposit_value);
								System.out.println("********************Deposite amount********************");
								System.out.println("Deposited amount:"+depo);
								break;
						case 4: System.out.println("Enter name(First Name)of receiver:");
								String name=x.next();
								System.out.println("Enter Account Number of receiver:");
								int account_no=x.nextInt();
								System.out.println("Enter how many amount you can transfer to receiver:");
								int transfer_amount=x.nextInt();
								t.transfer(name,account_no,transfer_amount);
								break;
						case 5: t.balance();
								break;
						case 6: System.exit(0);
			
						default: System.out.println("You Enter wrong choice...");
						}
					}
					}
					else{
					System.out.println("Sorry something went to wrong...");
					}
		
					break;
			default: System.out.println("Wrong choice...");
			}
		}
		
	}
}