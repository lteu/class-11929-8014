// demo, hash table with collision list

  
   class HashEntrySC extends HashEntry{
      // personalised vector class
      HashEntrySC next;
 
      HashEntrySC(int key, int value) {
        super(key,value);
      }
   }

   class HashTableSC implements HashTableInterface {
      private HashEntrySC[] table;  // hash table represented as an array of linked lists.

      private int size;  // The number of (key,value)

      public HashTableSC() {
         table = new HashEntrySC[64];
      }

      public HashTableSC(int initialSize) {
         table = new HashEntrySC[initialSize];
      }

      void dump() {
         System.out.println();
         for (int i = 0; i < table.length; i++) {
              // Print out the location number and the list of
              // key/value pairs in this location.
            System.out.print(i + ":");
            HashEntrySC entry = table[i]; // For traversing linked list number i.
            while (entry != null) {
               System.out.print("  (" + entry.key + "," + entry.value + ")");
               entry = entry.next;
            }
            System.out.println();
         }
      }

      public void insert(int key, int value) {
         int bucket = hash(key); 
         HashEntrySC entry = table[bucket];

         while (entry != null) {
            if (entry.key == key)
               break;
            entry = entry.next;
         }

         if (entry != null) {
            // if found, override
            entry.value = value;
         }
         else {
            // not found, then create
            if (size >= 0.75*table.length) {
                 // check if dynamic resizing is needed
               resize();
            }
            HashEntrySC newEntry = new HashEntrySC(key,value);
            newEntry.next = table[bucket];
            table[bucket] = newEntry;
            size++;  
         }
      }

      public Integer lookup(int key) {
         int bucket = hash(key); 
         HashEntrySC entry = table[bucket];  
         while (entry != null) {
            if (entry.key == key)
               return entry.value;
            entry = entry.next;
         }
         return null;  
      }

      public void remove(int key) {  
         int bucket = hash(key); 
         if (table[bucket] == null) {
            return; 
         }
         if (table[bucket].key ==  key) {
            table[bucket] = table[bucket].next;
            size--;
            return;
         }
          
         // if remove chain item
         HashEntrySC prev = table[bucket];
         HashEntrySC curr = prev.next;  
         while (curr != null && curr.key != key) {
            curr = curr.next;
            prev = curr;
         }
         if (curr != null) {
            prev.next = curr.next;
            size--; 
         }
      }

      private int hash(int key) {
        return key % table.length;
      }

      private void resize() {
            // Double the size of the table, and redistribute the
            // key/value pairs to their proper locations in the
            // new table.
         HashEntrySC[] newtable = new HashEntrySC[table.length*2];
         for (int i = 0; i < table.length; i++) {
            HashEntrySC entry = table[i]; 
            while (entry != null) {
    
               HashEntrySC next = entry.next; 
               int hash = entry.key % newtable.length;
               entry.next = newtable[hash];
               newtable[hash] = entry;
               entry = next;  // Move on to the next node in the OLD table.
            }
         }
         table = newtable;  // Replace the table with the new table.
      } // end resize()

   } // end class HashTableSC


   public class TestSeparateChaining {

      public static void main(String[] args){
        HashTableSC table = new HashTableSC(2);
        String key,value;
        System.out.println("   1. test insert(key,value)");
        table.insert(14,15);
        table.insert(16,17);
        table.insert(18,19);
        table.insert(20,19);
        table.insert(21,19);
        table.insert(22,19);
        table.insert(23,19);
        System.out.println("   2. test lookup(key)");
        System.out.println("   Value is of 18 is " + table.lookup(18));

        System.out.println("   3. test lookup(key)");
        System.out.println("   lookup(" + "14" + ") is "  + table.lookup(14));

        System.out.println("   4. test remove(14)");
        table.remove(14);

        System.out.println("   5. show complete contents of hash table.");
        table.dump();

      }

   } // end class TestHashTableSC

   // ref http://www-h.eng.cam.ac.uk/help/importedHTML/languages/java/javanotes5.0.2/c10/ex3-ans.html