class makeBankAccounts
{
	public static void main(String[] args)
	{
		// names of the smith family
		String[] theSmiths = {"Mary", "Fred", "Josie", "Alan", "Jeff", "Maggie", "Joe", "Betty"};
		
		// names of the jones family
		String[] theJones = {"Mary", "Fred", "Josie", "Alan", "Jeff", "Maggie", "Joe", "Betty"};
		
		// arraylist for the smith's BankAccounts
		java.util.ArrayList<BankAccount> bankAcounts = new java.util.ArrayList<>();
		
		// arraylist for the jones' EnhancedBankAccounts
		java.util.ArrayList<EnhancedBankAccount> enhancedBankAccounts = new java.util.ArrayList<>();
		
		// create the smith's BankAccount objects and store in the arraylist 
		System.out.println("BankAccount.getBankAccountCount() = " + BankAccount.getBankAccountCount());
		for( int i = 0; i < theSmiths.length; i++ )
		{
			BankAccount ba = new BankAccount("Smith", theSmiths[i]);
			bankAcounts.add(ba);
			System.out.println("BankAccount.getBankAccountCount() = " + BankAccount.getBankAccountCount());
		}
		
		// create the jones' EnhancedBankAccount objects and store in the arraylist
		// also give them a small amount of cash in their saving accounts
		for( int i = 0; i < theJones.length; i++ )
		{
			EnhancedBankAccount eba = new EnhancedBankAccount("Jones", theJones[i], i, 2*i);
			eba.depositToSavings(100+i);
			enhancedBankAccounts.add(eba);
			
			// output successful transactions
			System.out.println("successful transactions for " + eba.getOwnerLastName() + "," + eba.getOwnerFirstName());
			java.util.ArrayList<Transaction> allTransactions = eba.getAllSuccessfulTransactions();
			for( Transaction t : allTransactions )
			{
				System.out.println(t.toString());
			}
			
			// output the savings deposit transactions
			System.out.println("successful savings deposit transactions for " + eba.getOwnerLastName() + "," + eba.getOwnerFirstName());
			java.util.ArrayList<Transaction> depostTransactions = eba.getSavingsDepositTransactions();
			for( Transaction t : depostTransactions )
			{
				System.out.println(t.toString());
			}
			
			
			System.out.println("BankAccount.getBankAccountCount() = " + BankAccount.getBankAccountCount());
		}
	}
}
