import java.util.Comparator;

class WorkerMultiSortComparator implements Comparator<Worker> {
    
    public int compare(Worker w1, Worker w2) {
        int result = w1.getJobTitle().compareTo(w2.getJobTitle());
        if (result == 0) 
        {
            result = Integer.compare(w1.getName().length(), w2.getName().length());
            if (result == 0) 
            {
                result = w1.getName().compareTo(w2.getName());
            }
        }
        return result;
    }
}