/******************************************************************************
 * AUTHOR      : Saul Moreno
 * ASSIGNMENT# : 7
 * CLASS       : CSC 300
 * Due         : 4/13/24
 ******************************************************************************/
import java.util.Comparator;

class WorkerMultiSortComparator implements Comparator<Worker> 
{
    
  public int compare(Worker worker1, Worker worker2) {
    int result = worker1.getJobTitle().compareTo(worker2.getJobTitle());
    //Wil sort the salary by lowest
    if (result == 0) 
    {
        result = worker2.getSalary().compareTo(worker1.getSalary()); 
        //Sort by name
        if (result == 0) 
        {
            result = worker1.getName().compareTo(worker2.getName()); 
        }
    }
    return result;
}
}