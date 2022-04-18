package StringsFirstAssignment;


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int start = dna.indexOf("ATG");
        if (start==-1){
            return "";
        }
        int end = dna.indexOf("TAA", start+3);
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
        System.out.println(findSimpleGene(dna));
    }
}
