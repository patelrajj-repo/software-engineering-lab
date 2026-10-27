package com.lab.memory

import java.util.ArrayList;
import java.util.List;

public class MemoryInspector {

	static class Account {
		String id;
		double balance;

		Account(String id, double balance) {
			this.id = id;
			this.balance = balance;
		}
	}
	
	public static void main(String[] args) {
		int initialAmount = 500;
		Account primaryAccont = new Account("ACC-1001", 1500.00)
		List<Account> logList = new ArrayList<>();

		processTransaction(primaryAccount, initialAmount, logList);

		//POINT A: Exeecution reaches here
		system.out.println("Main Account Balance: " + prmaryAccount.balance);
		system.out.println("Main Initial Amount: " + initialAmount);
		system.out.println("Log Size: " + logList.size());
	}

	private static void processTransaction(Account acc, int amount, List<Account> list) {
		amount = amount + 200;
		acc.balance = acc.balance - amount;
		list.add(acc);
		acc = new Account("ACC-9999", 0.00);
		acc.balance = 9999.00;
	}
}
