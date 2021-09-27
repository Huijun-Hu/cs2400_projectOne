/** A demonstration of the class ResizableArrayBag
    @author Huijun Hu
    @version 1.0
*/
public class ArrayBagTest
{
	public static void main(String[] args) 
	{
		// A bag whose initial capacity is small
      BagInterface<String> aBag = new ResizableArrayBag<>(3);
      testIsEmpty(aBag, true);
      
		System.out.println("Adding to the bag more strings than its initial capacity.");
      String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);

      testIsEmpty(aBag, false);
      String[] testStrings2 = {"A", "B", "C", "D", "Z"};
      testFrequency(aBag, testStrings2);
      testContains(aBag, testStrings2);
		
      // Removing strings
		String[] testStrings3 = {"", "B", "A", "C", "Z"};
      testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();
      testIsEmpty(aBag, true);
		displayBag(aBag);

      System.out.println("\nTwo new bags are created...");
      String[] contentsOfBag1 = {"A", "B", "B", "B", "C", "C", "D"};
		String[] contentsOfBag2 = {"B", "B", "C", "D", "E", "F"};
      BagInterface<String> Bag1 = new ResizableArrayBag<>(contentsOfBag1);
      BagInterface<String> Bag2 = new ResizableArrayBag<>(contentsOfBag2);

      System.out.println("One bag contains " + Bag1.getCurrentSize() + " string(s), as follows:");
      Object[] bag1_Array = Bag1.toArray();
      for (int i = 0; i < bag1_Array.length; i++)
		{
			System.out.print(bag1_Array[i] + " ");
		}
      System.out.println("\nThe other bag contains " + Bag2.getCurrentSize() + " string(s), as follows:");
      Object[] bag2_Array = Bag2.toArray();
      for (int i = 0; i < bag2_Array.length; i++)
		{
			System.out.print(bag2_Array[i] + " ");
		}
      System.out.println("");

      System.out.println("\nUnion two bags testing...");
		testUnion(Bag1, Bag2);

      System.out.println("\nIntersection two bagstesting...");
      testIntersection(Bag1, Bag2);

      System.out.println("\nDifference of two bagstesting...");
      testDifference(Bag1, Bag2);

	} // end main
	
   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

   // Tests the two remove methods.
	private static void testRemove(BagInterface<String> aBag, String[] tests)
	{
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (aString.equals("") || (aString == null))
         {
            // Test remove()
            System.out.println("\nRemoving a string from the bag:");
            String removedString = aBag.remove();
            System.out.println("remove() returns " + removedString);
         }
         else
         {
            // Test remove(aString)
            System.out.println("\nRemoving \"" + aString + "\" from the bag:");
            boolean result = aBag.remove(aString);
            System.out.println("remove(\"" + aString + "\") returns " + result);
         } // end if
         
         displayBag(aBag);
      } // end for
	} // end testRemove

   // Tests the method isEmpty.
   // correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("Testing isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty

   // Tests the method getFrequencyOf.
	private static void testFrequency(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method getFrequencyOf:");
      for (int index = 0; index < tests.length; index++)
         System.out.println("In this bag, the count of " + tests[index] + 
                            " is " + aBag.getFrequencyOf(tests[index]));
   } // end testFrequency
   
   // Tests the method contains.
	private static void testContains(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method contains:");
      for (int index = 0; index < tests.length; index++)
         System.out.println("Does this bag contain " + tests[index] + 
                            "? " + aBag.contains(tests[index]));
   } // end testContains

   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag

   // Tests the method union
   private static void testUnion(BagInterface<String> BagA, BagInterface<String> BagB)
	{
      System.out.println("The combination of these two bags contains " + BagA.union(BagB).getCurrentSize() + " string(s), as follows:");
      Object[] bagU_Array = BagA.union(BagB).toArray();
      for (int i = 0; i < bagU_Array.length; i++)
		{
			System.out.print(bagU_Array[i] + " ");
		}         
      System.out.println("");         
	} // end testUnion

   // Tests the method intersection
   private static void testIntersection(BagInterface<String> BagA, BagInterface<String> BagB)
	{
      System.out.println("The intersection of these two bags contains " + BagA.intersection(BagB).getCurrentSize() + " string(s), as follows:");
      Object[] bagI_Array = BagA.intersection(BagB).toArray();
      for (int i = 0; i < bagI_Array.length; i++)
		{
			System.out.print(bagI_Array[i] + " ");
		} 
      System.out.println("");
   } // end testIntersection

   // Tests the method difference
   private static void testDifference(BagInterface<String> BagA, BagInterface<String> BagB)
	{
      System.out.println("The difference of the first bag from the second bag contains " + BagA.difference(BagB).getCurrentSize() + " string(s), as follows:");
      Object[] bagD_Array = BagA.difference(BagB).toArray();
      for (int i = 0; i < bagD_Array.length; i++)
		{
			System.out.print(bagD_Array[i] + " ");
		} 
      System.out.println("");
   } // end testDifference

} // end ArrayBagTest