public class Main {
    public static void main(String[] args){
       // initialize 2 document history objects, copy of doc 2, and merged history
       DocumentHistory document1 = new DocumentHistory();
       DocumentHistory document2 = new DocumentHistory();
       DocumentHistory copyOfDoc2;
       DocumentHistory mergedOfDoc1andDoc2;
       
       // adding 3 versions to each history
       document1.addVersion(5, "2024-09-01", "doc1 5th draft");
       document1.addVersion(7, "2024-09-02", "doc1 7th draft");
       document1.addVersion(9, "2024-09-03", "doc1 conclusion added");

       document2.addVersion(6, "2025-09-01", "doc2 6th draft");
       document2.addVersion(9, "2025-09-02", "doc2 9th draft");
       document2.addVersion(11, "2025-09-03", "doc2 conclusion added");
        
        // print each history
        System.out.println("=== Document 1 ===");
        document1.printHistory();
    
        System.out.println("\n=== Document 2 ===");
        document2.printHistory();
        
        // Deep Copy of doc 2
        System.out.println("\n=== Copy of Document 2 ===");
        copyOfDoc2 = new DocumentHistory(document2);
        copyOfDoc2.printHistory();

        // Demonstrate independence
        document2.addVersion(13, "2025-09-04", "doc2 changed after copy");

        System.out.println("\n=== Document 2 After Modification ===");
        document2.printHistory();

        System.out.println("\n=== Copy of Document 2 (Should Be Unchanged) ===");
        copyOfDoc2.printHistory();

        // Merge the two histories into a third history
        mergedOfDoc1andDoc2 = DocumentHistory.mergeHistories(document1, document2);
        // Print merged history
        System.out.println("\n=== Merged Document (Doc1 + Doc2) ===");
        mergedOfDoc1andDoc2.printHistory();

        // version counts for all histories
        System.out.println("\n=== Version Counts ===");
        System.out.println("Document 1 count: " + document1.getVersionCount());
        System.out.println("Document 2 count: " + document2.getVersionCount());
        System.out.println("Copy of Document 2 count: " + copyOfDoc2.getVersionCount());
        System.out.println("Merged history count: " + mergedOfDoc1andDoc2.getVersionCount());
    }

}
