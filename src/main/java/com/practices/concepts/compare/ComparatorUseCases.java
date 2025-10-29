package com.practices.concepts.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.practices.pojo.Player;

public class ComparatorUseCases {

	public static void main(String[] args) {
		
		Player player1 = new Player("Messey", 10 , 1, 12.5f);
		Player player2 = new Player("Mbhape", 11 , 5, 14.5f);
		Player player3 = new Player("Ronaldo", 9 , 3, 12.5f);
		
		var list = new ArrayList<Player>() {
			private static final long serialVersionUID = 1L;
			{
                add(player1);
                add(player2);
                add(player3);
            }
        };
		
		// Anonymous implementation of compare method from Comparator
		Collections.sort(list, (p1, p2) -> Integer.compare(p1.getJerseyNumber(), p2.getJerseyNumber()));
		System.out.println("By jersey: "+ list);
		
		// Anonymous implementation of compare method from Comparator
		list.sort((p1, p2) -> Float.compare(p1.getMaxDistance(), p2.getMaxDistance()));
		System.out.println("By maxDistance: "+ list);
		
		Comparator<Player> compareByRank = Comparator.comparing(Player::getRank);
		Comparator<Player> compareByName = Comparator.comparing(Player::getName);
		
		Collections.sort(list, compareByRank);
		System.out.println("By Rank: "+ list);
		
		Collections.sort(list, compareByName);
		System.out.println("By Name: "+ list);
		
		list.sort(Comparator.comparing(Player::getMaxDistance).thenComparing(Player::getRank));
		System.out.println("By distance and rank: "+ list);
		
		System.out.println("Using streams: " + list.stream().sorted(compareByName).collect(Collectors.toList()));
		
		list.add(null);
		
		list.sort(Comparator.nullsFirst(compareByRank));
		System.out.println("By name with null elements in the begining: "+ list);
		
		list.sort(Comparator.nullsLast(compareByRank));
		System.out.println("By name with null elements in the last: "+ list);
		
		
	}

}
