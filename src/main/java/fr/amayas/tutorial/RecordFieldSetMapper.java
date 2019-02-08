/**
 * 
 */
package fr.amayas.tutorial;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author anasb
 *
 */
public class RecordFieldSetMapper implements FieldSetMapper<Transaction> {
	 
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Transaction transaction = new Transaction();
        
        try {
			transaction.setUsername(fieldSet.readString("username"));
			transaction.setUserId(fieldSet.readInt("userid"));
			transaction.setAmount(fieldSet.readDouble("amount"));
			String dateString = fieldSet.readString("transactiondate");

			transaction.setTransactionDate(dateFormat.parse(dateString));
		} catch (Exception e) {
			System.out.println("Line escaped due to error");
		}
		return transaction;
    }
}
