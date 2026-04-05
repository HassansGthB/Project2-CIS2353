public class DocumentHistory {
    private VersionNode firstNode;

    // No-arg Constructor
    public DocumentHistory(){
        firstNode = null;
    }

    // Deep Copy Constructor
    public DocumentHistory(DocumentHistory copy) {
        VersionNode walker = copy.firstNode;

        while (walker != null) {
            this.addVersion(
                walker.getVersionNumber(),
                walker.getTimestamp(),
                walker.getDescription()
            );
            walker = walker.getNext();
        }
    }

    // Methods
    public void addVersion(int versionNumber, String timestamp, String description){
        VersionNode newNode = new VersionNode(versionNumber, timestamp, description);
        if (firstNode == null) {
            firstNode = newNode;
        } 
        else {
            VersionNode walker = firstNode;

            while (walker.getNext() != null) {
                walker = walker.getNext();
            }
            
            walker.setNext(newNode);
        }
    }
    public void printHistory(){
        VersionNode walker = firstNode;

        while(walker != null){
            System.out.println(walker);
            walker = walker.getNext();
        }
    }
    public int getVersionCount(){
        int count = 0;
        VersionNode walker = firstNode;

        while (walker != null) {
            count++;
            walker = walker.getNext();
        }
        return count;
    }

    public static DocumentHistory mergeHistories(DocumentHistory  history1, DocumentHistory history2){
        DocumentHistory merged = new DocumentHistory();
        int newVersionCounter = 1;

        VersionNode walker = history1.firstNode;
        while (walker != null) {
            merged.addVersion(
                newVersionCounter,
                walker.getTimestamp(),
                walker.getDescription()
            );
            newVersionCounter++;
            walker = walker.getNext();
        }

        walker = history2.firstNode;
        while (walker != null) {
            merged.addVersion(
                newVersionCounter,
                walker.getTimestamp(),
                walker.getDescription()
            );
            newVersionCounter++;
            walker = walker.getNext();
        }

        return merged;

    }

}
