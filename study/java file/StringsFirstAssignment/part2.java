package StringsFirstAssignment;


/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    public String findSimpleGene(String dna, String startCodon, String endCodon){
        if (dna==dna.toLowerCase()){
            startCodon = startCodon.toLowerCase();
            endCodon = endCodon.toLowerCase();
        }
        int start = dna.indexOf(startCodon);
        if (start==-1){
            return "";
        }
        int end = dna.indexOf(endCodon, start+3);
        if (end==-1){
            return "";
        }
        String gene = dna.substring(start, end+3);
        if (gene.length()%3==0){
                return gene;
            }
        else{
            return "";
        }
        
    }
    public void testSimpleGene(String dna){
        System.out.println(dna);
        System.out.println(findSimpleGene(dna, "ATG", "TAA"));
    }
}
