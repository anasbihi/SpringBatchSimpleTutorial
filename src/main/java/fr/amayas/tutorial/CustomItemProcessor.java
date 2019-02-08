/**
 * 
 */
package fr.amayas.tutorial;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author anasb
 *
 */
public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {
	 
    public Transaction process(Transaction item) {
        return item;
    }
}
