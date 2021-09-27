/**
   An interface that describes the operations of a bag of objects.
   @author Huijun Hu
   @author Jiyu Liu
*/
public interface BagInterface<T>
{
	/** Gets the current number of entries in this bag.
		 @return  The integer number of entries currently in the bag. */
	public int getCurrentSize();
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry);

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal.
                was successful, or null. */
	public T remove();
   
	/** Removes one occurrence of a given entry from this bag, if possible.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry);
	
	/** Removes all entries from this bag. */
	public void clear();
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry);
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to find.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry);
   
	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
                Note: If the bagempty, the returned array is empty. */
	public T[] toArray();

    /** Combine entries in another bag with that in called bag into a new collection.
		 @param otherBag  The bag collection to be combined.
		 @return  A new bag collection consists of contents in both bags. */
	public BagInterface<T> union(BagInterface<T> otherBag);

	/** Show the entries that occur in both bags as a new collection.
		 @param otherBag  The bag collection to be intersected.
		 @return  A new bag collection consists of common contents in both bags. */
	public BagInterface<T> intersection(BagInterface<T> otherBag);

	/** Distingguish the entries in called bag that are not in parameter bag.
		 @param otherBag  The bag collection to be compared with.
		 @return  A new bag collection consists of contents in only called bag but not parameter bag.*/
	public BagInterface<T> difference(BagInterface<T> anotherBag);
} // end BagInterface
