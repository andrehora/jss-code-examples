public static void main(String[] args) {
HashSet setA = newHashSet(1, 2, 3, 4, 5);  
HashSet setB = newHashSet(4, 5, 6, 7, 8);  
   
SetView union = Sets.union(setA, setB);  
System.out.println("union:");  
for (Integer integer : union)  
    System.out.println(integer);         
   
SetView difference = Sets.difference(setA, setB);  
System.out.println("difference:");  
for (Integer integer : difference)  
    System.out.println(integer);        
   
SetView intersection = Sets.intersection(setA, setB);  
System.out.println("intersection:");  
for (Integer integer : intersection)  
    System.out.println(integer);
}