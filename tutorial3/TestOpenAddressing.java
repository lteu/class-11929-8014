// demo, hash table open addressing and linear probing


class DeletedEntry extends HashEntry {
      // mark the entry an as item that has been deleted
      private static DeletedEntry entry = null;
 
      private DeletedEntry() {
            super(-1, -1);
      }
 
      public static DeletedEntry isDeleted() {
            return new DeletedEntry();
      }
}

class HashTableOA implements HashTableInterface{
      private int DEFAULT_TABLE_SIZE = 128;
      private float threshold = 0.75f;
      private int maxSize = 96;
      private int size = 0;
 
      HashEntry[] table;
 
      HashTableOA() {
            table = new HashEntry[DEFAULT_TABLE_SIZE];
            for (int i = 0; i < DEFAULT_TABLE_SIZE; i++)
                  table[i] = null;
      }

      HashTableOA(int size) {
            DEFAULT_TABLE_SIZE = size;
            maxSize = (int) (size * threshold);
            table = new HashEntry[DEFAULT_TABLE_SIZE];
            for (int i = 0; i < DEFAULT_TABLE_SIZE; i++)
                  table[i] = null;
      }
 
      void setThreshold(float threshold) {
            this.threshold = threshold;
            maxSize = (int) (table.length * threshold);
      }
      
      int scan(int key, boolean shouldInsert){
            int m = table.length;
            int c = m;
            int i = 0;
            int j = key % table.length;
            while(table[j] != null  
                  &&  table[j].key != key
                  && i < m){
                  if (table[j] == DeletedEntry.isDeleted() && c == m)
                        c = j;
                  j=(j + 1) % m;
                  i++;
            }

            if(shouldInsert && table[j].key != key && c < m)
                  j = c; // insert in any deleted position found

            return j;

      }
      public Integer lookup(int key) {
            int index = scan(key, false);
            if (table[index] != null && table[index].key == key)
                  return table[index].value;
            else
                  return -1;
      }
 
      public void insert(int key, int value) {
            int hash = (key % table.length);
            int initialHash = -1;
            int indexOfDeletedEntry = -1;

            int index = scan(key, false);
            hash = index;
            table[hash] = new HashEntry(key, value);
            size++;

            if (size >= maxSize)
                  resize();
      }
 
      private void resize() {

            // make new table
            int tableSize = 2 * table.length;
            maxSize = (int) (tableSize * threshold);
            HashEntry[] oldTable = table;
            table = new HashEntry[tableSize];
            size = 0;

            // copy content
            for (int i = 0; i < oldTable.length; i++)
                  if (oldTable[i] != null
                             && oldTable[i] != DeletedEntry.isDeleted())
                        insert(oldTable[i].key, oldTable[i].value);
      }
 
      public void remove(int key) {
            int index = scan(key, false);
            if (table[index] != null && table[index].key == key){
                  table[index] = DeletedEntry.isDeleted();
                  size--;
            }
      }

      public void dump() {
            for (int i = 0 ; i < table.length; i++) {
                  System.out.println(table[i]);
            }
      }

}

 public class TestOpenAddressing {

      public static void main(String[] args){
         HashTableOA table = new HashTableOA(2);
         String key,value;

            System.out.println("   1. test insert(key,value)");
            table.insert(14,15);
            table.insert(16,17);
            table.insert(18,19);
            table.insert(20,19);
            table.insert(21,19);
            table.insert(22,19);
            table.insert(23,19);

            System.out.println("   2. test get(key)");
            System.out.println("   Value is " + table.lookup(21));

            System.out.println("   3. test containsKey(key)");
            System.out.println("   containsKey(" + "14" + ") is "  + table.lookup(14));
            System.out.println("   containsKey(" + "222" + ") is "  + table.lookup(222));

            System.out.println("   4. test remove(key)");
            table.remove(14);
            
            System.out.println("   5. show complete contents of hash table.");
            table.dump();
    
      }

   } // end class TestHashTable

   // ref http://www.algolist.net/Data_structures/Hash_table/Open_addressing