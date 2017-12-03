package util;

import entity.Letter;
import entity.Neighbour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.lang.Math;

public class Knn {

	public static int K; // gui den al?n?p at?lacak
	
	public static double distanceBetweenArrays(ArrayList<Double> featureArray, ArrayList<Double> arrayList) {

		double totalError = 0;
		// ArrayList<Double> = new ArrayList<>();
		for (int i = 0; i < 76; i++) 
		{
			double fark = featureArray.get(i) - arrayList.get(i);

			double fark_karesi = Math.pow(fark, 2);

			totalError = totalError + fark_karesi;
			
		}
		return totalError;
	}

	public static TreeMap<String, Integer> nearestNeighbour(ArrayList<Letter> allLetterList, ArrayList<Double> averageCurrentList) // SUAN DA EN YAKIN KOMSUNUN ?NDEXINI DÖNDÜRÜYOR
																												
	{
		double minDistance = 0;
		int minIndex = 0;
		int currentIndex = 0;

		ArrayList<Letter> allLetterListCopy = new ArrayList<>(); // copy all
																	// data

		ArrayList<Neighbour> neighbourList = new ArrayList<>();
		
		for (Letter l : allLetterList) {
			Letter letter = new Letter();

			letter.setLetterName(l.getLetterName());
			letter.setLetterId(l.getLetterId());
			letter.setFeatureList(l.getFeatureList());
			letter.setPersonName(l.getPersonName());
			allLetterListCopy.add(letter);

		}

		for(Letter l : allLetterListCopy)
		{
			Neighbour neighbour= new Neighbour();
			neighbour.setLetterVote(l.getLetterName());
			
			//System.out.println(neighbour.getLetterVote());
			neighbour.setDistance(distanceBetweenArrays(averageCurrentList, l.getFeatureList()));
			neighbourList.add(neighbour);
			
		}
		
		Collections.sort(neighbourList,new ComparatorClass());  // büyükten küÇü\u011ee
		
		TreeMap<String, Integer> sortedVoteList = voting(neighbourList);
  		
		return sortedVoteList;
		
		}
	
	public static TreeMap<String, Integer> voting(ArrayList<Neighbour> neighbourList ){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
        Comparator_Distance bvc = new Comparator_Distance(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
		
        for(int i=0 ; i<K;i++)  // K TANES? SIRALANDI  // Çarp? 5 olabilir
        {
        	
        //	System.out.println(neighbourList.get(i).getLetterVote());
        	
        	if(map.containsKey(neighbourList.get(i).getLetterVote()))
        	{
        		map.put(neighbourList.get(i).getLetterVote(), map.get(neighbourList.get(i).getLetterVote())+1);
        	}
        	else {
        		map.put(neighbourList.get(i).getLetterVote(),1);
			}
        }
		
        
        
       sorted_map.putAll(map);  //  büyükten küÇü\u011ee s?ral?yor
       
       return sorted_map;
       
	}
	
	

}
