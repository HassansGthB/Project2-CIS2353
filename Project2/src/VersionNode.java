public class VersionNode {
    private int versionNumber;
    private String timestamp;
    private String description;
    private VersionNode next;

    // Constructor to initialize a new Node
    public VersionNode(int versionNumber, String timestamp, String description) {
        this.versionNumber = versionNumber;
        this.timestamp = timestamp;
        this.description = description;
        this.next = null; // initially no next node
        }
    
    // Getters
    public int getVersionNumber() { 
        return versionNumber; 
    }
    public String getTimestamp() { 
        return timestamp; 
    }
    public String getDescription() { 
        return description; 
    }
    public VersionNode getNext() { 
        return next; 
    }

    // Setters
    //this Setter links the new Node
    public void setNext(VersionNode next) {
        this.next = next; 
    }

    // string representation of this version node
    @Override
    public String toString() {
        return "Version " + versionNumber +
            " (" + timestamp + "): " +
            description;
        }

}
