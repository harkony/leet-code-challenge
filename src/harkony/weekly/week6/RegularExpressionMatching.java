package harkony.weekly.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        List<String> patterns= parsePatterns(p);
        List<String> optimized=removeDuplicatedPattern(patterns);
        return isValid(s,optimized,0);
    }
    public static boolean isValid(String src,List<String > patterns, int sIndex){
        char specialChar='.';
        String specialString=".";

        if(src.length()==sIndex && (patterns.isEmpty() || patterns.stream().allMatch(x-> x.length()>1))){
            return true;
        }
        if(src.length()==sIndex || patterns.isEmpty()){
            return false;
        }

        char character = src.charAt(sIndex);
        String pattern = patterns.get(0);
        List<String> patternsNext=patterns.subList(1,patterns.size());

        // case 1 : . character match
        if(pattern.equals(specialString)){

            return isValid(src,patternsNext,sIndex+1);

        } else if (pattern.length()==1){
            // case 2 : terminal match
            if(character == pattern.charAt(0))
                return isValid(src,patternsNext,sIndex+1);
            else
                return false;

        } else{
            // ignore *
            boolean caseIgnore=isValid(src,patternsNext,sIndex);

            boolean caseAdopt;
            // adopt pattern with *
            char signature = pattern.charAt(0);
            if(signature==specialChar || signature==character){
                boolean caseUsePatternOnce= isValid(src,patternsNext,sIndex+1);
                boolean caseUsePatternMore = isValid(src,patterns,sIndex+1);
                caseAdopt= caseUsePatternOnce || caseUsePatternMore;
            } else{
                caseAdopt =false;
            }
            return caseAdopt || caseIgnore;

        }
    }

    private static List<String> parsePatterns(String pattern){
        if(pattern==null || pattern.isEmpty())
            return Collections.EMPTY_LIST;
        List<String> result=new ArrayList<>();
        for(int i=0;i<pattern.length()-1;i++){
            if(pattern.charAt(i+1)=='*')
                result.add(pattern.substring(i++,i+1));
            else
                result.add(pattern.substring(i,i+1));
        }
        if(pattern.charAt(pattern.length()-1)!='*')
            result.add(pattern.substring(pattern.length()-1));
        return result;
    }
    private static List<String> removeDuplicatedPattern(List<String> patterns){
        if(patterns.isEmpty())
            return Collections.EMPTY_LIST;

        List<String> optimizedPatterns= new ArrayList<>();
        optimizedPatterns.add(patterns.get(0));
        for(String patten:patterns.subList(1,patterns.size())){
            if(patten.length()==1 || !optimizedPatterns.get(optimizedPatterns.size()-1).equals(patten))
                optimizedPatterns.add(patten);
        }
        return optimizedPatterns;
    }
    public static void main(String[] args) {
        String s="aa";
        String p="a";
        System.out.println(isMatch(s,p));
    }
}
